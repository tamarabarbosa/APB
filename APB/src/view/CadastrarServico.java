package view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class CadastrarServico extends JFrame {

	private JPanel contentPane;
	private JTable table;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastrarServico frame = new CadastrarServico();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public CadastrarServico() {
		setTitle("Servi\u00E7o");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 756, 543);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 506, 482);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] {
				"Servi\u00E7o", "Realizado por", "Valor", "Data" }) {
			boolean[] columnEditables = new boolean[] { false, false, false,
					false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table);

		JButton botaoNovoServico = new JButton("Novo");
		botaoNovoServico.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
				NovoServico frame = new NovoServico();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
			}
		});
		botaoNovoServico.setBounds(526, 11, 204, 43);
		contentPane.add(botaoNovoServico);

		JButton botaoAlterarServico = new JButton("Alterar");
		botaoAlterarServico.setBounds(526, 65, 204, 43);
		contentPane.add(botaoAlterarServico);

		JButton botaoRemoverServico = new JButton("Remover");
		botaoRemoverServico.setBounds(526, 119, 204, 43);
		contentPane.add(botaoRemoverServico);

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

		JButton botaoPesquisarServico = new JButton("Pesquisar");
		botaoPesquisarServico.setBounds(526, 173, 204, 43);
		contentPane.add(botaoPesquisarServico);
	}
}
