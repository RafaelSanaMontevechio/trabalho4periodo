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

	// Insere novo equipamento
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

		String sql = " SELECT * FROM EQUIPAMENTO ORDER BY FORNECEDOR ";

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

	// Select o equipamento pelo codigo
	public ArrayList<EquipamentoTO> selectEquipamentobyCodigo(int codigo) throws SQLException {
		ArrayList<EquipamentoTO> equipamentos = new ArrayList<EquipamentoTO>();

		Connection conn = DBUtil.openConnection();

		String sql = " SELECT * FROM EQUIPAMENTO WHERE codigo_equipamento = ? ";

		PreparedStatement prep = conn.prepareStatement(sql);
		prep.setInt(1, codigo);
		ResultSet rs = prep.executeQuery();

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

	// Select o equipamento pelo nome
	public ArrayList<EquipamentoTO> selectEquipamentobyName(String name) throws SQLException {
		ArrayList<EquipamentoTO> equipamentos = new ArrayList<EquipamentoTO>();

		Connection conn = DBUtil.openConnection();

		String sql = " SELECT * FROM EQUIPAMENTO WHERE nome LIKE ? ";

		PreparedStatement prep = conn.prepareStatement(sql);
		prep.setString(1, '%'+name.toUpperCase()+'%');
		ResultSet rs = prep.executeQuery();

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

	// Select o equipamento pelo fornecedor
	public ArrayList<EquipamentoTO> selectEquipamentobyFornecedor(String fornecedor) throws SQLException {
		ArrayList<EquipamentoTO> equipamentos = new ArrayList<EquipamentoTO>();

		Connection conn = DBUtil.openConnection();

		String sql = " SELECT * FROM EQUIPAMENTO WHERE fornecedor LIKE ? ";

		PreparedStatement prep = conn.prepareStatement(sql);
		prep.setString(1, '%'+fornecedor.toUpperCase()+'%');
		ResultSet rs = prep.executeQuery();

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

	// Retorna um ArrayList de String com o nome de todos os equipamentos
	// cadastrados
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

	public void deleteEquipamento(int codigo) throws SQLException {
		String sql = "DELETE FROM EQUIPAMENTO WHERE codigo_equipamento = ?";
		Connection conn = null;
		try {
			conn = DBUtil.openConnection();
			PreparedStatement prep = conn.prepareStatement(sql);
			prep.setLong(1, codigo);
			prep.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		conn.close();
	}

}
