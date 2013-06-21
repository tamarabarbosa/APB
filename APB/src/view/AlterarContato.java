package view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;

import control.AgendaController;
import exception.BarbeiroException;

import model.Agenda;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

@SuppressWarnings("serial")
public class AlterarContato extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textFieldNome;
	private JTextField textFieldTelefone;
	private JTextField textFieldDescricao;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AlterarContato frame = new AlterarContato();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public AlterarContato() {
		setTitle("Alterar Contato");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 22, 414, 57);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] {
				"Nome", "Telefone", "Descri\u00E7\u00E3o" }) {
			boolean[] columnEditables = new boolean[] { false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(2).setResizable(false);
		scrollPane.setViewportView(table);

		JButton btnSalvarAlteracao = new JButton("Salvar Altera\u00E7\u00E3o");
		btnSalvarAlteracao.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					Agenda contato = new Agenda();
					contato.setNome(textFieldNome.getText());
					contato.setNome(textFieldTelefone.getText());
					contato.setNome(textFieldDescricao.getText());
					
					AgendaController contatoController = AgendaController.getInstance();
					contatoController.alterar(contato);
				} catch (BarbeiroException e) {
					mostrarMensagemDeErro(e.getMessage());
				} catch (SQLException e) {
					mostrarMensagemDeErro(e.getMessage());
				}
			}
			
		});
		btnSalvarAlteracao.setBounds(83, 220, 121, 31);
		contentPane.add(btnSalvarAlteracao);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(259, 220, 104, 31);
		contentPane.add(btnVoltar);

		textFieldNome = new JTextField();
		textFieldNome.setBounds(83, 90, 341, 20);
		contentPane.add(textFieldNome);
		textFieldNome.setColumns(10);

		textFieldTelefone = new JTextField();
		textFieldTelefone.setBounds(83, 121, 341, 20);
		contentPane.add(textFieldTelefone);
		textFieldTelefone.setColumns(10);

		textFieldDescricao = new JTextField();
		textFieldDescricao.setBounds(83, 152, 341, 41);
		contentPane.add(textFieldDescricao);
		textFieldDescricao.setColumns(10);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(11, 93, 46, 14);
		contentPane.add(lblNome);

		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(10, 124, 46, 14);
		contentPane.add(lblTelefone);

		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o:");
		lblDescrio.setBounds(10, 152, 63, 14);
		contentPane.add(lblDescrio);
	}
	
	private void mostrarMensagemDeErro(String informacao) {
		JOptionPane.showMessageDialog(null, informacao, "Atenção",
				JOptionPane.INFORMATION_MESSAGE);
	}
}
