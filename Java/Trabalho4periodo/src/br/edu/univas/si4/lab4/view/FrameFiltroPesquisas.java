package br.edu.univas.si4.lab4.view;

import java.awt.BorderLayout;

import javax.swing.JDialog;

public class FrameFiltroPesquisas extends JDialog {

	private static final long serialVersionUID = -3686338980856283352L;

	private PanelFiltroPesquisas panelFiltroPesquisas;

	public FrameFiltroPesquisas() {
		this.setTitle("Pesquisar");
		this.setModal(true);
		this.setLocationRelativeTo(null);
		this.setResizable(false);

		addComponents();
		pack();
	}

	private void addComponents() {
		add(getPanelFiltroPesquisas(), BorderLayout.CENTER);
	}

	private PanelFiltroPesquisas getPanelFiltroPesquisas() {
		if (panelFiltroPesquisas == null) {
			panelFiltroPesquisas = new PanelFiltroPesquisas();
		}
		return panelFiltroPesquisas;
	}

}
