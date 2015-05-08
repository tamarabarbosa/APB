package view;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import control.DoneServiceController;
import model.DoneService;
import exception.ServiceException;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class RegisterDoneService extends JFrame {

	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterDoneService frame = new RegisterDoneService();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// These methods are used to initialize the components
	public RegisterDoneService() {
		setTitle("Servi\u00E7os Prestados");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 360, 240);
		contentPane.add(scrollPane);

		final DefaultTableModel modelo = new DefaultTableModel(null,
				new String[] { "Serviço", "Realizado por", "Valor", "Data" });
		final JTable table = new JTable(modelo);

		try {
			DoneServiceController jobController = DoneServiceController
					.getInstance();
			DoneService job = new DoneService();
			ResultSet rs = jobController.mostrarJobsPrestadosCadastrados(job);
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
		}

		scrollPane.setViewportView(table);

		JButton btnNovo = new JButton("Novo");
		btnNovo.addMouseListener(new MouseAdapter() {
			@Override
			// This method is used to initialize the main frame of the
			// application
			public void mouseClicked(MouseEvent arg0) {
				dispose();
				NewServiceType frame = new NewServiceType();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
			}
		});
		btnNovo.setBounds(380, 24, 94, 23);
		contentPane.add(btnNovo);

		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addMouseListener(new MouseAdapter() {
			@Override
			// This method is used to create a table that contains the contacts
			public void mouseClicked(MouseEvent e) {
				SearchDoneService frame = new SearchDoneService();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnPesquisar.setBounds(380, 58, 94, 23);
		contentPane.add(btnPesquisar);

		JButton btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			// This method is used to initialize the buttons
			public void actionPerformed(ActionEvent arg0) {
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
					}
				} catch (ArrayIndexOutOfBoundsException e) {
					mostrarMensagemDeErro("Selecione um Serviço para remover");
				} catch (ServiceException e) {
					mostrarMensagemDeErro(e.getMessage());
				} catch (SQLException e) {
					mostrarMensagemDeErro(e.getMessage());
				} catch (ParseException e) {
					mostrarMensagemDeErro(e.getMessage());
				}

			}
		});
		btnRemover.setBounds(380, 92, 94, 23);
		contentPane.add(btnRemover);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addMouseListener(new MouseAdapter() {
			@Override
			// This method is used to create the button and the action that open
			// the main frame
			public void mouseClicked(MouseEvent arg0) {
				dispose();
				MainMenu frame = new MainMenu();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
			}
		});
		btnVoltar.setBounds(380, 228, 94, 23);
		contentPane.add(btnVoltar);
	}

	// Method that shows the error message when a exception is triggered
	private void mostrarMensagemDeErro(String informacao) {
		JOptionPane.showMessageDialog(null, informacao, "Atenção",
				JOptionPane.INFORMATION_MESSAGE);
	}
}
