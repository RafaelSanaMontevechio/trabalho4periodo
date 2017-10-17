package br.edu.univas.si4.lab4.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.edu.univas.si4.lab4.dao.PecaDao;
import br.edu.univas.si4.lab4.to.PecaTO;
import br.edu.univas.si4.lab4.view.peca.InternalFramePecas;

public class PecaController {

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
}
