package br.edu.univas.si4.lab4.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

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
			prepStat.setString(2, fornecedor.getNomeRazao().toUpperCase());
			prepStat.setString(3, fornecedor.getFantasia().toUpperCase());

			prepStat.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (conn != null) {
			conn.close();
		}
	}

	// Deleta fornecedores
	public void deleteFornecedor(String str) throws SQLException {
		String sql = "DELETE FROM FORNECEDOR WHERE CNPJ = ?";
		Connection conn = null;
		Long cnpj;
		try {
			cnpj = Long.parseLong(str);
			conn = DBUtil.openConnection();
			PreparedStatement prep = conn.prepareStatement(sql);
			prep.setLong(1, cnpj);
			prep.execute();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro!", "Error",
					JOptionPane.ERROR_MESSAGE);
		}
		conn.close();
	}

	// Seleciona todos os fornecedores
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

	// Seleciona por Cnpj
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
			JOptionPane.showMessageDialog(null, "CNPJ Informado est� incorreto!\n " + e.getMessage(), "Error",
					JOptionPane.ERROR_MESSAGE);
		}
		return fornecedores;
	}

	// Seleciona o fornecedor cujo nome contenha valor informado
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

	// Select nome fantasia
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
