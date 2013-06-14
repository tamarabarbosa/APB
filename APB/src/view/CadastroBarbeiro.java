package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

import control.BarbeiroController;
import dao.FactoryConnection;
import exception.BarbeiroException;

import model.Barbeiro;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import exception.BarbeiroException;

@SuppressWarnings("serial")
public class CadastroBarbeiro extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNome;
	private JTextField textFieldCpf;
	private JTextField textFieldRg;
	private JTextField textFieldTel;
	private Barbeiro barbeiro;
	private Connection connection;
	private static String oldCpf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroBarbeiro frame = new CadastroBarbeiro();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CadastroBarbeiro() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 810, 421);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 56, 774, 120);
		contentPane.add(scrollPane);

		final DefaultTableModel modelo = new DefaultTableModel(null,
				new String[] { "Nome", "CPF", "RG", "Telefone" });
		final JTable table = new JTable(modelo);

		try {
			connection = FactoryConnection.getInstance().getConnection();
			ResultSet rs = connection.createStatement().executeQuery(
					"Select nome, cpf, rg, telefone from barbeiro");
			while (rs.next()) {
				String[] dados = new String[4];
				dados[0] = rs.getString("nome");
				dados[1] = rs.getString("cpf");
				dados[2] = rs.getString("rg");
				dados[3] = rs.getString("telefone");
				modelo.addRow(dados);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		scrollPane.setViewportView(table);

		JButton Novo = new JButton("Novo");
		Novo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textFieldNome.setEditable(true);
				textFieldCpf.setEditable(true);
				textFieldRg.setEditable(true);
				textFieldTel.setEditable(true);
				textFieldNome.setText("");
				textFieldCpf.setText("");
				textFieldRg.setText("");
				textFieldTel.setText("");
			}
		});
		Novo.setBounds(407, 11, 117, 34);
		contentPane.add(Novo);

		JButton Alterar = new JButton("Alterar");
		Alterar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				textFieldNome.setEditable(true);
				textFieldCpf.setEditable(true);
				textFieldRg.setEditable(true);
				textFieldTel.setEditable(true);
				textFieldNome.setText((table.getValueAt(table.getSelectedRow(),
						0).toString()));
				textFieldCpf.setText((table.getValueAt(table.getSelectedRow(),
						1).toString()));
				textFieldRg.setText((table.getValueAt(table.getSelectedRow(), 2)
						.toString()));
				textFieldTel.setText((table.getValueAt(table.getSelectedRow(),
						3).toString()));
				CadastroBarbeiro.setOldCpf((table.getValueAt(
						table.getSelectedRow(), 1)).toString());
			}
		});

		Alterar.setBounds(534, 11, 117, 34);
		contentPane.add(Alterar);
		Alterar.setEnabled(true);

		JButton Remover = new JButton("Remover");
		Remover.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textFieldNome.setEditable(false);
				textFieldCpf.setEditable(false);
				textFieldRg.setEditable(false);
				textFieldTel.setEditable(false);

				barbeiro = new Barbeiro();
				try {
					try {
						barbeiro.setNome(table.getValueAt(
								table.getSelectedRow(), 0).toString());
					} catch (BarbeiroException e1) {
						e1.printStackTrace();
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}

				try {
					barbeiro.setCpf(table.getValueAt(table.getSelectedRow(), 1)
							.toString());
				} catch (BarbeiroException e1) {
					e1.printStackTrace();
				}

				barbeiro.setRg(table.getValueAt(table.getSelectedRow(), 2)
						.toString());

				try {
					barbeiro.setTelefone(table.getValueAt(
							table.getSelectedRow(), 3).toString());
				} catch (BarbeiroException e1) {
					e1.printStackTrace();
				}

				BarbeiroController barbeiroController = BarbeiroController
						.getInstance();

				try {
					barbeiroController.excluir(barbeiro);
				} catch (SQLException k) {
					k.printStackTrace();
				}

			}
		});

		Remover.setBounds(661, 11, 123, 34);
		contentPane.add(Remover);
		Remover.setEnabled(true);

		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(20, 189, 46, 14);
		contentPane.add(lblNewLabel);

		textFieldNome = new JTextField();
		textFieldNome.setBounds(76, 187, 670, 20);
		contentPane.add(textFieldNome);
		textFieldNome.setColumns(10);
		textFieldNome.setEditable(false);

		JLabel lblNewLabel_1 = new JLabel("CPF");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(10, 221, 46, 14);
		contentPane.add(lblNewLabel_1);

		textFieldCpf = new JTextField();
		textFieldCpf.setBounds(76, 221, 261, 20);
		contentPane.add(textFieldCpf);
		textFieldCpf.setColumns(10);
		textFieldCpf.setEditable(false);

		JLabel lblRg = new JLabel("RG");
		lblRg.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblRg.setBounds(372, 222, 32, 14);
		contentPane.add(lblRg);

		textFieldRg = new JTextField();
		textFieldRg.setBounds(414, 219, 332, 20);
		contentPane.add(textFieldRg);
		textFieldRg.setColumns(10);
		textFieldRg.setEditable(false);

		JLabel lblNewLabel_2 = new JLabel("Telefone");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(10, 254, 67, 14);
		contentPane.add(lblNewLabel_2);

		textFieldTel = new JTextField();
		textFieldTel.setBounds(76, 252, 261, 20);
		contentPane.add(textFieldTel);
		textFieldTel.setColumns(10);
		textFieldTel.setEditable(false);

		JButton btnConcluir = new JButton("Concluir");
		btnConcluir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				TelaOpcoes frame = new TelaOpcoes();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
				dispose();
			}

		});
		btnConcluir.setIcon(new ImageIcon(CadastroBarbeiro.class
				.getResource("/resources/ButtonAccept.png")));
		btnConcluir.setBounds(327, 314, 150, 57);
		contentPane.add(btnConcluir);

		JButton btnLimparCampos = new JButton("Limpar Campos");
		btnLimparCampos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textFieldNome.setText("");
				textFieldCpf.setText("");
				textFieldRg.setText("");
				textFieldTel.setText("");
			}
		});
		btnLimparCampos.setIcon(null);
		btnLimparCampos.setBounds(487, 314, 164, 57);
		contentPane.add(btnLimparCampos);

		JButton Salvar = new JButton("Salvar");
		Salvar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (!this.validarCadastro()) {
					return;
				} else {

					barbeiro = new Barbeiro();

					try {
						barbeiro.setNome(textFieldNome.getText());
					} catch (BarbeiroException e) {
						e.printStackTrace();
					}

					try {
						barbeiro.setCpf(textFieldCpf.getText());
					} catch (BarbeiroException e) {
						e.printStackTrace();
					}

					barbeiro.setRg(textFieldRg.getText());

					try {
						barbeiro.setTelefone(textFieldTel.getText());
					} catch (BarbeiroException e) {
						e.printStackTrace();
					}

					BarbeiroController barbeiroController = BarbeiroController
							.getInstance();

					try {
						barbeiroController.inserir(barbeiro);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}

					JOptionPane.showMessageDialog(null, "Barbeiro "
							+ textFieldNome.getText()
							+ " foi inserido com sucesso");
				}

				textFieldNome.setText("");
				textFieldCpf.setText("");
				textFieldRg.setText("");
				textFieldTel.setText("");
				textFieldNome.setEditable(false);
				textFieldCpf.setEditable(false);
				textFieldRg.setEditable(false);
				textFieldTel.setEditable(false);
			}

			public boolean validarCadastro() {
				if (textFieldNome.getText().trim().length() == 0) {
					this.mostrarMensagemDeErro("O campo de Nome não pode estar em branco.");
					textFieldNome.requestFocus();
					return false;
				}

				if (textFieldCpf.getText().trim().length() == 0) {
					this.mostrarMensagemDeErro("O campo de CPF não pode estar em branco.");
					textFieldNome.requestFocus();
					return false;
				}

				if (textFieldRg.getText().trim().length() == 0) {
					this.mostrarMensagemDeErro("O campo de RG não pode estar em branco.");
					textFieldNome.requestFocus();
					return false;
				}

				if (textFieldTel.getText().trim().length() == 0) {
					this.mostrarMensagemDeErro("O campo de Telefone não pode estar em branco.");
					textFieldNome.requestFocus();
					return false;
				}

				return true;
			}

			private void mostrarMensagemDeErro(String informacao) {
				JOptionPane.showMessageDialog(null, informacao, "Atenção",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		Salvar.setBounds(153, 11, 117, 34);
		contentPane.add(Salvar);

		JButton btnRenew = new JButton("Renovar");
		btnRenew.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
				CadastroBarbeiro frame = new CadastroBarbeiro();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
			}
		});
		btnRenew.setBounds(280, 11, 117, 34);
		contentPane.add(btnRenew);

		JButton btnSaveA = new JButton("Salvar Altera\u00E7\u00F5es");
		btnSaveA.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (this.validarCadastro() == false) {
					return;
				} else if (this.validarCadastro() == true) {
					barbeiro = new Barbeiro();

					try {
						barbeiro.setNome(textFieldNome.getText());
					} catch (BarbeiroException e1) {
						e1.printStackTrace();
					}

					try {
						barbeiro.setCpf(textFieldCpf.getText());
					} catch (BarbeiroException e1) {
						e1.printStackTrace();
					}

					barbeiro.setRg(textFieldRg.getText());

					try {
						barbeiro.setTelefone(textFieldTel.getText());
					} catch (BarbeiroException e1) {
						e1.printStackTrace();
					}

					BarbeiroController barbeiroController = BarbeiroController
							.getInstance();

					try {
						barbeiroController.alterar(barbeiro);
					} catch (SQLException k) {
						k.printStackTrace();
					}

					JOptionPane.showMessageDialog(null, "Barbeiro "
							+ textFieldNome.getText()
							+ " foi alterado com sucesso");

					textFieldNome.setText("");
					textFieldCpf.setText("");
					textFieldRg.setText("");
					textFieldTel.setText("");
					textFieldNome.setEnabled(false);
					textFieldCpf.setEnabled(false);
					textFieldRg.setEnabled(false);
					textFieldTel.setEnabled(false);

				}
			}

			public boolean validarCadastro() {
				if (textFieldNome.getText().trim().length() == 0) {
					this.mostrarMensagemDeErro("O campo de Nome não pode estar em branco");
					textFieldNome.requestFocus();
					return false;
				}

				if (textFieldCpf.getText().trim().length() == 0) {
					this.mostrarMensagemDeErro("O campo de CPF não pode estar em branco");
					textFieldNome.requestFocus();
					return false;
				}

				if (textFieldRg.getText().trim().length() == 0) {
					this.mostrarMensagemDeErro("O campo de RG não pode estar em branco");
					textFieldNome.requestFocus();
					return false;
				}

				if (textFieldTel.getText().trim().length() == 0) {
					this.mostrarMensagemDeErro("O campo de Telefone não pode estar em branco");
					textFieldNome.requestFocus();
					return false;
				}

				return true;
			}

			private void mostrarMensagemDeErro(String informacao) {
				JOptionPane.showMessageDialog(null, informacao, "Atencao",
						JOptionPane.INFORMATION_MESSAGE);
			}

		});
		btnSaveA.setBounds(167, 314, 150, 57);
		contentPane.add(btnSaveA);
	}

	public static String getOldCpf() {
		return oldCpf;
	}

	public static void setOldCpf(String oldCpf) {
		CadastroBarbeiro.oldCpf = oldCpf;
	}
}
