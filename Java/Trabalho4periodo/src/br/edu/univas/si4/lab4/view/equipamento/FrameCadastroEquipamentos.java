package br.edu.univas.si4.lab4.view.equipamento;

import java.awt.BorderLayout;

import javax.swing.JDialog;

import br.edu.univas.si4.lab4.controller.EquipamentoController;
import br.edu.univas.si4.lab4.interfaces.ButtonsListener;
import br.edu.univas.si4.lab4.to.EquipamentoTO;
import br.edu.univas.si4.lab4.view.ButtonsPanels.ButtonsPanelCadastros;

public class FrameCadastroEquipamentos extends JDialog {

	private static final long serialVersionUID = 6411516047271744522L;

	private PanelCadastroEquipamento panelCadEquipamento;
	private ButtonsPanelCadastros buttonsCadastro;

	private EquipamentoController equipamentoControll;
	private EquipamentoTO equipamentoTO;

	public FrameCadastroEquipamentos() {
		this.setTitle("Cadastro de equipamento");
		this.setModal(true);
		this.setLocationRelativeTo(null);
		this.setResizable(false);

		addComponents();
		pack();
	}

	private void addComponents() {
		add(getPanelCadEquipamento(), BorderLayout.CENTER);
		add(getButtonsCadastro(), BorderLayout.SOUTH);
	}

	private EquipamentoController getEquipamentoControll() {
		if (equipamentoControll == null) {
			equipamentoControll = new EquipamentoController();
		}
		return equipamentoControll;
	}

	private EquipamentoTO getEquipamentoTO() {
		if (equipamentoTO == null) {
			equipamentoTO = new EquipamentoTO();
		}
		return equipamentoTO;
	}

	private PanelCadastroEquipamento getPanelCadEquipamento() {
		if (panelCadEquipamento == null) {
			panelCadEquipamento = new PanelCadastroEquipamento();
		}
		return panelCadEquipamento;
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

		getEquipamentoTO().setCodigo(Integer.parseInt(getPanelCadEquipamento().getJtCodigo().getText()));
		getEquipamentoTO().setNome(getPanelCadEquipamento().getJtNome().getText());
		getEquipamentoTO().setQuantidade(Integer.parseInt(getPanelCadEquipamento().getJtQuantidade().getText()));
		getEquipamentoTO().setFornecedor(getPanelCadEquipamento().getComboForncedores().getSelectedItem().toString());

		getEquipamentoControll().newEquipamento(getEquipamentoTO());

		getPanelCadEquipamento().getJtCodigo().setText("");
		getPanelCadEquipamento().getJtNome().setText("");
		getPanelCadEquipamento().getJtQuantidade().setText("");
	}

	private void cancelarClicked() {
		this.dispose();
	}
}
