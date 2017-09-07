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

public class InternalFrameEquipamentos extends Comum {

	private static final long serialVersionUID = 4727354562815126822L;

	private JPanel panelCadastro;
	private JPanel panelButtons;
	private JTable table;
	private JButton jbNovo;
	private JButton jbAlterar;
	private JButton jbDeletar;

	public InternalFrameEquipamentos() {
		super("Cadastro e consulta de Equipamentos");
		addComponents();
	}

	private void addComponents() {
		add(panelCadastrados());
		add(panelButtons(), BorderLayout.SOUTH);
	}

	private JPanel panelCadastrados() {
		panelCadastro = new JPanel();
		panelCadastro.setLayout(new BorderLayout());
		panelCadastro.setBorder(BorderFactory.createTitledBorder("Equipamentos cadastrados"));
		panelCadastro.add(criaTable());

		return panelCadastro;
	}

	public JScrollPane criaTable() {

		String[] columnNames = { "Codigo", "Nome", "Quantidade", "Fornecedor" };
		Object[][] tableData = { { "Rafael", "11111111111111", "Masculino", "Fornecedor 1" },
				{ "Maria ", "22222222222222", "Feminino ", "Fornecedor 2" },
				{ "José  ", "33333333333333", "Masculino", "Fornecedor 3" } };

		table = new JTable(tableData, columnNames);

		JScrollPane tableScroll = new JScrollPane(table);

		tableScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		return tableScroll;
	}

	private JPanel panelButtons() {
		panelButtons = new JPanel();
		panelButtons.setBorder(BorderFactory.createTitledBorder(""));

		jbNovo = new JButton("Novo");
		jbNovo.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent evt) {
				new FrameCadastroEquipamentos().setVisible(true);
			}
		});
		panelButtons.add(jbNovo);

		jbAlterar = new JButton("Alterar");
		panelButtons.add(jbAlterar);

		jbDeletar = new JButton("Deletar");
		panelButtons.add(jbDeletar);

		return panelButtons;

	}
	
	public void setPosicao() {
		Dimension dimension = this.getDesktopPane().getSize();
		this.setLocation((dimension.width - this.getSize().width) / 2, (dimension.height - this.getSize().height) / 2);
	}
}
