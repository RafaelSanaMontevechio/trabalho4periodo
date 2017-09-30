package br.edu.univas.si4.lab4.view;

import java.awt.BorderLayout;

import javax.swing.JDialog;


public class FrameCadastroPeca extends JDialog {

	private static final long serialVersionUID = -7860829342439937591L;

	private PanelCadastroPeca panelCadPeca;
	private ButtonsPanelCadastros buttonsCadastro;

	public FrameCadastroPeca() {
		this.setTitle("Cadastro de peça");
		this.setModal(true);
		this.setLocationRelativeTo(null);
		this.setResizable(false);

		addComponentes();
		pack();
	}
	
	private void addComponentes(){
		add(getPanelCadPeca(), BorderLayout.CENTER);
		add(getButtonsCadastro(), BorderLayout.SOUTH);
	}
	
	private PanelCadastroPeca getPanelCadPeca() {
		if (panelCadPeca == null) {
			panelCadPeca = new PanelCadastroPeca();
		}
		return panelCadPeca;
	}

	private ButtonsPanelCadastros getButtonsCadastro() {
		if (buttonsCadastro == null) {
			buttonsCadastro = new ButtonsPanelCadastros();
		}
		return buttonsCadastro;
	}

}
