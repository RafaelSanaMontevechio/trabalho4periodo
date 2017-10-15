package br.edu.univas.si4.lab4.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.edu.univas.si4.lab4.to.PecaTO;

public class PecaDao {

	public void insertNewPeca(PecaTO pecaTO) throws SQLException {

		// String para fazer o insert de nova peca no banco
		String sql = "INSERT INTO PECA " + " (codigo_peca, nome, quantidade, tipo, equipamento, fornecedor) "
				+ " VALUES (?, ?, ?, ?, ?, ?)";

		// Abre a conexão com o banco
		Connection conn = DBUtil.openConnection();

		// Prepara a String
		PreparedStatement prepStat = conn.prepareStatement(sql);

		// Configura os parametros da sentença
		prepStat.setInt(1, pecaTO.getCodigo());
		prepStat.setString(2, pecaTO.getNome());
		prepStat.setInt(3, pecaTO.getQuantidade());
		prepStat.setString(4, pecaTO.getTipo());
		prepStat.setString(5, pecaTO.getEquipamento());
		prepStat.setString(6, pecaTO.getFornecedor());

		// Executa a sentença
		prepStat.execute();

		// Fecha a conexão
		conn.close();
	}
}
