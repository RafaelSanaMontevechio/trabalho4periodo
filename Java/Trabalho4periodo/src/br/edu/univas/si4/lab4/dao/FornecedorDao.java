package br.edu.univas.si4.lab4.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.edu.univas.si4.lab4.model.Fornecedor;

public class FornecedorDao {

	private Fornecedor fornecedor;

	public Fornecedor getFornecedor() {
		if (fornecedor == null) {
			fornecedor = new Fornecedor();
		}
		return fornecedor;
	}

	public void insertNewFornecedor(Fornecedor fornecedor) throws SQLException {

		// String para fazer o insert de novo fornecedor no banco
		String sentence = "INSERT INTO FORNECEDOR " + " (cnpj, razao_social, nome_fantasia) " + " VALUES (?, ?, ?)";

		// Abre a conexão com o banco
		Connection conn = DBUtil.openConnection();

		// Prepara a String
		PreparedStatement prepStat = conn.prepareStatement(sentence);

		// Configura os parametros da sentença
		prepStat.setLong(1, fornecedor.getCnpj());
		prepStat.setString(2, fornecedor.getNomeRazao());
		prepStat.setString(3, fornecedor.getFantasia());

		// Executa a sentença
		prepStat.execute();

		// Fecha a conexão
		conn.close();
	}

	public Fornecedor selectAllFornecedor() throws SQLException{
		
		String sentence = "SELECT * FROM FORNCEDOR";
		
		Connection conn = DBUtil.openConnection();
		
		PreparedStatement prepStat = conn.prepareStatement(sentence);
		
		prepStat.execute();
		
		return fornecedor;

	}
}
