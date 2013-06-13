package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;

public class APB extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					APB frame = new APB();
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
	public APB() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(APB.class.getResource("/com/sun/java/swing/plaf/windows/icons/image-delayed.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 423, 266);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Bem Vindo ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(127, 11, 160, 38);
		contentPane.add(lblNewLabel);
		
		JLabel lblAutomatizaoDeProcessos = new JLabel("Automa\u00E7\u00E3o de Processos da Barbearia");
		lblAutomatizaoDeProcessos.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAutomatizaoDeProcessos.setHorizontalAlignment(SwingConstants.CENTER);
		lblAutomatizaoDeProcessos.setBounds(61, 60, 288, 57);
		contentPane.add(lblAutomatizaoDeProcessos);
		
		JButton btnNewButton = new JButton("Iniciar");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			
			public void mouseClicked(MouseEvent arg0) {
				TelaOpcoes frame1 = new TelaOpcoes();
				frame1.setVisible(true);
				frame1.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnNewButton.setIcon(new ImageIcon(APB.class.getResource("/resources/ButtonAccept.png")));
		btnNewButton.setBounds(24, 151, 137, 65);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Fechar");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(APB.class.getResource("/resources/cancel-button-icone-7221-48.png")));
		btnNewButton_1.setBounds(238, 151, 145, 65);
		contentPane.add(btnNewButton_1);
	}

}
