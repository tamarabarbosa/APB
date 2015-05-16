package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;

import control.ContactController;
import exception.BarberException;
import model.Contact;
import model.Phonebook;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

@SuppressWarnings("serial")
public class ModifyContact extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNome;
	private JTextField textFieldPhone;
	private JTextField textFieldDescricao;
	private String name;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModifyContact frame = new ModifyContact();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
				Logger.getLogger("Create the frame to Modify Contact");
			}
		});
	}

	// These methods are used to initialize the components
	public ModifyContact() {
		setTitle("Alterar Contato");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 225);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textFieldNome = new JTextField();
		textFieldNome.setBounds(83, 22, 341, 20);
		contentPane.add(textFieldNome);
		textFieldNome.setColumns(10);

		textFieldPhone = new JTextField();
		textFieldPhone.setBounds(83, 53, 341, 20);
		contentPane.add(textFieldPhone);
		textFieldPhone.setColumns(10);

		textFieldDescricao = new JTextField();
		textFieldDescricao.setBounds(83, 84, 341, 41);
		contentPane.add(textFieldDescricao);
		textFieldDescricao.setColumns(10);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 25, 46, 14);
		contentPane.add(lblNome);

		JLabel lblPhone = new JLabel("Phone:");
		lblPhone.setBounds(10, 56, 46, 14);
		contentPane.add(lblPhone);

		JLabel lblDescricao = new JLabel("Descri\u00E7\u00E3o:");
		lblDescricao.setBounds(10, 97, 63, 14);
		contentPane.add(lblDescricao);

		try {
			Contact contact = new Contact();
			ContactController phonebookController = ContactController
					.getInstance();
			contact.setName(Phonebook.getTempName());
			ResultSet rs = phonebookController.searchByName(contact);

			while (rs.next()) {
				textFieldNome.setText(rs.getString("name"));
				textFieldPhone.setText(rs.getString("telefone"));
				textFieldDescricao.setText(rs.getString("descricao"));
				
				Logger.getLogger("initialize the components of the frame");
			}
			name = textFieldNome.getText();
		} catch (SQLException e) {
			mostrarMensagemDeErro(e.getMessage());
		} catch (BarberException e) {
			mostrarMensagemDeErro(e.getMessage());
		}

		JButton btnSalvarAlteracao = new JButton("Salvar Altera\u00E7\u00E3o");
		btnSalvarAlteracao.addMouseListener(new MouseAdapter() {
			@Override
			// This method is used to initialize the buttons on the frame
			public void mouseClicked(MouseEvent arg0) {
				try {
					Contact phonebook = new Contact();
					phonebook.setName(textFieldNome.getText());
					phonebook.setName(textFieldPhone.getText());
					phonebook.setDescription(textFieldDescricao.getText());

					ContactController PhonebookController = control.ContactController
							.getInstance();
					PhonebookController.change(name, phonebook);

					JOptionPane.showMessageDialog(null, "Phonebook "
							+ textFieldNome.getText()
							+ " foi change com sucesso");

					dispose();
					RegisterPhonebook frame = new RegisterPhonebook();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (BarberException e1) {
					mostrarMensagemDeErro(e1.getMessage());
				} catch (SQLException k) {
					mostrarMensagemDeErro(k.getMessage());
				}
			}

		});
		btnSalvarAlteracao.setBounds(83, 136, 153, 31);
		contentPane.add(btnSalvarAlteracao);
		Logger.getLogger("save the change of contact");
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addMouseListener(new MouseAdapter() {
			@Override
			// This method is used to initialize the buttons on the frame
			public void mouseClicked(MouseEvent e) {

				dispose();
				RegisterPhonebook frame = new RegisterPhonebook();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
			}
		});
		btnVoltar.setBounds(259, 136, 165, 31);
		contentPane.add(btnVoltar);
		Logger.getLogger("Create the button to back");

	}

	// Method that shows the error message when a exception is triggered
	private void mostrarMensagemDeErro(String informacao) {
		JOptionPane.showMessageDialog(null, informacao, "Aten��o",
				JOptionPane.INFORMATION_MESSAGE);
	}
}
