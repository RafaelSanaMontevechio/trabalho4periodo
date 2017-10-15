package br.edu.univas.si4.lab4.view.peca;

import java.awt.BorderLayout;

import javax.swing.JDialog;

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
		getPecaTO().setCodigo(Integer.parseInt(getPanelCadPeca().getJtCodigo().getText()));
		getPecaTO().setNome(getPanelCadPeca().getJtNome().getText());
		getPecaTO().setQuantidade(Integer.parseInt(getPanelCadPeca().getJtQuantidade().getText()));
		getPecaTO().setTipo(getPanelCadPeca().getJcTipo().getSelectedItem().toString());
		getPecaTO().setEquipamento(getPanelCadPeca().getJcEquipamento().getSelectedItem().toString());
		getPecaTO().setFornecedor(getPanelCadPeca().getJcFornecedor().getSelectedItem().toString());
		
		getPecaControll().newPeca(getPecaTO());
	}

	private void cancelarClicked() {
		this.dispose();
	}

}
