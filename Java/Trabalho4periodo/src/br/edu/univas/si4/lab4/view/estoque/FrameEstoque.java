package br.edu.univas.si4.lab4.view.estoque;

import java.awt.BorderLayout;

import javax.swing.JDialog;

import br.edu.univas.si4.lab4.controller.EquipamentoController;
import br.edu.univas.si4.lab4.controller.EstoqueController;
import br.edu.univas.si4.lab4.controller.PecaController;
import br.edu.univas.si4.lab4.interfaces.ButtonsListener;
import br.edu.univas.si4.lab4.to.EquipamentoTO;
import br.edu.univas.si4.lab4.to.PecaTO;
import br.edu.univas.si4.lab4.view.ButtonsPanels.ButtonsPanelCadastros;

public class FrameEstoque extends JDialog {

	private static final long serialVersionUID = -4897376368273018326L;

	private PanelEstoque panelEstoque;
	private ButtonsPanelCadastros buttonsPanel;
	private PecaTO pecaTO;
	private EquipamentoTO equipamentoTO;
	private EstoqueController estoqueControll;
	private PecaController pecaControll;
	private EquipamentoController equipamentoControll;

	public FrameEstoque() {
		this.setTitle("Adicionar e remover item do estoque");
		this.setModal(true);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		
		pecaTO = new PecaTO();
		equipamentoTO = new EquipamentoTO();
		estoqueControll = new EstoqueController();
		pecaControll = new PecaController();
		equipamentoControll = new EquipamentoController();

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

	private void cancelarClicked() {
		this.dispose();
	}

	private void salvarClicked() {
		if (getPanelEstoque().getJrbAdicionar().isSelected() && getPanelEstoque().getJrbEquipamento().isSelected()) {
			addEquipamentoSelected();
		} else if (getPanelEstoque().getJrbAdicionar().isSelected() && getPanelEstoque().getJrbPeca().isSelected()) {
			addPecaSelected();
		} else if (getPanelEstoque().getJrbRetirar().isSelected() && getPanelEstoque().getJrbEquipamento().isSelected()) {
			retirarEquipamentoSelected();
		} else if (getPanelEstoque().getJrbRetirar().isSelected() && getPanelEstoque().getJrbPeca().isSelected()) {
			retirarPecaSelected();
		}
	}

	private void addPecaSelected() {
		pecaControll.alteraQtdPecaAdd(takeDataPeca());		
	}

	private void retirarPecaSelected() {
		pecaControll.updatePeca(takeDataPeca());
	}

	private void addEquipamentoSelected() {
		equipamentoControll.alteraQtdPecaAdd(takeDataEquipamento());
	}

	private void retirarEquipamentoSelected() {
		equipamentoControll.updatePeca(takeDataEquipamento());
	}
	
	private PecaTO takeDataPeca() {
		pecaTO.setCodigo(Integer.parseInt(getPanelEstoque().getJtCodigo().getText())); 
		pecaTO.setQuantidade(Integer.parseInt(getPanelEstoque().getJtQuantidade().getText()));
		return pecaTO;
	}
	
	private EquipamentoTO takeDataEquipamento() {
		equipamentoTO.setCodigo(Integer.parseInt(getPanelEstoque().getJtCodigo().getText())); 
		equipamentoTO.setQuantidade(Integer.parseInt(getPanelEstoque().getJtQuantidade().getText()));
		return equipamentoTO;
	}
}
