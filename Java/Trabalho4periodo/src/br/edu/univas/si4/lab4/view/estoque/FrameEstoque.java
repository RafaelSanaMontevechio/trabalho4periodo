package br.edu.univas.si4.lab4.view.estoque;

import java.awt.BorderLayout;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JDialog;

import br.edu.univas.si4.lab4.controller.EstoqueController;
import br.edu.univas.si4.lab4.interfaces.ButtonsListener;
import br.edu.univas.si4.lab4.to.EstoqueTO;
import br.edu.univas.si4.lab4.view.ButtonsPanels.ButtonsPanelCadastros;

public class FrameEstoque extends JDialog {

	private PanelEstoque panelEstoque;
	private ButtonsPanelCadastros buttonsPanel;
	private EstoqueTO estoqueTO;

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

		} else if (getPanelEstoque().getJrbAdicionar().isSelected() && getPanelEstoque().getJrbPeca().isSelected()) {

		} else if (getPanelEstoque().getJrbRetirar().isSelected()
				&& getPanelEstoque().getJrbEquipamento().isSelected()) {

		} else if (getPanelEstoque().getJrbRetirar().isSelected() && getPanelEstoque().getJrbPeca().isSelected()) {
			retirarPecaSelected();
		}
	}

	private void cancelarClicked() {
		this.dispose();
	}

	private void retirarPecaSelected() {
		estoqueTO = new EstoqueTO();

		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

		estoqueTO.setCodigo(Integer.parseInt(getPanelEstoque().getJtCodigo().getText()));
		estoqueTO.setQuantidade(Integer.parseInt(getPanelEstoque().getJtQuantidade().getText()));
		try {
			estoqueTO.setData(formato.parse(getPanelEstoque().getJtData().getText()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		new EstoqueController().addEquipamento(estoqueTO);
	}
}
