package view;

import java.awt.Checkbox;
import java.awt.Event;
import java.awt.EventQueue;

import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import javax.swing.text.MaskFormatter;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.UIManager;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

import exception.ReceiptException;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.sql.SQLException;
import java.text.ParseException;

@SuppressWarnings("serial")
public class SearchReport extends JFrame {

	private JPanel contentPane;
	private JTextField txtDataInicial;
	private JTextField txtDataFinal;
	private JTextField txtBarber;
	private JTextField txtJob;
	public static int typeBusca = 0;
	public static String job = "job";
	public static String barber = "barber";
	public static String dataInicial = "dataInicial";
	public static String dataFinal = "dataFinal";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchReport frame = new SearchReport();
					frame.setVisible(true);
				} catch (Exception e) {
					mostrarMensagemDeErro(e.getMessage());
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @throws ParseException
	 */
	public SearchReport() throws ParseException {
		setTitle("Tipo de Pesquisa do Relat\u00F3rio");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 372, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		final MaskFormatter mascaraFormatoData = new MaskFormatter("##/##/####");

		JPanel panelData = new JPanel();
		panelData.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"), "Por Data",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelData.setBounds(10, 11, 221, 97);
		contentPane.add(panelData);
		panelData.setLayout(null);

		txtDataInicial = new JFormattedTextField(mascaraFormatoData);
		txtDataInicial.setEnabled(false);
		txtDataInicial.setBounds(10, 66, 94, 20);
		panelData.add(txtDataInicial);
		txtDataInicial.setColumns(10);

		txtDataFinal = new JFormattedTextField(mascaraFormatoData);
		txtDataFinal.setEnabled(false);
		txtDataFinal.setBounds(114, 66, 94, 20);
		panelData.add(txtDataFinal);
		txtDataFinal.setColumns(10);

		JLabel lblDataInicial = new JLabel("Data Inicial");
		lblDataInicial.setBounds(10, 53, 86, 14);
		panelData.add(lblDataInicial);

		final Checkbox checkPorData = new Checkbox("Ativar");
		checkPorData.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (checkPorData.getState() == false) {
					txtDataInicial.setEnabled(false);
					txtDataFinal.setEnabled(false);
				} else {
					txtDataInicial.setEnabled(true);
					txtDataFinal.setEnabled(true);
				}
			}
		});
		checkPorData.setBounds(6, 23, 71, 23);
		panelData.add(checkPorData);

		JLabel lblDataFinal = new JLabel("Data Final");
		lblDataFinal.setBounds(114, 53, 71, 14);
		panelData.add(lblDataFinal);

		JPanel panelBarber = new JPanel();
		panelBarber.setLayout(null);
		panelBarber.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"), "Por Barber",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelBarber.setBounds(10, 119, 221, 62);
		contentPane.add(panelBarber);

		txtBarber = new JTextField();
		txtBarber.setText("Nome do barber");
		txtBarber.setEnabled(false);
		txtBarber.setColumns(10);
		txtBarber.setBounds(71, 23, 140, 20);
		panelBarber.add(txtBarber);

		final Checkbox checkBarber = new Checkbox("Ativar");
		checkBarber.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (checkBarber.getState() == false) {
					txtBarber.setEnabled(false);
					txtBarber.setText("Nome do barber");
				} else {
					txtBarber.setEnabled(true);
					txtBarber.setText("");
				}
			}
		});

		checkBarber.setBounds(6, 23, 59, 23);
		panelBarber.add(checkBarber);

		JPanel panelJob = new JPanel();
		panelJob.setLayout(null);
		panelJob.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"), "Por Servi\u00E7o",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelJob.setBounds(10, 189, 221, 62);
		contentPane.add(panelJob);

		txtJob = new JTextField();
		txtJob.setText("Tipo de Servi\u00E7o");
		txtJob.setEnabled(false);
		txtJob.setColumns(10);
		txtJob.setBounds(71, 23, 140, 20);
		panelJob.add(txtJob);

		final Checkbox checkJob = new Checkbox("Ativar");
		checkJob.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (checkJob.getState() == false) {
					txtJob.setEnabled(false);
					txtJob.setText("Tipo de Servi\u00E7o");
				} else {
					txtJob.setEnabled(true);
					txtJob.setText("");
				}
			}
		});
		checkJob.setBounds(6, 23, 59, 23);
		panelJob.add(checkJob);

		JButton btnConcluir = new JButton("Concluir");
		btnConcluir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				if (txtBarber.getText().equals("")) {
					JOptionPane.showMessageDialog(null,
							"Digite o name do barber.");
				} else if (txtJob.getText().equals("")) {
					JOptionPane.showMessageDialog(null,
							"Digite um type de servi�o.");
				} else if (txtDataFinal.getText().equals("")) {
					JOptionPane
							.showMessageDialog(null, "Digite uma data final");
				} else if (txtDataInicial.getText().equals("")) {
					JOptionPane.showMessageDialog(null,
							"Digite uma data inicial");
				} else {

					if (checkBarber.getState() == true
							&& checkPorData.getState() == false
							&& checkJob.getState() == false) {
						barber = txtBarber.getText();
						typeBusca = 1;
					}

					if (checkBarber.getState() == true
							&& checkPorData.getState() == false
							&& checkJob.getState() == true) {
						barber = txtBarber.getText();
						job = txtJob.getText();
						typeBusca = 2;
					}
					if (checkBarber.getState() == true
							&& checkPorData.getState() == true
							&& checkJob.getState() == false) {
						barber = txtBarber.getText();
						dataInicial = txtDataInicial.getText();
						dataFinal = txtDataFinal.getText();
						typeBusca = 3;
					}
					if (checkBarber.getState() == true
							&& checkPorData.getState() == true
							&& checkJob.getState() == true) {
						barber = txtBarber.getText();
						dataInicial = txtDataInicial.getText();
						dataFinal = txtDataFinal.getText();
						job = txtJob.getText();
						typeBusca = 4;
					}
					if (checkBarber.getState() == false
							&& checkPorData.getState() == false
							&& checkJob.getState() == true) {
						job = txtJob.getText();
						typeBusca = 5;
					}
					if (checkBarber.getState() == false
							&& checkPorData.getState() == true
							&& checkJob.getState() == true) {
						dataInicial = txtDataInicial.getText();
						dataFinal = txtDataFinal.getText();
						job = txtJob.getText();
						typeBusca = 6;
					}
					if (checkBarber.getState() == false
							&& checkPorData.getState() == true
							&& checkJob.getState() == false) {
						dataInicial = txtDataInicial.getText();
						dataFinal = txtDataFinal.getText();
						typeBusca = 7;
					}
				}

				if (checkBarber.getState() == false
						&& checkPorData.getState() == false
						&& checkJob.getState() == false) {
					JOptionPane.showMessageDialog(null,
							"Selecione uma op��o de busca");
				}
				if (typeBusca != 0) {
					try {
						VisualizarRelatorios frame = new VisualizarRelatorios();
						frame.setVisible(true);
						frame.setLocationRelativeTo(null);
						dispose();
					} catch (SQLException e) {
						mostrarMensagemDeErro(e.getMessage());
					} catch (ReceiptException e) {
						mostrarMensagemDeErro(e.getMessage());
					} catch (NullPointerException e) {
						mostrarMensagemDeErro(e.getMessage());
					} catch (ParseException e) {
						mostrarMensagemDeErro(e.getMessage());
					}

				}

			}
		});
		btnConcluir.setBounds(241, 11, 105, 62);
		contentPane.add(btnConcluir);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					VisualizarRelatorios frame = new VisualizarRelatorios();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					dispose();
				} catch (SQLException e1) {
					mostrarMensagemDeErro(e1.getMessage());
				} catch (ReceiptException e1) {
					mostrarMensagemDeErro(e1.getMessage());
				} catch (NullPointerException e1) {
					mostrarMensagemDeErro(e1.getMessage());
				} catch (ParseException e1) {
					mostrarMensagemDeErro(e1.getMessage());
				}
			}
		});
		btnVoltar.setBounds(241, 228, 105, 23);
		contentPane.add(btnVoltar);
	}

	public boolean action(Event evento, Object arg) {
		return false;
	}

	private static void mostrarMensagemDeErro(String informacao) {
		JOptionPane.showMessageDialog(null, informacao, "Aten��o",
				JOptionPane.INFORMATION_MESSAGE);
	}

}
