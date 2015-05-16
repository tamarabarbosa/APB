package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

import model.Barber;
import control.BarberController;
import exception.BarberException;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Logger;

@SuppressWarnings("serial")
public class NewBarber extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNome;
	private JTextField textFieldCpf;
	private JTextField textFieldRg;
	private JTextField textFieldPhone;
	private JButton botaoSalvar;
	private JButton botaoLimparCampos;
	private JTextField textFieldChair;
	private JLabel lblChair;
	private JButton botaoVoltar;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewBarber frame = new NewBarber();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
				Logger.getLogger("Create the frame to a new barber");
			}
		});
	}

	public NewBarber() throws ParseException {
		inicializarComponentes();
	}

	public void inicializarComponentes() throws ParseException {
		setTitle("Cadastrar Barber");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 474, 253);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		getContentPane().setLayout(null);
		contentPane.setLayout(null);

		MaskFormatter mascraFormatTel = new MaskFormatter("(##)####-####");
		MaskFormatter mascraFormatCpf = new MaskFormatter("###.###.###-##");

		textFieldNome = new JTextField();
		textFieldNome.setBounds(92, 11, 354, 20);
		getContentPane().add(textFieldNome);
		textFieldNome.setColumns(10);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(21, 14, 46, 14);
		getContentPane().add(lblNome);

		textFieldCpf = new JFormattedTextField(mascraFormatCpf);
		textFieldCpf.setBounds(92, 42, 354, 20);
		getContentPane().add(textFieldCpf);
		textFieldCpf.setColumns(10);

		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(21, 45, 46, 14);
		getContentPane().add(lblCpf);

		textFieldRg = new JTextField();
		textFieldRg.setBounds(92, 73, 354, 20);
		getContentPane().add(textFieldRg);
		textFieldRg.setColumns(10);

		JLabel lblRg = new JLabel("RG:");
		lblRg.setBounds(21, 76, 46, 14);
		getContentPane().add(lblRg);

		textFieldPhone = new JFormattedTextField(mascraFormatTel);
		textFieldPhone.setBounds(92, 104, 354, 20);
		getContentPane().add(textFieldPhone);
		textFieldPhone.setColumns(10);

		JLabel lblPhone = new JLabel("Phone:");
		lblPhone.setBounds(21, 107, 61, 14);
		getContentPane().add(lblPhone);

		lblChair = new JLabel("Chair:");
		lblChair.setBounds(21, 136, 61, 14);
		contentPane.add(lblChair);

		botaoSalvar = new JButton("Salvar");
		Logger.getLogger("initialize the components of the frame");
		
		botaoSalvar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent k) {
				try {
					Barber barber = new Barber();
					barber.setName(textFieldNome.getText());
					barber.setCpf(textFieldCpf.getText());
					barber.setRg(textFieldRg.getText());
					barber.setPhoneNumber(textFieldPhone.getText());
					barber.setChair(textFieldChair.getText());

					BarberController barberController = BarberController
							.getInstance();
					barberController.insert(barber);

					JOptionPane.showMessageDialog(null, "Barber "
							+ textFieldNome.getText()
							+ " foi cadastrado com sucesso");

					dispose();
					RegisterBarber frame = new RegisterBarber();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (BarberException e) {
					mostrarMensagemDeErro(e.getMessage());
				} catch (SQLException e) {
					mostrarMensagemDeErro(e.getMessage());
				}
				Logger.getLogger("save the change confirm to a new barber was created");
			}

		});

		textFieldChair = new JTextField();
		textFieldChair.setBounds(92, 133, 354, 20);
		contentPane.add(textFieldChair);
		textFieldChair.setColumns(10);
		botaoSalvar.setBounds(10, 177, 125, 23);
		contentPane.add(botaoSalvar);

		botaoLimparCampos = new JButton("Limpar Campos");
		botaoLimparCampos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textFieldNome.setText("");
				textFieldCpf.setText("");
				textFieldRg.setText("");
				textFieldPhone.setText("");
				textFieldChair.setText("");
			}
		});
		botaoLimparCampos.setBounds(308, 177, 138, 23);
		contentPane.add(botaoLimparCampos);
		Logger.getLogger("clean the fields");
		
		botaoVoltar = new JButton("Voltar");
		botaoVoltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				RegisterBarber frame = new RegisterBarber();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
			}
		});
		botaoVoltar.setBounds(158, 177, 125, 23);
		contentPane.add(botaoVoltar);
		Logger.getLogger("make the action to return");

	}

	private void mostrarMensagemDeErro(String informacao) {
		JOptionPane.showMessageDialog(null, informacao, "Aten��o",
				JOptionPane.INFORMATION_MESSAGE);
	}
}
