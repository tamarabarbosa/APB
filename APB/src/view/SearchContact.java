package view;

import java.awt.EventQueue;

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

import control.ContactController;
import exception.BarberException;
import model.Contact;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

@SuppressWarnings("serial")
public class SearchContact extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchContact frame = new SearchContact();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public SearchContact() {
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

		final DefaultTableModel modelo = new DefaultTableModel(null,
				new String[] { "Nome", "Phone", "Descrição" });
		final JTable table = new JTable(modelo);

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
		btnPesquisarNome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {

					for (int i = 0; i < modelo.getRowCount(); i++) {
						modelo.removeRow(i);
					}

					Contact contact = new Contact();
					ContactController ContactController = control.ContactController
							.getInstance();
					contact.setName(textField.getText());
					ResultSet rs = ContactController.searchByName(contact);

					while (rs.next()) {
						String[] dados = new String[3];
						dados[0] = rs.getString("name");
						dados[1] = rs.getString("telefone");
						dados[2] = rs.getString("descricao");
						modelo.addRow(dados);
					}
				} catch (SQLException e) {
					mostrarMensagemDeErro(e.getMessage());
				} catch (BarberException e) {
					mostrarMensagemDeErro(e.getMessage());
				}
			}
		});
		btnPesquisarNome.setBounds(82, 168, 160, 23);
		contentPane.add(btnPesquisarNome);

		JButton btnPesquisarPhone = new JButton("Pesquisar Phone");
		btnPesquisarPhone.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				try {

					for (int i = 0; i < modelo.getRowCount(); i++) {
						modelo.removeRow(i);
					}

					Contact contact = new Contact();
					ContactController ContactController = control.ContactController
							.getInstance();
					contact.setPhoneNumber(textField.getText());
					ResultSet rs = ContactController.searchByPhonebook(contact);

					while (rs.next()) {
						String[] dados = new String[3];
						dados[0] = rs.getString("name");
						dados[1] = rs.getString("telefone");
						dados[2] = rs.getString("descricao");

						modelo.addRow(dados);

						table.updateUI();
					}
				} catch (SQLException e) {
					mostrarMensagemDeErro(e.getMessage());
				} catch (BarberException e) {
					mostrarMensagemDeErro(e.getMessage());
				}
			}
		});
		btnPesquisarPhone.setBounds(264, 168, 160, 23);
		contentPane.add(btnPesquisarPhone);

		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Contact.setTempName(modelo.getValueAt(
							table.getSelectedRow(), 0).toString());
					dispose();
					ModifyContact frame = new ModifyContact();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);

				} catch (ArrayIndexOutOfBoundsException e1) {
					mostrarMensagemDeErro("Selecione um contact para change");
				}
			}
		});
		btnAlterar.setBounds(98, 228, 89, 23);
		contentPane.add(btnAlterar);

		JButton btnRemover = new JButton("Remover");
		btnRemover.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				try {
					String name = (String) table.getValueAt(
							table.getSelectedRow(), 0);
					String telefone = (String) table.getValueAt(
							table.getSelectedRow(), 1);
					Contact Contact = new Contact();
					Contact.setName(name);
					Contact.setPhoneNumber(telefone);

					int confirmacao = JOptionPane.showConfirmDialog(null,
							"Remover " + name + " da lista?");

					if (confirmacao == JOptionPane.YES_OPTION) {
						ContactController ContactController = control.ContactController
								.getInstance();
						ContactController.delete(Contact);

						dispose();
						SearchContact frame = new SearchContact();
						frame.setVisible(true);
						frame.setLocationRelativeTo(null);
					}
				} catch (ArrayIndexOutOfBoundsException e1) {
					mostrarMensagemDeErro("Selecione um contact para remover");
				} catch (BarberException e1) {
					mostrarMensagemDeErro(e1.getMessage());
				} catch (SQLException e1) {
					mostrarMensagemDeErro(e1.getMessage());
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
				RegisterPhonebook frame = new RegisterPhonebook();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
			}
		});
		btnVoltar.setBounds(335, 228, 89, 23);
		contentPane.add(btnVoltar);
	}

	private void mostrarMensagemDeErro(String informacao) {
		JOptionPane.showMessageDialog(null, informacao, "Aten��o",
				JOptionPane.INFORMATION_MESSAGE);
	}

}
