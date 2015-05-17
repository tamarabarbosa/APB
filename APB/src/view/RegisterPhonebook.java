package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.Phonebook;
import control.ContactController;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.EventQueue;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Logger;

@SuppressWarnings("serial")
public class RegisterPhonebook extends JFrame {

	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterPhonebook frame = new RegisterPhonebook();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		Logger.getLogger("Create the frame to a register phonebook");
	}

	// Class constructor
	public RegisterPhonebook() {
		setTitle("Phonebook de Contatos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 575, 472);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 21, 435, 401);
		contentPane.add(scrollPane);

		final DefaultTableModel modelo = new DefaultTableModel(null,
				new String[] { "Nome", "Phone", "Descri\u00E7\u00E3o" }) {
			boolean[] columnEditables = new boolean[] { false, false, false };

			// Method that initialize the frame
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		};

		final JTable table = new JTable(modelo);
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(2).setResizable(false);
		scrollPane.setViewportView(table);

		try {
			ContactController phonebookController = ContactController
					.getInstance();
			Phonebook contact = new Phonebook("nome", "telefone", "descricao");
			ResultSet rs = phonebookController.showContactsRegistered(contact);
			while (rs.next()) {
				String[] dados = new String[3];
				dados[0] = rs.getString("nome");
				dados[1] = rs.getString("telefone");
				dados[2] = rs.getString("descricao");
				modelo.addRow(dados);
			}
		} catch (SQLException e) {
			mostrarMensagemDeErro(e.getMessage());
		}

		scrollPane.setViewportView(table);
		Logger.getLogger("table with register phonebook was created");

		JButton btnNovo = new JButton("Novo");
		btnNovo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
				NewContact frame;
				try {
					frame = new NewContact();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (ParseException e) {
					e.printStackTrace();
				}

			}
		});
		btnNovo.setBounds(455, 24, 94, 23);
		contentPane.add(btnNovo);
		Logger.getLogger("table with register of Phonebook was create");

		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				PesquisarContato frame = new PesquisarContato();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
			}
		});
		btnPesquisar.setBounds(455, 58, 94, 23);
		contentPane.add(btnPesquisar);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addMouseListener(new MouseAdapter() {
			@Override
			// // This method calls the register barber frame
			public void mouseClicked(MouseEvent arg0) {
				dispose();
				Administrative frame = new Administrative();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
			}
		});
		btnVoltar.setBounds(455, 399, 94, 23);
		contentPane.add(btnVoltar);
	}

	// Method that shows a error message
	private void mostrarMensagemDeErro(String informacao) {
		JOptionPane.showMessageDialog(null, informacao, "Aten��o",
				JOptionPane.INFORMATION_MESSAGE);
	}
}
