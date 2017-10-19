package br.edu.univas.si4.lab4.view.equipamento;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JOptionPane;

import br.edu.univas.si4.lab4.controller.EquipamentoController;
import br.edu.univas.si4.lab4.interfaces.ButtonsListenerRelatorios;
import br.edu.univas.si4.lab4.interfaces.ButtonsListernerFiltroPesquisa;
import br.edu.univas.si4.lab4.to.EquipamentoTO;
import br.edu.univas.si4.lab4.view.Comum;
import br.edu.univas.si4.lab4.view.ButtonsPanels.ButtonsPanelFiltrosPesquisas;
import br.edu.univas.si4.lab4.view.ButtonsPanels.ButtonsPanelRelatorio;

public class InternalFrameEquipamentos extends Comum {

	private static final long serialVersionUID = 4727354562815126822L;

	private ButtonsPanelFiltrosPesquisas buttonsPanelPesquisa;
	private EquipamentoController equipamentoControll;

	public InternalFrameEquipamentos() {
		super("Consulta equipamentos em estoque", "Equipamentos cadastrados");

		add(getPanelFiltroPesquisas(), BorderLayout.WEST);
	}

	public EquipamentoController getEquipamentoControll() {
		if (equipamentoControll == null) {
			equipamentoControll = new EquipamentoController();
		}
		return equipamentoControll;
	}

	@Override
	public ButtonsPanelRelatorio getButtonsPanelRelatorio() {
		if (buttonsPanelRelatorio == null) {
			buttonsPanelRelatorio = new ButtonsPanelRelatorio();
			buttonsPanelRelatorio.addButtonsListenerRelatorios(new ButtonsListenerRelatorios() {

				@Override
				public void novoPerformed() {
					getEquipamentoControll().callRegisterNewEquipamento();
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

				}
			});
		}
		return buttonsPanelRelatorio;
	}

	// Getter frame filtros

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
		if (getPanelFiltroPesquisas().getJrbCodigo().isSelected()) {
			jrbCodigoSelected();
		} else if (getPanelFiltroPesquisas().getJrbNome().isSelected()) {
			jrbNomeSelected();
		} else if (getPanelFiltroPesquisas().getJrbFornecedor().isSelected()) {
			jrbFornecedorSelected();
		} else if (getPanelFiltroPesquisas().getJrbTodos().isSelected()) {
			getEquipamentoControll().addDataAll(this);
		} else {
			JOptionPane.showMessageDialog(null, "Nenhum filtro selecionado!", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void jrbCodigoSelected() {
		String str = getPanelFiltroPesquisas().getJtDados().getText();
		if (verifyEmptyString(str)) {
			getEquipamentoControll().addDataByCodigo(this, str);
			getPanelFiltroPesquisas().getJtDados().setText("");
		} else {
			JOptionPane.showMessageDialog(null, "Código não informado!", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void jrbNomeSelected() {
		String str = getPanelFiltroPesquisas().getJtDados().getText();
		if (verifyEmptyString(str)) {
			getEquipamentoControll().addDataByName(this, str);
			getPanelFiltroPesquisas().getJtDados().setText("");
		} else {
			JOptionPane.showMessageDialog(null, "Nome não informado!", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void jrbFornecedorSelected() {
		String str = getPanelFiltroPesquisas().getJtDados().getText();
		if (verifyEmptyString(str)) {
			getEquipamentoControll().addDataByFornecedor(this, str);
			getPanelFiltroPesquisas().getJtDados().setText("");
		} else {
			JOptionPane.showMessageDialog(null, "Fornecedor não informado!", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void deleteClicked() {
		Object obj = getTable().getValueAt(getTable().getSelectedRow(), 0);
		String codigo = String.valueOf(obj);

		new EquipamentoController().removeEquipamento(codigo);
	}

	public void updateModelEquipamento(List<EquipamentoTO> list) {
		TableModelEquipamento tmEquipamento = new TableModelEquipamento(list);
		getTable().setModel(tmEquipamento);
		getTable().getColumnModel().getColumn(0).setPreferredWidth(20);
		getTable().getColumnModel().getColumn(1).setPreferredWidth(450);
		getTable().getColumnModel().getColumn(2).setPreferredWidth(20);
		getTable().getColumnModel().getColumn(3).setPreferredWidth(20);
	}
}
