package br.edu.univas.si4.lab4.view.peca;

import java.awt.BorderLayout;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import br.edu.univas.si4.lab4.controller.PecaController;
import br.edu.univas.si4.lab4.interfaces.ButtonsListener;
import br.edu.univas.si4.lab4.to.PecaTO;
import br.edu.univas.si4.lab4.view.ButtonsPanels.ButtonsPanelCadastros;

public class FrameCadastroPeca extends JDialog {

	private static final long serialVersionUID = -7860829342439937591L;

	private PanelCadastroPeca panelCadPeca;
	private ButtonsPanelCadastros buttonsCadastro;

	private PecaTO pecaTO;
	private PecaController pecaControll;

	public FrameCadastroPeca() {
		this.setTitle("Cadastro de peça");
		this.setModal(true);
		this.setLocationRelativeTo(null);
		this.setResizable(false);

		addComponentes();
		pack();
	}

	private void addComponentes() {
		add(getPanelCadPeca(), BorderLayout.CENTER);
		add(getButtonsCadastro(), BorderLayout.SOUTH);
	}

	public PecaTO getPecaTO() {
		if (pecaTO == null) {
			pecaTO = new PecaTO();
		}
		return pecaTO;
	}

	public PecaController getPecaControll() {
		if (pecaControll == null) {
			pecaControll = new PecaController();
		}
		return pecaControll;
	}

	private PanelCadastroPeca getPanelCadPeca() {
		if (panelCadPeca == null) {
			panelCadPeca = new PanelCadastroPeca();
		}
		return panelCadPeca;
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
		String str1 = getPanelCadPeca().getJtCodigo().getText();
		String str2 = getPanelCadPeca().getJtNome().getText();
		String str3 = getPanelCadPeca().getJtQuantidade().getText();
		if (verifyEmptyString(str1, str2, str3)) {
			getPecaTO().setCodigo(Integer.parseInt(str1));
			getPecaTO().setNome(str2);
			getPecaTO().setQuantidade(Integer.parseInt(str3));
			getPecaTO().setTipo(getPanelCadPeca().getJcTipo().getSelectedItem().toString());
			getPecaTO().setEquipamento(getPanelCadPeca().getJcEquipamento().getSelectedItem().toString());
			getPecaTO().setFornecedor(getPanelCadPeca().getJcFornecedor().getSelectedItem().toString());
			getPecaControll().newPeca(getPecaTO());
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
		getPanelCadPeca().getJtCodigo().setText("");
		getPanelCadPeca().getJtNome().setText("");
		getPanelCadPeca().getJtQuantidade().setText("");
	}
}
