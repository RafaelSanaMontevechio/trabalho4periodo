package br.edu.univas.si4.lab4.view.estoque;

import java.awt.BorderLayout;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import br.edu.univas.si4.lab4.controller.EquipamentoController;
import br.edu.univas.si4.lab4.controller.EstoqueController;
import br.edu.univas.si4.lab4.controller.PecaController;
import br.edu.univas.si4.lab4.interfaces.ButtonsListener;
import br.edu.univas.si4.lab4.to.EquipamentoTO;
import br.edu.univas.si4.lab4.to.EstoqueTO;
import br.edu.univas.si4.lab4.to.PecaTO;
import br.edu.univas.si4.lab4.view.ButtonsPanels.ButtonsPanelCadastros;

public class FrameEstoque extends JDialog {

	private static final long serialVersionUID = -4897376368273018326L;

	private PanelEstoque panelEstoque;
	private ButtonsPanelCadastros buttonsPanel;
	private PecaTO pecaTO;
	private EquipamentoTO equipamentoTO;
	private EstoqueTO estoqueTO;
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
		estoqueTO = new EstoqueTO();
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
		} else if (getPanelEstoque().getJrbRetirar().isSelected()
				&& getPanelEstoque().getJrbEquipamento().isSelected()) {
			retirarEquipamentoSelected();
		} else if (getPanelEstoque().getJrbRetirar().isSelected() && getPanelEstoque().getJrbPeca().isSelected()) {
			retirarPecaSelected();
		}
	}
	
	//Atualiza a quantidade de paça
	private void addPecaSelected() {
		pecaControll.alteraQtdPecaAdd(takeDataPeca());
	}
	
	//Retira peça do estoque
	private void retirarPecaSelected() {
		if(pecaControll.updatePeca(takeDataPeca())) {
			estoqueControll.adicionaHistorico(takeDataPecaOut());
		}else {
			System.out.println("Erro!");
		}
	}
	
	//Atualiza quantidade de equipamento no estoque
	private void addEquipamentoSelected() {
		equipamentoControll.alteraQtdPecaAdd(takeDataEquipamento());
	}

	//Retira equipamento do estoque
	private void retirarEquipamentoSelected() {
		equipamentoControll.updatePeca(takeDataEquipamento());
	}

	//Captura os dados na tela
	private PecaTO takeDataPeca() {
		pecaTO.setCodigo(Integer.parseInt(getPanelEstoque().getJtCodigo().getText()));
		pecaTO.setQuantidade(Integer.parseInt(getPanelEstoque().getJtQuantidade().getText()));
		return pecaTO;
	}

	//Captura os dados na tela
	private EquipamentoTO takeDataEquipamento() {
		equipamentoTO.setCodigo(Integer.parseInt(getPanelEstoque().getJtCodigo().getText()));
		equipamentoTO.setQuantidade(Integer.parseInt(getPanelEstoque().getJtQuantidade().getText()));
		return equipamentoTO;
	}
	
	//Captura os dados da peça que será retirada para salvar no historico
	private EstoqueTO takeDataPecaOut() {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		estoqueTO.setCodigo(pecaTO.getCodigo());
		estoqueTO.setQuantidade(pecaTO.getQuantidade());
		try {
			estoqueTO.setData(formato.parse(getPanelEstoque().getJtData().getText()));
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(null, "Erro na data\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
		return estoqueTO;
	}
}
