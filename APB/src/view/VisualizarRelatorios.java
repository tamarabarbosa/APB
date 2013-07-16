package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;

import model.Relatorio;

import control.BarbeiroController;
import control.RelatorioController;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import view.PesquisarRelatorio;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import exception.RelatorioException;

@SuppressWarnings("serial")
public class VisualizarRelatorios extends JFrame {

	/**
	 * Launch the application.
	 */
	private JPanel contentPane;
	private double total = 0;
	private String numero;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VisualizarRelatorios frame = new VisualizarRelatorios();
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
	 * @throws SQLException
	 * @throws RelatorioException
	 */
	public VisualizarRelatorios() throws SQLException, RelatorioException {
		setTitle("Relat\u00F3rios");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 660, 508);
		contentPane.add(scrollPane);

		final DefaultTableModel modelo = new DefaultTableModel(null,
				new String[] { "Barbeiro Responsável", "Tipo de Serviço",
						"Valor", "Data" }) {
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

		RelatorioController relatorioController = RelatorioController
				.getInstance();

		Relatorio relatorio = new Relatorio();
		if (PesquisarRelatorio.tipoBusca != 0) {
			relatorio.setBarbeiro(PesquisarRelatorio.barbeiro);
			relatorio.setTipoServico(PesquisarRelatorio.servico);
			relatorio.setDataFinal(PesquisarRelatorio.dataFinal);
			relatorio.setDataInicial(PesquisarRelatorio.dataInicial);
		}

		if (PesquisarRelatorio.tipoBusca != 0) {
			if (PesquisarRelatorio.tipoBusca == 1) {
				ResultSet rs = relatorioController
						.pesquisarPorBarbeiro(relatorio);

				while (rs.next()) {
					String[] dados = new String[4];
					dados[0] = rs.getString("barbeiro");
					dados[1] = rs.getString("nome");
					dados[2] = rs.getString("preco");
					dados[3] = rs.getString("data");
					numero = rs.getString("preco").replace(",", ".");
					double valor = Double.parseDouble(numero);
					total = total + valor;
					modelo.addRow(dados);
				}
			}
			if (PesquisarRelatorio.tipoBusca == 2) {
				ResultSet rs = relatorioController
						.pesquisarPorBarbeiroEServico(relatorio);

				while (rs.next()) {
					String[] dados = new String[4];
					dados[0] = rs.getString("barbeiro");
					dados[1] = rs.getString("nome");
					dados[2] = rs.getString("preco");
					dados[3] = rs.getString("data");
					numero = rs.getString("preco").replace(",", ".");
					double valor = Double.parseDouble(numero);
					total = total + valor;
					modelo.addRow(dados);
				}
			}
			if (PesquisarRelatorio.tipoBusca == 3) {
				ResultSet rs = relatorioController
						.pesquisarPorDataEBarbeiro(relatorio);

				while (rs.next()) {
					String[] dados = new String[4];
					dados[0] = rs.getString("barbeiro");
					dados[1] = rs.getString("nome");
					dados[2] = rs.getString("preco");
					dados[3] = rs.getString("data");
					numero = rs.getString("preco").replace(",", ".");
					double valor = Double.parseDouble(numero);
					total = total + valor;
					modelo.addRow(dados);
				}
			}
			if (PesquisarRelatorio.tipoBusca == 4) {
				ResultSet rs = relatorioController
						.pesquisarPorDataBarbeiroEServico(relatorio);

				while (rs.next()) {
					String[] dados = new String[4];
					dados[0] = rs.getString("barbeiro");
					dados[1] = rs.getString("nome");
					dados[2] = rs.getString("preco");
					dados[3] = rs.getString("data");
					numero = rs.getString("preco").replace(",", ".");
					double valor = Double.parseDouble(numero);
					total = total + valor;
					modelo.addRow(dados);
				}

			}
			if (PesquisarRelatorio.tipoBusca == 5) {
				ResultSet rs = relatorioController
						.pesquisarPorServico(relatorio);

				while (rs.next()) {
					String[] dados = new String[4];
					dados[0] = rs.getString("barbeiro");
					dados[1] = rs.getString("nome");
					dados[2] = rs.getString("preco");
					dados[3] = rs.getString("data");
					numero = rs.getString("preco").replace(",", ".");
					double valor = Double.parseDouble(numero);
					total = total + valor;
					modelo.addRow(dados);
				}
			}
			if (PesquisarRelatorio.tipoBusca == 6) {
				ResultSet rs = relatorioController
						.pesquisarPorDataEServico(relatorio);

				while (rs.next()) {
					String[] dados = new String[4];
					dados[0] = rs.getString("barbeiro");
					dados[1] = rs.getString("nome");
					dados[2] = rs.getString("preco");
					dados[3] = rs.getString("data");
					numero = rs.getString("preco").replace(",", ".");
					double valor = Double.parseDouble(numero);
					total = total + valor;
					modelo.addRow(dados);
				}
			}
			if (PesquisarRelatorio.tipoBusca == 7) {
				ResultSet rs = relatorioController.pesquisarPorData(relatorio);

				while (rs.next()) {
					String[] dados = new String[4];
					dados[0] = rs.getString("barbeiro");
					dados[1] = rs.getString("nome");
					dados[2] = rs.getString("preco");
					dados[3] = rs.getString("data");
					numero = rs.getString("preco").replace(",", ".");
					double valor = Double.parseDouble(numero);
					total = total + valor;
					modelo.addRow(dados);
				}
			}
		}

		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PesquisarRelatorio.tipoBusca = 0;
				PesquisarRelatorio frame = new PesquisarRelatorio();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnPesquisar.setBounds(680, 13, 94, 62);
		contentPane.add(btnPesquisar);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MenuPrincipal frame = new MenuPrincipal();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnVoltar.setBounds(680, 527, 94, 23);
		contentPane.add(btnVoltar);

		JPanel panel = new JPanel();
		panel.setBounds(10, 529, 660, 22);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblLucroTotal = new JLabel("Valor total pesquisado:");
		lblLucroTotal.setBounds(6, 4, 138, 14);
		panel.add(lblLucroTotal);

		DecimalFormat decimal = new DecimalFormat("##0.00");

		JLabel lblValor = new JLabel("R$ "
				+ String.valueOf(decimal.format(total)));
		lblValor.setHorizontalAlignment(SwingConstants.RIGHT);
		lblValor.setVerticalAlignment(SwingConstants.BOTTOM);
		lblValor.setBounds(476, 4, 174, 14);
		panel.add(lblValor);

		final JPanel painelGrafico = new JPanel();
		painelGrafico.setBounds(10, 10, 660, 540);
		contentPane.add(painelGrafico);
		painelGrafico.setVisible(true);

		JButton btnGrafico = new JButton("Gr\u00E1fico");
		btnGrafico.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					CategoryDataset cds;
					cds = createDataset();
					String titulo = "Gráfico de Teste";
					String eixoy = "Valores";
					String txt_legenda = "Ledenda:";
					boolean legenda = true;
					boolean tooltips = true;
					boolean urls = true;
					JFreeChart graf = ChartFactory.createBarChart3D(titulo,
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
					painelGrafico.setVisible(true);
				} catch (SQLException e) {
					e.printStackTrace();
				} catch (RelatorioException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		btnGrafico.setBounds(680, 86, 94, 54);
		contentPane.add(btnGrafico);
	}

	private CategoryDataset createDataset() throws SQLException,
			RelatorioException {

		// Criar relatorio
		Relatorio relatorio = new Relatorio();
		relatorio.setBarbeiro(PesquisarRelatorio.barbeiro);
		relatorio.setTipoServico(PesquisarRelatorio.servico);
		relatorio.setDataFinal(PesquisarRelatorio.dataFinal);
		relatorio.setDataInicial(PesquisarRelatorio.dataInicial);

		// Obter todos os barbeiros cadastrados
		BarbeiroController barbeiroController = BarbeiroController
				.getInstance();
		ResultSet rs = barbeiroController.pesquisar();

		// Preencher arraylist com todos os barbeiros cadastrados
		List<String> barbeiros = new ArrayList<String>();
		while (rs.next()) {
			barbeiros.add(rs.getString("nome"));
		}

		rs = RelatorioController.getInstance().pesquisarPorData(relatorio);

		double totalServico = 0;
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		// Obter o valor total de cada barbeiro
		for (int i = 0; i < barbeiros.size(); i++) {
			rs.beforeFirst();
			while (rs.next()) {
				if (rs.getString("barbeiro").equals(barbeiros.get(i))) {
					totalServico += Double.parseDouble(rs.getString("preco")
							.replace(",", "."));
				}
			}

			dataset.addValue(totalServico, barbeiros.get(i),
					PesquisarRelatorio.dataInicial + " - "
							+ PesquisarRelatorio.dataFinal);
			totalServico = 0;
		}

		return dataset;

	}
}
