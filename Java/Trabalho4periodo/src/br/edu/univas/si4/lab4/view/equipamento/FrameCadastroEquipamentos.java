package br.edu.univas.si4.lab4.view.equipamento;

import java.awt.BorderLayout;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

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
		String str1 = getPanelCadEquipamento().getJtCodigo().getText();
		String str2 = getPanelCadEquipamento().getJtNome().getText();
		String str3 = getPanelCadEquipamento().getJtQuantidade().getText();

		if (verifyEmptyString(str1, str2, str3)) {
			getEquipamentoTO().setCodigo(Integer.parseInt(str1));
			getEquipamentoTO().setNome(str2);
			getEquipamentoTO().setQuantidade(Integer.parseInt(str3));
			getEquipamentoTO().setFornecedor(getPanelCadEquipamento().getComboForncedores().getSelectedItem().toString());
			getEquipamentoControll().newEquipamento(getEquipamentoTO());
			setText();
		} else {
			JOptionPane.showMessageDialog(this, "Todos os campos devem ser preenchidos!", "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	private void cancelarClicked() {
		this.dispose();
	}

	// Verifica String vazia
	private boolean verifyEmptyString(String str, String str2, String str3) {
		if (str.trim().equals("") || str2.trim().equals("") || str2.trim().equals("")) {
			return false;
		}
		return true;
	}

	private void setText() {
		getPanelCadEquipamento().getJtCodigo().setText("");
		getPanelCadEquipamento().getJtNome().setText("");
		getPanelCadEquipamento().getJtQuantidade().setText("");
	}
}
