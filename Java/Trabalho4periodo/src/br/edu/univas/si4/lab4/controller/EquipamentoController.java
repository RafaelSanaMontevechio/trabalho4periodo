package br.edu.univas.si4.lab4.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.edu.univas.si4.lab4.dao.EquipamentoDao;
import br.edu.univas.si4.lab4.to.EquipamentoTO;
import br.edu.univas.si4.lab4.view.equipamento.InternalFrameEquipamentos;

public class EquipamentoController {

	private EquipamentoDao equipamentoDAO;

	private EquipamentoDao getEquipamentoDAO() {
		if (equipamentoDAO == null) {
			equipamentoDAO = new EquipamentoDao();
		}
		return equipamentoDAO;
	}

	// Passa para o equipamento DAO os dados para novo cadastro
	public void newEquipamento(EquipamentoTO equipamento) {

		try {
			getEquipamentoDAO().insertNewEquipamento(equipamento);
			JOptionPane.showMessageDialog(null, "Sucesso!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Retorna todos os equipamentos cadastrados
	public void addData(InternalFrameEquipamentos iFrameEquipamento) {
		List<EquipamentoTO> equipamentos = null;
		try {
			equipamentos = new ArrayList<EquipamentoTO>();
			equipamentos = new EquipamentoDao().listAllEquipamentos();
			iFrameEquipamento.updateModelEquipamento(equipamentos);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Seleciona apenas nome dos equipamentos
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
