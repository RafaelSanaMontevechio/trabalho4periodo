package br.edu.univas.si4.lab4.view;

import java.awt.BorderLayout;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import br.edu.univas.si4.lab4.interfaces.ButtonsListener;

public class FrameCadastroPeca extends JDialog {

	private static final long serialVersionUID = -7860829342439937591L;

	private PanelCadastroPeca panelCadPeca;
	private ButtonsPanelCadastros buttonsCadastro;

	public FrameCadastroPeca() {
		this.setTitle("Cadastro de pe�a");
		this.setModal(true);
		this.setLocationRelativeTo(null);
		this.setResizable(false);

		addComponentes();
		pack();
	}

	private void addComponentes() {
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
		JOptionPane.showMessageDialog(null, "Clicou bot�o salvar - Tela cadastro pe�a");
	}

	private void cancelarClicked() {
		this.dispose();
	}

}
