package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.ImageIcon;

import control.ServicoController;

import model.Servico;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

public class CadastrarServico extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldPreco;
	private JTextField textFieldNome;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastrarServico frame = new CadastrarServico();
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
	public CadastrarServico() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 350, 232);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNome.setBounds(10, 11, 46, 14);
		contentPane.add(lblNome);
		
		JLabel lblPreo = new JLabel("Pre\u00E7o");
		lblPreo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPreo.setBounds(10, 36, 46, 21);
		contentPane.add(lblPreo);
		
		textFieldPreco = new JTextField();
		textFieldPreco.setBounds(57, 37, 86, 20);
		contentPane.add(textFieldPreco);
		textFieldPreco.setColumns(10);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(57, 9, 267, 20);
		contentPane.add(textFieldNome);
		textFieldNome.setColumns(10);
		
		JButton btnNewButton = new JButton("Aceitar");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Servico servico = new Servico();
				servico.setNome(textFieldNome.getText());
				servico.setPreco(textFieldPreco.getText());
				
				if(textFieldNome.getText().isEmpty() || textFieldPreco.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Todos os campos são obrigatorios");
				}else
				{
					
					ServicoController servicoController = ServicoController.getInstance();
					
					try {
						servicoController.inserir(servico);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					JOptionPane.showMessageDialog(null, "Servico " +textFieldNome.getText()+" inserido com sucesso");	
					
				}
				textFieldNome.setText("");
				textFieldPreco.setText("");
				
				
			}
		});
		btnNewButton.setIcon(new ImageIcon(CadastrarServico.class.getResource("/resources/ButtonAccept.png")));
		btnNewButton.setBounds(10, 68, 133, 57);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaOpcoes frame = new TelaOpcoes();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(CadastrarServico.class.getResource("/resources/cancel-button-icone-7221-48.png")));
		btnNewButton_1.setBounds(185, 68, 139, 57);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Limpar Campos");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textFieldNome.setText("");
				textFieldPreco.setText("");
				
			}
		});
		btnNewButton_2.setBounds(10, 136, 314, 46);
		contentPane.add(btnNewButton_2);
	}

}
