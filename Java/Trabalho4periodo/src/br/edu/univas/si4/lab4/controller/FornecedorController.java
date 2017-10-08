package br.edu.univas.si4.lab4.controller;

import java.sql.SQLException;

import br.edu.univas.si4.lab4.dao.FornecedorDao;
import br.edu.univas.si4.lab4.model.Fornecedor;

public class FornecedorController {

	private Fornecedor fornecedor = new Fornecedor();

	public void newFornecedor(String cnpj, String razaoSocial, String nomeFantasia) {

		cnpj = removeMask(cnpj);

		long cnpjInt = Long.parseLong(cnpj);

		fornecedor.setCnpj(cnpjInt);
		fornecedor.setNomeRazao(razaoSocial);
		fornecedor.setFantasia(nomeFantasia);

		try {
			new FornecedorDao().insertNewFornecedor(fornecedor);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Remove mask do cnpj
	private String removeMask(String cnpj) {

		cnpj = cnpj.replace(".", "");
		cnpj = cnpj.replace(".", "");
		cnpj = cnpj.replace("/", "");
		cnpj = cnpj.replace("-", "");

		return cnpj;
	}
}
