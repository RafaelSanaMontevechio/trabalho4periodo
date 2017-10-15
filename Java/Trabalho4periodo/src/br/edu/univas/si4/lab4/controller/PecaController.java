package br.edu.univas.si4.lab4.controller;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.edu.univas.si4.lab4.dao.PecaDao;
import br.edu.univas.si4.lab4.to.PecaTO;

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
}
