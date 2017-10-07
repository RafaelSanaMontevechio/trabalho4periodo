package br.edu.univas.si4.lab4.view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;

import br.edu.univas.si4.lab4.view.commonButtonsPanels.ButtonsPanelRelatorio;

public abstract class Comum extends JInternalFrame {

	private static final long serialVersionUID = 7859729951608406473L;

	private JTable table;
	private JScrollPane tableScroll;
	private JPanel panelCadastrados;
	private String titleContentPane;
	private String[] columnNames;
	private Object[][] tableData;

	private JPanel contentPane;
	protected ButtonsPanelRelatorio buttonsPanelRelatorio;

	public Comum(String title, String titleContentPane, String[] columnNames, Object[][] tableData) {
		this.setTitle(title);
		this.titleContentPane = titleContentPane;
		this.columnNames = columnNames;
		this.tableData = tableData;

		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setLayout(new BorderLayout());
		setClosable(true);// Se o frame vai poder ser fechado pelo botão fechar
		setIconifiable(true);// Se o frame vai poder ser minimizado.
		setResizable(true);// Pemite editar o tamanho.
		setMaximizable(true);
		setBorder(null);
		addComponents();
	}

	private void addComponents() {
		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout());
		contentPane.add(criaPanelCadastrados(), BorderLayout.CENTER);
		contentPane.add(getButtonsPanelRelatorio(), BorderLayout.SOUTH);
	
		setContentPane(contentPane);

	}

	// Cria um panel onde será colocada a tabela com os dados
	private JPanel criaPanelCadastrados() {

		panelCadastrados = new JPanel();
		panelCadastrados.setLayout(new BorderLayout());
		panelCadastrados.setBorder(BorderFactory.createTitledBorder(titleContentPane));
		panelCadastrados.add(getTableScroll());

		return panelCadastrados;
	}

	/**
	 * Getters
	 */
	public JTable getTable() {
		if (table == null) {
			table = new JTable(tableData, columnNames);
		}
		return table;
	}

	public JScrollPane getTableScroll() {
		if (tableScroll == null) {
			tableScroll = new JScrollPane();
			tableScroll = new JScrollPane(getTable());
			tableScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		}
		return tableScroll;
	}

	public abstract ButtonsPanelRelatorio getButtonsPanelRelatorio();

	public void setPosicao() {
		Dimension dimension = this.getDesktopPane().getSize();
		this.setLocation((dimension.width - this.getSize().width) / 2, (dimension.height - this.getSize().height) / 2);
	}
}