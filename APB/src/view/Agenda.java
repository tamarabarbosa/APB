package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Agenda extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Agenda frame = new Agenda();
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
	public Agenda() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 21, 310, 230);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nome", "Telefone", "Descri\u00E7\u00E3o"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton btnNovoContato = new JButton("Novo");
		btnNovoContato.setBounds(330, 24, 94, 23);
		contentPane.add(btnNovoContato);
		
		JButton btnAlterarCantato = new JButton("Alterar");
		btnAlterarCantato.setBounds(330, 58, 94, 23);
		contentPane.add(btnAlterarCantato);
		
		JButton btnRemoverContato = new JButton("Remover");
		btnRemoverContato.setBounds(330, 92, 94, 23);
		contentPane.add(btnRemoverContato);
		
		JButton btnPesquisarContato = new JButton("Pesquisar");
		btnPesquisarContato.setBounds(330, 126, 94, 23);
		contentPane.add(btnPesquisarContato);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(330, 228, 94, 23);
		contentPane.add(btnVoltar);
	}
}
