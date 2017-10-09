package br.edu.univas.si4.lab4.view.fornecedor;

import java.awt.BorderLayout;

import javax.swing.JDialog;

import br.edu.univas.si4.lab4.controller.FornecedorController;
import br.edu.univas.si4.lab4.interfaces.ButtonsListener;
import br.edu.univas.si4.lab4.view.ButtonsPanels.ButtonsPanelCadastros;

public class FrameCadastroFornecedor extends JDialog {

	private PanelCadastroFornecedor panelCadFornecedor;
	private ButtonsPanelCadastros buttonsCadastro;
	private FornecedorController fornecedorController = new FornecedorController();

	private static final long serialVersionUID = 8703398655774672349L;

	public FrameCadastroFornecedor() {
		this.setTitle("Cadastro de Fornecedor");
		this.setModal(true);
		this.setResizable(false);

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

	private void salvarClicked() {

		 fornecedorController.newFornecedor(panelCadFornecedor.getJtCnpj().getText(),
		 panelCadFornecedor.getJtNomeRazao().getText(),
		 panelCadFornecedor.getJtFantasia().getText());		
	}

	private void cancelarClicked() {
		this.dispose();
	}
}
