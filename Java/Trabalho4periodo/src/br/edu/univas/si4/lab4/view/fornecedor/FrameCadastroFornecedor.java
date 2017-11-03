package br.edu.univas.si4.lab4.view.fornecedor;

import java.awt.BorderLayout;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import br.edu.univas.si4.lab4.controller.FornecedorController;
import br.edu.univas.si4.lab4.interfaces.ButtonsListener;
import br.edu.univas.si4.lab4.to.FornecedorTO;
import br.edu.univas.si4.lab4.view.ButtonsPanels.ButtonsPanelCadastros;

public class FrameCadastroFornecedor extends JDialog {

	private PanelCadastroFornecedor panelCadFornecedor;
	private ButtonsPanelCadastros buttonsCadastro;
	private FornecedorController fornecedorController;
	private FornecedorTO fornecedorTO;

	private static final long serialVersionUID = 8703398655774672349L;

	public FrameCadastroFornecedor() {
		this.setTitle("Cadastro de Fornecedor");
		this.setModal(true);
		this.setResizable(false);

		fornecedorController = new FornecedorController();
		fornecedorTO = new FornecedorTO();

		addComponents();
		pack();
	}

	private void addComponents() {
		add(getPanelCadFornecedor(), BorderLayout.CENTER);
		add(getButtonsCadastro(), BorderLayout.SOUTH);
	}

	private PanelCadastroFornecedor getPanelCadFornecedor() {
		if (panelCadFornecedor == null) {
			panelCadFornecedor = new PanelCadastroFornecedor();
		}
		return panelCadFornecedor;
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

	// Passa os dados capturados para o controller
	private void salvarClicked() {

		String str = fornecedorController.removeMask(panelCadFornecedor.getJtCnpj().getText());
		String str2 = panelCadFornecedor.getJtNomeRazao().getText();
		String str3 = panelCadFornecedor.getJtFantasia().getText();

		if (verifyEmptyString(str, str2, str3)) {
			fornecedorTO.setCnpj(Long.parseLong(str));
			fornecedorTO.setNomeRazao(str2);
			fornecedorTO.setFantasia(str3);
			fornecedorController.newFornecedor(fornecedorTO);
			setText();
		} else {
			JOptionPane.showMessageDialog(this, "Todos os campos devem ser preenchidos!", "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}
	
	// Fecha a tela
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
		panelCadFornecedor.getJtCnpj().setText("");
		panelCadFornecedor.getJtNomeRazao().setText("");
		panelCadFornecedor.getJtFantasia().setText("");
	}
}
