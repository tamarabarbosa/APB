package view;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

import control.BarbeiroController;

import exception.BarbeiroException;

import model.Barbeiro;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

@SuppressWarnings("serial")
public class RemoverBarbeiro extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNome;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RemoverBarbeiro frame = new RemoverBarbeiro();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public RemoverBarbeiro() {
		inicializarComponentes();
	}
	
	public void inicializarComponentes(){
		setTitle("Remover Barbeiro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 375, 153);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(53, 39, 296, 20);
		contentPane.add(textFieldNome);
		textFieldNome.setColumns(10);
		
		JButton btnNewButton = new JButton("Remover");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Barbeiro barbeiro = new Barbeiro();
				try {
					barbeiro.setNome(textFieldNome.getText());
				} catch (BarbeiroException e) {
					e.printStackTrace();
				}
				
				BarbeiroController barbeiroController = BarbeiroController
						.getInstance();

				JOptionPane.showMessageDialog(null, "Barbeiro "
						+ textFieldNome.getText()
						+ " foi removido com sucesso");
				
				dispose();
				CadastrarBarbeiro frame =  new CadastrarBarbeiro();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
				
				try {
					barbeiroController.excluir(barbeiro);
				} catch (SQLException k) {
					k.printStackTrace();
				}
				
			}
		});
		btnNewButton.setBounds(53, 80, 98, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Voltar");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
				CadastrarBarbeiro frame =  new CadastrarBarbeiro();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
			}
		});
		btnNewButton_1.setBounds(260, 80, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 42, 46, 14);
		contentPane.add(lblNome);
	}
}

