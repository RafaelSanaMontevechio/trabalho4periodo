package br.edu.univas.si4.lab4.view.fornecedor;

import java.awt.BorderLayout;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.edu.univas.si4.lab4.controller.FornecedorController;
import br.edu.univas.si4.lab4.dao.FornecedorDao;
import br.edu.univas.si4.lab4.interfaces.ButtonsListenerRelatorios;
import br.edu.univas.si4.lab4.interfaces.ButtonsListernerFiltroPesquisa;
import br.edu.univas.si4.lab4.to.FornecedorTO;
import br.edu.univas.si4.lab4.view.Comum;
import br.edu.univas.si4.lab4.view.ButtonsPanels.ButtonsPanelRelatorio;

public class InternalFrameFornecedor extends Comum {

	private static final long serialVersionUID = 7818698877376614841L;

	private FrameCadastroFornecedor fCadFornecedor;
	private ButtonsPanelFiltroFornecedor buttonsFiltroFornecedor;
	static TableModelFornecedor tmFornecedor;

	public InternalFrameFornecedor() {
		super("Consulta de fornecedores cadastrados", "Fornecedores Cadastrados");

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

		} else if (buttonsFiltroFornecedor.getJrbRazao().isSelected()) {

		} else {

//			List<FornecedorTO> fornecedores = new ArrayList<FornecedorTO>();
//			try {
//				fornecedores = new FornecedorDao().listAllFornecedores();
//				for (FornecedorTO fornecedor : fornecedores) {
//					System.out.println(fornecedor.getCnpj() + " - " + fornecedor.getNomeRazao() + " - "
//							+ fornecedor.getFantasia() + "\n");
//				}
//			} catch (SQLException e) {
//				System.out.println("Erro!");
//				e.printStackTrace();
//			}
			List<FornecedorTO> fornecedores = new ArrayList<FornecedorTO>();
			try {
				fornecedores = new FornecedorDao().listAllFornecedores();
				this.updateModel(fornecedores);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
