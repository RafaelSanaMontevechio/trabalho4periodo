package br.edu.univas.si4.lab4.view.estoque;

import java.awt.BorderLayout;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import br.edu.univas.si4.lab4.controller.EstoqueController;
import br.edu.univas.si4.lab4.interfaces.ButtonsListener;
import br.edu.univas.si4.lab4.to.EstoqueTO;
import br.edu.univas.si4.lab4.to.PecaTO;
import br.edu.univas.si4.lab4.view.ButtonsPanels.ButtonsPanelCadastros;

public class FrameEstoque extends JDialog {

	private PanelEstoque panelEstoque;
	private ButtonsPanelCadastros buttonsPanel;
	private EstoqueTO estoqueTO;
	private PecaTO pecaTO;

	private static final long serialVersionUID = -4897376368273018326L;

	private EstoqueController estoqueControll;


	public FrameEstoque() {
		this.setTitle("Adicionar e remover item do estoque");
		this.setModal(true);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		
		pecaTO = new PecaTO();

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

	public EstoqueTO getEstoqueTO() {
		if (estoqueTO == null) {
			estoqueTO = new EstoqueTO();
		}
		return estoqueTO;
	}

	public EstoqueController getEstoqueControll() {
		if (estoqueControll == null) {
			estoqueControll = new EstoqueController();
		}
		return estoqueControll;
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
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

		getEstoqueTO().setCodigo(Integer.parseInt(getPanelEstoque().getJtCodigo().getText()));
		getEstoqueTO().setQuantidade(Integer.parseInt(getPanelEstoque().getJtQuantidade().getText()));
		pecaTO.setCodigo(Integer.parseInt(getPanelEstoque().getJtCodigo().getText()));
		pecaTO.setQuantidade(Integer.parseInt(getPanelEstoque().getJtQuantidade().getText()));
		try {
			getEstoqueTO().setData(formato.parse(getPanelEstoque().getJtData().getText()));
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(null, "Erro ao converter data para java.Util.Date: " + e.getMessage());
		}
		if (getEstoqueControll().callIsRegistro(Integer.parseInt(getPanelEstoque().getJtCodigo().getText()))) {
			getEstoqueControll().updatePeca(getEstoqueTO(), pecaTO);	
		} else {
			getEstoqueControll().addPeca(getEstoqueTO(), pecaTO);
		}
	}
}
