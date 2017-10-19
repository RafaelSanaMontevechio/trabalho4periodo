package br.edu.univas.si4.lab4.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

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

	// Passa para o FornecedorDAO os dados para novo cadastro
	public void newFornecedor(FornecedorTO fornecedor) {

		try {
			new FornecedorDao().insertNewFornecedor(fornecedor);
			JOptionPane.showMessageDialog(null, "Sucesso!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Passa ao FornecedorDAO o cnpj do fornecedor para ser deletado
	public void removeFornecedor(String str) {
		long cnpj = Long.parseLong(str);
		try {
			new FornecedorDao().deleteFornecedor(cnpj);
			JOptionPane.showMessageDialog(null, "Fornecedor excluido!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Pega o retorno do select e popula o jtable com todos os fornecedores
	public void addDataAll(InternalFrameFornecedor iFrameFornecedor) {
		List<FornecedorTO> fornecedores = null;
		try {
			fornecedores = new ArrayList<FornecedorTO>();
			fornecedores = new FornecedorDao().listAllFornecedores();
			iFrameFornecedor.updateModel(fornecedores);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Pega retorno do select por cnpj e popula jtable
	public void addDatabyCnpj(InternalFrameFornecedor iFrameFornecedor, String str) {
		List<FornecedorTO> fornecedores = null;
		try {
			fornecedores = new ArrayList<FornecedorTO>();
			fornecedores = new FornecedorDao().listByCnpj(str);
			iFrameFornecedor.updateModel(fornecedores);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Pega retorno do select por razao e popula jtable
	public void addDataByRazao(InternalFrameFornecedor iFrameFornecedor, String str) {
		List<FornecedorTO> fornecedores = null;
		try {
			fornecedores = new ArrayList<FornecedorTO>();
			fornecedores = new FornecedorDao().listByRazao(str);
			iFrameFornecedor.updateModel(fornecedores);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Seleciona apenas nome fantasia
	public ArrayList<String> listaFantasia() {
		ArrayList<String> fantasia = new ArrayList<>();
		try {
			fantasia = new FornecedorDao().selectFantasia();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return fantasia;
	}

	// Altera registro
	public void alterFornecedor(String cnpj, String razao, String fantasia) {

	}

	// Chama a tela para um novo cadastro
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
