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
	private PecaController pecaControll;

	public InternalFramePecas() {
		super("Consulta de peças em estoque", "Peças em estoque");
		
		pecaControll = new PecaController();

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
					deleteClicked();
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
			jrbCodigoSelected();
		} else if (buttonsPanelPesquisa.getJrbNome().isSelected()) {
			jrbNomeSelected();
		} else if (buttonsPanelPesquisa.getJrbFornecedor().isSelected()) {
			jrbFornecedorSelected();
		} else if (buttonsPanelPesquisa.getJrbTodos().isSelected()) {
			pecaControll.addDataAll(this);
		} else {
			JOptionPane.showMessageDialog(null, "Nenhum filtro selecionado!");
		}
	}
	
	private void jrbCodigoSelected() {
		String str = getPanelFiltroPesquisas().getJtDados().getText();
		if(verifyEmptyString(str)) {
			pecaControll.addDataByCodigo(this,str);
			clearText();
		}else {
			JOptionPane.showMessageDialog(null, "Código não informado!", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void jrbNomeSelected() {
		String str = getPanelFiltroPesquisas().getJtDados().getText();
		if(verifyEmptyString(str)) {
			pecaControll.addDataByName(this,str);
			clearText();
		}else {
			JOptionPane.showMessageDialog(null, "Nome não informado!", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void jrbFornecedorSelected() {
		String str = getPanelFiltroPesquisas().getJtDados().getText();
		if(verifyEmptyString(str)) {
			pecaControll.addDataByFornecedor(this,str);
			clearText();
		}else {
			JOptionPane.showMessageDialog(null, "Fornecedor não informado!", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void deleteClicked() {
		Object obj = getTable().getValueAt(getTable().getSelectedRow(), 0);
		String codigo = String.valueOf(obj);
		pecaControll.removePeca(codigo);
	}

	public void updateModelPecas(List<PecaTO> pecas) {
		TableModelPeca tmbPeca = new TableModelPeca(pecas);
		getTable().setModel(tmbPeca);
		getTable().getColumnModel().getColumn(0).setPreferredWidth(10);
		getTable().getColumnModel().getColumn(1).setPreferredWidth(450);
		getTable().getColumnModel().getColumn(2).setPreferredWidth(20);
		getTable().getColumnModel().getColumn(3).setPreferredWidth(20);
		getTable().getColumnModel().getColumn(4).setPreferredWidth(20);
		getTable().getColumnModel().getColumn(5).setPreferredWidth(20);
	}
	
	private void clearText() {
		getPanelFiltroPesquisas().getJtDados().setText("");
	}
}
