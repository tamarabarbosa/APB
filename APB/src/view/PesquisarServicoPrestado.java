package view;

import java.awt.EventQueue;
import model.JobPrestado;

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

import control.JobPrestadoController;

import dao.FactoryConnection;
import exception.JobException;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

@SuppressWarnings("serial")
public class PesquisarJobPrestado extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private Connection connection;
	private static String tempNome;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PesquisarJobPrestado frame = new PesquisarJobPrestado();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public PesquisarJobPrestado() {
		inicializarComponentes();
	}

	public void inicializarComponentes() {
		setTitle("Pesquisar Servi\u00E7o");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 464, 115);
		contentPane.add(scrollPane);

		final DefaultTableModel modelo = new DefaultTableModel(null,
				new String[] { "Serviço", "Realizado por", "Valor", "Data" });
		final JTable table = new JTable(modelo);
		scrollPane.setViewportView(table);

		textField = new JTextField();
		textField.setBounds(82, 137, 392, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblPesquisar = new JLabel("Pesquisar:");
		lblPesquisar.setBounds(20, 137, 66, 14);
		contentPane.add(lblPesquisar);

		JButton btnPesquisarJob = new JButton("Pesquisar Serviço");
		btnPesquisarJob.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					JobPrestado job = new JobPrestado();
					job.setNomeJob(textField.getText());

					connection = FactoryConnection.getInstance().getConnection();
					ResultSet rs = connection.createStatement().executeQuery(
							"SELECT name, preco, barber, data FROM jobprestado WHERE name = '"
									+ job.getNomeJob() + "' ORDER BY data;");

					while (rs.next()) {
						String[] dados = new String[4];
						dados[0] = rs.getString("name");
						dados[1] = rs.getString("barber");
						dados[2] = rs.getString("preco");
						dados[3] = job.ConverterDataParaABNT(rs.getString("data"));
						modelo.addRow(dados);
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
		btnPesquisarJob.setBounds(10, 168, 148, 23);
		contentPane.add(btnPesquisarJob);

		JButton btnPesquisarBarber = new JButton("Pesquisar Barber");
		btnPesquisarBarber.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					JobPrestado job = new JobPrestado();
					job.setNomeBarber(textField.getText());

					connection = FactoryConnection.getInstance().getConnection();
					ResultSet rs = connection.createStatement().executeQuery(
							"SELECT name, preco, barber, data FROM jobprestado WHERE barber = '"
									+ job.getNomeBarber() + "' ORDER BY data;");

					while (rs.next()) {
						String[] dados = new String[4];
						dados[0] = rs.getString("name");
						dados[1] = rs.getString("barber");
						dados[2] = rs.getString("preco");
						dados[3] = job.ConverterDataParaABNT(rs.getString("data"));
						modelo.addRow(dados);
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
		btnPesquisarBarber.setBounds(168, 168, 148, 23);
		contentPane.add(btnPesquisarBarber);

		JButton btnRemover = new JButton("Remover");
		btnRemover.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					String name = (String) table.getValueAt(table.getSelectedRow(), 0);
					String barber = (String) table.getValueAt(table.getSelectedRow(), 1);
					String valor = (String) table.getValueAt(table.getSelectedRow(), 2);
					String data = (String) table.getValueAt(table.getSelectedRow(), 3);
					JobPrestado job = new JobPrestado();
					job.setNomeJob(name);
					job.setNomeBarber(barber);
					job.setPreco(valor);
					job.setData(data);

					int confirmacao = JOptionPane.showConfirmDialog(null,
							"Remover " + name + " da lista?");

					if (confirmacao == JOptionPane.YES_OPTION) {
						JobPrestadoController jobController = JobPrestadoController.getInstance();
						jobController.delete(job);

						dispose();
						CadastrarJobPrestado frame = new CadastrarJobPrestado();
						frame.setVisible(true);
						frame.setLocationRelativeTo(null);
					}
				} catch (ArrayIndexOutOfBoundsException e) {
					mostrarMensagemDeErro("Selecione um Serviço para remover");
				} catch (JobException e) {
					mostrarMensagemDeErro(e.getMessage());
				} catch (SQLException e) {
					mostrarMensagemDeErro(e.getMessage());
				} catch (ParseException e) {
					mostrarMensagemDeErro(e.getMessage());
				}

			}
		});
		btnRemover.setBounds(123, 228, 89, 23);
		contentPane.add(btnRemover);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				CadastrarJobPrestado frame = new CadastrarJobPrestado();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
			}
		});
		btnVoltar.setBounds(279, 228, 89, 23);
		contentPane.add(btnVoltar);

		JButton btnPesquisarData = new JButton("Pesquisar Data");
		btnPesquisarData.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					JobPrestado job = new JobPrestado();
					job.setData(textField.getText());

					connection = FactoryConnection.getInstance().getConnection();
					ResultSet rs = connection.createStatement().executeQuery(
							"Select name, preco, barber, data from jobprestado where data = '"
									+ job.getData() + "' order by data;");

					while (rs.next()) {
						String[] dados = new String[4];
						dados[0] = rs.getString("name");
						dados[1] = rs.getString("barber");
						dados[2] = rs.getString("preco");
						dados[3] = job.ConverterDataParaABNT(rs.getString("data"));
						modelo.addRow(dados);
					}
				} catch (SQLException e) {
					mostrarMensagemDeErro(e.getMessage());
				} catch (ParseException e) {
					mostrarMensagemDeErro(e.getMessage());
				} catch (JobException e) {
					mostrarMensagemDeErro(e.getMessage());
				}

			}
		});
		btnPesquisarData.setBounds(326, 168, 148, 23);
		contentPane.add(btnPesquisarData);
	}

	private void mostrarMensagemDeErro(String informacao) {
		JOptionPane.showMessageDialog(null, informacao, "Atenção",
				JOptionPane.INFORMATION_MESSAGE);
	}

	public static String getTempNome() {
		return tempNome;
	}
}
