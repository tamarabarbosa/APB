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

import control.ServicoPrestadoController;
import exception.ServicoException;
import model.ServicoPrestado;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import dao.FactoryConnection;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class AlterarServicoPrestado extends JFrame {

	private JPanel contentPane;
	private JTextField textValor;
	private JTextField textData;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AlterarServicoPrestado frame = new AlterarServicoPrestado();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public AlterarServicoPrestado() {
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
				"Selecione um tipo de servi\u00E7o", "Barba", "Corte Adulto", "Corte Infantil" }));
		comboBoxServico.setMaximumRowCount(4);
		comboBoxServico.setBounds(129, 22, 289, 20);
		contentPane.add(comboBoxServico);

		try {
			Connection connection = FactoryConnection.getInstance().getConnection();
			ResultSet rs = connection.createStatement().executeQuery(
					"DELETE FROM servico WHERE " + "nome = '"
							+ PesquisarServicoPrestado.getTempNome() + "';");

			textValor.setText(rs.getString("preco"));
			textData.setText(rs.getString("data"));
		} catch (SQLException e) {
			mostrarMensagemDeErro(e.getMessage());
		}

		JButton botaoSalvar = new JButton("Salvar");
		botaoSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					ServicoPrestado servico_prestado = new ServicoPrestado();
					servico_prestado.setNomeBarbeiro(comboBoxBarbeiro.getSelectedItem().toString());
					servico_prestado.setNomeServico(comboBoxServico.getSelectedItem().toString());
					servico_prestado.setPreco(textValor.getText());
					servico_prestado.setData(textData.getText());

					if (comboBoxServico.getSelectedIndex() == 0)
						JOptionPane.showMessageDialog(null, "Você deve selecionar um tipo de serviço.");
					else if (comboBoxBarbeiro.getSelectedIndex() == 0)
						JOptionPane.showMessageDialog(null, "Você deve selecionar um barbeiro.");
					else {
						ServicoPrestadoController servicoController = ServicoPrestadoController.getInstance();
						servicoController.alterar(servico_prestado);

						JOptionPane.showMessageDialog(null, "Servico "
								+ comboBoxServico.getSelectedItem().toString()
								+ " alterado com sucesso");

						comboBoxBarbeiro.setSelectedIndex(0);
						comboBoxServico.setSelectedIndex(0);

						textValor.setText("");
						textData.setText("");
					}
				} catch (ServicoException e) {
					mostrarMensagemDeErro(e.getMessage());
				} catch (SQLException e) {
					mostrarMensagemDeErro(e.getMessage());
				}
			}
		});
		botaoSalvar.setBounds(129, 129, 89, 23);
		contentPane.add(botaoSalvar);

		JButton botaoVoltar = new JButton("Voltar");
		botaoVoltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
				PesquisarServicoPrestado frame = new PesquisarServicoPrestado();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
			}
		});
		botaoVoltar.setBounds(253, 129, 89, 23);
		contentPane.add(botaoVoltar);
	}

	private void mostrarMensagemDeErro(String informacao) {
		JOptionPane.showMessageDialog(null, informacao, "Atenção",
				JOptionPane.INFORMATION_MESSAGE);
	}
}
