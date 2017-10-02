package br.edu.univas.si4.lab4.view;

public class InternalFramePecas extends Comum {

	private static final long serialVersionUID = -6930334799958851725L;

	private static String[] columnNames = { "Codigo", "Nome   ", "Quantidade", "Tipo","Equipamento", "Fornecedor  " };
	private static Object[][] tableData = { { "001 ", "Teste 1", "        10", "Unidade", "Equipamento 1", "Fornecedor 1" } };

	
	public InternalFramePecas() {
		super("Consulta de peças em estoque", "Peças em estoque", columnNames,  tableData);
	}


	@Override
	public ButtonsPanelRelatorio getButtonsPanelRelatorio() {
		// TODO Auto-generated method stub
		return null;
	}
}
