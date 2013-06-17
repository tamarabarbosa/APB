package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;

import control.AgendaController;
import exception.BarbeiroException;
import model.Agenda;

import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.sql.SQLException;

@SuppressWarnings("serial")
public class NovoContato extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNomeContato;
	private JTextField textFieldTelefoneContato;
	private JTextField textFieldDescricaoContato;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NovoContato frame = new NovoContato();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public NovoContato() {
		inicializarComponentes();
	}

	public void inicializarComponentes() {
		setTitle("Novo Contato");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnSalvarContato = new JButton("Salvar");
		btnSalvarContato.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Agenda agenda = new Agenda();
					agenda.setNome(textFieldNomeContato.getText());
					agenda.setTelefone(textFieldTelefoneContato.getText());
					agenda.setDescricao(textFieldDescricaoContato.getText());

					AgendaController agendaController = AgendaController.getInstance();
					agendaController.incluir(agenda);

					JOptionPane.showMessageDialog(null, "Contato "
							+ textFieldNomeContato.getText()
							+ " foi alterado com sucesso");
					
				} catch (SQLException e1) {
					mostrarMensagemDeErro(e1.getMessage());
				} catch (BarbeiroException e1) {
					mostrarMensagemDeErro(e1.getMessage());
				}

				textFieldNomeContato.setText("");
				textFieldTelefoneContato.setText("");
				textFieldDescricaoContato.setText("");
			}

			private void mostrarMensagemDeErro(String informacao) {
				JOptionPane.showMessageDialog(null, informacao, "Atenção",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});

		btnSalvarContato.setBounds(26, 218, 109, 33);
		contentPane.add(btnSalvarContato);

		JButton btnVoltarAgenda = new JButton("Voltar");
		btnVoltarAgenda.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				CadastrarAgenda frame = new CadastrarAgenda();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
			}
		});

		btnVoltarAgenda.setBounds(166, 218, 100, 33);
		contentPane.add(btnVoltarAgenda);

		JButton btnLimparCampos = new JButton("Limpar Campos");
		btnLimparCampos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textFieldNomeContato.setText("");
				textFieldTelefoneContato.setText("");
				textFieldDescricaoContato.setText("");
			}
		});

		btnLimparCampos.setBounds(287, 218, 125, 33);
		contentPane.add(btnLimparCampos);

		textFieldNomeContato = new JTextField();
		textFieldNomeContato.setBounds(85, 23, 327, 20);
		contentPane.add(textFieldNomeContato);
		textFieldNomeContato.setColumns(10);

		textFieldTelefoneContato = new JTextField();
		textFieldTelefoneContato.setBounds(85, 67, 327, 20);
		contentPane.add(textFieldTelefoneContato);
		textFieldTelefoneContato.setColumns(10);

		textFieldDescricaoContato = new JTextField();
		textFieldDescricaoContato.setBounds(85, 117, 327, 44);
		contentPane.add(textFieldDescricaoContato);
		textFieldDescricaoContato.setColumns(10);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(22, 26, 46, 14);
		contentPane.add(lblNome);

		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(22, 70, 64, 14);
		contentPane.add(lblTelefone);

		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o:");
		lblDescrio.setBounds(22, 117, 64, 14);
		contentPane.add(lblDescrio);
	}
}
