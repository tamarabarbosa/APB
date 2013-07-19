package view;

import java.awt.EventQueue;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;

import control.BarbeiroController;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GerarRecibo extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldDataInicial;
	private JTextField textFieldDataFinal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GerarRecibo frame = new GerarRecibo();
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
	public GerarRecibo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 348, 264);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox comboBoxBarbeiros = new JComboBox();
		comboBoxBarbeiros.setModel(new DefaultComboBoxModel(new String[] {"Selecione um barbeiro"}));
		comboBoxBarbeiros.setBounds(10, 32, 304, 26);
		contentPane.add(comboBoxBarbeiros);
		
		try {
			ResultSet rs = BarbeiroController.getInstance().pesquisar();
			while(rs.next()){
				comboBoxBarbeiros.addItem(rs.getString("cadeira")+" - "+rs.getString("nome"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		textFieldDataInicial = new JTextField();
		textFieldDataInicial.setBounds(10, 110, 124, 20);
		contentPane.add(textFieldDataInicial);
		textFieldDataInicial.setColumns(10);
		
		JLabel lblDataDeInicio = new JLabel("Data Inicial");
		lblDataDeInicio.setBounds(36, 89, 86, 14);
		contentPane.add(lblDataDeInicio);
		
		textFieldDataFinal = new JTextField();
		textFieldDataFinal.setBounds(190, 110, 124, 20);
		contentPane.add(textFieldDataFinal);
		textFieldDataFinal.setColumns(10);
		
		JLabel lblDataFinal = new JLabel("Data Final");
		lblDataFinal.setBounds(215, 89, 86, 14);
		contentPane.add(lblDataFinal);
		
		JButton btnGerarRecibo = new JButton("Gerar Recibo");
		btnGerarRecibo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		btnGerarRecibo.setBounds(202, 175, 112, 35);
		contentPane.add(btnGerarRecibo);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
				Administrativo frame = new Administrativo();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
			}
		});
		btnVoltar.setBounds(10, 175, 112, 35);
		contentPane.add(btnVoltar);
	}
}
