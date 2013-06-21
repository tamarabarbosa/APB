package view;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.FactoryConnection;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class CadastrarBarbeiro extends JFrame {

	private JPanel contentPane;
	private Connection connection;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastrarBarbeiro frame = new CadastrarBarbeiro();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public CadastrarBarbeiro() {
		inicializarComponentes();
	}

	public void inicializarComponentes() {
		setTitle("Barbeiro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 756, 543);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 506, 482);
		contentPane.add(scrollPane);

		final DefaultTableModel modelo = new DefaultTableModel(null,
				new String[] { "Nome", "CPF", "RG", "Telefone", "Cadeira" });
		final JTable table = new JTable(modelo);
		
		try {
			connection = FactoryConnection.getInstance().getConnection();
			ResultSet rs = connection.createStatement().executeQuery(
					"Select nome, cpf, rg, telefone, cadeira from barbeiro;");
			while (rs.next()) {
				String[] dados = new String[5];
				dados[0] = rs.getString("nome");
				dados[1] = rs.getString("cpf");
				dados[2] = rs.getString("rg");
				dados[3] = rs.getString("telefone");
				dados[4] = rs.getString("cadeira");
				modelo.addRow(dados);
			}
		} catch (SQLException e) {
			mostrarMensagemDeErro(e.getMessage());
		}

		scrollPane.setViewportView(table);

		JButton botaoNovoBarbeirp = new JButton("Novo");
		botaoNovoBarbeirp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				NovoBarbeiro frame = new NovoBarbeiro();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
			}
		});
		botaoNovoBarbeirp.setBounds(526, 11, 204, 43);
		contentPane.add(botaoNovoBarbeirp);

		JButton botaoConcluir = new JButton("Voltar");
		botaoConcluir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				TelaOpcoes frame = new TelaOpcoes();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);

				
			}
		});
		botaoConcluir.setBounds(526, 450, 204, 43);
		contentPane.add(botaoConcluir);
		
		JButton botaoRemover = new JButton("Remover");
		botaoRemover.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
				RemoverBarbeiro frame =  new RemoverBarbeiro();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
			}
		});
		botaoRemover.setBounds(526, 65, 204, 43);
		contentPane.add(botaoRemover);

	
		botaoConcluir.setBounds(526, 450, 204, 43);
		contentPane.add(botaoConcluir);

		JButton btnNewButton = new JButton("Pesquisar");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnNewButton.setBounds(526, 65, 204, 43);
		contentPane.add(btnNewButton);
	}
	
	private void mostrarMensagemDeErro(String informacao) {
		JOptionPane.showMessageDialog(null, informacao, "Atenção",
				JOptionPane.INFORMATION_MESSAGE);
	}
}
