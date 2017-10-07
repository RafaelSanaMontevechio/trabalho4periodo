package br.edu.univas.si4.lab4.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FornecedorDao {

	public void insertNewFornecedor(int cnpj, String razaoSocial, String nomeFantasia) throws SQLException {

		// String para fazer o insert de novo fornecedor no banco
		String sentence = "INSERT INTO FORNECEDOR " + " (cnpj, razao_social, nome_fantasia) " + " VALUES (?, ?, ?)";

		// Abre a conexão com o banco
		Connection conn = DBUtil.openConnection();

		// Prepara a String
		PreparedStatement prepStat = conn.prepareStatement(sentence);

		// Configura os parametros da sentença
		prepStat.setInt(1, cnpj);
		prepStat.setString(2, razaoSocial);
		prepStat.setString(3, nomeFantasia);

		// Executa a sentença
		prepStat.execute();

		// Fecha a conexão
		conn.close();
	}
}
