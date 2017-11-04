// Insere novo equipamento
	public void insertNewEquipamento(EquipamentoTO equipamento) throws SQLException {

		String sql = " INSERT INTO EQUIPAMENTO " + " (codigo_equipamento, nome, quantidade, fornecedor) "
				+ " VALUES (?, ?, ?, ?)";

		Connection conn = DBUtil.openConnection();

		PreparedStatement prepStat = conn.prepareStatement(sql);

		prepStat.setInt(1, equipamento.getCodigo());
		prepStat.setString(2, equipamento.getNome().toUpperCase());
		prepStat.setInt(3, equipamento.getQuantidade());
		prepStat.setString(4, equipamento.getFornecedor());

		prepStat.execute();

		conn.close();
	}
	
// Seleciona todos os equipamentos
	public ArrayList<EquipamentoTO> listAllEquipamentos() throws SQLException {
		ArrayList<EquipamentoTO> equipamentos = new ArrayList<EquipamentoTO>();

		Connection conn = DBUtil.openConnection();

		String sql = " SELECT * FROM EQUIPAMENTO ORDER BY FORNECEDOR ";

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
	
// Atualiza a quantidade de peça no estoque já cadastrada
	public void updateQtdEquipamento(EquipamentoTO equipamentoTO) throws SQLException {
		Connection conn = null;
		int qtd = 0;
		String sql = " UPDATE equipamento SET quantidade = ? WHERE codigo_equipamento = ? ";
		qtd = (selectQtd(equipamentoTO.getCodigo()) + equipamentoTO.getQuantidade());

		try {
			conn = DBUtil.openConnection();
			PreparedStatement prep = conn.prepareStatement(sql);
			prep.setInt(1, qtd);
			prep.setInt(2, equipamentoTO.getCodigo());
			prep.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		conn.close();
	}

// Deleta equipamento
	public void deleteEquipamento(int codigo) throws SQLException {
		String sql = " DELETE FROM EQUIPAMENTO WHERE codigo_equipamento = ? ";
		Connection conn = null;
		try {
			conn = DBUtil.openConnection();
			PreparedStatement prep = conn.prepareStatement(sql);
			prep.setLong(1, codigo);
			prep.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		conn.close();
	}
	