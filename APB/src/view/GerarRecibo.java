package view;

import java.awt.EventQueue;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;

import com.mysql.jdbc.PreparedStatement;

import control.BarbeiroController;
import control.ReciboController;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import com.javadocx.CreateDocx;

@SuppressWarnings("serial")
public class GerarRecibo extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldDataInicial;
	private JTextField textFieldDataFinal;
	private double total = 0;
	private String nomeBarbeiro = null;
	private String numero;

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
		
		final JComboBox comboBoxBarbeiros = new JComboBox();
		comboBoxBarbeiros.setModel(new DefaultComboBoxModel(new String[] {"Selecione um barbeiro"}));
		comboBoxBarbeiros.setBounds(10, 32, 304, 26);
		contentPane.add(comboBoxBarbeiros);
		
		try {
			ResultSet rs = BarbeiroController.getInstance().pesquisar();
			while(rs.next()){
				comboBoxBarbeiros.addItem(rs.getString("cadeira")+" - "+rs.getString("nome"));
			}
		} catch (SQLException e) {
			mostrarMensagemDeErro(e.getMessage());
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
				ReciboController reciboController = ReciboController.getInstance();
				try {
					CreateDocx docx = new CreateDocx("docx");
					String[] nome = comboBoxBarbeiros.getSelectedItem()
							.toString().split(" ");
					
					HashMap paramsCabeca = new HashMap();
					HashMap paramsTitulo = new HashMap();
					HashMap paramsValor = new HashMap();
					HashMap paramsTexto = new HashMap();
					HashMap paramsLinhaAssinatura = new HashMap();
			        HashMap paramsTexto4 = new HashMap();
			        HashMap paramsQuebraLinha = new HashMap();
			        HashMap paramsAssinaturaBarbeiro = new HashMap();
			        
					paramsCabeca.put("b", "single");
					paramsCabeca.put("jc", "center");
					paramsCabeca.put("font", "Arial");
					
					paramsQuebraLinha.put("jc", "center");
					
					paramsTitulo.put("b", "single");
					paramsTitulo.put("jc", "center");
					paramsTitulo.put("font", "Arial");
					
					paramsValor.put("b", "single");
					paramsValor.put("jc", "center");
			        paramsValor.put("font", "Arial");
					
			        paramsTexto.put("font", "Arial");
			        
			        paramsLinhaAssinatura.put("jc", "center");
			        
			        paramsTexto4.put("jc", "center");
			        
			        paramsAssinaturaBarbeiro.put("jc", "center");

					ResultSet rs = reciboController.getInstance().pesquisarServicosDoBarbeiro(nome[2],
							textFieldDataInicial.getText(), textFieldDataFinal.getText());
					while (rs.next()) {
						numero = rs.getString("preco").replace(",", ".");
						double valor = Double.parseDouble(numero);
						total = total + (valor/2);
					}
					
					ResultSet rs2 = BarbeiroController.getInstance().pesquisar();
					
					while(rs2.next()){
						nomeBarbeiro = rs2.getString("nome");
					}
					
					String dataInic = textFieldDataInicial.getText();
					String dataFin = textFieldDataFinal.getText();
					
					String cabeca =	"BARBEARIA DO ONOFRE LTDA - ME";
					
					String titulo = "RECIBO PAGAMENTO ALUGUEL BENS MÓVEIS";
					
					String valor = ("VALOR R$ " + total);
					
					String quebraLinha = " ";
					
					String texto = "                    Recebi do Sr. " + nomeBarbeiro + 
							" a importância supra de  R$ " + total + " (), " +
							"referente ao Aluguel do período de " + dataInic +
							" até " + dataFin + ", conforme CONTRATO de locação " +
							"de bens móveis, firmado entre as partes.";
					String texto2 =  "                    Por ser verdade assino o presente RECIBO para" +
							" os fins de direitos, de acordo com a lei.";
					String texto3 = "                    Brasília - DF ____/____/________";
					
					String linhaAssinatura = "_____________________________________________________";
					String texto4 = "BARBEARIA DO ONOFRE LTDA - ME";
					String assianturaBarbeiro = nomeBarbeiro;
					
					docx.addText(cabeca, paramsCabeca);
					docx.addText(titulo, paramsTitulo);
					docx.addText(valor, paramsValor);
					docx.addText(quebraLinha, paramsQuebraLinha);
					docx.addText(texto, paramsTexto);
					docx.addText(texto2, paramsTexto);
					docx.addText(texto3, paramsTexto);
					docx.addText(quebraLinha, paramsQuebraLinha);
					docx.addText(linhaAssinatura, paramsLinhaAssinatura);
					docx.addText(texto4, paramsTexto4);
					docx.addText(quebraLinha, paramsQuebraLinha);
					docx.addText(linhaAssinatura, paramsLinhaAssinatura);
					docx.addText(nomeBarbeiro, paramsAssinaturaBarbeiro);
					
					docx.createDocx("Recibo");
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
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
	
	private void mostrarMensagemDeErro(String informacao) {
		JOptionPane.showMessageDialog(null, informacao, "Atenção",
				JOptionPane.INFORMATION_MESSAGE);
	}
}
