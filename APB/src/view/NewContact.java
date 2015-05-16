package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;

import control.ContactController;
import exception.BarberException;
import model.Contact;
import model.Phonebook;

import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Logger;

@SuppressWarnings("serial")
public class NewContact extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNome;
	private JTextField textFieldPhone;
	private JTextField textFieldDescricao;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewContact frame = new NewContact();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		Logger.getLogger("Create the frame to a new contact");
	}

	public NewContact() throws ParseException {
		inicializarComponentes();
	}

	public void inicializarComponentes() throws ParseException {
		setTitle("Novo Contato");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		MaskFormatter mascraFormatTel = new MaskFormatter("(##)####-####");
		Logger.getLogger("initialize the components of new contact");

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Contact phonebook = new Contact();
					phonebook.setName(textFieldNome.getText());
					phonebook.setName(textFieldPhone.getText());
					phonebook.setDescription(textFieldDescricao.getText());

					ContactController phonebookController = ContactController
							.getInstance();
					phonebookController.include(phonebook);

					JOptionPane.showMessageDialog(null, "Contato "
							+ textFieldNome.getText()
							+ " foi adicionado com sucesso");

					textFieldNome.setText("");
					textFieldPhone.setText("");
					textFieldDescricao.setText("");

					dispose();
					RegisterPhonebook frame = new RegisterPhonebook();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					
					
					
				} catch (SQLException e1) {
					mostrarMensagemDeErro(e1.getMessage());
				} catch (BarberException e1) {
					mostrarMensagemDeErro(e1.getMessage());
				}
				Logger.getLogger("save the change confirm to a new contact was created");
			}

		});

		btnSalvar.setBounds(26, 218, 109, 33);
		contentPane.add(btnSalvar);

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

		btnVoltar.setBounds(166, 218, 100, 33);
		contentPane.add(btnVoltar);
		Logger.getLogger("save the change confirm to a new barber was created");
		
		JButton btnLimparCampos = new JButton("Limpar Campos");
		btnLimparCampos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textFieldNome.setText("");
				textFieldPhone.setText("");
				textFieldDescricao.setText("");
			}
		});

		btnLimparCampos.setBounds(287, 218, 125, 33);
		contentPane.add(btnLimparCampos);


		textFieldNome = new JTextField();
		textFieldNome.setBounds(85, 23, 327, 20);
		contentPane.add(textFieldNome);
		textFieldNome.setColumns(10);

		textFieldPhone = new JFormattedTextField(mascraFormatTel);
		textFieldPhone.setBounds(85, 67, 327, 20);
		contentPane.add(textFieldPhone);
		textFieldPhone.setColumns(10);

		textFieldDescricao = new JTextField();
		textFieldDescricao.setBounds(85, 117, 327, 44);
		contentPane.add(textFieldDescricao);
		textFieldDescricao.setColumns(10);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(22, 26, 46, 14);
		contentPane.add(lblNome);

		JLabel lblPhone = new JLabel("Phone:");
		lblPhone.setBounds(22, 70, 64, 14);
		contentPane.add(lblPhone);

		JLabel lblDescricao = new JLabel("Descri\u00E7\u00E3o:");
		lblDescricao.setBounds(22, 117, 64, 14);
		contentPane.add(lblDescricao);
		Logger.getLogger("clean the fields");
	}

	private void mostrarMensagemDeErro(String informacao) {
		JOptionPane.showMessageDialog(null, informacao, "Aten��o",
				JOptionPane.INFORMATION_MESSAGE);
	}
}
