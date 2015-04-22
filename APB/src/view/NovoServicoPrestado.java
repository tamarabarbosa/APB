package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import control.JobPrestadoController;
import exception.JobException;
import model.JobPrestado;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import dao.FactoryConnection;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

@SuppressWarnings("serial")
public class NovoJobPrestado extends JFrame {

	private JPanel contentPane;
	private JTextField textValor;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NovoJobPrestado frame = new NovoJobPrestado();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public NovoJobPrestado() {
		setTitle("Criar nova presta\u00E7\u00E3o de servi\u00E7o");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 474, 214);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblJob = new JLabel("Servi\u00E7o:");
		lblJob.setBounds(27, 25, 46, 14);
		contentPane.add(lblJob);

		JLabel lblRealizadoPor = new JLabel("Realizado por:");
		lblRealizadoPor.setBounds(27, 56, 92, 14);
		contentPane.add(lblRealizadoPor);

		JLabel lblPreco = new JLabel("Pre\u00E7o (R$):");
		lblPreco.setBounds(27, 87, 71, 14);
		contentPane.add(lblPreco);

		textValor = new JTextField();
		textValor.setColumns(10);
		textValor.setBounds(129, 84, 114, 20);
		contentPane.add(textValor);

		final JComboBox comboBoxBarber = new JComboBox();
		comboBoxBarber.setModel(new DefaultComboBoxModel(
				new String[] { "Selecione um barber" }));
		comboBoxBarber.setBounds(129, 53, 289, 20);
		contentPane.add(comboBoxBarber);

		final JComboBox comboBoxJob = new JComboBox();
		comboBoxJob.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				Connection connection;
				if (comboBoxJob.getSelectedIndex() != 0)
					try {
						String[] name = comboBoxJob.getSelectedItem()
								.toString().split(" - ");
						connection = FactoryConnection.getInstance()
								.getConnection();
						java.sql.PreparedStatement pst1 = connection
								.prepareStatement("SELECT preco FROM typeJob WHERE name = \""
										+ name[1] + "\";");
						ResultSet rs1 = pst1.executeQuery();
						rs1.next();

						textValor.setText(rs1.getString("preco"));
					} catch (SQLException e) {
						mostrarMensagemDeErro(e.getMessage());
					}
			}

		});
		comboBoxJob.setModel(new DefaultComboBoxModel(
				new String[] { "Selecione um type de servi\u00E7o" }));
		comboBoxJob.setMaximumRowCount(4);
		comboBoxJob.setBounds(129, 22, 289, 20);
		contentPane.add(comboBoxJob);
		try {
			int cont = 0;
			Connection connection = FactoryConnection.getInstance()
					.getConnection();
			java.sql.PreparedStatement pst = connection
					.prepareStatement("SELECT name, chair FROM barber ORDER BY chair;");
			java.sql.PreparedStatement pst2 = connection
					.prepareStatement("SELECT name FROM typejob;");
			ResultSet rs = pst.executeQuery();
			ResultSet rs2 = pst2.executeQuery();

			while (rs.next()) {
				String name = rs.getString("name");
				String chair = rs.getString("chair");
				comboBoxBarber.addItem(chair + " - " + name);
			}
			while (rs2.next()) {
				cont++;
				String name = rs2.getString("name");
				comboBoxJob.addItem(cont + " - " + name);
			}

		} catch (SQLException e) {
			mostrarMensagemDeErro(e.getMessage());
		}

		JButton botaoSalvar = new JButton("Salvar");
		botaoSalvar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					if (comboBoxJob.getSelectedIndex() == 0)
						JOptionPane.showMessageDialog(null,
								"Você deve selecionar um type de serviço.");
					else if (comboBoxBarber.getSelectedIndex() == 0)
						JOptionPane.showMessageDialog(null,
								"Você deve selecionar um barber.");
					else {
						String data;
						Date d = new Date();
						SimpleDateFormat sdf = new SimpleDateFormat(
								"yyyy-MM-dd");
						data = sdf.format(d);

						String[] name = comboBoxJob.getSelectedItem()
								.toString().split(" - ");
						String[] barber = comboBoxBarber.getSelectedItem()
								.toString().split(" - ");

						JobPrestado job_prestado = new JobPrestado();

						job_prestado.setNomeBarber(barber[1]);
						job_prestado.setNomeJob(name[1]);
						job_prestado.setPreco(textValor.getText());
						job_prestado.setData(data);

						JobPrestadoController jobController = JobPrestadoController
								.getInstance();
						jobController.insert(job_prestado);

						JOptionPane.showMessageDialog(null,
								"Serviço criado com sucesso");

						comboBoxBarber.setSelectedIndex(0);
						comboBoxJob.setSelectedIndex(0);

						textValor.setText("");
					}
				} catch (JobException e) {
					mostrarMensagemDeErro(e.getMessage());
				} catch (SQLException e) {
					mostrarMensagemDeErro(e.getMessage());
				} catch (ParseException e) {
					mostrarMensagemDeErro(e.getMessage());
				}

			}
		});
		botaoSalvar.setBounds(27, 129, 89, 23);
		contentPane.add(botaoSalvar);

		JButton botaoLimparCampos = new JButton("Limpar Campos");
		botaoLimparCampos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				textValor.setText("");
				comboBoxBarber.setSelectedIndex(0);
				comboBoxJob.setSelectedIndex(0);
			}
		});
		botaoLimparCampos.setBounds(152, 129, 148, 23);
		contentPane.add(botaoLimparCampos);

		JButton botaoVoltar = new JButton("Voltar");
		botaoVoltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
				CadastrarJobPrestado frame = new CadastrarJobPrestado();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
			}
		});
		botaoVoltar.setBounds(329, 129, 89, 23);
		contentPane.add(botaoVoltar);
	}

	private void mostrarMensagemDeErro(String informacao) {
		JOptionPane.showMessageDialog(null, informacao, "Atenção",
				JOptionPane.INFORMATION_MESSAGE);
	}
}
