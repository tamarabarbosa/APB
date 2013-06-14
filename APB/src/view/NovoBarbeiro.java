package view;


import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

import model.Barbeiro;
import control.BarbeiroController;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

@SuppressWarnings("serial")
public class NovoBarbeiro extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNome;
	private JTextField textFieldCpf;
	private JTextField textFieldRg;
	private JTextField textFieldTel;
	private JButton botaoSalvar;
	private JButton botaoLimparCampos;
	private JTextField textFieldCadeira;
	private JLabel lblCadeira;
	private JButton botaoVoltar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NovoBarbeiro frame = new NovoBarbeiro();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public NovoBarbeiro() {
		inicializarComponentes();
	}
	
	public void inicializarComponentes(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 474, 253);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		getContentPane().setLayout(null);
		contentPane.setLayout(null);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(92, 11, 354, 20);
		getContentPane().add(textFieldNome);
		textFieldNome.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(21, 14, 46, 14);
		getContentPane().add(lblNome);
		
		textFieldCpf = new JTextField();
		textFieldCpf.setBounds(92, 42, 354, 20);
		getContentPane().add(textFieldCpf);
		textFieldCpf.setColumns(10);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(21, 45, 46, 14);
		getContentPane().add(lblCpf);
		
		textFieldRg = new JTextField();
		textFieldRg.setBounds(92, 73, 354, 20);
		getContentPane().add(textFieldRg);
		textFieldRg.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("RG:");
		lblNewLabel.setBounds(21, 76, 46, 14);
		getContentPane().add(lblNewLabel);
		
		textFieldTel = new JTextField();
		textFieldTel.setBounds(92, 133, 354, 20);
		getContentPane().add(textFieldTel);
		textFieldTel.setColumns(10);
		
		JLabel lblTelefone = new JLabel("Tel:");
		lblTelefone.setBounds(21, 136, 46, 14);
		getContentPane().add(lblTelefone);
		
		botaoSalvar = new JButton("Salvar");
		botaoSalvar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (this.validarCadastro() == false) {
					return;
				} else if (this.validarCadastro() == true) {

				
						Barbeiro barbeiro = new Barbeiro();
						barbeiro.setNome(textFieldNome.getText());
						barbeiro.setCpf(textFieldCpf.getText());
						barbeiro.setRg(textFieldRg.getText());
						barbeiro.setTelefone(textFieldTel.getText());

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
				
				if (textFieldCadeira.getText().trim().length() == 0) {
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
		botaoSalvar.setBounds(10, 177, 125, 23);
		contentPane.add(botaoSalvar);
		
		botaoLimparCampos = new JButton("Limpar Campos");
		botaoLimparCampos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textFieldNome.setText("");
				textFieldCpf.setText("");
				textFieldRg.setText("");
				textFieldTel.setText("");
				textFieldCadeira.setText("");
			}
		});
		botaoLimparCampos.setBounds(308, 177, 138, 23);
		contentPane.add(botaoLimparCampos);
		
		textFieldCadeira = new JTextField();
		textFieldCadeira.setBounds(92, 104, 354, 20);
		contentPane.add(textFieldCadeira);
		textFieldCadeira.setColumns(10);
		
		lblCadeira = new JLabel("Cadeira");
		lblCadeira.setBounds(21, 111, 46, 14);
		contentPane.add(lblCadeira);
		
		botaoVoltar = new JButton("Voltar");
		botaoVoltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				CadastroBarbeiro frame =  new CadastroBarbeiro();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
				
				
			}
		});
		botaoVoltar.setBounds(158, 177, 125, 23);
		contentPane.add(botaoVoltar);
		
	}
}
