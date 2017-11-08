//Insere novas peças		
	public void insertNewPeca(PecaTO pecaTO) throws SQLException {

		String sql = "INSERT INTO PECA " + " (codigo_peca, nome, quantidade, tipo, equipamento, fornecedor) "
				+ " VALUES (?, ?, ?, ?, ?, ?)";

		Connection conn = DBUtil.openConnection();

		PreparedStatement prepStat = conn.prepareStatement(sql);

		prepStat.setInt(1, pecaTO.getCodigo());
		prepStat.setString(2, pecaTO.getNome().toUpperCase());
		prepStat.setInt(3, pecaTO.getQuantidade());
		prepStat.setString(4, pecaTO.getTipo().toUpperCase());
		prepStat.setString(5, pecaTO.getEquipamento().toUpperCase());
		prepStat.setString(6, pecaTO.getFornecedor().toUpperCase());

		prepStat.execute();
		conn.close();
	}

// Seleciona todas peças cadastrados
	public ArrayList<PecaTO> listAllPecas() throws SQLException {
		ArrayList<PecaTO> pecas = new ArrayList<PecaTO>();
		Connection conn = DBUtil.openConnection();

		String sql = " SELECT codigo_peca, nome, quantidade, tipo, equipamento, fornecedor FROM PECA ORDER BY FORNECEDOR ";

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
	
	// Select a peça cujo nome contenha parte do valor informado
	public ArrayList<PecaTO> selectPecabyName(String name) throws SQLException {
		ArrayList<PecaTO> pecas = new ArrayList<PecaTO>();

		Connection conn = DBUtil.openConnection();

		String sql = " SELECT codigo_peca, nome, quantidade, tipo, equipamento, fornecedor FROM PECA WHERE nome LIKE ? ";

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
	
// Retira peça do estoque
	public boolean TakeOffPeca(PecaTO pecaTO) throws SQLException {
		Connection conn = null;
		if (compareQtd(pecaTO)) {
			int qtd = 0;
			String sql = "UPDATE peca SET quantidade = ? WHERE codigo_peca = ? ";
			qtd = (selectQtd(pecaTO.getCodigo()) - pecaTO.getQuantidade());

			try {
				conn = DBUtil.openConnection();
				PreparedStatement prep = conn.prepareStatement(sql);
				prep.setInt(1, qtd);
				prep.setInt(2, pecaTO.getCodigo());
				prep.execute();
				return true;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			conn.close();
		}
		return false;
	}
	
// Deleta peça
	public void deletePeca(int codigo) throws SQLException {
		String sql = "DELETE FROM peca WHERE codigo_peca = ?";
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

	
