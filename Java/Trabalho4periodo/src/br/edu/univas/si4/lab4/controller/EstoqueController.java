package br.edu.univas.si4.lab4.controller;

import java.sql.SQLException;
import java.text.ParseException;

import br.edu.univas.si4.lab4.dao.EstoqueDao;

public class EstoqueController {

	public void addEquipamento(String cod, String qtd, String data) {
		
		try {
			new EstoqueDao().addEquipment(cod, qtd, data);
		} catch (SQLException | ParseException e) {
			e.printStackTrace();
		}
	}
}
