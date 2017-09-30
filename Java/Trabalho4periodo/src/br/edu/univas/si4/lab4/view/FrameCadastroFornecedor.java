package br.edu.univas.si4.lab4.view;

import java.awt.BorderLayout;

import javax.swing.JDialog;

public class FrameCadastroFornecedor extends JDialog {

	private PanelCadastroFornecedor panelCadFornecedor;
	private ButtonsPanelCadastros buttonsCadastro;

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
		}
		return buttonsCadastro;
	}

}
