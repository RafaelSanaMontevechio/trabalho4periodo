package br.edu.univas.si4.lab4.view;

import javax.swing.JOptionPane;

import br.edu.univas.si4.lab4.interfaces.ButtonsListenerRelatorios;

public class InternalFrameEquipamentos extends Comum {

	private static final long serialVersionUID = 4727354562815126822L;
	
	private FrameFiltroPesquisas frameFiltros;

	private static String[] columnNames = { "Codigo", "Nome", "Quantidade", "Fornecedor" };
	private static Object[][] tableData = { { "90100123", "Equipamento 1", "20", "Fornecedor 1" } };

	public InternalFrameEquipamentos() {
		super("Consulta equipamentos em estoque", "Equipamentos cadastrados", columnNames, tableData);
	}

	@Override
	public ButtonsPanelRelatorio getButtonsPanelRelatorio() {
		if (buttonsPanelRelatorio == null) {
			buttonsPanelRelatorio = new ButtonsPanelRelatorio();
			buttonsPanelRelatorio.addButtonsListenerRelatorios(new ButtonsListenerRelatorios() {

				@Override
				public void novoPerformed() {
					JOptionPane.showMessageDialog(null, "Clicou botão novo - Tela pesquisa Equipamento");
				}

				@Override
				public void listarPerformed() {
					//JOptionPane.showMessageDialog(null, "Clicou botão listar - Tela pesquisa Equipamento");
					getFrameFiltros().setVisible(true);;
				}

				@Override
				public void imprimirPerformed() {
					JOptionPane.showMessageDialog(null, "Clicou botão imprimir - Tela pesquisa Equipamento");
				}

				@Override
				public void deletarPerformed() {
					JOptionPane.showMessageDialog(null, "Clicou botão deletar - Tela pesquisa Equipamento");
				}

				@Override
				public void alterarPerformed() {
					JOptionPane.showMessageDialog(null, "Clicou botão alterar - Tela pesquisa Equipamento");

				}
			});
		}
		return buttonsPanelRelatorio;
	}
	
	//Getter frame filtros
	
	private FrameFiltroPesquisas getFrameFiltros() {
		if (frameFiltros == null) {
			frameFiltros = new FrameFiltroPesquisas();
		}
		return frameFiltros;
	}
}
