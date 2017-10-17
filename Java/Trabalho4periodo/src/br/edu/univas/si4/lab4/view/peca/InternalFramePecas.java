package br.edu.univas.si4.lab4.view.peca;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JOptionPane;

import br.edu.univas.si4.lab4.controller.PecaController;
import br.edu.univas.si4.lab4.interfaces.ButtonsListenerRelatorios;
import br.edu.univas.si4.lab4.interfaces.ButtonsListernerFiltroPesquisa;
import br.edu.univas.si4.lab4.to.PecaTO;
import br.edu.univas.si4.lab4.view.Comum;
import br.edu.univas.si4.lab4.view.ButtonsPanels.ButtonsPanelFiltrosPesquisas;
import br.edu.univas.si4.lab4.view.ButtonsPanels.ButtonsPanelRelatorio;

public class InternalFramePecas extends Comum {

	private static final long serialVersionUID = -6930334799958851725L;

	private FrameCadastroPeca fCadPeca;
	private ButtonsPanelFiltrosPesquisas buttonsPanelPesquisa;

	public InternalFramePecas() {
		super("Consulta de peças em estoque", "Peças em estoque");

		add(getPanelFiltroPesquisas(), BorderLayout.WEST);
	}

	private FrameCadastroPeca getfCadPeca() {
		if (fCadPeca == null) {
			fCadPeca = new FrameCadastroPeca();
			fCadPeca.setLocationRelativeTo(null);
		}
		return fCadPeca;
	}

	@Override
	public ButtonsPanelRelatorio getButtonsPanelRelatorio() {
		if (buttonsPanelRelatorio == null) {
			buttonsPanelRelatorio = new ButtonsPanelRelatorio();
			buttonsPanelRelatorio.addButtonsListenerRelatorios(new ButtonsListenerRelatorios() {

				@Override
				public void novoPerformed() {
					getfCadPeca().setVisible(true);
				}

				@Override
				public void deletarPerformed() {

				}

				@Override
				public void alterarPerformed() {

				}

				@Override
				public void imprimirPerformed() {

				}
			});
		}

		return buttonsPanelRelatorio;
	}

	private ButtonsPanelFiltrosPesquisas getPanelFiltroPesquisas() {
		if (buttonsPanelPesquisa == null) {
			buttonsPanelPesquisa = new ButtonsPanelFiltrosPesquisas();
			buttonsPanelPesquisa.addButtonsListenerFiltroPesquisa(new ButtonsListernerFiltroPesquisa() {

				@Override
				public void pesquisarPerformed() {
					pesquisarClicked();
				}
			});
		}
		return buttonsPanelPesquisa;
	}

	private void pesquisarClicked() {
		if (buttonsPanelPesquisa.getJrbCodigo().isSelected()) {
			int codigo = Integer.parseInt(getPanelFiltroPesquisas().getJtDados().getText());
			new PecaController().addDataByCodigo(this, codigo);
			getPanelFiltroPesquisas().getJtDados().setText("");
		} else if (buttonsPanelPesquisa.getJrbNome().isSelected()) {
			String name = getPanelFiltroPesquisas().getJtDados().getText();
			new PecaController().addDataByName(this, name);
			getPanelFiltroPesquisas().getJtDados().setText("");
		} else if (buttonsPanelPesquisa.getJrbFornecedor().isSelected()) {
			String fornecedor = getPanelFiltroPesquisas().getJtDados().getText();
			new PecaController().addDataByFornecedor(this, fornecedor);
			getPanelFiltroPesquisas().getJtDados().setText("");
		} else if (buttonsPanelPesquisa.getJrbTodos().isSelected()) {
			new PecaController().addDataAll(this);
		} else {
			JOptionPane.showMessageDialog(null, "Nenhum filtro selecionado!");
		}
	}

	public void updateModelPecas(List<PecaTO> pecas) {
		TableModelPeca tmbPeca = new TableModelPeca(pecas);
		getTable().setModel(tmbPeca);
	}
}
