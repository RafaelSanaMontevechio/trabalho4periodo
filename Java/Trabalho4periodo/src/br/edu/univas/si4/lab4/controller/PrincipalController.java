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
		fCadFornecedor = new FrameCadastroFornecedor();
		fCadFornecedor.setLocationRelativeTo(null);
		fCadFornecedor.setVisible(true);
	}
	
	public void callScreenRegisterNewEquipamento() {
		fCadEquipamento = new FrameCadastroEquipamentos();
		fCadEquipamento.setLocationRelativeTo(null);
		fCadEquipamento.setVisible(true);
	}
	
	public void callScreenRegisterNewPeca() {
		fCadPeca = new FrameCadastroPeca();
		fCadPeca.setLocationRelativeTo(null);
		fCadPeca.setVisible(true);
	}
	
	public void callScreenEstoque() {
		fEstoque = new FrameEstoque();
		fEstoque.setLocationRelativeTo(null);
		fEstoque.setVisible(true);
	}
}
