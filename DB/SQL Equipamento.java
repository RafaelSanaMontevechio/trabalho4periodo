//EQUIPAMENTO
	
// Seleciona todos os equipamentos

		String sql = " SELECT equip.codigo_equipamento, equip.nome, equip.quantidade, forn.fantasia FROM EQUIPAMENTO equip, FORNECEDOR forn " 
				   + " WHERE equip.cnpj = forn.cnpj ORDER BY forn.fantasia";
	
// Select o equipamento pelo codigo informado
	
		String sql = " SELECT equip.codigo_equipamento, equip.nome, equip.quantidade, forn.fantasia FROM EQUIPAMENTO equip, FORNECEDOR forn " 
				   + " WHERE equip.codigo_equipamento = ? AND equip.cnpjfornecedor = forn.cnpj";
					   
// Select o equipamento cujo nome contenha parte da string informada
	
		String sql = " SELECT equip.codigo_equipamento, equip.nome, equip.quantidade, forn.fantasia FROM EQUIPAMENTO equip, FORNECEDOR forn"
				   + " WHERE equip.nome LIKE ? AND equip.cnpjfornecedor = forn.cnpj";


// Retorna um ArrayList de String com o nome de todos os equipamentos cadastrados para popular JcomboBox no cadastro de peças
	
		String sql = " SELECT nome FROM EQUIPAMENTO ";
