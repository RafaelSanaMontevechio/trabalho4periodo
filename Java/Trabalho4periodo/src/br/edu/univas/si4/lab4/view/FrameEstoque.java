package br.edu.univas.si4.lab4.view;

import java.awt.BorderLayout;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import br.edu.univas.si4.lab4.interfaces.ButtonsListener;

public class FrameEstoque extends JDialog {

	private PanelEstoque panelEstoque;
	private ButtonsPanelCadastros buttonsPanel;

	private static final long serialVersionUID = -4897376368273018326L;

	public FrameEstoque() {
		this.setTitle("Adicionar e remover item do estoque");
		this.setModal(true);
		this.setLocationRelativeTo(null);
		this.setResizable(false);

		addComponents();
		pack();
	}

	private void addComponents() {
		add(getPanelEstoque(), BorderLayout.CENTER);
		add(getButtonsPanel(), BorderLayout.SOUTH);
	}

	public PanelEstoque getPanelEstoque() {
		if (panelEstoque == null) {
			panelEstoque = new PanelEstoque();
		}
		return panelEstoque;
	}

	public ButtonsPanelCadastros getButtonsPanel() {
		if (buttonsPanel == null) {
			buttonsPanel = new ButtonsPanelCadastros();
			buttonsPanel.addButtonsListener(new ButtonsListener() {
				
				@Override
				public void salvarPerformed() {
					salvarClicked();
				}
				
				@Override
				public void cancelarPerforme() {
					cancelarClicked();
				}
			});
		}
		return buttonsPanel;
	}
	
	private void salvarClicked() {
		JOptionPane.showMessageDialog(null, "Clicou botão salvar - Tela estoque");
	}

	private void cancelarClicked() {
		JOptionPane.showMessageDialog(null, "Clicou botão cancelar - Tela estoque");
	}

}
