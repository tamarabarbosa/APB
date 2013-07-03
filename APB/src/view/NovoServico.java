package view;

import java.awt.EventQueue;

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
import exception.ServicoException;
import model.Servico;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import dao.FactoryConnection;


@SuppressWarnings("serial")
public class NovoServico extends JFrame {

	private JPanel contentPane;
	private JTextField textValor;
	private JTextField textData;
	private Connection connection;

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

	public NovoServico() {
		setTitle("Cadastrar novo servi\u00E7o");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 474, 214);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblServico = new JLabel("Servi\u00E7o:");
		lblServico.setBounds(27, 25, 46, 14);
		contentPane.add(lblServico);

		JLabel lblRealizadoPor = new JLabel("Realizado por:");
		lblRealizadoPor.setBounds(27, 56, 92, 14);
		contentPane.add(lblRealizadoPor);

		JLabel lblPreco = new JLabel("Pre\u00E7o (R$):");
		lblPreco.setBounds(27, 87, 71, 14);
		contentPane.add(lblPreco);

		JLabel lblData = new JLabel("Data:");
		lblData.setBounds(267, 87, 46, 14);
		contentPane.add(lblData);

		textValor = new JTextField();
		textValor.setBounds(129, 84, 114, 20);
		contentPane.add(textValor);
		textValor.setColumns(10);

		textData = new JTextField();
		textData.setBounds(312, 84, 106, 20);
		contentPane.add(textData);
		textData.setColumns(10);

		final JComboBox comboBoxBarbeiro = new JComboBox();
		comboBoxBarbeiro.setModel(new DefaultComboBoxModel(new String[] { "Selecione um barbeiro" }));
		comboBoxBarbeiro.setBounds(129, 53, 289, 20);
		contentPane.add(comboBoxBarbeiro);

		final JComboBox comboBoxServico = new JComboBox();
		comboBoxServico.setModel(new DefaultComboBoxModel(new String[] {
				"Selecione um tipo de servi\u00E7o", "Barba", "Corte Adulto",
				"Corte Infantil" }));
		comboBoxServico.setMaximumRowCount(4);
		comboBoxServico.setBounds(129, 22, 289, 20);
		contentPane.add(comboBoxServico);
		
		try{
			Connection connection = FactoryConnection.getInstance().getConnection();
			java.sql.PreparedStatement pst = connection.prepareStatement("SELECT nome FROM barbeiro;");
			ResultSet rs = pst.executeQuery();
			
			while (rs.next()){
				String nome = rs.getString("nome");
				comboBoxBarbeiro.addItem(nome);
			}
		 } catch (SQLException e){
			 
		 }

		JButton botaoSalvar = new JButton("Salvar");
		botaoSalvar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					Servico servico = new Servico();
					servico.setNomeBarbeiro(comboBoxBarbeiro.getSelectedItem().toString());
					servico.setNome(comboBoxServico.getSelectedItem().toString());
					servico.setPreco(textValor.getText());
					servico.setData(textData.getText());

					ServicoController servicoController = ServicoController.getInstance();
					servicoController.inserir(servico);

					JOptionPane.showMessageDialog(null, "Servico "
							+ comboBoxServico.getSelectedItem().toString()
							+ " inserido com sucesso");

					textValor.setText("");
					textData.setText("");

				} catch (ServicoException e) {
					mostrarMensagemDeErro(e.getMessage());
				} catch (SQLException e1) {
					mostrarMensagemDeErro(e1.getMessage());
				}
			}

			private void mostrarMensagemDeErro(String informacao) {
				JOptionPane.showMessageDialog(null, informacao, "Atenção",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});
		botaoSalvar.setBounds(27, 129, 89, 23);
		contentPane.add(botaoSalvar);

		JButton botaoLimparCampos = new JButton("Limpar Campos");
		botaoLimparCampos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				textValor.setText("");
				textData.setText("");
			}
		});
		botaoLimparCampos.setBounds(152, 129, 148, 23);
		contentPane.add(botaoLimparCampos);

		JButton botaoVoltar = new JButton("Voltar");
		botaoVoltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
				CadastrarServico frame = new CadastrarServico();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
			}
		});
		botaoVoltar.setBounds(329, 129, 89, 23);
		contentPane.add(botaoVoltar);
		}
}
