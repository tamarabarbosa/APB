package view;

import java.awt.EventQueue;
import java.text.*;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import control.ServicoController;
import model.Servico;
import java.sql.SQLException;

@SuppressWarnings("serial")
public class NovoServico extends JFrame {

	private JPanel contentPane;
	private JTextField textServico;
	private JTextField textBarbeiro;
	private JTextField textValor;
	private JTextField textData;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NovoServico frame = new NovoServico();
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
	public NovoServico() {
		setTitle("Cadastrar novo servi\u00E7o");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 474, 214);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textServico = new JTextField();
		textServico.setBounds(83, 22, 335, 20);
		contentPane.add(textServico);
		textServico.setColumns(10);

		JLabel lblServico = new JLabel("Servico:");
		lblServico.setBounds(27, 25, 46, 14);
		contentPane.add(lblServico);

		JLabel lblRealizadoPor = new JLabel("Realizado por:");
		lblRealizadoPor.setBounds(27, 56, 92, 14);
		contentPane.add(lblRealizadoPor);

		JLabel lblValor = new JLabel("Valor:");
		lblValor.setBounds(27, 87, 46, 14);
		contentPane.add(lblValor);

		JLabel lblData = new JLabel("Data:");
		lblData.setBounds(232, 87, 46, 14);
		contentPane.add(lblData);

		textBarbeiro = new JTextField();
		textBarbeiro.setBounds(129, 53, 289, 20);
		contentPane.add(textBarbeiro);
		textBarbeiro.setColumns(10);

		textValor = new JTextField();
		textValor.setBounds(83, 84, 114, 20);
		contentPane.add(textValor);
		textValor.setColumns(10);

		textData = new JTextField();
		textData.setBounds(288, 84, 130, 20);
		contentPane.add(textData);
		textData.setColumns(10);

		JButton botaoSalvar = new JButton("Salvar");
		botaoSalvar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Servico servico = new Servico();
				SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
				java.sql.Date data = null;
				try {
					data = new java.sql.Date(format.parse(textData.getText())
							.getTime());
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				servico.setNome(textServico.getText());
				servico.setPreco(textValor.getText());
				servico.setNomeDoBarbeiro(textBarbeiro.getText());
				servico.setData(data);

				if (textServico.getText().isEmpty()
						|| textValor.getText().isEmpty()
						|| textBarbeiro.getText().isEmpty()
						|| textData.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null,
							"Todos os campos são obrigatorios");
				} else {

					ServicoController servicoController = ServicoController
							.getInstance();

					try {
						servicoController.inserir(servico);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

					JOptionPane.showMessageDialog(null, "Servico "
							+ textServico.getText() + " inserido com sucesso");

				}

				dispose();
				CadastrarServico frame = new CadastrarServico();
				frame.setVisible(true);
			}
		});
		botaoSalvar.setBounds(27, 129, 89, 23);
		contentPane.add(botaoSalvar);

		JButton botaoLimparCampos = new JButton("Limpar Campos");
		botaoLimparCampos.setBounds(152, 129, 148, 23);
		contentPane.add(botaoLimparCampos);

		JButton botaoVoltar = new JButton("Voltar");
		botaoVoltar.setBounds(329, 129, 89, 23);
		contentPane.add(botaoVoltar);
	}
}
