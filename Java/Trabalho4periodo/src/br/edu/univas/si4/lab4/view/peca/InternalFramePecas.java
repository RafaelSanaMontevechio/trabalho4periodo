package br.edu.univas.si4.lab4.view.peca;

import java.awt.BorderLayout;

import javax.swing.JOptionPane;

import br.edu.univas.si4.lab4.interfaces.ButtonsListenerRelatorios;
import br.edu.univas.si4.lab4.interfaces.ButtonsListernerFiltroPesquisa;
import br.edu.univas.si4.lab4.view.Comum;
import br.edu.univas.si4.lab4.view.ButtonsPanels.ButtonsPanelFiltrosPesquisas;
import br.edu.univas.si4.lab4.view.ButtonsPanels.ButtonsPanelRelatorio;

public class InternalFramePecas extends Comum {

	private static final long serialVersionUID = -6930334799958851725L;

	private FrameCadastroPeca fCadPeca;
	private ButtonsPanelFiltrosPesquisas buttonsPanelPesquisa;

	private static String[] columnNames = { "Codigo", "Nome   ", "Quantidade", "Tipo", "Equipamento", "Fornecedor  " };
	private static Object[][] tableData = {
			{ "001 ", "Teste 1", "        10", "Unidade", "Equipamento 1", "Fornecedor 1" } };

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
					JOptionPane.showMessageDialog(null, "Clicou botão deletar - Tela pesquisa peças");

				}

				@Override
				public void alterarPerformed() {
					JOptionPane.showMessageDialog(null, "Clicou botão alterar - Tela pesquisa peças");

				}

				@Override
				public void imprimirPerformed() {
					// TODO Auto-generated method stub

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
			JOptionPane.showMessageDialog(null, "Filto: Código selecionado! - Peça");
		} else if (buttonsPanelPesquisa.getJrbNome().isSelected()) {
			JOptionPane.showMessageDialog(null, "Filto: Nome selecionado!");
		} else if (buttonsPanelPesquisa.getJrbFornecedor().isSelected()) {
			JOptionPane.showMessageDialog(null, "Filto: Fornecedor selecionado!");
		} else {
			JOptionPane.showMessageDialog(null, "Filto: Todos selecionado!");
		}
	}
}
