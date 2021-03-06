package br.edu.univas.si4.lab4.view.fornecedor;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JOptionPane;

import br.edu.univas.si4.lab4.controller.FornecedorController;
import br.edu.univas.si4.lab4.interfaces.ButtonsListenerRelatorios;
import br.edu.univas.si4.lab4.interfaces.ButtonsListernerFiltroPesquisa;
import br.edu.univas.si4.lab4.to.FornecedorTO;
import br.edu.univas.si4.lab4.view.Comum;
import br.edu.univas.si4.lab4.view.ButtonsPanels.ButtonsPanelRelatorio;

public class InternalFrameFornecedor extends Comum {

	private static final long serialVersionUID = 7818698877376614841L;

	private FornecedorController fornecedorControll;
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

				}

				@Override
				public void deletarPerformed() {
					deleteClicked();
				}

				@Override
				public void alterarPerformed() {
					alterarClicked();
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
			jrbCnpjSelected();
		} else if (buttonsFiltroFornecedor.getJrbRazao().isSelected()) {
			jrbRazaoSelected();
		} else if (buttonsFiltroFornecedor.getJrbTodos().isSelected()) {
			jrbTodosSelected();
		} else {
			JOptionPane.showMessageDialog(null, "Nenhum filtro selecionado!", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void deleteClicked() {
		// Captura o valor da coluna selecionada pelo usuario
		Object obj = getTable().getValueAt(getTable().getSelectedRow(), 0);
		String str = String.valueOf(obj);

		new FornecedorController().removeFornecedor(str);
	}

	private void alterarClicked() {
		// TODO : Implementar
	}

	private void jrbCnpjSelected() {

		String str = (buttonsFiltroFornecedor.getJtDados().getText());
		if (str.length() != 14) {
			JOptionPane.showMessageDialog(null, "CNPJ deve ter 14 digitos", "Error", JOptionPane.ERROR_MESSAGE);
		} else {
			if (verifyEmptyString(str)) {
				getFornecedorControll().addDatabyCnpj(this, str);
				buttonsFiltroFornecedor.getJtDados().setText("");
			} else {
				JOptionPane.showMessageDialog(null, "CNPJ n�o informado", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	private void jrbRazaoSelected() {

		String str = (buttonsFiltroFornecedor.getJtDados().getText());
		if (verifyEmptyString(str)) {
			getFornecedorControll().addDataByRazao(this, str);
			buttonsFiltroFornecedor.getJtDados().setText("");
		} else {
			JOptionPane.showMessageDialog(null, "Raz�o social n�o informada!", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void jrbTodosSelected() {
		getFornecedorControll().addDataAll(this);
	}

	public void updateModel(List<FornecedorTO> list) {
		TableModelFornecedor tmFornecedor = new TableModelFornecedor(list);
		getTable().setModel(tmFornecedor);
		getTable().getColumnModel().getColumn(0).setPreferredWidth(20);
		getTable().getColumnModel().getColumn(1).setPreferredWidth(570);
		getTable().getColumnModel().getColumn(2).setPreferredWidth(30);
	}

}
