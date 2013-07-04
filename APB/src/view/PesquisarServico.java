package view;

import java.awt.EventQueue;
import model.Servico;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JButton;

import control.ServicoController;

import dao.FactoryConnection;
import exception.ServicoException;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

@SuppressWarnings("serial")
public class PesquisarServico extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	private Connection connection;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PesquisarServico frame = new PesquisarServico();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public PesquisarServico() {
		inicializarComponentes();
	}

	public void inicializarComponentes() {
		setTitle("Pesquisar Servi\u00E7o");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 464, 115);
		contentPane.add(scrollPane);

		final DefaultTableModel modelo = new DefaultTableModel(null,
				new String[] { "Serviço", "Realizado por", "Valor", "Data" });
		final JTable table = new JTable(modelo);
		scrollPane.setViewportView(table);

		textField = new JTextField();
		textField.setBounds(82, 137, 392, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblPesquisar = new JLabel("Pesquisar:");
		lblPesquisar.setBounds(20, 137, 66, 14);
		contentPane.add(lblPesquisar);

		JButton btnPesquisarServico = new JButton("Pesquisar Serviço");
		btnPesquisarServico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Servico servico = new Servico();
					servico.setNome(textField.getText());

					connection = FactoryConnection.getInstance()
							.getConnection();
					ResultSet rs = connection.createStatement().executeQuery(
							"Select nome, preco, barbeiro, data from servico where nome = '"
									+ servico.getNome() + "';");

					while (rs.next()) {
						String[] dados = new String[4];
						dados[0] = rs.getString("nome");
						dados[1] = rs.getString("barbeiro");
						dados[2] = rs.getString("preco");
						dados[3] = rs.getString("data");
						modelo.addRow(dados);
					}
				} catch (ServicoException e) {
					mostrarMensagemDeErro(e.getMessage());
				} catch (SQLException e) {
					mostrarMensagemDeErro(e.getMessage());
				}

			}
		});
		btnPesquisarServico.setBounds(10, 168, 148, 23);
		contentPane.add(btnPesquisarServico);

		JButton btnPesquisarBarbeiro = new JButton("Pesquisar Barbeiro");
		btnPesquisarBarbeiro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					Servico servico = new Servico();
					try {
						servico.setNomeBarbeiro(textField.getText());
					} catch (ServicoException e) {
						e.printStackTrace();
					}

					connection = FactoryConnection.getInstance().getConnection();
					ResultSet rs = connection.createStatement().executeQuery(
							"Select nome, preco, barbeiro, data from servico where barbeiro = '"
									+ servico.getNomeBarbeiro() + "';");

					while (rs.next()) {
						String[] dados = new String[4];
						dados[0] = rs.getString("nome");
						dados[1] = rs.getString("barbeiro");
						dados[2] = rs.getString("preco");
						dados[3] = rs.getString("data");
						modelo.addRow(dados);
					}

				} catch (SQLException e) {
					mostrarMensagemDeErro(e.getMessage());
				}
			}
		});
		btnPesquisarBarbeiro.setBounds(168, 168, 148, 23);
		contentPane.add(btnPesquisarBarbeiro);

		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.setBounds(98, 228, 89, 23);
		contentPane.add(btnAlterar);

		JButton btnRemover = new JButton("Remover");
		btnRemover.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				try {
					String nome = (String) table.getValueAt(table.getSelectedRow(), 0);
					Servico servico = new Servico();
					servico.setNome(nome);

					int confirmacao = JOptionPane.showConfirmDialog(null, "Remover esse serviço da lista?");
					
					if (confirmacao == JOptionPane.YES_OPTION) {
						ServicoController barbeiroController = ServicoController.getInstance();
						barbeiroController.excluir(servico);

						dispose();
						CadastrarServico frame = new CadastrarServico();
						frame.setVisible(true);
						frame.setLocationRelativeTo(null);
					}
				} catch (ServicoException e) {
					mostrarMensagemDeErro(e.getMessage());
				} catch (SQLException e) {
					mostrarMensagemDeErro(e.getMessage());
				}
				
			}
		});
		btnRemover.setBounds(216, 228, 89, 23);
		contentPane.add(btnRemover);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				CadastrarServico frame = new CadastrarServico();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
			}
		});
		btnVoltar.setBounds(335, 228, 89, 23);
		contentPane.add(btnVoltar);

		JButton btnPesquisarData = new JButton("Pesquisar Data");
		btnPesquisarData.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				try {
					Servico servico = new Servico();
					try {
						servico.setData(textField.getText());
					} catch (ServicoException e) {
						e.printStackTrace();
					}

					connection = FactoryConnection.getInstance()
							.getConnection();
					ResultSet rs = connection.createStatement().executeQuery(
							"Select nome, preco, barbeiro, data from servico where data = '"
									+ servico.getData() + "';");

					while (rs.next()) {
						String[] dados = new String[4];
						dados[0] = rs.getString("nome");
						dados[1] = rs.getString("barbeiro");
						dados[2] = rs.getString("preco");
						dados[3] = rs.getString("data");
						modelo.addRow(dados);
					}

				} catch (SQLException e) {
					mostrarMensagemDeErro(e.getMessage());
				}

			}
		});
		btnPesquisarData.setBounds(326, 168, 148, 23);
		contentPane.add(btnPesquisarData);
	}

	private void mostrarMensagemDeErro(String informacao) {
		JOptionPane.showMessageDialog(null, informacao, "Atenção",
				JOptionPane.INFORMATION_MESSAGE);
	}
}
