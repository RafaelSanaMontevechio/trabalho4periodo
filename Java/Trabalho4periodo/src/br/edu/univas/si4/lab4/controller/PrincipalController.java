package br.edu.univas.si4.lab4.controller;

import br.edu.univas.si4.lab4.view.Principal;
import br.edu.univas.si4.lab4.view.equipamento.FrameCadastroEquipamentos;
import br.edu.univas.si4.lab4.view.estoque.FrameEstoque;
import br.edu.univas.si4.lab4.view.fornecedor.FrameCadastroFornecedor;
import br.edu.univas.si4.lab4.view.peca.FrameCadastroPeca;

public class PrincipalController {

	private Principal principal;
	private FrameCadastroFornecedor fCadFornecedor;
	private FrameCadastroEquipamentos fCadEquipamento;
	private FrameCadastroPeca fCadPeca;
	private FrameEstoque fEstoque;

	public PrincipalController() {
		principal = new Principal();
	}

	public void initialize() {
		principal.setVisible(true);
	}

	public void callScreenRegisterNewFornecedor() {
		getfCadFornecedor();
	}

	public void callScreenRegisterNewEquipamento() {
		getfCadEquipamento();
	}

	public void callScreenRegisterNewPeca() {
		getfCadPeca();
	}

	public void callScreenEstoque() {
		getfEstoque();
	}

	private FrameCadastroFornecedor getfCadFornecedor() {
		if (fCadFornecedor == null) {
			fCadFornecedor = new FrameCadastroFornecedor();
			fCadFornecedor.setLocationRelativeTo(null);
			fCadFornecedor.setVisible(true);
		}
		return fCadFornecedor;
	}

	private FrameCadastroEquipamentos getfCadEquipamento() {
		if (fCadEquipamento == null) {
			fCadEquipamento = new FrameCadastroEquipamentos();
			fCadEquipamento.setLocationRelativeTo(null);
			fCadEquipamento.setVisible(true);
		}
		return fCadEquipamento;
	}

	private FrameCadastroPeca getfCadPeca() {
		if (fCadPeca == null) {
			fCadPeca = new FrameCadastroPeca();
			fCadPeca.setLocationRelativeTo(null);
			fCadPeca.setVisible(true);
		}
		return fCadPeca;
	}

	private FrameEstoque getfEstoque() {
		if (fEstoque == null) {
			fEstoque = new FrameEstoque();
			fEstoque.setLocationRelativeTo(null);
			fEstoque.setVisible(true);
		}
		return fEstoque;
	}
}
