package br.edu.univas.si4.lab4.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import br.edu.univas.si4.lab4.to.PecaTO;

public class PecaDao {

	private PecaTO peca;

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

	// Seleciona todos os equipamentos
	public ArrayList<PecaTO> listAllPecas() throws SQLException {
		ArrayList<PecaTO> pecas = new ArrayList<PecaTO>();

		Connection conn = DBUtil.openConnection();

		String sql = " SELECT * FROM PECA ";

		Statement stm = conn.createStatement();
		ResultSet rs = stm.executeQuery(sql);

		while (rs.next()) {
			peca = new PecaTO();
			peca.setCodigo(rs.getInt(1));
			peca.setNome(rs.getString(2));
			peca.setQuantidade(rs.getInt(3));
			peca.setTipo(rs.getString(4));
			peca.setEquipamento(rs.getString(5));
			peca.setFornecedor(rs.getString(6));
			pecas.add(peca);

		}
		conn.close();
		return pecas;
	}
}
