package br.edu.univas.si4.lab4.controller;

import java.sql.SQLException;

import br.edu.univas.si4.lab4.dao.EstoqueDao;
import br.edu.univas.si4.lab4.to.EstoqueTO;

public class EstoqueController {
	
	private EstoqueDao estoqueDao;
	
	public EstoqueController() {
		estoqueDao = new EstoqueDao();
	}
	
	public void adicionaHistorico(EstoqueTO estoqueTO) {
		try {
			estoqueDao.insertHistoricoPeca(estoqueTO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
