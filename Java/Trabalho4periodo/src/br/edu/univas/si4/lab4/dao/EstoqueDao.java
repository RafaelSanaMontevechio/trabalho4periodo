package br.edu.univas.si4.lab4.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.DateTimeException;

import javax.swing.JOptionPane;

import br.edu.univas.si4.lab4.to.EstoqueTO;

public class EstoqueDao {

	// private EstoqueTO estoqueTO;

	// Insere dados de peças que sairam do estoque
	public void insertHistoricoPeca(EstoqueTO estoqueTO) throws SQLException {

		String sql = "INSERT INTO historico_peca " + " (codigo, quantidade, data_saida) " + " VALUES (?, ?, ?)";
		Connection conn = null;

		try {
			conn = DBUtil.openConnection();
			PreparedStatement prepStat = conn.prepareStatement(sql);

			prepStat.setInt(1, estoqueTO.getCodigo());
			prepStat.setInt(2, estoqueTO.getQuantidade());
			prepStat.setTimestamp(3, converteDataUtilToSql(estoqueTO.getData()));

			prepStat.execute();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao salvar historico\n" + e.getMessage(), "Error" + e.getMessage(),
					JOptionPane.ERROR_MESSAGE);
		}
		if (conn != null) {
			conn.close();
		}
	}

	// Converte a data de java.util.Date para java.sql.Date
	public java.sql.Timestamp converteDataUtilToSql(java.util.Date date) {
		java.sql.Timestamp dataSql = null;
		try {
			dataSql = new java.sql.Timestamp(date.getTime());
		} catch (DateTimeException e) {
			JOptionPane.showMessageDialog(null, "Erro ao converter data para sql: " + e.getMessage(), "Error",
					JOptionPane.ERROR_MESSAGE);
		}
		return dataSql;
	}
}
