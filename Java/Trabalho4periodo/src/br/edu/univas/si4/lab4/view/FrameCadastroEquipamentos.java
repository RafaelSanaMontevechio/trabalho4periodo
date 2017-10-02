package br.edu.univas.si4.lab4.view;

import java.awt.BorderLayout;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import br.edu.univas.si4.lab4.interfaces.ButtonsListener;

public class FrameCadastroEquipamentos extends JDialog {

	private static final long serialVersionUID = 6411516047271744522L;

	private PanelCadastroEquipamento panelCadEquipamento;
	private ButtonsPanelCadastros buttonsCadastro;

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
		JOptionPane.showMessageDialog(null, "Clicou botão salvar - Tela cadastro equipamento");
	}

	private void cancelarClicked() {
		JOptionPane.showMessageDialog(null, "Clicou botão cancelar - Tela cadastro equipamento");
	}

}
