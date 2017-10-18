package br.edu.univas.si4.lab4.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class EstoqueDao {

	public void addEquipment(String cod, String qtd, String date) throws SQLException, ParseException {

		String sql = "INSERT INTO EQUIPAMENTO_OUT " + " VALUES (?, ?, ?)";

		Connection conn = null;

		try {
			conn = DBUtil.openConnection();
			PreparedStatement prepStat = conn.prepareStatement(sql);

			prepStat.setInt(1, Integer.parseInt(cod));
			prepStat.setInt(2, Integer.parseInt(qtd));
			prepStat.setDate(3, (java.sql.Date) new SimpleDateFormat("dd/MM/yyyy").parse(date));
			prepStat.execute();

		} catch (Exception e) {
			e.printStackTrace();
		}
		if (conn != null) {
			conn.close();
		}
	}
}
