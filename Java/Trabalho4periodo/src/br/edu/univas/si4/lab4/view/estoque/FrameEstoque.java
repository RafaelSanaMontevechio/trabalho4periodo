package br.edu.univas.si4.lab4.view.estoque;

import java.awt.BorderLayout;

import javax.swing.JDialog;

import br.edu.univas.si4.lab4.controller.EstoqueController;
import br.edu.univas.si4.lab4.interfaces.ButtonsListener;
import br.edu.univas.si4.lab4.view.ButtonsPanels.ButtonsPanelCadastros;

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
				public void cancelarPerformed() {
					cancelarClicked();
				}
			});
		}
		return buttonsPanel;
	}

	private void salvarClicked() {
		if (getPanelEstoque().getJrbAdicionar().isSelected() && getPanelEstoque().getJrbEquipamento().isSelected()) {
			
		} 
		else if (getPanelEstoque().getJrbAdicionar().isSelected() && getPanelEstoque().getJrbPeca().isSelected()) {
			getPanelEstoque().getJtCodigo().getText();
			getPanelEstoque().getJtQuantidade().getText();
			getPanelEstoque().getJtData().getText();
		} 
		else if (getPanelEstoque().getJrbRetirar().isSelected()
				&& getPanelEstoque().getJrbEquipamento().isSelected()) {
			new EstoqueController().addEquipamento(getPanelEstoque().getJtCodigo().getText(),
					getPanelEstoque().getJtQuantidade().getText(), getPanelEstoque().getJtData().getText());
		} 
		else if (getPanelEstoque().getJrbRetirar().isSelected() && getPanelEstoque().getJrbPeca().isSelected()) {
			getPanelEstoque().getJtCodigo().getText();
			getPanelEstoque().getJtQuantidade().getText();
			getPanelEstoque().getJtData().getText();
		}
	}

	private void cancelarClicked() {
		this.dispose();
	}
}
