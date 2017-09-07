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

public class InternalFrameFornecedor extends Comum {

	private static final long serialVersionUID = 7818698877376614841L;

	private JPanel panelCadastrados = null;
	private JPanel panelButtons = null;
	private JTable table;

	private JButton btNovo;
	private JButton btDeletar;
	private JButton btListar;

	public InternalFrameFornecedor() {
		super("Cadastro e consulta de Fornecedores");
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
		panelCadastrados.setBorder(BorderFactory.createTitledBorder("Fornecedores Cadastrados"));
		panelCadastrados.add(criaTable());

		return panelCadastrados;
	}

	public JScrollPane criaTable() {

		String[] columnNames = { "Nome/Razão", "CNPJ", "Nome Fantasia" };
		Object[][] tableData = { { "Rafael", "11111111111111", "Masculino" }, { "Maria", "22222222222222", "Feminino" },
				{ "José", "33333333333333", "Masculino" } };

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
				FrameCadastroFornecedor cadFornecedor = new FrameCadastroFornecedor();
				cadFornecedor.setVisible(true);
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
