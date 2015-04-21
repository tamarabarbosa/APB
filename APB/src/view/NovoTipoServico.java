package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import control.TipoJobController;

import exception.JobException;

import model.TipoJob;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;


@SuppressWarnings("serial")
public class NovoTipoJob extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldJob;
	private JTextField textFieldPreco;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NovoTipoJob frame = new NovoTipoJob();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public NovoTipoJob() {
		setTitle("Cadastar novo tipo de servi\u00E7o");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 320, 180);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblJob = new JLabel("Serviço:");
		lblJob.setBounds(29, 33, 46, 14);
		contentPane.add(lblJob);

		textFieldJob = new JTextField();
		textFieldJob.setBounds(100, 30, 170, 20);
		contentPane.add(textFieldJob);
		textFieldJob.setColumns(10);

		textFieldPreco = new JTextField();
		textFieldPreco.setBounds(100, 63, 170, 20);
		contentPane.add(textFieldPreco);
		textFieldPreco.setColumns(10);

		JLabel lblPreco = new JLabel("Pre\u00E7o (R$):");
		lblPreco.setBounds(29, 65, 65, 17);
		contentPane.add(lblPreco);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					TipoJob tipoJob = new TipoJob();
					tipoJob.setNomeTipoJob(textFieldJob.getText());
					tipoJob.setPreco(textFieldPreco.getText());

					TipoJobController tipoJobController = TipoJobController
							.getInstance();
					tipoJobController.insert(tipoJob);

					JOptionPane.showMessageDialog(null, "Serviço "
							+ textFieldJob.getText()
							+ " foi cadastrado com sucesso");

					dispose();
					CadastrarTipoJob frame = new CadastrarTipoJob();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);

				} catch (JobException e) {
					mostrarMensagemDeErro(e.getMessage());
				} catch (IllegalArgumentException e) {
					mostrarMensagemDeErro(e.getMessage());
				} catch (SQLException e) {
				}
			}
		});
		btnSalvar.setBounds(29, 108, 89, 23);
		contentPane.add(btnSalvar);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastrarTipoJob frame = new CadastrarTipoJob();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnVoltar.setBounds(181, 108, 89, 23);
		contentPane.add(btnVoltar);
	}

	private void mostrarMensagemDeErro(String informacao) {
		JOptionPane.showMessageDialog(null, informacao, "Atenção",
				JOptionPane.INFORMATION_MESSAGE);
	}
}
