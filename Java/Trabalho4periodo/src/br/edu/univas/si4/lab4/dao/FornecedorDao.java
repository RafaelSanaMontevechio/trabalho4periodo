package br.edu.univas.si4.lab4.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.edu.univas.si4.lab4.to.FornecedorTO;

public class FornecedorDao {

	private FornecedorTO fornecedor;

	public FornecedorTO getFornecedor() {
		if (fornecedor == null) {
			fornecedor = new FornecedorTO();
		}
		return fornecedor;
	}

	public void insertNewFornecedor(FornecedorTO fornecedor) throws SQLException {

		String sql = "INSERT INTO FORNECEDOR " + " (cnpj, razao_social, nome_fantasia) " + " VALUES (?, ?, ?)";

		Connection conn = null;

		try {

			conn = DBUtil.openConnection();
			PreparedStatement prepStat = conn.prepareStatement(sql);

			prepStat.setLong(1, fornecedor.getCnpj());
			prepStat.setString(2, fornecedor.getNomeRazao());
			prepStat.setString(3, fornecedor.getFantasia());

			prepStat.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (conn != null) {
			conn.close();
		}
	}

	public List<FornecedorTO> listAllFornecedores() throws SQLException {
		ArrayList<FornecedorTO> fornecedores = new ArrayList<FornecedorTO>();

		Connection conn = DBUtil.openConnection();

		String sql = " SELECT * FROM FORNECEDOR ";

		Statement stm = conn.createStatement();
		ResultSet rs = stm.executeQuery(sql);

		while (rs.next()) {
			fornecedor = new FornecedorTO();
			fornecedor.setCnpj(rs.getLong(1));
			fornecedor.setNomeRazao(rs.getString(2));
			fornecedor.setFantasia(rs.getString(3));
			fornecedores.add(fornecedor);
		}
		return fornecedores;
	}
}
