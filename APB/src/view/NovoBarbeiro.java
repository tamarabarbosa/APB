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
import exception.BarbeiroException;

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
	private Barbeiro barbeiro;

	
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
		setTitle("Cadastrar Barbeiro");
		inicializarComponentes();
	}

	public void inicializarComponentes() {
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

		JLabel lblRg = new JLabel("RG:");
		lblRg.setBounds(21, 76, 46, 14);
		getContentPane().add(lblRg);

		textFieldTel = new JTextField();
		textFieldTel.setBounds(92, 104, 354, 20);
		getContentPane().add(textFieldTel);
		textFieldTel.setColumns(10);

		JLabel lblTel = new JLabel("Telefone:");
		lblTel.setBounds(21, 107, 61, 14);
		getContentPane().add(lblTel);
		
		textFieldCadeira = new JTextField();
		textFieldCadeira.setBounds(92, 133, 354, 20);
		contentPane.add(textFieldCadeira);
		textFieldCadeira.setColumns(10);

		lblCadeira = new JLabel("Cadeira:");
		lblCadeira.setBounds(21, 136, 61, 14);
		contentPane.add(lblCadeira);

		botaoSalvar = new JButton("Salvar");
		botaoSalvar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					barbeiro = new Barbeiro();
					barbeiro.setNome(textFieldNome.getText());
					barbeiro.setCpf(textFieldCpf.getText());
					barbeiro.setRg(textFieldRg.getText());
					barbeiro.setTelefone(textFieldTel.getText());
					barbeiro.setCadeira(textFieldCadeira.getText());

					BarbeiroController barbeiroController = BarbeiroController.getInstance();
					barbeiroController.inserir(barbeiro);

					JOptionPane.showMessageDialog(null, "Barbeiro "
							+ textFieldNome.getText()
							+ " foi alterado com sucesso");

					textFieldNome.setText("");
					textFieldCpf.setText("");
					textFieldRg.setText("");
					textFieldTel.setText("");
					textFieldCadeira.setText("");
				} catch (BarbeiroException e1) {
					mostrarMensagemDeErro(e1.getMessage());
				} catch (SQLException k) {
					mostrarMensagemDeErro(k.getMessage());
				}
			}

			private void mostrarMensagemDeErro(String informacao) {
				JOptionPane.showMessageDialog(null, informacao, "Atenção",
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

<<<<<<< HEAD
		textFieldCadeira = new JTextField();
		textFieldCadeira.setBounds(92, 133, 354, 20);
		contentPane.add(textFieldCadeira);
		textFieldCadeira.setColumns(10);

		lblCadeira = new JLabel("Cadeira:");
		lblCadeira.setBounds(21, 136, 61, 14);
		contentPane.add(lblCadeira);

=======
>>>>>>> 1b07c99d7984491cc4daa224aaf24a5cc97a04b7
		botaoVoltar = new JButton("Voltar");
		botaoVoltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				CadastrarBarbeiro frame = new CadastrarBarbeiro();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);

			}
		});
		botaoVoltar.setBounds(158, 177, 125, 23);
		contentPane.add(botaoVoltar);

	}
}
