package br.edu.univas.si4.lab4.view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;

public class Comum extends JInternalFrame {

	private JTable table;
	private JScrollPane tableScroll;
	private JPanel contentPane;
	private JPanel panelCadastrados;
	private String titleContentPane;
	private JPanel panelButtons = null;
	private JButton btNovo;
	private JButton btDeletar;
	private JButton btListar;
	private String[] columnNames;
	private Object[][] tableData;

	private static final long serialVersionUID = 7859729951608406473L;

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
		contentPane.add(criaPanelButtons(), BorderLayout.SOUTH);
		setContentPane(contentPane);
	}
	
	//Cria a tabela onde serão exibido os dados 
	private JScrollPane criaTable() {

		table = new JTable(tableData, columnNames);
		tableScroll = new JScrollPane(table);
		tableScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		return tableScroll;
	}

	//Cria um panel onde será colocada a tabela com os dados 
	private JPanel criaPanelCadastrados() {

		panelCadastrados = new JPanel();
		panelCadastrados.setLayout(new BorderLayout());
		panelCadastrados.setBorder(BorderFactory.createTitledBorder(titleContentPane));
		panelCadastrados.add(criaTable());

		return panelCadastrados;
	}

	//Cria um panel que conterá os botões para manipular os dados na area de pesquisa
	private JPanel criaPanelButtons() {

		panelButtons = new JPanel();
		panelButtons.setBorder(BorderFactory.createTitledBorder(""));

		btNovo = new JButton("Novo");
		btDeletar = new JButton("Deletar");
		btListar = new JButton("Listar");

		panelButtons.add(btNovo);
		panelButtons.add(btDeletar);
		panelButtons.add(btListar);
		
		return panelButtons;
	}
	
	public void setPosicao() {
		Dimension dimension = this.getDesktopPane().getSize();
		this.setLocation((dimension.width - this.getSize().width) / 2, (dimension.height - this.getSize().height) / 2);
	}
}