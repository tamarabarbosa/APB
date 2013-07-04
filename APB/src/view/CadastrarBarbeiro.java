package view;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.Barbeiro;
import control.BarbeiroController;

import dao.FactoryConnection;
import exception.BarbeiroException;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import control.BarbeiroController;
import model.Barbeiro;
import dao.FactoryConnection;
import exception.BarbeiroException;

@SuppressWarnings("serial")
public class CadastrarBarbeiro extends JFrame {

	private JPanel contentPane;
	private Connection connection;
	private static String tempNome;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastrarBarbeiro frame = new CadastrarBarbeiro();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public CadastrarBarbeiro() {
		inicializarComponentes();
	}

	public void inicializarComponentes() {
		setTitle("Barbeiro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 566, 345);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 365, 286);
		contentPane.add(scrollPane);

		final DefaultTableModel modelo = new DefaultTableModel(null,
				new String[] { "Nome", "CPF", "RG", "Telefone", "Cadeira" });
		final JTable table = new JTable(modelo);

		try {
			connection = FactoryConnection.getInstance().getConnection();
			ResultSet rs = connection.createStatement().executeQuery(
					"Select nome, cpf, rg, telefone, cadeira from barbeiro;");
			while (rs.next()) {
				String[] dados = new String[5];
				dados[0] = rs.getString("nome");
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
			public void mouseClicked(MouseEvent e) {
				dispose();
				NovoBarbeiro frame = new NovoBarbeiro();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
			}
		});
		botaoNovo.setBounds(385, 11, 158, 28);
		contentPane.add(botaoNovo);

		JButton botaoRemover = new JButton("Remover");
		botaoRemover.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				Barbeiro barbeiro = new Barbeiro();
				try {
					barbeiro.setNome(modelo.getValueAt(table.getSelectedRow(),
							0).toString());
				} catch (NullPointerException e) {
					e.printStackTrace();
				} catch (BarbeiroException e) {
					e.printStackTrace();
				}
				try {
					barbeiro.setCpf(modelo
							.getValueAt(table.getSelectedRow(), 1).toString());
					barbeiro.setRg(modelo.getValueAt(table.getSelectedRow(), 2)
							.toString());
					barbeiro.setTelefone(modelo.getValueAt(
							table.getSelectedRow(), 3).toString());
					barbeiro.setCadeira(modelo.getValueAt(
							table.getSelectedRow(), 4).toString());
				} catch (BarbeiroException e) {
					e.printStackTrace();
				}
				JOptionPane.showConfirmDialog(null,
						"Tem certeza que deseja excluir o barbeiro: "
								+ modelo.getValueAt(table.getSelectedRow(), 0)
										.toString() + "?");
				BarbeiroController barbeiroController = BarbeiroController
						.getInstance();
				try {
					barbeiroController.excluir(barbeiro);
				} catch (SQLException e) {
					e.printStackTrace();
				}

				/*
				 * dispose(); RemoverBarbeiro frame = new RemoverBarbeiro();
				 * frame.setVisible(true); frame.setLocationRelativeTo(null);
				 */

				try {
					String nome = (String) table.getValueAt(
							table.getSelectedRow(), 0);
					barbeiro.setNome(nome);

					int confirmacao = JOptionPane.showConfirmDialog(null,
							"Remover " + nome + " da lista?");

					if (confirmacao == JOptionPane.YES_OPTION) {
						barbeiroController.excluir(barbeiro);

						dispose();
						CadastrarBarbeiro frame = new CadastrarBarbeiro();
						frame.setVisible(true);
						frame.setLocationRelativeTo(null);
					}
				} catch (BarbeiroException e) {
					mostrarMensagemDeErro(e.getMessage());
				} catch (SQLException e) {
					mostrarMensagemDeErro(e.getMessage());
				}

			}
		});
		botaoRemover.setBounds(385, 50, 158, 28);
		contentPane.add(botaoRemover);

		JButton botaoAlterar = new JButton("Alterar");
		botaoAlterar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tempNome = modelo.getValueAt(table.getSelectedRow(), 0)
						.toString();
				AlterarBarbeiro frame = new AlterarBarbeiro();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
				dispose();
			}
		});
		botaoAlterar.setBounds(385, 89, 158, 28);
		contentPane.add(botaoAlterar);

		JButton botaoVoltar = new JButton("Voltar");
		botaoVoltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				TelaOpcoes frame = new TelaOpcoes();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
				dispose();
			}
		});
		botaoVoltar.setBounds(385, 267, 158, 28);
		contentPane.add(botaoVoltar);
	}

	private void mostrarMensagemDeErro(String informacao) {
		JOptionPane.showMessageDialog(null, informacao, "Atenção",
				JOptionPane.INFORMATION_MESSAGE);
	}

	public static String getTempNome() {
		return tempNome;
	}
}
