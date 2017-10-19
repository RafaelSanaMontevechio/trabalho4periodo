package br.edu.univas.si4.lab4.controller;

import java.sql.SQLException;
import java.text.ParseException;

import javax.swing.JOptionPane;

import br.edu.univas.si4.lab4.dao.EstoqueDao;
import br.edu.univas.si4.lab4.to.EstoqueTO;
import br.edu.univas.si4.lab4.to.PecaTO;

public class EstoqueController {

	private EstoqueDao estoqueDao;
	private PecaController pecaControll;

	public EstoqueController() {
		estoqueDao = new EstoqueDao();
		pecaControll = new PecaController();
	}

	// Passa ao DAO os dados da peça que foi retirada
	public void addPeca(EstoqueTO estoqueTO, PecaTO pecaTO) {
		
		if(pecaControll.updatePeca(pecaTO)) {
			try {
				estoqueDao.addPeca(estoqueTO);
				JOptionPane.showMessageDialog(null, "Sucesso");
			} catch (SQLException | ParseException e) {
				e.printStackTrace();
			}
		}
	}

	// Recebe retorno do DAO informando se codigo já está cadastrado
	public boolean callIsRegistro(int codigo) {
		try {
			if (estoqueDao.isRegistro(codigo)) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	// Chama metodo para atualizar a quantidade da peça já cadastrada
	public void updatePeca(EstoqueTO estoqueTO, PecaTO pecaTO) {
		try {
			if(pecaControll.updatePeca(pecaTO)) {
				estoqueDao.updateQtdPeca(estoqueTO);
				JOptionPane.showMessageDialog(null, "Sucesso");
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao atualizar a quantidade" + e.getMessage());
			e.printStackTrace();
		}
	}
}
