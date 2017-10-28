package br.edu.univas.si4.lab4.view.fornecedor;

import java.awt.BorderLayout;

import javax.swing.JDialog;

import br.edu.univas.si4.lab4.controller.FornecedorController;
import br.edu.univas.si4.lab4.interfaces.ButtonsListener;
import br.edu.univas.si4.lab4.to.FornecedorTO;
import br.edu.univas.si4.lab4.view.ButtonsPanels.ButtonsPanelCadastros;

public class FrameCadastroFornecedor extends JDialog {

	private PanelCadastroFornecedor panelCadFornecedor;
	private ButtonsPanelCadastros buttonsCadastro;
	private FornecedorController fornecedorController;
	private FornecedorTO fornecedorTO;

	private static final long serialVersionUID = 8703398655774672349L;

	public FrameCadastroFornecedor() {
		this.setTitle("Cadastro de Fornecedor");
		this.setModal(true);
		this.setResizable(false);
		
		fornecedorController = new FornecedorController();
		fornecedorTO = new FornecedorTO();
		
		addComponents();
		pack();
	}

	private void addComponents() {
		add(getPanelCadFornecedor(), BorderLayout.CENTER);
		add(getButtonsCadastro(), BorderLayout.SOUTH);
	}

	private PanelCadastroFornecedor getPanelCadFornecedor() {
		if (panelCadFornecedor == null) {
			panelCadFornecedor = new PanelCadastroFornecedor();
		}
		return panelCadFornecedor;
	}

	private ButtonsPanelCadastros getButtonsCadastro() {
		if (buttonsCadastro == null) {
			buttonsCadastro = new ButtonsPanelCadastros();
			buttonsCadastro.addButtonsListener(new ButtonsListener() {

				@Override
				public void salvarPerformed() {
					salvarClicked();
				}

				@Override
				public void cancelarPerformed() {
					cancelarClicked();
				}
			});
		}
		return buttonsCadastro;
	}

	// Passa os dados capturados para o controller
	private void salvarClicked() {

		fornecedorController.newFornecedor(takeDataView());
		panelCadFornecedor.getJtCnpj().setText("");
		panelCadFornecedor.getJtNomeRazao().setText("");
		panelCadFornecedor.getJtFantasia().setText("");
	}

	// Captura os dados da tela
	private FornecedorTO takeDataView() {
		
			fornecedorTO.setCnpj(Long.parseLong(fornecedorController.removeMask(panelCadFornecedor.getJtCnpj().getText())));
			fornecedorTO.setNomeRazao(panelCadFornecedor.getJtNomeRazao().getText());
			fornecedorTO.setFantasia(panelCadFornecedor.getJtFantasia().getText());
		
		return fornecedorTO;
	}

	// Fecha a tela
	private void cancelarClicked() {
		this.dispose();
	}
}
