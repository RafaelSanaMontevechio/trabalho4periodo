package br.edu.univas.si4.lab4.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import br.edu.univas.si4.lab4.to.EquipamentoTO;

public class EquipamentoDao {

	private EquipamentoTO equipamento;

	public void insertNewEquipamento(EquipamentoTO equipamento) throws SQLException {

		// String para fazer o insert de novo fornecedor no banco
		String sentence = "INSERT INTO EQUIPAMENTO " + " (codigo_equipamento, nome, quantidade, cnpj_fornecedor) "
				+ " VALUES (?, ?, ?, ?)";

		// Abre a conexão com o banco
		Connection conn = DBUtil.openConnection();

		// Prepara a String
		PreparedStatement prepStat = conn.prepareStatement(sentence);

		// Configura os parametros da sentença
		prepStat.setInt(1, equipamento.getCodigo());
		prepStat.setString(2, equipamento.getNome());
		prepStat.setInt(3, equipamento.getQuantidade());
		prepStat.setString(4, equipamento.getFornecedor());

		// Executa a sentença
		prepStat.execute();

		// Fecha a conexão
		conn.close();
	}

	// Seleciona todos os fornecedores
	public ArrayList<EquipamentoTO> listAllEquipamentos() throws SQLException {
		ArrayList<EquipamentoTO> equipamentos = new ArrayList<EquipamentoTO>();

		Connection conn = DBUtil.openConnection();

		String sql = " SELECT * FROM EQUIPAMENTO ";

		Statement stm = conn.createStatement();
		ResultSet rs = stm.executeQuery(sql);

		while (rs.next()) {
			equipamento.setCodigo(rs.getInt(1));
			equipamento.setNome(rs.getString(2));
			equipamento.setQuantidade(rs.getInt(3));
			equipamento.setFornecedor(rs.getString(4));
			equipamentos.add(equipamento);

		}
		conn.close();
		return equipamentos;
	}
}
