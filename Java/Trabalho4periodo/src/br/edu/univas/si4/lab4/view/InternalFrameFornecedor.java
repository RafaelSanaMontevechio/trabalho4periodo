package br.edu.univas.si4.lab4.view;

public class InternalFrameFornecedor extends Comum {

	private static final long serialVersionUID = 7818698877376614841L;

	private static String[] columnNames = { "Nome/Razão", "CNPJ", "Nome Fantasia" };
	private static Object[][] tableData = { { "Fornecedor 1 LTDA", "11111111111111", "Fornecedor 1" } };
	

	public InternalFrameFornecedor() {
		super("Consulta de fornecedores cadastrados", "Fornecedores Cadastrados", columnNames, tableData);
	}
}
