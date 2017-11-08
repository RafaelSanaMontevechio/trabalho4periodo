//EQUIPAMENTO
	
// Seleciona todos os equipamentos
	public ArrayList<EquipamentoTO> listAllEquipamentos() throws SQLException {
		ArrayList<EquipamentoTO> equipamentos = new ArrayList<EquipamentoTO>();

		Connection conn = DBUtil.openConnection();

		String sql = " SELECT equip.codigo_equipamento, equip.nome, equip.quantidade, forn.fantasia FROM EQUIPAMENTO equip, FORNECEDOR forn " 
				   + " WHERE equip.cnpj = forn.cnpj ORDER BY forn.fantasia";

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
	
// Select o equipamento pelo codigo informado
	public ArrayList<EquipamentoTO> selectEquipamentobyCodigo(String str) throws SQLException {
		ArrayList<EquipamentoTO> equipamentos = new ArrayList<EquipamentoTO>();

		Connection conn = DBUtil.openConnection();

		int codigo;
		try {
			codigo = Integer.parseInt(str);
			String sql = " SELECT equip.codigo_equipamento, equip.nome, equip.quantidade, forn.fantasia FROM EQUIPAMENTO equip, FORNECEDOR forn " 
					   + " WHERE equip.codigo_equipamento = ? AND equip.cnpjfornecedor = forn.cnpj";

			PreparedStatement prep = conn.prepareStatement(sql);
			prep.setInt(1, codigo);
			ResultSet rs = prep.executeQuery();

			while (rs.next()) {
				equipamentoTO = new EquipamentoTO();
				equipamentoTO.setCodigo(rs.getInt(1));
				equipamentoTO.setNome(rs.getString(2));
				equipamentoTO.setQuantidade(rs.getInt(3));
				equipamentoTO.setFornecedor(rs.getString(4));
				equipamentos.add(equipamentoTO);
			}
			conn.close();
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Código incorreto!\n " + e.getMessage(), "Error",
					JOptionPane.ERROR_MESSAGE);
		}
		return equipamentos;
	}
	
// Select o equipamento cujo nome contenha parte da string informada
	public ArrayList<EquipamentoTO> selectEquipamentobyName(String name) throws SQLException {
		ArrayList<EquipamentoTO> equipamentos = new ArrayList<EquipamentoTO>();

		Connection conn = DBUtil.openConnection();

		String sql = " SELECT equip.codigo_equipamento, equip.nome, equip.quantidade, forn.fantasia FROM EQUIPAMENTO equip, FORNECEDOR forn"
				   + " WHERE equip.nome LIKE ? AND equip.cnpjfornecedor = forn.cnpj";

		PreparedStatement prep = conn.prepareStatement(sql);
		prep.setString(1, '%' + name.toUpperCase() + '%');
		ResultSet rs = prep.executeQuery();

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