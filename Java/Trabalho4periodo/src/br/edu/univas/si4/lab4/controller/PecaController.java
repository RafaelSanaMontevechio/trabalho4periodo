package br.edu.univas.si4.lab4.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.edu.univas.si4.lab4.dao.PecaDao;
import br.edu.univas.si4.lab4.to.PecaTO;
import br.edu.univas.si4.lab4.view.peca.InternalFramePecas;

public class PecaController {

	private PecaDao pecaDAO;

	public PecaController() {
		pecaDAO = new PecaDao();
	}

	// Passa para o FornecedorDAO os dados para novo cadastro
	public void newPeca(PecaTO pecaTO) {

		try {
			new PecaDao().insertNewPeca(pecaTO);
			JOptionPane.showMessageDialog(null, "Sucesso!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Pega o retorno do select e popula o jtable com todos as peças cadastradas
	public void addDataAll(InternalFramePecas iFramePecas) {
		List<PecaTO> pecas = null;
		try {
			pecas = new ArrayList<PecaTO>();
			pecas = new PecaDao().listAllPecas();
			iFramePecas.updateModelPecas(pecas);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Recebe o retorno da pesquisa pelo codigo
	public void addDataByCodigo(InternalFramePecas iFramePecas, int codigo) {
		List<PecaTO> pecas = null;
		try {
			pecas = new ArrayList<PecaTO>();
			pecas = new PecaDao().selectPecabyCodigo(codigo);
			iFramePecas.updateModelPecas(pecas);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Recebe o retorno da pesquisa pelo nome
	public void addDataByName(InternalFramePecas iFramePecas, String name) {
		List<PecaTO> pecas = null;
		try {
			pecas = new ArrayList<PecaTO>();
			pecas = new PecaDao().selectPecabyName(name);
			iFramePecas.updateModelPecas(pecas);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Recebe o retorno da pesquisa pelo fornecedor
	public void addDataByFornecedor(InternalFramePecas iFramePecas, String fornecedor) {
		List<PecaTO> pecas = null;
		try {
			pecas = new ArrayList<PecaTO>();
			pecas = new PecaDao().selectPecabyFornecedor(fornecedor);
			iFramePecas.updateModelPecas(pecas);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Retira peca
	public void updatePeca(PecaTO pecaTO) {

		try {
			pecaDAO.TakeOffPeca(pecaTO);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao atualizar a quantidade" + e.getMessage());
		}
	}

	// Adiciona peca
	public void alteraQtdPecaAdd(PecaTO pecaTO) {
		try {
			pecaDAO.updateQtdPecaAdd(pecaTO);
			JOptionPane.showMessageDialog(null, "Adicionado com sucesso!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Delete peça
	public void removePeca(String cod) {
		int codigo = Integer.parseInt(cod);
		try {
			new PecaDao().deletePeca(codigo);
			JOptionPane.showMessageDialog(null, "Peça excluido!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
