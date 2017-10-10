package br.edu.univas.si4.lab4.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.edu.univas.si4.lab4.model.Fornecedor;

public class FornecedorDao {

	private Fornecedor fornecedor;

	public Fornecedor getFornecedor() {
		if (fornecedor == null) {
			fornecedor = new Fornecedor();
		}
		return fornecedor;
	}

	public void insertNewFornecedor(Fornecedor fornecedor) throws SQLException {

		String sentence = "INSERT INTO FORNECEDOR " + " (cnpj, razao_social, nome_fantasia) " + " VALUES (?, ?, ?)";

		Connection conn = null;

		try {

			conn = DBUtil.openConnection();
			PreparedStatement prepStat = conn.prepareStatement(sentence);

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

	public List<Fornecedor> listAllFornecedores() throws SQLException {
		ArrayList<Fornecedor> fornecedores = new ArrayList<Fornecedor>();

		Connection conn = DBUtil.openConnection();

		String sentence = " SELECT * FROM FORNECEDOR ";

		Statement stm = conn.createStatement();
		ResultSet rs = stm.executeQuery(sentence);

		while (rs.next()) {
			fornecedor = new Fornecedor();
			fornecedor.setCnpj(rs.getLong(1));
			fornecedor.setNomeRazao(rs.getString(2));
			fornecedor.setFantasia(rs.getString(3));
			fornecedores.add(fornecedor);
		}
		return fornecedores;
	}
}
