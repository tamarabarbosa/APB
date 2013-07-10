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

import control.RelatorioController;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

import view.PesquisarRelatorio;

@SuppressWarnings("serial")
public class VisualizarRelatorios extends JFrame {

	/**
	 * Launch the application.
	 */
	private JPanel contentPane;

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
	 */
	public VisualizarRelatorios() throws SQLException {
		setTitle("Relat\u00F3rios");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 660, 540);
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

		relatorio.setBarbeiro(PesquisarRelatorio.barbeiro);
		relatorio.setTipoServico(PesquisarRelatorio.servico);
		relatorio.setDataFinal(PesquisarRelatorio.dataFinal);
		relatorio.setDataInicial(PesquisarRelatorio.dataInicial);

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

	}
}
