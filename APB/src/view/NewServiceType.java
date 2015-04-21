package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JButton;

import control.ServiceTypeController;
import model.ServiceType;
import exception.ServiceException;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

@SuppressWarnings("serial")
public class NewServiceType extends JFrame {

	private JPanel contentPane;
	private static String nomeTemp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			// Method that initializes the window registration service type
			public void run() {
				try {
					NewServiceType frame = new NewServiceType();
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
	// Class constructor
	public NewServiceType() {
		setTitle("Tipo de Servi\u00E7o");
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
				new String[] { "Serviço", "Valor" });
		final JTable table = new JTable(modelo);
		try {
			ServiceTypeController servicoController = ServiceTypeController
					.getInstance();
			ServiceType servico = new ServiceType();
			ResultSet rs = servicoController
					.mostrarTipoServicoCadastrados(servico);
			while (rs.next()) {
				String[] dados = new String[5];
				dados[0] = rs.getString("nome");
				dados[1] = rs.getString("preco");
				modelo.addRow(dados);
			}
		} catch (SQLException e) {
			mostrarMensagemDeErro(e.getMessage());
		}

		scrollPane.setViewportView(table);

		JButton btnNovo = new JButton("Novo");
		btnNovo.addMouseListener(new MouseAdapter() {
			@Override
			// Start all needed view components
			public void mouseClicked(MouseEvent arg0) {

				dispose();
				NovoTipoServico frame = new NovoTipoServico();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);

			}
		});
		btnNovo.setBounds(380, 24, 94, 23);
		contentPane.add(btnNovo);

		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addMouseListener(new MouseAdapter() {
			@Override
			// // VIEW method that calls the window changeTypeService to make a
			// change
			public void mouseClicked(MouseEvent e) {
				try {
					ServiceType.setTempName(modelo.getValueAt(
							table.getSelectedRow(), 0).toString());
					ModifyServiceType frame = new ModifyServiceType();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					dispose();
				} catch (ServiceException e1) {
					mostrarMensagemDeErro(e1.getMessage());
				} catch (ArrayIndexOutOfBoundsException e1) {
					mostrarMensagemDeErro("Selecione um Tipo de Serviço");
				}
			}
		});
		btnAlterar.setBounds(380, 58, 94, 23);
		contentPane.add(btnAlterar);

		JButton btnRemover = new JButton("Remover");
		btnRemover.addMouseListener(new MouseAdapter() {
			@Override
			// // VIEW method that performs a delete of a Type of Service
			public void mouseClicked(MouseEvent e) {
				String nome = (String) table.getValueAt(table.getSelectedRow(),
						0);
				ServiceType tipoServico = new ServiceType();

				try {
					tipoServico.setNameServiceType(nome);
				} catch (ServiceException e1) {
					e1.printStackTrace();
				}

				int confirmacao = JOptionPane.showConfirmDialog(null,
						"Remover " + nome + " da lista?");

				if (confirmacao == JOptionPane.YES_OPTION) {
					ServiceTypeController tipoServicoController = ServiceTypeController
							.getInstance();
					try {
						tipoServicoController.delete(tipoServico);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}

					dispose();
					NewServiceType frame = new NewServiceType();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				}

			}
		});
		btnRemover.setBounds(380, 92, 94, 23);
		contentPane.add(btnRemover);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(380, 228, 94, 23);
		btnVoltar.addActionListener(new ActionListener() {
			// VIEW method of returning to the administrative window
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				Administrative frame = new Administrative();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
			}
		});
		contentPane.add(btnVoltar);
	}

	// temporaryName getter
	public static String getNomeTemp() {
		return nomeTemp;
	}

	// Display the error message that occurred
	private void mostrarMensagemDeErro(String informacao) {
		JOptionPane.showMessageDialog(null, informacao, "Atenção",
				JOptionPane.INFORMATION_MESSAGE);
	}
}
