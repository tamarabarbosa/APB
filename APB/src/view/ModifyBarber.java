package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

import control.BarberController;
import exception.BarberException;

import model.Barber;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

@SuppressWarnings("serial")
public class ModifyBarber extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNome;
	private JTextField textFieldRg;
	private JTextField textFieldPhone;
	private JTextField textFieldChair;
	private String name;
	private JTextField textFieldCpf;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModifyBarber frame = new ModifyBarber();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
				Logger.getLogger("Create the frame of moddify barber");
			}
		});
	}

	// Constructor
	public ModifyBarber() {

		setTitle("Alterar Barber");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 475, 283);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textFieldNome = new JTextField();
		textFieldNome.setColumns(10);
		textFieldNome.setBounds(92, 11, 354, 20);
		contentPane.add(textFieldNome);

		JLabel labelNome = new JLabel("Nome:");
		labelNome.setBounds(21, 14, 46, 14);
		contentPane.add(labelNome);

		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(21, 43, 31, 14);
		contentPane.add(lblCpf);

		textFieldCpf = new JTextField();
		textFieldCpf.setBounds(92, 40, 354, 20);
		contentPane.add(textFieldCpf);
		textFieldCpf.setColumns(10);

		textFieldRg = new JTextField();
		textFieldRg.setColumns(10);
		textFieldRg.setBounds(92, 71, 354, 20);
		contentPane.add(textFieldRg);

		JLabel labelRg = new JLabel("RG:");
		labelRg.setBounds(21, 77, 46, 14);
		contentPane.add(labelRg);

		textFieldPhone = new JTextField();
		textFieldPhone.setColumns(10);
		textFieldPhone.setBounds(92, 102, 354, 20);
		contentPane.add(textFieldPhone);

		JLabel labelPhone = new JLabel("Phone:");
		labelPhone.setBounds(21, 108, 61, 14);
		contentPane.add(labelPhone);

		textFieldChair = new JTextField();
		textFieldChair.setColumns(10);
		textFieldChair.setBounds(92, 133, 354, 20);
		contentPane.add(textFieldChair);

		JLabel labelChair = new JLabel("Chair:");
		labelChair.setBounds(21, 139, 61, 14);
		contentPane.add(labelChair);

		try {
			Barber barber = new Barber();
			BarberController barberController = BarberController.getInstance();
			barber.setName(Barber.getTempName());

			ResultSet rs = barberController.searchBarberByName(barber);

			while (rs.next()) {
				textFieldNome.setText(rs.getString("name"));
				textFieldCpf.setText(rs.getString("cpf"));
				textFieldRg.setText(rs.getString("rg"));
				textFieldPhone.setText(rs.getString("telefone"));
				textFieldChair.setText(rs.getString("chair"));
			}
			name = textFieldCpf.getText();
		} catch (SQLException e) {
			mostrarMensagemDeErro(e.getMessage());
		} catch (BarberException e) {
			mostrarMensagemDeErro(e.getMessage());
		}

		JButton buttonSalvar = new JButton("Salvar");
		buttonSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Barber barber = new Barber();
					barber.setName(textFieldNome.getText());
					barber.setCpf(textFieldCpf.getText());
					barber.setRg(textFieldRg.getText());
					barber.setPhoneNumber(textFieldPhone.getText());
					barber.setChair(textFieldChair.getText());

					BarberController barberController = BarberController
							.getInstance();
					barberController.change(name, barber);

					JOptionPane.showMessageDialog(null, "Barber "
							+ textFieldNome.getText()
							+ " foi change com sucesso");

					dispose();
					RegisterBarber frame = new RegisterBarber();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);

				} catch (BarberException e1) {
					mostrarMensagemDeErro(e1.getMessage());
				} catch (SQLException k) {
					mostrarMensagemDeErro(k.getMessage());
				}
				Logger.getLogger("save the change of barber");
			}
		});
		buttonSalvar.setBounds(10, 196, 125, 23);
		contentPane.add(buttonSalvar);

		JButton buttonLimpar = new JButton("Limpar Campos");
		buttonLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldNome.setText("");
				textFieldRg.setText("");
				textFieldPhone.setText("");
				textFieldChair.setText("");
				
				Logger.getLogger("Clean the fields ");
			}
		});
		buttonLimpar.setBounds(308, 196, 138, 23);
		contentPane.add(buttonLimpar);

		JButton buttonVoltar = new JButton("Voltar");
		buttonVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				RegisterBarber frame = new RegisterBarber();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
			}
		});
		buttonVoltar.setBounds(158, 196, 125, 23);
		contentPane.add(buttonVoltar);
		Logger.getLogger("Create the button to back");

	}

	// Method used to show an error message for exception treatment
	private void mostrarMensagemDeErro(String informacao) {
		JOptionPane.showMessageDialog(null, informacao, "Aten��o",
				JOptionPane.INFORMATION_MESSAGE);
	}
}
