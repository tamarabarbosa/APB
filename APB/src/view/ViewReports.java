package view;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.ldap.ControlFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import model.Report;
import control.ReportController;
import exception.ReceiptException;
import exception.ReportException;

@SuppressWarnings("serial")
public class ViewReports extends JFrame {

	private JPanel contentPane;
	private double total = 0;
	private String numero;
	List<String> jobs = new ArrayList<String>();
	private int contador = 0;
	private int numeroTotalDeJobs = 0;
	private double valorTotalDoJob = 0;
	private double valorTotalASerPAgo = 0;
	private double total2 = 0;

	DecimalFormat decimal = new DecimalFormat("##0.00");

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewReports frame = new ViewReports();
					frame.setVisible(true);
				} catch (Exception e) {
					mostrarMensagemDeErro(e.getMessage());
				}
			}
		});
	}

	public ViewReports() throws SQLException, ReceiptException,
			NullPointerException, ParseException {
		setTitle("Relat\u00F3rios");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		final JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 660, 486);
		contentPane.add(scrollPane);

		final DefaultTableModel modelo = new DefaultTableModel(null,
				new String[] { "Nome do Serviço", "Quantidade", "Valor total",
						"Valor recebido" }) {
			boolean[] columnEditables = new boolean[] { false, false, false,
					false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		};

		final JTable table = new JTable(modelo);
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(3).setResizable(false);
		scrollPane.setViewportView(table);

		ReportController relatorioController = ReportController.getInstance();

		Report report = new Report();

		if (SearchReport.typeBusca == 1) {

			report.setBarber(SearchReport.barber);

			ResultSet rs = relatorioController.searchByBarber(report);

			while (rs.next()) {

				if (jobs.contains(rs.getString("name")) == false) {
					jobs.add(rs.getString("name"));
					contador++;
				}
			}

			for (int i = 0; i < contador; i++) {
				rs.beforeFirst();
				while (rs.next()) {
					if (jobs.get(i).equals(rs.getString("name"))) {
						numero = rs.getString("preco").replace(",", ".");
						double valor = Double.parseDouble(numero);
						valorTotalDoJob = valorTotalDoJob + valor;

						numeroTotalDeJobs++;
					}
				}

				String[] dados = new String[4];
				dados[0] = jobs.get(i);
				dados[1] = Integer.toString(numeroTotalDeJobs);
				dados[2] = Double.toString(valorTotalDoJob)
						.replace(".", ",")
						.valueOf(decimal.format(valorTotalDoJob));
				valorTotalASerPAgo = valorTotalDoJob / 2;
				dados[3] = Double.toString(valorTotalASerPAgo)
						.replace(".", ",")
						.valueOf(decimal.format(valorTotalASerPAgo));

				total = total + valorTotalDoJob;
				total2 = total2 + valorTotalASerPAgo;
				modelo.addRow(dados);

				numeroTotalDeJobs = 0;
				valorTotalASerPAgo = 0;
				valorTotalDoJob = 0;
			}
		}
		if (SearchReport.typeBusca == 2) {

			report.setBarber(SearchReport.barber);
			report.setServiceType(SearchReport.job);

			ResultSet rs = relatorioController
					.searchByBarberEJob(report);

			while (rs.next()) {

				if (jobs.contains(rs.getString("name")) == false) {
					jobs.add(rs.getString("name"));
					contador++;
				}
			}

			for (int i = 0; i < contador; i++) {
				rs.beforeFirst();
				while (rs.next()) {
					if (jobs.get(i).equals(rs.getString("name"))) {
						numero = rs.getString("preco").replace(",", ".");
						double valor = Double.parseDouble(numero);
						valorTotalDoJob = valorTotalDoJob + valor;

						numeroTotalDeJobs++;
					}
				}

				String[] dados = new String[4];
				dados[0] = jobs.get(i);
				dados[1] = Integer.toString(numeroTotalDeJobs);
				dados[2] = Double.toString(valorTotalDoJob)
						.replace(".", ",")
						.valueOf(decimal.format(valorTotalDoJob));
				valorTotalASerPAgo = valorTotalDoJob / 2;
				dados[3] = Double.toString(valorTotalASerPAgo)
						.replace(".", ",")
						.valueOf(decimal.format(valorTotalASerPAgo));

				modelo.addRow(dados);

				total = total + valorTotalDoJob;
				total2 = total2 + valorTotalASerPAgo;

				numeroTotalDeJobs = 0;
				valorTotalASerPAgo = 0;
				valorTotalDoJob = 0;
			}
		}
		if (SearchReport.typeBusca == 3) {

			report.setBarber(SearchReport.barber);
			report.setEndDate(SearchReport.dataFinal);
			report.setInitialDate(SearchReport.dataInicial);

			ResultSet rs = relatorioController
					.searchByDataEBarber(report);

			while (rs.next()) {

				if (jobs.contains(rs.getString("name")) == false) {
					jobs.add(rs.getString("name"));
					contador++;
				}
			}

			for (int i = 0; i < contador; i++) {
				rs.beforeFirst();
				while (rs.next()) {
					if (jobs.get(i).equals(rs.getString("name"))) {
						numero = rs.getString("preco").replace(",", ".");
						double valor = Double.parseDouble(numero);
						valorTotalDoJob = valorTotalDoJob + valor;

						numeroTotalDeJobs++;
					}
				}

				String[] dados = new String[4];
				dados[0] = jobs.get(i);
				dados[1] = Integer.toString(numeroTotalDeJobs);
				dados[2] = Double.toString(valorTotalDoJob)
						.replace(".", ",")
						.valueOf(decimal.format(valorTotalDoJob));
				valorTotalASerPAgo = valorTotalDoJob / 2;
				dados[3] = Double.toString(valorTotalASerPAgo)
						.replace(".", ",")
						.valueOf(decimal.format(valorTotalASerPAgo));

				modelo.addRow(dados);

				total = total + valorTotalDoJob;
				total2 = total2 + valorTotalASerPAgo;

				numeroTotalDeJobs = 0;
				valorTotalASerPAgo = 0;
				valorTotalDoJob = 0;
			}
		}
		if (SearchReport.typeBusca == 4) {

			report.setBarber(SearchReport.barber);
			report.setServiceType(SearchReport.job);
			report.setEndDate(SearchReport.dataFinal);
			report.setInitialDate(SearchReport.dataInicial);

			ResultSet rs = relatorioController
					.searchByDataBarberEJob(report);

			while (rs.next()) {

				if (jobs.contains(rs.getString("name")) == false) {
					jobs.add(rs.getString("name"));
					contador++;
				}
			}

			for (int i = 0; i < contador; i++) {
				rs.beforeFirst();
				while (rs.next()) {
					if (jobs.get(i).equals(rs.getString("name"))) {
						numero = rs.getString("preco").replace(",", ".");
						double valor = Double.parseDouble(numero);
						valorTotalDoJob = valorTotalDoJob + valor;

						numeroTotalDeJobs++;
					}
				}

				String[] dados = new String[4];
				dados[0] = jobs.get(i);
				dados[1] = Integer.toString(numeroTotalDeJobs);
				dados[2] = Double.toString(valorTotalDoJob)
						.replace(".", ",")
						.valueOf(decimal.format(valorTotalDoJob));
				valorTotalASerPAgo = valorTotalDoJob / 2;
				dados[3] = Double.toString(valorTotalASerPAgo)
						.replace(".", ",")
						.valueOf(decimal.format(valorTotalASerPAgo));

				modelo.addRow(dados);

				total = total + valorTotalDoJob;
				total2 = total2 + valorTotalASerPAgo;

				numeroTotalDeJobs = 0;
				valorTotalASerPAgo = 0;
				valorTotalDoJob = 0;

			}
		}
		if (SearchReport.typeBusca == 5) {

			report.setServiceType(SearchReport.job);

			ResultSet rs = relatorioController.searchByJob(report);

			while (rs.next()) {

				if (jobs.contains(rs.getString("name")) == false) {
					jobs.add(rs.getString("name"));
					contador++;
				}
			}

			for (int i = 0; i < contador; i++) {
				rs.beforeFirst();
				while (rs.next()) {
					if (jobs.get(i).equals(rs.getString("name"))) {
						numero = rs.getString("preco").replace(",", ".");
						double valor = Double.parseDouble(numero);
						valorTotalDoJob = valorTotalDoJob + valor;

						numeroTotalDeJobs++;
					}
				}

				String[] dados = new String[4];
				dados[0] = jobs.get(i);
				dados[1] = Integer.toString(numeroTotalDeJobs);
				dados[2] = Double.toString(valorTotalDoJob)
						.replace(".", ",")
						.valueOf(decimal.format(valorTotalDoJob));
				valorTotalASerPAgo = valorTotalDoJob / 2;
				dados[3] = Double.toString(valorTotalASerPAgo)
						.replace(".", ",")
						.valueOf(decimal.format(valorTotalASerPAgo));

				modelo.addRow(dados);

				total = total + valorTotalDoJob;
				total2 = total2 + valorTotalASerPAgo;

				numeroTotalDeJobs = 0;
				valorTotalASerPAgo = 0;
				valorTotalDoJob = 0;
			}
		}
		if (SearchReport.typeBusca == 6) {

			report.setServiceType(SearchReport.job);
			report.setEndDate(SearchReport.dataFinal);
			report.setInitialDate(SearchReport.dataInicial);

			ResultSet rs = relatorioController.searchByDataEJob(report);

			while (rs.next()) {

				if (jobs.contains(rs.getString("name")) == false) {
					jobs.add(rs.getString("name"));
					contador++;
				}
			}

			for (int i = 0; i < contador; i++) {
				rs.beforeFirst();
				while (rs.next()) {
					if (jobs.get(i).equals(rs.getString("name"))) {
						numero = rs.getString("preco").replace(",", ".");
						double valor = Double.parseDouble(numero);
						valorTotalDoJob = valorTotalDoJob + valor;

						numeroTotalDeJobs++;
					}
				}

				String[] dados = new String[4];
				dados[0] = jobs.get(i);
				dados[1] = Integer.toString(numeroTotalDeJobs);
				dados[2] = Double.toString(valorTotalDoJob)
						.replace(".", ",")
						.valueOf(decimal.format(valorTotalDoJob));
				valorTotalASerPAgo = valorTotalDoJob / 2;
				dados[3] = Double.toString(valorTotalASerPAgo)
						.replace(".", ",")
						.valueOf(decimal.format(valorTotalASerPAgo));

				modelo.addRow(dados);

				total = total + valorTotalDoJob;
				total2 = total2 + valorTotalASerPAgo;

				numeroTotalDeJobs = 0;
				valorTotalASerPAgo = 0;
				valorTotalDoJob = 0;
			}
		}
		if (SearchReport.typeBusca == 7) {

			report.setEndDate(SearchReport.dataFinal);
			report.setInitialDate(SearchReport.dataInicial);

			ResultSet rs = relatorioController.searchByData(report);

			while (rs.next()) {

				if (jobs.contains(rs.getString("name")) == false) {
					jobs.add(rs.getString("name"));
					contador++;
				}
			}

			for (int i = 0; i < contador; i++) {
				rs.beforeFirst();
				while (rs.next()) {
					if (jobs.get(i).equals(rs.getString("name"))) {
						numero = rs.getString("preco").replace(",", ".");
						double valor = Double.parseDouble(numero);
						valorTotalDoJob = valorTotalDoJob + valor;

						numeroTotalDeJobs++;
					}
				}

				String[] dados = new String[4];
				dados[0] = jobs.get(i);
				dados[1] = Integer.toString(numeroTotalDeJobs);
				dados[2] = Double.toString(valorTotalDoJob)
						.replace(".", ",")
						.valueOf(decimal.format(valorTotalDoJob));
				valorTotalASerPAgo = valorTotalDoJob / 2;
				dados[3] = Double.toString(valorTotalASerPAgo)
						.replace(".", ",")
						.valueOf(decimal.format(valorTotalASerPAgo));

				modelo.addRow(dados);

				total = total + valorTotalDoJob;
				total2 = total2 + valorTotalASerPAgo;

				numeroTotalDeJobs = 0;
				valorTotalASerPAgo = 0;
				valorTotalDoJob = 0;
			}
		}
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					SearchReport.typeBusca = 0;
					SearchReport frame = new SearchReport();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					dispose();
				} catch (ParseException e1) {
					mostrarMensagemDeErro(e1.getMessage());
				}
			}
		});
		btnPesquisar.setBounds(680, 13, 94, 62);
		contentPane.add(btnPesquisar);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MainMenu frame = new MainMenu();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnVoltar.setBounds(680, 527, 94, 23);
		contentPane.add(btnVoltar);

		JPanel panel = new JPanel();
		panel.setBounds(10, 529, 660, 22);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblLucroTotal = new JLabel("Valor total pesquisado:");
		lblLucroTotal.setBounds(6, 4, 174, 14);
		panel.add(lblLucroTotal);

		JLabel lblValor = new JLabel("R$ "
				+ String.valueOf(decimal.format(total)));
		lblValor.setHorizontalAlignment(SwingConstants.RIGHT);
		lblValor.setVerticalAlignment(SwingConstants.BOTTOM);
		lblValor.setBounds(476, 4, 174, 14);
		panel.add(lblValor);

		final JPanel painelGrafico = new JPanel();
		painelGrafico.setBounds(10, 10, 660, 486);
		contentPane.add(painelGrafico);
		painelGrafico.setVisible(true);

		if (SearchReport.typeBusca != 0) {
			try {
				CategoryDataset cds;
				cds = createDatasetRelatorio();
				String titulo = "Total Por Dia";
				String eixoy = "Valores";
				String txt_legenda = "Ledenda:";
				boolean legenda = true;
				boolean tooltips = true;
				boolean urls = true;
				JFreeChart graf = ControlFactory.createBarChart(titulo,
						txt_legenda, eixoy, cds, PlotOrientation.VERTICAL,
						legenda, tooltips, urls);
				ChartPanel myChartPanel = new ChartPanel(graf, true);
				myChartPanel.setSize(painelGrafico.getWidth(),
						painelGrafico.getHeight());
				myChartPanel.setVisible(true);
				painelGrafico.removeAll();
				painelGrafico.add(myChartPanel);
				painelGrafico.revalidate();
				painelGrafico.repaint();

			} catch (SQLException e) {
				mostrarMensagemDeErro(e.getMessage());
			} catch (ReportException e) {
				mostrarMensagemDeErro(e.getMessage());
			}

		}

		JButton btnGrafico = new JButton("Gr\u00E1fico");
		btnGrafico.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (SearchReport.typeBusca != 0) {
					painelGrafico.setVisible(true);
					scrollPane.setVisible(false);
				} else
					JOptionPane
							.showMessageDialog(null,
									"Você deve fazer uma busca para visualizar o gráfico.");
			}
		});
		btnGrafico.setBounds(680, 159, 94, 62);
		contentPane.add(btnGrafico);

		JButton btnTabela = new JButton("Tabela");
		btnTabela.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				painelGrafico.setVisible(false);
				scrollPane.setVisible(true);
			}
		});
		btnTabela.setBounds(680, 86, 94, 62);
		contentPane.add(btnTabela);

		JPanel painelTotalPago = new JPanel();
		painelTotalPago.setBounds(10, 509, 660, 22);
		contentPane.add(painelTotalPago);
		painelTotalPago.setLayout(null);

		JLabel lblNewLabel = new JLabel(
				"Valor total a ser pago para o barber:");
		lblNewLabel.setBounds(6, 4, 235, 14);
		painelTotalPago.add(lblNewLabel);

		JLabel lblvalorTotalDoBarber = new JLabel("R$ "
				+ String.valueOf(decimal.format(total2)));
		lblvalorTotalDoBarber.setVerticalAlignment(SwingConstants.BOTTOM);
		lblvalorTotalDoBarber.setHorizontalAlignment(SwingConstants.RIGHT);
		lblvalorTotalDoBarber.setBounds(476, 4, 174, 14);
		painelTotalPago.add(lblvalorTotalDoBarber);
	}

	private CategoryDataset createDatasetRelatorio() throws SQLException,
			ReportException, NullPointerException, ParseException {

		Report report = new Report();
		ResultSet rs = null;

		if (SearchReport.typeBusca != 0) {
			if (SearchReport.typeBusca == 1) {
				report.setBarber(SearchReport.barber);

				rs = ReportController.getInstance()
						.searchByBarber(report);
			}
			if (SearchReport.typeBusca == 2) {
				report.setBarber(SearchReport.barber);
				report.setServiceType(SearchReport.job);

				rs = ReportController.getInstance()
						.searchByBarberEJob(report);
			}
			if (SearchReport.typeBusca == 3) {
				report.setBarber(SearchReport.barber);
				report.setEndDate(SearchReport.dataFinal);
				report.setInitialDate(SearchReport.dataInicial);

				rs = ReportController.getInstance().searchByDataEBarber(
						report);
			}
			if (SearchReport.typeBusca == 4) {
				report.setBarber(SearchReport.barber);
				report.setServiceType(SearchReport.job);
				report.setEndDate(SearchReport.dataFinal);
				report.setInitialDate(SearchReport.dataInicial);

				rs = ReportController.getInstance()
						.searchByDataBarberEJob(report);
			}
			if (SearchReport.typeBusca == 5) {
				report.setServiceType(SearchReport.job);

				rs = ReportController.getInstance().searchByJob(report);
			}
			if (SearchReport.typeBusca == 6) {
				report.setServiceType(SearchReport.job);
				report.setEndDate(SearchReport.dataFinal);
				report.setInitialDate(SearchReport.dataInicial);

				rs = ReportController.getInstance().searchByDataEJob(
						report);
			}
			if (SearchReport.typeBusca == 7) {
				report.setEndDate(SearchReport.dataFinal);
				report.setInitialDate(SearchReport.dataInicial);

				rs = ReportController.getInstance().searchByData(report);
			}
		}

		List<String> dias = new ArrayList<String>();

		while (rs.next())
			if (dias.contains(rs.getString("data")) == false)
				dias.add(rs.getString("data"));

		double totalPorDia = 0;

		DefaultCategoryDataset dataset = new DefaultCategoryDataset();

		for (int i = 0; i < dias.size(); i++) {
			rs.beforeFirst();

			while (rs.next())
				if (rs.getString("data").equals(dias.get(i)))
					totalPorDia += Double.parseDouble(rs.getString("preco")
							.replace(",", "."));

			dataset.addValue(totalPorDia, dias.get(i), dias.get(0) + " - "
					+ dias.get(dias.size() - 1));
			totalPorDia = 0;
		}

		return dataset;
	}

	private static void mostrarMensagemDeErro(String informacao) {
		JOptionPane.showMessageDialog(null, informacao, "Atenção",
				JOptionPane.INFORMATION_MESSAGE);
	}
}
