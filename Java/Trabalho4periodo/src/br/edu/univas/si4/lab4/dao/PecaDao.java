package br.edu.univas.si4.lab4.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import br.edu.univas.si4.lab4.to.PecaTO;

public class PecaDao {

	private PecaTO peca;

	public void insertNewPeca(PecaTO pecaTO) throws SQLException {

		// String para fazer o insert de nova peca no banco
		String sql = "INSERT INTO PECA " + " (codigo_peca, nome, quantidade, tipo, equipamento, fornecedor) "
				+ " VALUES (?, ?, ?, ?, ?, ?)";

		// Abre a conex�o com o banco
		Connection conn = DBUtil.openConnection();

		// Prepara a String
		PreparedStatement prepStat = conn.prepareStatement(sql);

		// Configura os parametros da senten�a
		prepStat.setInt(1, pecaTO.getCodigo());
		prepStat.setString(2, pecaTO.getNome().toUpperCase());
		prepStat.setInt(3, pecaTO.getQuantidade());
		prepStat.setString(4, pecaTO.getTipo().toUpperCase().toUpperCase());
		prepStat.setString(5, pecaTO.getEquipamento().toUpperCase());
		prepStat.setString(6, pecaTO.getFornecedor().toUpperCase());

		// Executa a senten�a
		prepStat.execute();

		// Fecha a conex�o
		conn.close();
	}

	// Seleciona todas pe�as cadastrados
	public ArrayList<PecaTO> listAllPecas() throws SQLException {
		ArrayList<PecaTO> pecas = new ArrayList<PecaTO>();

		Connection conn = DBUtil.openConnection();

		String sql = " SELECT * FROM PECA ORDER BY FORNECEDOR ";

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

	// Select a pe�a pelo codigo
	public ArrayList<PecaTO> selectPecabyCodigo(int codigo) throws SQLException {
		ArrayList<PecaTO> pecas = new ArrayList<PecaTO>();

		Connection conn = DBUtil.openConnection();

		String sql = " SELECT * FROM PECA WHERE codigo_peca = ? ";

		PreparedStatement prep = conn.prepareStatement(sql);
		prep.setInt(1, codigo);
		ResultSet rs = prep.executeQuery();

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

	// Select a pe�a pelo nome
	public ArrayList<PecaTO> selectPecabyName(String name) throws SQLException {
		ArrayList<PecaTO> pecas = new ArrayList<PecaTO>();

		Connection conn = DBUtil.openConnection();

		String sql = " SELECT * FROM PECA WHERE nome LIKE ? ";

		PreparedStatement prep = conn.prepareStatement(sql);
		prep.setString(1, '%' + name.toUpperCase() + '%');
		ResultSet rs = prep.executeQuery();

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

	// Select a pe�a pelo fornecedor
	public ArrayList<PecaTO> selectPecabyFornecedor(String fornecedor) throws SQLException {
		ArrayList<PecaTO> pecas = new ArrayList<PecaTO>();

		Connection conn = DBUtil.openConnection();

		String sql = " SELECT * FROM PECA WHERE fornecedor LIKE ? ";

		PreparedStatement prep = conn.prepareStatement(sql);
		prep.setString(1, '%' + fornecedor.toUpperCase() + '%');
		ResultSet rs = prep.executeQuery();

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

	// Busca a quantiade no banco referente ao codigo informado
	private int selectQtd(int cod) {
		int qtd = 0;
		String sql = "SELECT quantidade FROM peca WHERE codigo_peca = ? ";

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

	// Compare quantidade
	private boolean compareQtd(PecaTO pecaTO) {
		if (selectQtd(pecaTO.getCodigo()) >= pecaTO.getQuantidade()) {
			return true;
		} else {
			JOptionPane.showMessageDialog(null, "Quantidade em estoque insuficiente!", "Error",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}
	}

	// Alter a quantidade da pe�a ja cadastrada
	public boolean updateQtdPeca(PecaTO pecaTO) throws SQLException {
		Connection conn = null;
		if (compareQtd(pecaTO)) {
			int qtd = 0;
			String sql = "UPDATE peca SET quantidade = ? WHERE codigo_peca = ? ";
			qtd = (selectQtd(pecaTO.getCodigo()) - pecaTO.getQuantidade());

			try {
				conn = DBUtil.openConnection();
				PreparedStatement prep = conn.prepareStatement(sql);
				prep.setInt(1, qtd);
				prep.setInt(2, pecaTO.getCodigo());
				prep.execute();
				return true;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			conn.close();
		}
		return false;
	}

	// Deleta pe�a cadastrada
	public void deletePeca(int codigo) throws SQLException {
		String sql = "DELETE FROM peca WHERE codigo_peca = ?";
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
