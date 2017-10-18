package br.edu.univas.si4.lab4.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;

import br.edu.univas.si4.lab4.to.EstoqueTO;

public class EstoqueDao {

	public void addEquipment(EstoqueTO estoqueTO) throws SQLException, ParseException {

		String sql = "INSERT INTO EQUIPAMENTO_OUT " + " VALUES (?, ?, ?)";

		Connection conn = null;

		SimpleDateFormat in = new SimpleDateFormat("dd/MM/yyyy");

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

	
	//Converte a data de java.util.Date para java.sql.Date
	public java.sql.Date converteDataUtilToSql(java.util.Date date) {
		java.util.Date dataUtil = date;
		java.sql.Date dataSql = null;
		try {
			dataUtil = new java.sql.Date(dataUtil.getTime());
			dataSql = (java.sql.Date) dataUtil;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao converte data para sql: " + e.getMessage());
		}
		return dataSql;
	}
}
