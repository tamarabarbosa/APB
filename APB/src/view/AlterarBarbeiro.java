package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;



import control.BarbeiroController;
import dao.FactoryConnection;
import exception.BarbeiroException;

import model.Barbeiro;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

@SuppressWarnings("serial")
public class AlterarBarbeiro extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNome;
	private JTextField textFieldCpf;
	private JTextField textFieldRg;
	private JTextField textFieldTelefone;
	private JTextField textFieldCadeira;
	private static String cpfAntigo;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AlterarBarbeiro frame = new AlterarBarbeiro();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public AlterarBarbeiro() {
		setTitle("Alterar Barbeiro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 475, 253);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textFieldNome = new JTextField();
		textFieldNome.setColumns(10);
		textFieldNome.setBounds(92, 11, 354, 20);
		contentPane.add(textFieldNome);

		JLabel labelNome = new JLabel("Nome:");
		labelNome.setBounds(21, 14, 46, 14);
		contentPane.add(labelNome);

		textFieldCpf = new JTextField();
		textFieldCpf.setColumns(10);
		textFieldCpf.setBounds(92, 42, 354, 20);
		contentPane.add(textFieldCpf);

		JLabel labelCpf = new JLabel("CPF:");
		labelCpf.setBounds(21, 45, 46, 14);
		contentPane.add(labelCpf);

		textFieldRg = new JTextField();
		textFieldRg.setColumns(10);
		textFieldRg.setBounds(92, 73, 354, 20);
		contentPane.add(textFieldRg);

		JLabel labelRg = new JLabel("RG:");
		labelRg.setBounds(21, 76, 46, 14);
		contentPane.add(labelRg);

		textFieldTelefone = new JTextField();
		textFieldTelefone.setColumns(10);
		textFieldTelefone.setBounds(92, 104, 354, 20);
		contentPane.add(textFieldTelefone);

		JLabel labelTelefone = new JLabel("Telefone:");
		labelTelefone.setBounds(21, 107, 61, 14);
		contentPane.add(labelTelefone);

		textFieldCadeira = new JTextField();
		textFieldCadeira.setColumns(10);
		textFieldCadeira.setBounds(92, 133, 354, 20);
		contentPane.add(textFieldCadeira);

		JLabel labelCadeira = new JLabel("Cadeira:");
		labelCadeira.setBounds(21, 136, 61, 14);
		contentPane.add(labelCadeira);


		try {
			Connection connection = FactoryConnection.getInstance().getConnection();
			java.sql.PreparedStatement pst = connection.prepareStatement("SELECT * FROM barbeiro WHERE "
					+ "nome = '" + CadastrarBarbeiro.getTempNome() + "';");
			ResultSet rs = pst.executeQuery();
				
			rs.next(); 
			
				textFieldNome.setText(rs.getString("nome"));
				textFieldCpf.setText(rs.getString("cpf"));
				AlterarBarbeiro.setCpfAntigo(rs.getString("cpf"));
				textFieldRg.setText(rs.getString("rg"));
				textFieldTelefone.setText(rs.getString("telefone"));
				textFieldCadeira.setText(rs.getString("cadeira"));
		} catch (SQLException e) {
			mostrarMensagemDeErro(e.getMessage());
		}


		JButton buttonSalvar = new JButton("Salvar");
		buttonSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Barbeiro barbeiro = new Barbeiro();
					barbeiro.setNome(textFieldNome.getText());
					barbeiro.setCpf(textFieldCpf.getText());
					barbeiro.setRg(textFieldRg.getText());
					barbeiro.setTelefone(textFieldTelefone.getText());
					barbeiro.setCadeira(textFieldCadeira.getText());

					BarbeiroController barbeiroController = BarbeiroController.getInstance();
					barbeiroController.alterar(barbeiro);

					JOptionPane.showMessageDialog(null, "Barbeiro "
							+ textFieldNome.getText()
							+ " foi alterado com sucesso");

					dispose();
					CadastrarBarbeiro frame = new CadastrarBarbeiro();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					
				} catch (BarbeiroException e1) {
					mostrarMensagemDeErro(e1.getMessage());
				} catch (SQLException k) {
					mostrarMensagemDeErro(k.getMessage());
				}
			}
		});
		buttonSalvar.setBounds(10, 177, 125, 23);
		contentPane.add(buttonSalvar);

		JButton buttonLimpar = new JButton("Limpar Campos");
		buttonLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldNome.setText("");
				textFieldCpf.setText("");
				textFieldRg.setText("");
				textFieldTelefone.setText("");
				textFieldCadeira.setText("");
			}
		});
		buttonLimpar.setBounds(308, 177, 138, 23);
		contentPane.add(buttonLimpar);

		JButton buttonVoltar = new JButton("Voltar");
		buttonVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				CadastrarBarbeiro frame = new CadastrarBarbeiro();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
			}
		});
		buttonVoltar.setBounds(158, 177, 125, 23);
		contentPane.add(buttonVoltar);
	}
	
	

	public static String getCpfAntigo() {
		return cpfAntigo;
	}

	public static void setCpfAntigo(String cpfAntigo) {
		AlterarBarbeiro.cpfAntigo = cpfAntigo;
	}

	private void mostrarMensagemDeErro(String informacao) {
		JOptionPane.showMessageDialog(null, informacao, "Atenção",
				JOptionPane.INFORMATION_MESSAGE);
	}
}
