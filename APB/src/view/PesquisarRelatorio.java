//Fazer bot�o Voltar e Concluir

package view;

import java.awt.Checkbox;
import java.awt.Event;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.UIManager;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PesquisarRelatorio extends JFrame {

	private JPanel contentPane;
	private JTextField txtDataInicial;
	private JTextField txtDataFinal;
	private JTextField txtBarbeiro;
	private JTextField txtServico;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PesquisarRelatorio frame = new PesquisarRelatorio();
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
	public PesquisarRelatorio() {
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 372, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelData = new JPanel();
		panelData.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Por Data", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelData.setBounds(10, 11, 221, 97);
		contentPane.add(panelData);
		panelData.setLayout(null);
		
		txtDataInicial = new JTextField();
		txtDataInicial.setEnabled(false);
		txtDataInicial.setBounds(10, 66, 94, 20);
		panelData.add(txtDataInicial);
		txtDataInicial.setText("dd/MM/aaaa");
		txtDataInicial.setColumns(10);
		
		txtDataFinal = new JTextField();
		txtDataFinal.setEnabled(false);
		txtDataFinal.setBounds(114, 66, 94, 20);
		panelData.add(txtDataFinal);
		txtDataFinal.setText("dd/MM/aaaa\r\n");
		txtDataFinal.setColumns(10);
		
		JLabel lblDataInicial = new JLabel("Data Inicial");
		lblDataInicial.setBounds(10, 53, 86, 14);
		panelData.add(lblDataInicial);
		
		Checkbox checkPorData = new Checkbox("Ativar");
		checkPorData.setBounds(6, 23, 71, 23);
		panelData.add(checkPorData);
		
		JLabel lblDataFinal = new JLabel("Data Final");
		lblDataFinal.setBounds(114, 53, 71, 14);
		panelData.add(lblDataFinal);
		
		JPanel panelBarbeiro = new JPanel();
		panelBarbeiro.setLayout(null);
		panelBarbeiro.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Por Barbeiro", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelBarbeiro.setBounds(10, 119, 221, 62);
		contentPane.add(panelBarbeiro);
		
		txtBarbeiro = new JTextField();
		txtBarbeiro.setText("Nome do barbeiro");
		txtBarbeiro.setEnabled(false);
		txtBarbeiro.setColumns(10);
		txtBarbeiro.setBounds(71, 23, 140, 20);
		panelBarbeiro.add(txtBarbeiro);
		
		Checkbox checkBarbeiro = new Checkbox("Ativar");
		checkBarbeiro.setBounds(6, 23, 59, 23);
		panelBarbeiro.add(checkBarbeiro);
		
		JPanel panelServico = new JPanel();
		panelServico.setLayout(null);
		panelServico.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Por Servi\u00E7o", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelServico.setBounds(10, 189, 221, 62);
		contentPane.add(panelServico);
		
		txtServico = new JTextField();
		txtServico.setText("Tipo de Servi\u00E7o");
		txtServico.setEnabled(false);
		txtServico.setColumns(10);
		txtServico.setBounds(71, 23, 140, 20);
		panelServico.add(txtServico);
		
		Checkbox checkServico = new Checkbox("Ativar");
		checkServico.setBounds(6, 23, 59, 23);
		panelServico.add(checkServico);
	}
	public boolean action(Event evento, Object arg){
		return false;
	}
}