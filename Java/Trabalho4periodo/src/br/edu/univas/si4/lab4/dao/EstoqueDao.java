package br.edu.univas.si4.lab4.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

import javax.swing.JOptionPane;

import br.edu.univas.si4.lab4.to.EstoqueTO;

public class EstoqueDao {

	private EstoqueTO estoqueTO;

	// Adiciona peça retirada
	public void addPeca(EstoqueTO estoqueTO) throws SQLException, ParseException {
		String sql = "INSERT INTO peca_out " + " VALUES (?, ?, ?)";

		Connection conn = null;
		try {
			conn = DBUtil.openConnection();
			PreparedStatement prepStat = conn.prepareStatement(sql);
			prepStat.setInt(1, estoqueTO.getCodigo());
			prepStat.setInt(2, estoqueTO.getQuantidade());
			prepStat.setDate(3, converteDataUtilToSql(estoqueTO.getData()));
			prepStat.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (conn != null) {
			conn.close();
		}
	}

	// Busca a quantiade no banco referente ao codigo informado
	private int selectQtd(int cod) {
		int qtd = 0;

		String sql = "SELECT quantidade FROM peca_out WHERE codigo = ? ";

		Connection conn = null;
		try {
			conn = DBUtil.openConnection();
			PreparedStatement prep = conn.prepareStatement(sql);
			prep.setInt(1, cod);
			ResultSet rs = prep.executeQuery();

			while (rs.next()) {
				qtd = (rs.getInt(1));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return qtd;
	}

	// Alter a quantidade da peça ja cadastrada
	public void updateQtdPeca(EstoqueTO estoqueTO) throws SQLException {
		String sql = "UPDATE peca_out SET quantidade = ? WHERE codigo = ? ";
		int qtd = estoqueTO.getQuantidade() + (selectQtd(estoqueTO.getCodigo()));
		Connection conn = null;
		try {
			conn = DBUtil.openConnection();
			PreparedStatement prep = conn.prepareStatement(sql);
			prep.setInt(1, qtd);
			prep.setInt(2, estoqueTO.getCodigo());
			prep.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		conn.close();
	}

	// Verifica registro
	public boolean isRegistro(int codigo) throws SQLException {
		boolean result = false;
		estoqueTO = new EstoqueTO();
		Connection conn = DBUtil.openConnection();

		String sql = " SELECT * FROM peca_out WHERE codigo = ? ";

		PreparedStatement prep = conn.prepareStatement(sql);
		prep.setInt(1, codigo);
		ResultSet rs = prep.executeQuery();

		while (rs.next()) {
			estoqueTO.setCodigo(rs.getInt(1));
			if (estoqueTO.getCodigo() == codigo) {
				result = true;
			} else {
				result = false;
			}
		}
		conn.close();
		return result;
	}

	// Converte a data de java.util.Date para java.sql.Date
	public java.sql.Date converteDataUtilToSql(java.util.Date date) {
		java.util.Date dataUtil = date;
		java.sql.Date dataSql = null;
		try {
			dataUtil = new java.sql.Date(dataUtil.getTime());
			dataSql = (java.sql.Date) dataUtil;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao converter data para java.sql.Date: " + e.getMessage());
		}
		return dataSql;
	}
}
