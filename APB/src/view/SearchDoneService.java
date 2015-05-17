package view;

import java.awt.EventQueue;

import model.DoneService;

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

import control.DoneServiceController;
import dao.FactoryConnection;
import exception.ServiceException;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Logger;

@SuppressWarnings("serial")
public class SearchDoneService extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private Connection connection;
	private static String tempNome;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchDoneService frame = new SearchDoneService();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		Logger.getLogger("Create the frame search done service");
	}

	public SearchDoneService() {
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
				new String[] { "Servi�o", "Realizado por", "Valor", "Data" });
		final JTable table = new JTable(modelo);
		scrollPane.setViewportView(table);

		textField = new JTextField();
		textField.setBounds(82, 137, 392, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblPesquisar = new JLabel("Pesquisar:");
		lblPesquisar.setBounds(20, 137, 66, 14);
		contentPane.add(lblPesquisar);

		JButton btnPesquisarJob = new JButton("Pesquisar Servi�o");
		btnPesquisarJob.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					DoneService job = new DoneService();
					job.setServiceName(textField.getText());

					connection = FactoryConnection.getInstance()
							.getConnection();
					ResultSet rs = connection.createStatement()
							.executeQuery(
									"SELECT name, preco, barber, data FROM DoneService WHERE name = '"
											+ job.getServiceName()
											+ "' ORDER BY data;");
					Logger.getLogger("database connection has been established with sucess");

					while (rs.next()) {
						String[] dados = new String[4];
						dados[0] = rs.getString("name");
						dados[1] = rs.getString("barber");
						dados[2] = rs.getString("preco");
						dados[3] = job.ConvertTOABNT(rs.getString("data"));
						modelo.addRow(dados);
					}
				} catch (ServiceException e) {
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
		Logger.getLogger("table was created");		

		JButton btnPesquisarBarber = new JButton("Pesquisar Barber");
		btnPesquisarBarber.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					DoneService job = new DoneService();
					job.setBarberName(textField.getText());

					connection = FactoryConnection.getInstance()
							.getConnection();
					ResultSet rs = connection.createStatement().executeQuery(
							"SELECT name, preco, barber, data FROM DoneService WHERE barber = '"
									+ job.getBarberName() + "' ORDER BY data;");
					Logger.getLogger("database connection has been established with sucess");
					while (rs.next()) {
						String[] dados = new String[4];
						dados[0] = rs.getString("name");
						dados[1] = rs.getString("barber");
						dados[2] = rs.getString("preco");
						dados[3] = job.ConvertTOABNT(rs.getString("data"));
						modelo.addRow(dados);
					}
				} catch (ServiceException e) {
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
		Logger.getLogger("table 2 was created");

		JButton btnRemover = new JButton("Remover");
		btnRemover.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					String name = (String) table.getValueAt(
							table.getSelectedRow(), 0);
					String barber = (String) table.getValueAt(
							table.getSelectedRow(), 1);
					String valor = (String) table.getValueAt(
							table.getSelectedRow(), 2);
					String data = (String) table.getValueAt(
							table.getSelectedRow(), 3);
					DoneService job = new DoneService();
					job.setServiceName(name);
					job.setBarberName(barber);
					job.setPrice(valor);
					job.setDate(data);

					int confirmacao = JOptionPane.showConfirmDialog(null,
							"Remover " + name + " da lista?");

					if (confirmacao == JOptionPane.YES_OPTION) {
						DoneServiceController jobController = DoneServiceController
								.getInstance();
						jobController.delete(job);

						dispose();
						RegisterDoneService frame = new RegisterDoneService();
						frame.setVisible(true);
						frame.setLocationRelativeTo(null);
						Logger.getLogger("register are removed");
					}
					else{
						//nothing to do
					}
				} catch (ArrayIndexOutOfBoundsException e) {
					mostrarMensagemDeErro("Selecione um Servi�o para remover");
				} catch (ServiceException e) {
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
		Logger.getLogger("done service was deleted with sucess");

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				RegisterDoneService frame = new RegisterDoneService();
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
					DoneService job = new DoneService();
					job.setDate(textField.getText());

					connection = FactoryConnection.getInstance()
							.getConnection();
					ResultSet rs = connection.createStatement().executeQuery(
							"Select name, preco, barber, data from DoneService where data = '"
									+ job.getDate() + "' order by data;");
					Logger.getLogger("table 3 was created");
					while (rs.next()) {
						String[] dados = new String[4];
						dados[0] = rs.getString("name");
						dados[1] = rs.getString("barber");
						dados[2] = rs.getString("preco");
						dados[3] = job.ConvertTOABNT(rs.getString("data"));
						modelo.addRow(dados);
					}
				} catch (SQLException e) {
					mostrarMensagemDeErro(e.getMessage());
				} catch (ParseException e) {
					mostrarMensagemDeErro(e.getMessage());
				} catch (ServiceException e) {
					mostrarMensagemDeErro(e.getMessage());
				}

			}
		});
		btnPesquisarData.setBounds(326, 168, 148, 23);
		contentPane.add(btnPesquisarData);
		Logger.getLogger("search was done with sucess");
	}

	private void mostrarMensagemDeErro(String informacao) {
		JOptionPane.showMessageDialog(null, informacao, "Aten��o",
				JOptionPane.INFORMATION_MESSAGE);
	}

	public static String getTempNome() {
		return tempNome;
	}
}
