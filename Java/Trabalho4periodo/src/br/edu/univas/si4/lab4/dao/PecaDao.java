package br.edu.univas.si4.lab4.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PecaDao {

	public void insertNewPeca(int codigo, String nome, int quantidade, String equipamento, String fornecedor)
			throws SQLException {

		// String para fazer o insert de novo fornecedor no banco
		String sentence = "INSERT INTO PECA "
				+ " (codigo_peca, nome, quantidade, codigo_equipamento, cnpj_fornecedor) "
				+ " VALUES (?, ?, ?, ?, ?)";

		// Abre a conexão com o banco
		Connection conn = DBUtil.openConnection();

		// Prepara a String
		PreparedStatement prepStat = conn.prepareStatement(sentence);

		// Configura os parametros da sentença
		prepStat.setInt(1, codigo);
		prepStat.setString(2, nome);
		prepStat.setInt(3, quantidade);
		prepStat.setString(4, equipamento);
		prepStat.setString(5, fornecedor);

		// Executa a sentença
		prepStat.execute();

		// Fecha a conexão
		conn.close();
	}

}
