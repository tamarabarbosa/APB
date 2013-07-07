package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


@SuppressWarnings("serial")
public class Administrativo extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Administrativo frame = new Administrativo();
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
	public Administrativo() {
		setTitle("APB");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 540, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"), "Administrativo",
				TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 505, 138);
		contentPane.add(panel);
		panel.setLayout(null);

		JButton btnBarbeiro = new JButton("Barbeiro");
		btnBarbeiro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				CadastrarBarbeiro frame = new CadastrarBarbeiro();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
			}
		});
		btnBarbeiro.setBounds(10, 45, 157, 37);
		panel.add(btnBarbeiro);

		JButton btnTipoServico = new JButton("Tipo de Servi\u00E7o");
		btnTipoServico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				CadastrarTipoServico frame = new CadastrarTipoServico();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
			}
		});
		btnTipoServico.setBounds(346, 45, 149, 37);
		panel.add(btnTipoServico);
		
		JButton btnAgenda = new JButton("Agenda");
		btnAgenda.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				CadastrarAgenda frame = new CadastrarAgenda();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
			}
		});
		btnAgenda.setBounds(179, 45, 157, 37);
		panel.add(btnAgenda);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				MenuPrincipal frame = new MenuPrincipal();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
			}
		});
		btnVoltar.setBounds(211, 104, 89, 23);
		panel.add(btnVoltar);
	}
}
