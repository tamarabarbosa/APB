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
import java.text.ParseException;

@SuppressWarnings("serial")
public class Administrative extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Administrative frame = new Administrative();
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
	// These methods are used to initialize the components
	public Administrative() {
		setTitle("APB");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 418, 238);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"), "Administrative",
				TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 379, 183);
		contentPane.add(panel);
		panel.setLayout(null);

		JButton btnBarber = new JButton("Barber");
		btnBarber.addMouseListener(new MouseAdapter() {
			@Override
			// This method is used to create the button and the action that open
			// the Phonebook frame
			public void mouseClicked(MouseEvent e) {
				dispose();
				RegisterBarber frame = new RegisterBarber();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
			}
		});
		btnBarber.setBounds(10, 45, 157, 37);
		panel.add(btnBarber);

		JButton btnTipoJob = new JButton("Tipo de Servi\u00E7o");
		btnTipoJob.addActionListener(new ActionListener() {
			// This method is used to create the button and the action that open
			// the Service Type frame
			public void actionPerformed(ActionEvent e) {
				dispose();
				RegisterDoneService frame = new RegisterDoneService();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
			}
		});
		btnTipoJob.setBounds(215, 45, 149, 37);
		panel.add(btnTipoJob);

		JButton btnPhonebook = new JButton("Phonebook");
		btnPhonebook.addMouseListener(new MouseAdapter() {
			@Override
			// This method is used to create the button and the action that open
			// the Phonebook frame
			public void mouseClicked(MouseEvent e) {
				dispose();
				RegisterPhonebook frame = new RegisterPhonebook();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
			}
		});
		btnPhonebook.setBounds(10, 93, 157, 37);
		panel.add(btnPhonebook);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			// This method is used to create the button and the action that open
			// the Service Type frame
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				MainMenu frame = new MainMenu();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
			}
		});
		btnVoltar.setBounds(151, 141, 89, 23);
		panel.add(btnVoltar);

		JButton btnRecibo = new JButton("Recibo");
		btnRecibo.addMouseListener(new MouseAdapter() {
			@Override
			// This method is used to create the button and the action that open
			// the receipt frame
			public void mouseClicked(MouseEvent arg0) {
				dispose();
				GenerateReceipt frame = null;
				try {
					frame = new GenerateReceipt();
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
			}
		});
		btnRecibo.setBounds(215, 93, 149, 37);
		panel.add(btnRecibo);
	}
}
