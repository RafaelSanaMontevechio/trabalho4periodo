//PECA

// Seleciona todas peças cadastrados

		String sql = " SELECT pec.codigo_peca, pec.nome, pec.quantidade, pec.tipo, equip.nome, forn.fantasia "
		           + " FROM PECA pec, EQUIPAMENTO equip, FORNECEDOR forn ORDER BY forn.fantasia ";

	
// Select a peça pelo codigo
	
		String sql = " SELECT pec.codigo_peca, pec.nome, pec.quantidade, pec.tipo, equip.nome, forn.fantasia "
				   + " FROM PECA pec, EQUIPAMENTO equip, FORNECEDOR forn "
				   + " WHERE pec.codigo_peca = ? ORDER BY forn.fantasia ";

		
// Select a peça cujo nome contenha parte da string informada

		String sql = " SELECT pec.codigo_peca, pec.nome, pec.quantidade, pec.tipo, equip.nome, forn.fantasia "
				   + " FROM PECA pec, EQUIPAMENTO equip, FORNECEDOR forn "
				   + " WHERE pec.nome LIKE ? ORDER BY forn.fantasia ";

				   
	

	
