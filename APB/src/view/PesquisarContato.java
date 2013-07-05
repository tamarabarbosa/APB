package view;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class PesquisarContato extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PesquisarContato frame = new PesquisarContato();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public PesquisarContato() {
		inicializarComponentes();
	}

	public void inicializarComponentes() {
		setTitle("Pesquisar Contato");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 414, 115);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nome", "Telefone", "Descri\u00E7\u00E3o" }) {
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(2).setResizable(false);
		scrollPane.setViewportView(table);
		
		textField = new JTextField();
		textField.setBounds(82, 137, 342, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblPesquisar = new JLabel("Pesquisar:");
		lblPesquisar.setBounds(20, 137, 66, 14);
		contentPane.add(lblPesquisar);
		
		JButton btnPesquisarNome = new JButton("Pesquisar Nome");
		btnPesquisarNome.setBounds(82, 168, 160, 23);
		contentPane.add(btnPesquisarNome);
		
		JButton btnPesquisarTelefone = new JButton("Pesquisar Telefone");
		btnPesquisarTelefone.setBounds(264, 168, 160, 23);
		contentPane.add(btnPesquisarTelefone);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.setBounds(98, 228, 89, 23);
		contentPane.add(btnAlterar);
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.setBounds(216, 228, 89, 23);
		contentPane.add(btnRemover);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				CadastrarAgenda frame = new CadastrarAgenda();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
			}
		});
		btnVoltar.setBounds(335, 228, 89, 23);
		contentPane.add(btnVoltar);
	}
}
