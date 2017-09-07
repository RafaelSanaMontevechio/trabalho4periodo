package br.edu.univas.si4.lab4.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;

public class InternalFramePecas extends Comum {

	private static final long serialVersionUID = -6930334799958851725L;

	private JPanel panelCadastrados;
	private JPanel panelButtons;
	private JTable table;

	private JButton btNovo;
	private JButton btDeletar;
	private JButton btListar;
	
	public InternalFramePecas() {
		super("Cadastros e consulta de peças");
		addComponents();
	}
	
	public void addComponents() {

		new BorderLayout();
		add(criaPanelCadastrados(), BorderLayout.CENTER);
		add(criaPanelButtons(), BorderLayout.SOUTH);

	}

	public JPanel criaPanelCadastrados() {

		panelCadastrados = new JPanel();
		panelCadastrados.setLayout(new BorderLayout());
		panelCadastrados.setBorder(BorderFactory.createTitledBorder("Peças no estoque"));
		panelCadastrados.add(criaTable());

		return panelCadastrados;
	}

	public JScrollPane criaTable() {

		String[] columnNames = { "Codigo", "Nome   ", "Quantidade", "Tipo","Equipamento", "Fornecedor  " };
		Object[][] tableData = { { "001 ", "Teste 1", "        10", "Unidade", "Equipamento 1", "Fornecedor 1" } };

		table = new JTable(tableData, columnNames);

		JScrollPane tableScroll = new JScrollPane(table);
		tableScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		return tableScroll;
	}

	public JPanel criaPanelButtons() {

		panelButtons = new JPanel();
		panelButtons.setBorder(BorderFactory.createTitledBorder(""));

		btNovo = new JButton("Novo");
		btNovo.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent evt) {
				FrameCadastroPeca cadPeca = new FrameCadastroPeca();
				cadPeca.setVisible(true);
			}
		});
		
		
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
