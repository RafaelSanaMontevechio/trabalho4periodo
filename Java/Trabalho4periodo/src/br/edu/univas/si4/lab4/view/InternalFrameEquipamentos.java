package br.edu.univas.si4.lab4.view;

public class InternalFrameEquipamentos extends Comum {

	private static final long serialVersionUID = 4727354562815126822L;

	private static String[] columnNames = { "Codigo", "Nome", "Quantidade", "Fornecedor" };
	private static Object[][] tableData = { { "Rafael", "11111111111111", "Masculino", "Fornecedor 1" } };

	public InternalFrameEquipamentos() {
		super("Consulta equipamentos em estoque", "Equipamentos cadastrados", columnNames, tableData);

	}
}
