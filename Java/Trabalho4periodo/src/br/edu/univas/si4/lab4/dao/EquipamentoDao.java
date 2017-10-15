package br.edu.univas.si4.lab4.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import br.edu.univas.si4.lab4.to.EquipamentoTO;

public class EquipamentoDao {

	private EquipamentoTO equipamentoTO;

	public EquipamentoDao() {
		equipamentoTO = new EquipamentoTO();
	}

	public void insertNewEquipamento(EquipamentoTO equipamento) throws SQLException {
		
		String sql = "INSERT INTO EQUIPAMENTO " + " (codigo_equipamento, nome, quantidade, fornecedor) "
				+ " VALUES (?, ?, ?, ?)";

		Connection conn = DBUtil.openConnection();

		PreparedStatement prepStat = conn.prepareStatement(sql);

		prepStat.setInt(1, equipamento.getCodigo());
		prepStat.setString(2, equipamento.getNome());
		prepStat.setInt(3, equipamento.getQuantidade());
		prepStat.setString(4, equipamento.getFornecedor());

		prepStat.execute();
		
		conn.close();
	}

	// Seleciona todos os equipamentos
	public ArrayList<EquipamentoTO> listAllEquipamentos() throws SQLException {
		ArrayList<EquipamentoTO> equipamentos = new ArrayList<EquipamentoTO>();

		Connection conn = DBUtil.openConnection();

		String sql = " SELECT * FROM EQUIPAMENTO ";

		Statement stm = conn.createStatement();
		ResultSet rs = stm.executeQuery(sql);

		while (rs.next()) {
			equipamentoTO = new EquipamentoTO();
			equipamentoTO.setCodigo(rs.getInt(1));
			equipamentoTO.setNome(rs.getString(2));
			equipamentoTO.setQuantidade(rs.getInt(3));
			equipamentoTO.setFornecedor(rs.getString(4));
			equipamentos.add(equipamentoTO);

		}
		conn.close();
		return equipamentos;
	}

	// Select nomes de equipamentos
	public ArrayList<String> selectNomeEquipamento() throws SQLException {
		ArrayList<String> nomeEquipamento = new ArrayList<String>();

		Connection conn = DBUtil.openConnection();

		String sql = " SELECT nome FROM EQUIPAMENTO ";

		Statement stm = conn.createStatement();
		ResultSet rs = stm.executeQuery(sql);

		while (rs.next()) {
			nomeEquipamento.add(rs.getString(1));
		}
		conn.close();
		return nomeEquipamento;
	}
}
