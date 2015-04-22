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
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.Barber;
import control.BarberController;
import exception.BarberException;

@SuppressWarnings("serial")
public class RegisterBarber extends JFrame {

	// Creating a panel
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterBarber frame = new RegisterBarber();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// Class constructor
	public RegisterBarber() {
		inicializarComponentes();
	}

	// Method that initialize the panel in the frame
	public void inicializarComponentes() {
		setTitle("Barber");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 678, 490);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 474, 429);
		contentPane.add(scrollPane);

		final DefaultTableModel modelo = new DefaultTableModel(null,
				new String[] { "Nome", "CPF", "RG", "Phone", "Cadeira" });
		final JTable table = new JTable(modelo);

		try {
			BarberController barberController = BarberController
					.getInstance();
			Barber barber = new Barber();
			ResultSet rs = barberController.showRegisteredBarbers(barber);
			while (rs.next()) {
				String[] dados = new String[5];
				dados[0] = rs.getString("name");
				dados[1] = rs.getString("cpf");
				dados[2] = rs.getString("rg");
				dados[3] = rs.getString("telefone");
				dados[4] = rs.getString("cadeira");
				modelo.addRow(dados);
			}
		} catch (SQLException e) {
			mostrarMensagemDeErro(e.getMessage());
		}

		scrollPane.setViewportView(table);

		JButton botaoNovo = new JButton("Novo");
		botaoNovo.addMouseListener(new MouseAdapter() {
			@Override
			// This method is used to create a table that contains the contacts
			public void mouseClicked(MouseEvent e) {
				dispose();
				NovoBarber frame;
				try {
					frame = new NovoBarber();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (ParseException e1) {
					e1.printStackTrace();
				}

			}
		});
		botaoNovo.setBounds(494, 11, 158, 28);
		contentPane.add(botaoNovo);

		JButton botaoAlterar = new JButton("Alterar");
		botaoAlterar.addMouseListener(new MouseAdapter() {
			@Override
			// This method is used to initialize the buttons
			public void mouseClicked(MouseEvent e) {
				try {
					Barber.setTempName(modelo.getValueAt(
							table.getSelectedRow(), 0).toString());
					ModifyBarber frame = new ModifyBarber();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					dispose();
				} catch (ArrayIndexOutOfBoundsException e1) {
					mostrarMensagemDeErro("Selecione um Barber para Alterar");
				}
			}
		});
		botaoAlterar.setBounds(494, 50, 158, 28);
		contentPane.add(botaoAlterar);

		JButton botaoRemover = new JButton("Remover");
		botaoRemover.addMouseListener(new MouseAdapter() {
			@Override
			// This method is used to create the button and the action that open
			// the frame that register a new barber
			public void mouseClicked(MouseEvent arg0) {
				try {
					String name = (String) table.getValueAt(
							table.getSelectedRow(), 0);
					Barber barber = new Barber();
					barber.setName(name);

					int confirmacao = JOptionPane.showConfirmDialog(null,
							"Remover " + name + " da lista?");

					if (confirmacao == JOptionPane.YES_OPTION) {
						BarberController barberController = BarberController
								.getInstance();
						barberController.delete(barber);

						dispose();
						RegisterBarber frame = new RegisterBarber();
						frame.setVisible(true);
						frame.setLocationRelativeTo(null);
					}
				} catch (ArrayIndexOutOfBoundsException e) {
					mostrarMensagemDeErro("Selecione um Barber para remover");
				} catch (BarberException e) {
					mostrarMensagemDeErro(e.getMessage());
				} catch (SQLException e) {
					mostrarMensagemDeErro(e.getMessage());
				}
			}
		});
		botaoRemover.setBounds(494, 89, 158, 28);
		contentPane.add(botaoRemover);

		JButton botaoVoltar = new JButton("Voltar");
		botaoVoltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Administrative frame = new Administrative();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
				dispose();
			}
		});
		botaoVoltar.setBounds(494, 412, 158, 28);
		contentPane.add(botaoVoltar);
	}

	// Method that shows a error message
	private void mostrarMensagemDeErro(String informacao) {
		JOptionPane.showMessageDialog(null, informacao, "Atenção",
				JOptionPane.INFORMATION_MESSAGE);
	}

}
