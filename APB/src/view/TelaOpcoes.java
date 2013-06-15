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

@SuppressWarnings("serial")
public class TelaOpcoes extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaOpcoes frame = new TelaOpcoes();
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
	public TelaOpcoes() {
		setTitle("APB");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 166);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"), "Op\u00E7\u00F5es",
				TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 414, 117);
		contentPane.add(panel);
		panel.setLayout(null);

		JButton btnBarbeiro = new JButton("Barbeiro");
		btnBarbeiro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CadastroBarbeiro frame = new CadastroBarbeiro();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnBarbeiro.setBounds(22, 39, 157, 37);
		panel.add(btnBarbeiro);

		JButton btnServico = new JButton("Servi\u00E7o");
		btnServico.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CadastrarServico frame = new CadastrarServico();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnServico.setBounds(238, 39, 149, 37);
		panel.add(btnServico);
	}
}
