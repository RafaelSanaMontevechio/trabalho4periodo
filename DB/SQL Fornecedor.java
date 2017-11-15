//--FORNECEDOR
	
// Seleciona todos os fornecedores cadastrados

	String sql = " SELECT cnpj, razao_social, nome_fantasia FROM FORNECEDOR ORDER BY nome_fantasia ";

// Seleciona o fornecedor por Cnpj

	String sql = " SELECT cnpj, razao_social, nome_fantasia FROM FORNECEDOR WHERE CNPJ = ? ";

// Seleciona o fornecedor cujo razão social contenha parte do valor informado

	String sql = " SELECT cnpj, razao_social, nome_fantasia FROM FORNECEDOR WHERE razao_social LIKE ? ";
	
// Select nome fantasia dos fornecedores para popular um JcomboBox para ser usado no cadastro de equipamentos e peças

	String sql = " SELECT nome_fantasia FROM FORNECEDOR ";

