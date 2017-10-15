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
		public void addData(InternalFramePecas iFramePecas) {
			List<PecaTO> pecas = null;
			try {
				pecas = new ArrayList<PecaTO>();
				pecas = new PecaDao().listAllPecas();
				iFramePecas.updateModelPecas(pecas);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
}
