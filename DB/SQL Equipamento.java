//EQUIPAMENTO
	
// Seleciona todos os equipamentos
	public ArrayList<EquipamentoTO> listAllEquipamentos() throws SQLException {
		ArrayList<EquipamentoTO> equipamentos = new ArrayList<EquipamentoTO>();

		Connection conn = DBUtil.openConnection();

		String sql = " SELECT equip.codigo_equipamento, equip.nome, equip.quantidade, f.fantasia FROM EQUIPAMENTO equip, FORNECEDOR forn " 
		+ " WHERE equip.cnpj = forn.cnpj ORDER BY FORNECEDOR ";

		Statement stm = conn.createStatement();
		ResultSet rs = stm.executeQuery(sql);

		while (rs.next()) {
			equipamentoTO = new EquipamentoTO();
			equipamentoTO.setCodigo(rs.getInt(1));
			equipamentoTO.setNome(rs.getString(2));
			equipamentoTO.setQuantidade(rs.getInt(3));
			equipamentoTO.setFornecedor(rs.getString(4));
			equipamentos.add(equipamentoTO);
		}
		conn.close();
		return equipamentos;
	}

// Retorna um ArrayList de String com o nome de todos os equipamentos cadastrados para popular JcomboBox no cadastro de peças
	public ArrayList<String> selectNomeEquipamento() throws SQLException {
		ArrayList<String> nomeEquipamento = new ArrayList<String>();

		Connection conn = DBUtil.openConnection();

		String sql = " SELECT nome FROM EQUIPAMENTO ";

		Statement stm = conn.createStatement();
		ResultSet rs = stm.executeQuery(sql);

		while (rs.next()) {
			nomeEquipamento.add(rs.getString(1));
		}
		conn.close();
		return nomeEquipamento;
	}