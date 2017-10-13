package br.edu.univas.si4.lab4.view.equipamento;

import java.awt.BorderLayout;

import javax.swing.JOptionPane;

import br.edu.univas.si4.lab4.controller.EquipamentoController;
import br.edu.univas.si4.lab4.interfaces.ButtonsListenerRelatorios;
import br.edu.univas.si4.lab4.interfaces.ButtonsListernerFiltroPesquisa;
import br.edu.univas.si4.lab4.view.Comum;
import br.edu.univas.si4.lab4.view.ButtonsPanels.ButtonsPanelFiltrosPesquisas;
import br.edu.univas.si4.lab4.view.ButtonsPanels.ButtonsPanelRelatorio;

public class InternalFrameEquipamentos extends Comum {

	private static final long serialVersionUID = 4727354562815126822L;

	private FrameCadastroEquipamentos fCadEquipamentos;
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

	private FrameCadastroEquipamentos getfCadEquipamentos() {
		if (fCadEquipamentos == null) {
			fCadEquipamentos = new FrameCadastroEquipamentos();
			fCadEquipamentos.setLocationRelativeTo(null);
		}
		return fCadEquipamentos;
	}

	@Override
	public ButtonsPanelRelatorio getButtonsPanelRelatorio() {
		if (buttonsPanelRelatorio == null) {
			buttonsPanelRelatorio = new ButtonsPanelRelatorio();
			buttonsPanelRelatorio.addButtonsListenerRelatorios(new ButtonsListenerRelatorios() {

				@Override
				public void novoPerformed() {
					getfCadEquipamentos().setVisible(true);
				}

				@Override
				public void imprimirPerformed() {
					
				}

				@Override
				public void deletarPerformed() {
					
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
		if (buttonsPanelPesquisa.getJrbCodigo().isSelected()) {
			
		} else if (buttonsPanelPesquisa.getJrbNome().isSelected()) {
			JOptionPane.showMessageDialog(null, "Filto: Nome selecionado!");
		} else if (buttonsPanelPesquisa.getJrbFornecedor().isSelected()) {
			JOptionPane.showMessageDialog(null, "Filto: Fornecedor selecionado!");
		} else if (buttonsPanelPesquisa.getJrbTodos().isSelected()) {
			getEquipamentoControll().addData(this);
		}else {
			JOptionPane.showMessageDialog(null, "Nenhum filtro selecionado!", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

}
