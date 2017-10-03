package br.edu.univas.si4.lab4.view;

import javax.swing.JOptionPane;

import br.edu.univas.si4.lab4.interfaces.ButtonsListenerRelatorios;

public class InternalFramePecas extends Comum {

	private static final long serialVersionUID = -6930334799958851725L;

	private static String[] columnNames = { "Codigo", "Nome   ", "Quantidade", "Tipo", "Equipamento", "Fornecedor  " };
	private static Object[][] tableData = {
			{ "001 ", "Teste 1", "        10", "Unidade", "Equipamento 1", "Fornecedor 1" } };

	public InternalFramePecas() {
		super("Consulta de peças em estoque", "Peças em estoque", columnNames, tableData);
	}

	@Override
	public ButtonsPanelRelatorio getButtonsPanelRelatorio() {
		if (buttonsPanelRelatorio == null) {
			buttonsPanelRelatorio = new ButtonsPanelRelatorio();
			buttonsPanelRelatorio.addButtonsListenerRelatorios(new ButtonsListenerRelatorios() {

				@Override
				public void novoPerformed() {
					JOptionPane.showMessageDialog(null, "Clicou botão novo - Tela pesquisa peças");

				}

				@Override
				public void listarPerformed() {
					JOptionPane.showMessageDialog(null, "Clicou botão listar - Tela pesquisa peças");

				}

				@Override
				public void imprimirPerformed() {
					JOptionPane.showMessageDialog(null, "Clicou botão imprimir - Tela pesquisa peças");

				}

				@Override
				public void deletarPerformed() {
					JOptionPane.showMessageDialog(null, "Clicou botão deletar - Tela pesquisa peças");

				}

				@Override
				public void alterarPerformed() {
					JOptionPane.showMessageDialog(null, "Clicou botão alterar - Tela pesquisa peças");

				}
			});
		}

		return buttonsPanelRelatorio;
	}
}
