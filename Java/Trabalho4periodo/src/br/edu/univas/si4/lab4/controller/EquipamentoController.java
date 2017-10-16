package br.edu.univas.si4.lab4.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.edu.univas.si4.lab4.dao.EquipamentoDao;
import br.edu.univas.si4.lab4.to.EquipamentoTO;
import br.edu.univas.si4.lab4.view.equipamento.FrameCadastroEquipamentos;
import br.edu.univas.si4.lab4.view.equipamento.InternalFrameEquipamentos;

public class EquipamentoController {

	private EquipamentoDao equipamentoDAO;
	private FrameCadastroEquipamentos fCadEquipamentos;

	private EquipamentoDao getEquipamentoDAO() {
		if (equipamentoDAO == null) {
			equipamentoDAO = new EquipamentoDao();
		}
		return equipamentoDAO;
	}
	
	private FrameCadastroEquipamentos getfCadEquipamentos() {
		if (fCadEquipamentos == null) {
			fCadEquipamentos = new FrameCadastroEquipamentos();
			fCadEquipamentos.setLocationRelativeTo(null);
		}
		return fCadEquipamentos;
	}
	
	public void callRegisterNewEquipamento() {
		getfCadEquipamentos().setVisible(true);
	}
	

	// Passa para o equipamentoDAO os dados para novo cadastro
	public void newEquipamento(EquipamentoTO equipamento) {

		try {
			getEquipamentoDAO().insertNewEquipamento(equipamento);
			JOptionPane.showMessageDialog(null, "Sucesso!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Retorna todos os equipamentos cadastrados
	public void addDataAll(InternalFrameEquipamentos iFrameEquipamento) {
		List<EquipamentoTO> equipamentos = null;
		try {
			equipamentos = new ArrayList<EquipamentoTO>();
			equipamentos = new EquipamentoDao().listAllEquipamentos();
			iFrameEquipamento.updateModelEquipamento(equipamentos);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Recebe o retorno da pesquisa pelo nome
	public void addDataByName(InternalFrameEquipamentos iFrameEquipamento, String name) {
		List<EquipamentoTO> equipamentos = null;
		try {
			equipamentos = new ArrayList<EquipamentoTO>();
			equipamentos = new EquipamentoDao().selectEquipamentobyName(name);
			iFrameEquipamento.updateModelEquipamento(equipamentos);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Recebe o retorno da pesquisa pelo codigo
	public void addDataByCodigo(InternalFrameEquipamentos iFrameEquipamento, int codigo) {
		List<EquipamentoTO> equipamentos = null;
		try {
			equipamentos = new ArrayList<EquipamentoTO>();
			equipamentos = new EquipamentoDao().selectEquipamentobyCodigo(codigo);
			iFrameEquipamento.updateModelEquipamento(equipamentos);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Recebe o retorno da pesquisa por fornecedor
	public void addDataByFornecedor(InternalFrameEquipamentos iFrameEquipamento, String fornecedor) {
		List<EquipamentoTO> equipamentos = null;
		equipamentos = new ArrayList<EquipamentoTO>();
		try {
			equipamentos = new EquipamentoDao().selectEquipamentobyFornecedor(fornecedor);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		iFrameEquipamento.updateModelEquipamento(equipamentos);
	}

	// Retorna um ArrayList de String com o nome de todos os equipamentos
	public ArrayList<String> listaNomeEquipamentos() {
		ArrayList<String> nomeEquipamento = new ArrayList<>();
		try {
			nomeEquipamento = new EquipamentoDao().selectNomeEquipamento();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nomeEquipamento;
	}
}
