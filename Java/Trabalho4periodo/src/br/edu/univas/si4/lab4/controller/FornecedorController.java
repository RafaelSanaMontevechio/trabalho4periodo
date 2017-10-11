package br.edu.univas.si4.lab4.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.univas.si4.lab4.dao.FornecedorDao;
import br.edu.univas.si4.lab4.to.FornecedorTO;
import br.edu.univas.si4.lab4.view.fornecedor.FrameCadastroFornecedor;
import br.edu.univas.si4.lab4.view.fornecedor.InternalFrameFornecedor;

public class FornecedorController {
	
	private FrameCadastroFornecedor fCadFornecedor;
	
	private FrameCadastroFornecedor getfCadFornecedor() {
		if (fCadFornecedor == null) {
			fCadFornecedor = new FrameCadastroFornecedor();
			fCadFornecedor.setLocationRelativeTo(null);
		}
		return fCadFornecedor;
	}

	// Passa para o FornecedorDAO os dados para cadastro
	public void newFornecedor(FornecedorTO fornecedor) {

		try {
			new FornecedorDao().insertNewFornecedor(fornecedor);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Pega o retorno do select e popula o jtable
	public void addData(InternalFrameFornecedor iFrameFornecedor) {
		List<FornecedorTO> fornecedores = null;
		try {
			fornecedores = new ArrayList<FornecedorTO>();
			fornecedores = new FornecedorDao().listAllFornecedores();
			iFrameFornecedor.updateModel(fornecedores);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//Chama a tela para um novo cadastro
	public void callScreenRegisterNewFornecedor() {
		getfCadFornecedor().setVisible(true);
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
