package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

import control.ServiceTypeController;
import exception.ServiceException;
import model.ServiceType;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

@SuppressWarnings("serial")
public class ModifyServiceType extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNome;
	private JTextField textFieldPreco;
	private String name;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModifyServiceType frame = new ModifyServiceType();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// These methods are used to initialize the components
	public ModifyServiceType() {
		setTitle("Alterar Tipo Job");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 436, 163);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textFieldNome = new JTextField();
		textFieldNome.setColumns(10);
		textFieldNome.setBounds(121, 11, 289, 20);
		contentPane.add(textFieldNome);

		JLabel labelNome = new JLabel("Tipo de servi\u00E7o:");
		labelNome.setBounds(21, 14, 90, 14);
		contentPane.add(labelNome);

		textFieldPreco = new JTextField();
		textFieldPreco.setColumns(10);
		textFieldPreco.setBounds(121, 42, 289, 20);
		contentPane.add(textFieldPreco);

		JLabel labelChair = new JLabel("Pre\u00E7o:");
		labelChair.setBounds(21, 45, 61, 14);
		contentPane.add(labelChair);

		try {
			ServiceType typejob = new ServiceType();
			ServiceTypeController jobController = ServiceTypeController
					.getInstance();
			typejob.setNameServiceType(ServiceType.getTempName());
			ResultSet rs = ServiceTypeController.searchByName(typejob);

			while (rs.next()) {
				textFieldNome.setText(rs.getString("name"));
				textFieldPreco.setText(rs.getString("preco"));
			}
			name = textFieldNome.getText();
		} catch (SQLException e) {
			mostrarMensagemDeErro(e.getMessage());
		} catch (ServiceException e) {
			mostrarMensagemDeErro(e.getMessage());
		}
		Logger.getLogger("initialize the components on the frame");

		JButton buttonSalvar = new JButton("Salvar");
		buttonSalvar.addActionListener(new ActionListener() {
			// This method is used to initialize the main frame of the
			// application
			public void actionPerformed(ActionEvent e) {
				try {
					ServiceType typeJob = new ServiceType();
					typeJob.setNameServiceType(textFieldNome.getText());
					typeJob.setPrice(textFieldPreco.getText());

					ServiceTypeController typeJobController = ServiceTypeController
							.getInstance();
					typeJobController.change(name, typeJob);

					JOptionPane.showMessageDialog(null, "Tipo de Serviço "
							+ textFieldNome.getText()
							+ " foi change com sucesso");

					dispose();
					RegisterDoneService frame = new RegisterDoneService();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (ServiceException e1) {
					mostrarMensagemDeErro(e1.getMessage());
				} catch (SQLException k) {
					mostrarMensagemDeErro(k.getMessage());
				}
			}
		});
		buttonSalvar.setBounds(10, 86, 124, 23);
		contentPane.add(buttonSalvar);
		Logger.getLogger("save the change of the type of service is modify");

		JButton buttonLimpar = new JButton("Limpar Campos");
		buttonLimpar.addActionListener(new ActionListener() {
			// This method is used to initialize the panel to insert the
			// components
			public void actionPerformed(ActionEvent e) {
				textFieldNome.setText("");
				textFieldPreco.setText("");
			}
		});
		buttonLimpar.setBounds(282, 86, 128, 23);
		contentPane.add(buttonLimpar);
		Logger.getLogger("clean the fields");

		JButton buttonVoltar = new JButton("Voltar");
		buttonVoltar.addActionListener(new ActionListener() {
			// This method is used to initialize the text fields on the frame
			public void actionPerformed(ActionEvent e) {
				dispose();
				RegisterDoneService frame = new RegisterDoneService();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
			}
		});
		buttonVoltar.setBounds(144, 86, 128, 23);
		contentPane.add(buttonVoltar);
		Logger.getLogger("make the action to back");
	}

	// Method that shows the error message when a exception is triggered
	private void mostrarMensagemDeErro(String informacao) {
		JOptionPane.showMessageDialog(null, informacao, "Atenção",
				JOptionPane.INFORMATION_MESSAGE);
	}
}
