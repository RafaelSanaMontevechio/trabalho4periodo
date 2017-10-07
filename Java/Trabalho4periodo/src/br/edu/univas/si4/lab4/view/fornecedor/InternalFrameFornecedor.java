package br.edu.univas.si4.lab4.view.fornecedor;

import java.awt.BorderLayout;

import javax.swing.JOptionPane;

import br.edu.univas.si4.lab4.interfaces.ButtonsListenerRelatorios;
import br.edu.univas.si4.lab4.interfaces.ButtonsListernerFiltroPesquisa;
import br.edu.univas.si4.lab4.view.Comum;
import br.edu.univas.si4.lab4.view.commonButtonsPanels.ButtonsPanelRelatorio;

public class InternalFrameFornecedor extends Comum {

	private static final long serialVersionUID = 7818698877376614841L;

	private FrameCadastroFornecedor fCadFornecedor;
	private ButtonsPanelFiltroFornecedor buttonsFiltroFornecedor;

	private static String[] columnNames = { "Nome/Razão", "CNPJ", "Nome Fantasia" };
	private static Object[][] tableData = { { "Fornecedor 1 LTDA", "11111111111111", "Fornecedor 1" } };

	public InternalFrameFornecedor() {
		super("Consulta de fornecedores cadastrados", "Fornecedores Cadastrados", columnNames, tableData);

		add(getButtonsFiltroFornecedor(), BorderLayout.WEST);
		pack();
	}

	private FrameCadastroFornecedor getfCadFornecedor() {
		if (fCadFornecedor == null) {
			fCadFornecedor = new FrameCadastroFornecedor();
			fCadFornecedor.setLocationRelativeTo(null);
		}
		return fCadFornecedor;
	}

	@Override
	public ButtonsPanelRelatorio getButtonsPanelRelatorio() {
		if (buttonsPanelRelatorio == null) {
			buttonsPanelRelatorio = new ButtonsPanelRelatorio();
			buttonsPanelRelatorio.addButtonsListenerRelatorios(new ButtonsListenerRelatorios() {

				@Override
				public void novoPerformed() {
					getfCadFornecedor().setVisible(true);
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
			String cnpj = buttonsFiltroFornecedor.getJtDados().getText();
			JOptionPane.showMessageDialog(null, "Filtro: CNPJ - " + cnpj);
		} else if(buttonsFiltroFornecedor.getJrbRazao().isSelected()){
			String razao = buttonsFiltroFornecedor.getJtDados().getText();
			JOptionPane.showMessageDialog(null, "Filtro: Razão - " + razao);
		}else{
			JOptionPane.showMessageDialog(null, "Filtro: Todos foi selecionado! ");
		}
	}
}
