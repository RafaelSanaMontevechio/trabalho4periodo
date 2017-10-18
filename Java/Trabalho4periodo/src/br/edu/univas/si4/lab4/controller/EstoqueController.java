package br.edu.univas.si4.lab4.controller;

import java.sql.SQLException;
import java.text.ParseException;

import br.edu.univas.si4.lab4.dao.EstoqueDao;
import br.edu.univas.si4.lab4.to.EstoqueTO;

public class EstoqueController {

	public void addEquipamento(EstoqueTO estoqueTO) {
		
		try {
			new EstoqueDao().addEquipment(estoqueTO);
		} catch (SQLException | ParseException e) {
			e.printStackTrace();
		}
	}
}
