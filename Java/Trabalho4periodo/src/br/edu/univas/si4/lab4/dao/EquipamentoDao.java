package br.edu.univas.si4.lab4.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EquipamentoDao {

	public void insertNewEquipamento(int codigo, String nome, int quantidade, String fornecedor) throws SQLException {

		// String para fazer o insert de novo fornecedor no banco
		String sentence = "INSERT INTO EQUIPAMENTO " + " (codigo_equipamento, nome, quantidade, cnpj_fornecedor) "
				+ " VALUES (?, ?, ?, ?)";

		// Abre a conexão com o banco
		Connection conn = DBUtil.openConnection();

		// Prepara a String
		PreparedStatement prepStat = conn.prepareStatement(sentence);

		// Configura os parametros da sentença
		prepStat.setInt(1, codigo);
		prepStat.setString(2, nome);
		prepStat.setInt(3, quantidade);
		prepStat.setString(4, fornecedor);

		// Executa a sentença
		prepStat.execute();

		// Fecha a conexão
		conn.close();
	}

}
