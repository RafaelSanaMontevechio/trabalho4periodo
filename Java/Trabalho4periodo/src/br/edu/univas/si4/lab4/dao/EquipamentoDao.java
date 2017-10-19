package br.edu.univas.si4.lab4.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

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
		prepStat.setString(2, equipamento.getNome().toUpperCase());
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
	public ArrayList<EquipamentoTO> selectEquipamentobyCodigo(String str) throws SQLException {
		ArrayList<EquipamentoTO> equipamentos = new ArrayList<EquipamentoTO>();

		Connection conn = DBUtil.openConnection();

		int codigo;
		try {
			codigo = Integer.parseInt(str);
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
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Código incorreto!\n " + e.getMessage(), "Error",
					JOptionPane.ERROR_MESSAGE);
		}
		return equipamentos;
	}

	// Select o equipamento pelo nome
	public ArrayList<EquipamentoTO> selectEquipamentobyName(String name) throws SQLException {
		ArrayList<EquipamentoTO> equipamentos = new ArrayList<EquipamentoTO>();

		Connection conn = DBUtil.openConnection();

		String sql = " SELECT * FROM EQUIPAMENTO WHERE nome LIKE ? ";

		PreparedStatement prep = conn.prepareStatement(sql);
		prep.setString(1, '%' + name.toUpperCase() + '%');
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
		prep.setString(1, '%' + fornecedor.toUpperCase() + '%');
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

	// Busca a quantidade no banco referente ao codigo informado
	private int selectQtd(int cod) {
		int qtd = 0;
		String sql = "SELECT quantidade FROM equipamento WHERE codigo_equipamento = ? ";

		Connection conn = null;
		try {
			conn = DBUtil.openConnection();
			PreparedStatement prep = conn.prepareStatement(sql);
			prep.setInt(1, cod);
			ResultSet rs = prep.executeQuery();
			while (rs.next()) {
				qtd = (rs.getInt(1));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return qtd;
	}

	// Verifica se a quantidade cadastrada e maior ou igual a que será retirada
	private boolean compareQtd(EquipamentoTO equipamentoTO) {
		if (selectQtd(equipamentoTO.getCodigo()) >= equipamentoTO.getQuantidade()) {
			return true;
		} else {
			JOptionPane.showMessageDialog(null, "Quantidade em estoque insuficiente!", "Error",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}
	}

	// Retira peça do estoque
	public void TakeOffEquipamento(EquipamentoTO equipamentoTO) throws SQLException {
		Connection conn = null;
		if (compareQtd(equipamentoTO)) {
			int qtd = 0;
			String sql = "UPDATE equipamento SET quantidade = ? WHERE codigo_equipamento = ? ";
			qtd = (selectQtd(equipamentoTO.getCodigo()) - equipamentoTO.getQuantidade());

			try {
				conn = DBUtil.openConnection();
				PreparedStatement prep = conn.prepareStatement(sql);
				prep.setInt(1, qtd);
				prep.setInt(2, equipamentoTO.getCodigo());
				prep.execute();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			conn.close();
		}
	}

	// Atualiza a quantidade de peça no estoque já cadastrada
	public void updateQtdEquipamentoAdd(EquipamentoTO equipamentoTO) throws SQLException {
		Connection conn = null;
		int qtd = 0;
		String sql = "UPDATE equipamento SET quantidade = ? WHERE codigo_equipamento = ? ";
		qtd = (selectQtd(equipamentoTO.getCodigo()) + equipamentoTO.getQuantidade());

		try {
			conn = DBUtil.openConnection();
			PreparedStatement prep = conn.prepareStatement(sql);
			prep.setInt(1, qtd);
			prep.setInt(2, equipamentoTO.getCodigo());
			prep.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		conn.close();
	}

	// Deleta equipamento
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
