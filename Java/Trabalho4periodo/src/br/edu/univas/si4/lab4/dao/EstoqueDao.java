package br.edu.univas.si4.lab4.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.DateTimeException;

import javax.swing.JOptionPane;

import br.edu.univas.si4.lab4.to.EstoqueTO;

public class EstoqueDao {

	// private EstoqueTO estoqueTO;

	// Insere novos fornecedores
	public void insertHistoricoPeca(EstoqueTO estoqueTO) throws SQLException {

		String sql = "INSERT INTO historico_peca " + " (codigo, quantidade, data_saida) " + " VALUES (?, ?, ?)";
		Connection conn = null;

		try {
			conn = DBUtil.openConnection();
			PreparedStatement prepStat = conn.prepareStatement(sql);

			prepStat.setInt(1, estoqueTO.getCodigo());
			prepStat.setInt(2, estoqueTO.getQuantidade());
			prepStat.setDate(3, converteDataUtilToSql(estoqueTO.getData()));

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
	public java.sql.Date converteDataUtilToSql(java.util.Date date) {
		java.util.Date dataUtil = date;
		java.sql.Date dataSql = null;
		try {
			dataUtil = new java.sql.Date(dataUtil.getTime());
			dataSql = (java.sql.Date) dataUtil;
		} catch (DateTimeException e) {
			JOptionPane.showMessageDialog(null, "Erro ao converter data para sql: " + e.getMessage(), "Error",
					JOptionPane.ERROR_MESSAGE);
		}
		return dataSql;
	}

}
