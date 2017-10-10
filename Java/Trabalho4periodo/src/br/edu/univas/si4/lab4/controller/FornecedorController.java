package br.edu.univas.si4.lab4.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.univas.si4.lab4.dao.FornecedorDao;
import br.edu.univas.si4.lab4.to.FornecedorTO;
import br.edu.univas.si4.lab4.view.fornecedor.InternalFrameFornecedor;
import br.edu.univas.si4.lab4.view.fornecedor.TableModelFornecedor;

public class FornecedorController {

	public void newFornecedor(FornecedorTO fornecedor) {

		try {
			new FornecedorDao().insertNewFornecedor(fornecedor);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void addData() {
		List<FornecedorTO> fornecedores = null;
		FornecedorDao fDAO = null;

		try {
			fornecedores = new ArrayList<FornecedorTO>();
			fDAO = new FornecedorDao();
			
			fornecedores = fDAO.listAllFornecedores();
			
			InternalFrameFornecedor ifFornecedor = new InternalFrameFornecedor();
			
			ifFornecedor.updateModel(fornecedores);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Remove mask do cnpj
	public String removeMask(String cnpj) {

		cnpj = cnpj.replace(".", "");
		cnpj = cnpj.replace(".", "");
		cnpj = cnpj.replace("/", "");
		cnpj = cnpj.replace("-", "");

		return cnpj;
	}
}
