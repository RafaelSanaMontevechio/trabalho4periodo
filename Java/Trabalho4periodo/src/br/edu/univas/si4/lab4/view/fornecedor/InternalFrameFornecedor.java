package br.edu.univas.si4.lab4.view.fornecedor;

import java.awt.BorderLayout;

import javax.swing.JOptionPane;

import br.edu.univas.si4.lab4.controller.FornecedorController;
import br.edu.univas.si4.lab4.interfaces.ButtonsListenerRelatorios;
import br.edu.univas.si4.lab4.interfaces.ButtonsListernerFiltroPesquisa;
import br.edu.univas.si4.lab4.view.Comum;
import br.edu.univas.si4.lab4.view.ButtonsPanels.ButtonsPanelRelatorio;

public class InternalFrameFornecedor extends Comum {

	private static final long serialVersionUID = 7818698877376614841L;

	private FornecedorController fornecedorControll;
	//private FrameCadastroFornecedor fCadFornecedor;
	private ButtonsPanelFiltroFornecedor buttonsFiltroFornecedor;

	public InternalFrameFornecedor() {
		super("Consulta de fornecedores cadastrados", "Fornecedores Cadastrados");

		add(getButtonsFiltroFornecedor(), BorderLayout.WEST);
		pack();
	}

	public FornecedorController getFornecedorControll() {
		if (fornecedorControll == null) {
			fornecedorControll = new FornecedorController();
		}
		return fornecedorControll;
	}

//	private FrameCadastroFornecedor getfCadFornecedor() {
//		if (fCadFornecedor == null) {
//			fCadFornecedor = new FrameCadastroFornecedor();
//			fCadFornecedor.setLocationRelativeTo(null);
//		}
//		return fCadFornecedor;
//	}

	@Override
	public ButtonsPanelRelatorio getButtonsPanelRelatorio() {
		if (buttonsPanelRelatorio == null) {
			buttonsPanelRelatorio = new ButtonsPanelRelatorio();
			buttonsPanelRelatorio.addButtonsListenerRelatorios(new ButtonsListenerRelatorios() {

				@Override
				public void novoPerformed() {
					getFornecedorControll().callScreenRegisterNewFornecedor();
				}

				@Override
				public void imprimirPerformed() {
					JOptionPane.showMessageDialog(null, "Clicou botão imprimir - Tela pesquisa fornecedor");

				}

				@Override
				public void deletarPerformed() {
					JOptionPane.showMessageDialog(null, "Clicou botão deletar - Tela pesquisa fornecedor");

				}

				@Override
				public void alterarPerformed() {
					JOptionPane.showMessageDialog(null, "Clicou botão alterar - Tela pesquisa fornecedor");

				}
			});
		}

		return buttonsPanelRelatorio;
	}

	private ButtonsPanelFiltroFornecedor getButtonsFiltroFornecedor() {
		if (buttonsFiltroFornecedor == null) {
			buttonsFiltroFornecedor = new ButtonsPanelFiltroFornecedor();
			buttonsFiltroFornecedor.addButtonsListenerFiltroPesquisa(new ButtonsListernerFiltroPesquisa() {

				@Override
				public void pesquisarPerformed() {
					pesquisarClicked();
				}
			});
		}
		return buttonsFiltroFornecedor;
	}

	private void pesquisarClicked() {
		if (buttonsFiltroFornecedor.getJrbCnpj().isSelected()) {

		} else if (buttonsFiltroFornecedor.getJrbRazao().isSelected()) {

		} else {
			getFornecedorControll().addData(this);
		}
	}
}
