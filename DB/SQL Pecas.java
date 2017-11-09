//PECA

// Seleciona todas peças cadastrados
	public ArrayList<PecaTO> listAllPecas() throws SQLException {
		ArrayList<PecaTO> pecas = new ArrayList<PecaTO>();
		Connection conn = DBUtil.openConnection();

		String sql = " SELECT pec.codigo_peca, pec.nome, pec.quantidade, pec.tipo, equip.nome, forn.fantasia "
		           + " FROM PECA pec, EQUIPAMENTO equip, FORNECEDOR forn ORDER BY forn.fantasia ";

		Statement stm = conn.createStatement();
		ResultSet rs = stm.executeQuery(sql);

		while (rs.next()) {
			peca = new PecaTO();
			peca.setCodigo(rs.getInt(1));
			peca.setNome(rs.getString(2));
			peca.setQuantidade(rs.getInt(3));
			peca.setTipo(rs.getString(4));
			peca.setEquipamento(rs.getString(5));
			peca.setFornecedor(rs.getString(6));
			pecas.add(peca);

		}
		conn.close();
		return pecas;
	}
	
// Select a peça pelo codigo
	public ArrayList<PecaTO> selectPecabyCodigo(String str) throws SQLException {
		ArrayList<PecaTO> pecas = new ArrayList<PecaTO>();

		Connection conn = DBUtil.openConnection();
		
		try {
			int codigo = Integer.parseInt(str);
			String sql = " SELECT pec.codigo_peca, pec.nome, pec.quantidade, pec.tipo, equip.nome, forn.fantasia "
					   + " FROM PECA pec, EQUIPAMENTO equip, FORNECEDOR forn "
					   + " WHERE pec.codigo_peca = ? ORDER BY forn.fantasia ";

			PreparedStatement prep = conn.prepareStatement(sql);
			prep.setInt(1, codigo);
			ResultSet rs = prep.executeQuery();

			while (rs.next()) {
				peca = new PecaTO();
				peca.setCodigo(rs.getInt(1));
				peca.setNome(rs.getString(2));
				peca.setQuantidade(rs.getInt(3));
				peca.setTipo(rs.getString(4));
				peca.setEquipamento(rs.getString(5));
				peca.setFornecedor(rs.getString(6));
				pecas.add(peca);

			}
			conn.close();
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Código incorreto!\n " + e.getMessage(), "Error",
					JOptionPane.ERROR_MESSAGE);
		}
		return pecas;
	}
	
	// Select a peça cujo nome contenha parte da string informada
	public ArrayList<PecaTO> selectPecabyName(String name) throws SQLException {
		ArrayList<PecaTO> pecas = new ArrayList<PecaTO>();

		Connection conn = DBUtil.openConnection();

		String sql = " SELECT pec.codigo_peca, pec.nome, pec.quantidade, pec.tipo, equip.nome, forn.fantasia "
				   + " FROM PECA pec, EQUIPAMENTO equip, FORNECEDOR forn "
				   + " WHERE pec.nome LIKE ? ORDER BY forn.fantasia ";

		PreparedStatement prep = conn.prepareStatement(sql);
		prep.setString(1, '%' + name.toUpperCase() + '%');
		ResultSet rs = prep.executeQuery();

		while (rs.next()) {
			peca = new PecaTO();
			peca.setCodigo(rs.getInt(1));
			peca.setNome(rs.getString(2));
			peca.setQuantidade(rs.getInt(3));
			peca.setTipo(rs.getString(4));
			peca.setEquipamento(rs.getString(5));
			peca.setFornecedor(rs.getString(6));
			pecas.add(peca);

		}
		conn.close();
		return pecas;
	}
	

	
