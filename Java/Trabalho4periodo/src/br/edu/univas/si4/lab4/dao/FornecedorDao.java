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

	// Insere novos fornecedores
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

	// Deleta fornecedores
	public void deleteFornecedor(Long cnpj) throws SQLException {
		String sql = "DELETE FROM FORNECEDOR WHERE CNPJ = ?";
		Connection conn = null;
		try {
			conn = DBUtil.openConnection();
			PreparedStatement prep = conn.prepareStatement(sql);
			prep.setLong(1, cnpj);
			prep.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		conn.close();
	}

	// Seleciona todos os fornecedores
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
		conn.close();
		return fornecedores;
	}
	
	//Seleciona por Cnpj
	public List<FornecedorTO> listByCnpj(Long cnpj) throws SQLException {
		ArrayList<FornecedorTO> fornecedores = new ArrayList<FornecedorTO>();

		Connection conn = DBUtil.openConnection();

		String sql = " SELECT * FROM FORNECEDOR WHERE CNPJ = ? ";
		
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
		return fornecedores;
	}
	
	//Seleciona o fornecedor cujo nome contenha valor informado
	public List<FornecedorTO> listByRazao(String str) throws SQLException {
		ArrayList<FornecedorTO> fornecedores = new ArrayList<FornecedorTO>();

		Connection conn = DBUtil.openConnection();

		String sql = " SELECT * FROM FORNECEDORES WHERE razao_social LIKE " + str;
		
		PreparedStatement prep = conn.prepareStatement(sql);
		prep.setString(1, str);
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
	
	
}
