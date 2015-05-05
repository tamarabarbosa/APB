package view;

import java.awt.EventQueue;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;

import control.BarberController;
import control.ReceiptController;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.javadocx.CreateDocx;

@SuppressWarnings("serial")
public class GenerateReceipt extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldDataInicial;
	private JTextField textFieldDataFinal;
	private double total = 0;
	private String numero;

	private static String RAZAO_SOCIAL = "BARBEARIA DO ONOFRE LTDA - ME";
	private static String RECIBO_PAGAMENTO = "RECIBO PAGAMENTO ALUGUEL BENS MÓVEIS";
	private static String LINHA = "____________________________________________________________";
	private static String LOCAL_E_DATA = "                    Brasília - DF  ____/____/________";

	/**
	 * Launch the application.
	 */

	public String ConverterDataParaABNT(String data) throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date dataISO = sdf.parse(data);

		SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
		String databr = sdf2.format(dataISO);

		return databr;
	}

	public String ConverterDataParaABNTSemBarra(String data)
			throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date dataISO = sdf.parse(data);

		SimpleDateFormat sdf2 = new SimpleDateFormat("dd-MM-yyyy");
		String databr = sdf2.format(dataISO);

		return databr;
	}

	private String ConverterDataParaISO(String data) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date dataABNT = sdf.parse(data);

		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
		String dataISO = sdf2.format(dataABNT);

		return dataISO;
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GenerateReceipt frame = new GenerateReceipt();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 *
	 * @throws ParseException
	 */
	public GenerateReceipt() throws ParseException {
		setTitle("Gerar Recibo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 348, 264);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		final JComboBox comboBoxBarbers = new JComboBox();
		comboBoxBarbers.setModel(new DefaultComboBoxModel(
				new String[] { "Selecione um barber" }));
		comboBoxBarbers.setBounds(10, 32, 304, 26);
		contentPane.add(comboBoxBarbers);

		try {
			ResultSet rs = BarberController.getInstance().search();
			while (rs.next()) {
				comboBoxBarbers.addItem(rs.getString("chair") + " - "
						+ rs.getString("name"));
			}
		} catch (SQLException e) {
			mostrarMensagemDeErro(e.getMessage());
		}

		final MaskFormatter mascaraFormatoData = new MaskFormatter("##/##/####");

		textFieldDataInicial = new JFormattedTextField(mascaraFormatoData);
		textFieldDataInicial.setBounds(10, 110, 124, 20);
		contentPane.add(textFieldDataInicial);
		textFieldDataInicial.setColumns(10);

		JLabel lblDataDeInicio = new JLabel("Data Inicial");
		lblDataDeInicio.setBounds(36, 89, 86, 14);
		contentPane.add(lblDataDeInicio);

		textFieldDataFinal = new JFormattedTextField(mascaraFormatoData);
		textFieldDataFinal.setBounds(190, 110, 124, 20);
		contentPane.add(textFieldDataFinal);
		textFieldDataFinal.setColumns(10);

		JLabel lblDataFinal = new JLabel("Data Final");
		lblDataFinal.setBounds(215, 89, 86, 14);
		contentPane.add(lblDataFinal);

		JButton btnGenerateReceipt = new JButton("Gerar Recibo");
		btnGenerateReceipt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ReceiptController reciboController = ReceiptController
						.getInstance();
				try {
					if (comboBoxBarbers.getSelectedIndex() != 0) {
						CreateDocx docx = new CreateDocx("docx");

						HashMap paramsCabeca = new HashMap();
						HashMap paramsTitulo = new HashMap();
						HashMap paramsValor = new HashMap();
						HashMap paramsTexto = new HashMap();
						HashMap paramsLinhaAssinatura = new HashMap();
						HashMap paramsTexto4 = new HashMap();
						HashMap paramsQuebraLinha = new HashMap();
						HashMap paramsAssinaturaBarber = new HashMap();

						paramsCabeca.put("b", "single");
						paramsCabeca.put("jc", "center");
						paramsCabeca.put("font", "Arial");

						paramsTitulo.put("b", "single");
						paramsTitulo.put("jc", "center");
						paramsTitulo.put("font", "Arial");

						paramsValor.put("b", "single");
						paramsValor.put("jc", "center");
						paramsValor.put("font", "Arial");

						paramsTexto.put("font", "Arial");
						paramsTexto.put("align", "justify");

						paramsLinhaAssinatura.put("jc", "center");

						paramsTexto4.put("jc", "center");
						paramsTexto4.put("b", "single");

						paramsAssinaturaBarber.put("jc", "center");
						paramsAssinaturaBarber.put("b", "single");

						final String dataInicialIso = ConverterDataParaISO(textFieldDataInicial
								.getText());
						final String dataFinalIso = ConverterDataParaISO(textFieldDataFinal
								.getText());

						String[] name = comboBoxBarbers.getSelectedItem()
								.toString().split(" - ");

						ResultSet rs = reciboController.getInstance()
								.pesquisarJobsDoBarber(name[1],
										dataInicialIso, dataFinalIso);
						while (rs.next()) {
							numero = rs.getString("preco").replace(",", ".");
							double valor = Double.parseDouble(numero);
							total = total + (valor / 2);
						}

						DecimalFormat decimal = new DecimalFormat("##0.00");

						String dataInic = textFieldDataInicial.getText();
						String dataFin = textFieldDataFinal.getText();

						String valor = ("VALOR R$ " + decimal.format(total));

						String texto = "                    Recebi do Sr. "
								+ name[1] + " a importância supra de R$ "
								+ (decimal.format(total)) + ", "
								+ "referente ao Aluguel do período de "
								+ dataInic + " até " + dataFin
								+ ", conforme CONTRATO de locação "
								+ "de bens móveis, firmado entre as partes.";
						String texto2 = "                    Por ser verdade assino o presente RECIBO para"
								+ " os fins de direitos, de acordo com a lei.";

						docx.addText(RAZAO_SOCIAL, paramsCabeca);
						docx.addText(RECIBO_PAGAMENTO, paramsTitulo);
						docx.addText(valor, paramsValor);
						docx.addBreak("line");
						docx.addText(texto, paramsTexto);
						docx.addText(texto2, paramsTexto);
						docx.addText(LOCAL_E_DATA, paramsTexto);
						docx.addBreak("line");
						docx.addText(LINHA, paramsLinhaAssinatura);
						docx.addText(RAZAO_SOCIAL, paramsTexto4);
						docx.addBreak("line");
						docx.addText(LINHA, paramsLinhaAssinatura);
						docx.addText(name[1], paramsAssinaturaBarber);

						docx.createDocx("Recibo " + name[1] + " "
								+ ConverterDataParaABNTSemBarra(dataInicialIso)
								+ " - "
								+ ConverterDataParaABNTSemBarra(dataFinalIso));

						GenerateReceipt frame = new GenerateReceipt();
						frame.setVisible(true);
						frame.setLocationRelativeTo(null);
						dispose();
					} else {
						JOptionPane.showMessageDialog(null,
								"Selecione o um barber");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnGenerateReceipt.setBounds(202, 175, 112, 35);
		contentPane.add(btnGenerateReceipt);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
				Administrative frame = new Administrative();
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
