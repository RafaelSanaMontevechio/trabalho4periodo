//--FORNECEDOR
	
// Seleciona todos os fornecedores cadastrados
	public List<FornecedorTO> listAllFornecedores() throws SQLException {
		ArrayList<FornecedorTO> fornecedores = new ArrayList<FornecedorTO>();

		Connection conn = DBUtil.openConnection();

		String sql = " SELECT cnpj, razao_social, nome_fantasia FROM FORNECEDOR ORDER BY razao_social ";

		Statement stm = conn.createStatement();
		ResultSet rs = stm.executeQuery(sql);

		while (rs.next()) {
			fornecedor = new FornecedorTO();
			fornecedor.setCnpj(rs.getLong(1));
			fornecedor.setNomeRazao(rs.getString(2));
			fornecedor.setFantasia(rs.getString(3));
			fornecedores.add(fornecedor);
		}
		conn.close();
		return fornecedores;
	}
	
// Seleciona o fornecedor por Cnpj
	public List<FornecedorTO> listByCnpj(String str) throws SQLException {
		ArrayList<FornecedorTO> fornecedores = new ArrayList<FornecedorTO>();
		Connection conn = DBUtil.openConnection();

		try {
			long cnpj = Long.parseLong(str);
			String sql = " SELECT cnpj, razao_social, nome_fantasia FROM FORNECEDOR WHERE CNPJ = ? ";
			PreparedStatement prep = conn.prepareStatement(sql);
			prep.setLong(1, cnpj);
			ResultSet rs = prep.executeQuery();

			while (rs.next()) {
				fornecedor = new FornecedorTO();
				fornecedor.setCnpj(rs.getLong(1));
				fornecedor.setNomeRazao(rs.getString(2));
				fornecedor.setFantasia(rs.getString(3));
				fornecedores.add(fornecedor);
			}
			conn.close();
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "CNPJ Informado está incorreto!\n " + e.getMessage(), "Error",
					JOptionPane.ERROR_MESSAGE);
		}
		return fornecedores;
	}

	
// Seleciona o fornecedor cujo razão social contenha parte do valor informado
	public List<FornecedorTO> listByRazao(String str) throws SQLException {
		ArrayList<FornecedorTO> fornecedores = new ArrayList<FornecedorTO>();

		Connection conn = DBUtil.openConnection();

		String sql = " SELECT cnpj, razao_social, nome_fantasia FROM FORNECEDOR WHERE razao_social LIKE ? ";

		PreparedStatement prep = conn.prepareStatement(sql);
		prep.setString(1, '%' + str.toUpperCase() + '%');
		ResultSet rs = prep.executeQuery();

		while (rs.next()) {
			fornecedor = new FornecedorTO();
			fornecedor.setCnpj(rs.getLong(1));
			fornecedor.setNomeRazao(rs.getString(2));
			fornecedor.setFantasia(rs.getString(3));
			fornecedores.add(fornecedor);
		}
		conn.close();
		return fornecedores;
	}
	
// Select nome fantasia dos fornecedores para popular um JcomboBox para ser usado no cadastro de equipamentos e peças
	public ArrayList<String> selectFantasia() throws SQLException {
		ArrayList<String> fantasia = new ArrayList<String>();

		Connection conn = DBUtil.openConnection();

		String sql = " SELECT nome_fantasia FROM FORNECEDOR ";

		Statement stm = conn.createStatement();
		ResultSet rs = stm.executeQuery(sql);

		while (rs.next()) {
			fantasia.add(rs.getString(1));
		}
		conn.close();
		return fantasia;
	}
}
