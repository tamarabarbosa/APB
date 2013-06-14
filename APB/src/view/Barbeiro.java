package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Barbeiro extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Barbeiro frame = new Barbeiro();
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
	public Barbeiro() {
		setTitle("Barbeiro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 756, 543);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 506, 482);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setFillsViewportHeight(true);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nome", "CPF", "RG", "Telefone"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton botaoNovoBarbeirp = new JButton("Novo");
		botaoNovoBarbeirp.setBounds(526, 11, 204, 43);
		contentPane.add(botaoNovoBarbeirp);
		
		JButton botaoAlterarBarbeiro = new JButton("Alterar");
		botaoAlterarBarbeiro.setBounds(526, 65, 204, 43);
		contentPane.add(botaoAlterarBarbeiro);
		
		JButton botaoRemoverBarbeiro = new JButton("Remover");
		botaoRemoverBarbeiro.setBounds(526, 119, 204, 43);
		contentPane.add(botaoRemoverBarbeiro);
		
		JButton botaoConcluir = new JButton("Voltar");
		botaoConcluir.setBounds(526, 450, 204, 43);
		contentPane.add(botaoConcluir);
		
		JButton btnNewButton = new JButton("Pesquisar");
		btnNewButton.setBounds(526, 173, 204, 43);
		contentPane.add(btnNewButton);
	}
}
