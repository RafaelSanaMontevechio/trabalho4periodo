package br.edu.univas.si4.lab4.view;

import javax.swing.JOptionPane;

import br.edu.univas.si4.lab4.interfaces.ButtonsListenerRelatorios;

public class InternalFrameFornecedor extends Comum {

	private static final long serialVersionUID = 7818698877376614841L;

	private static String[] columnNames = { "Nome/Razão", "CNPJ", "Nome Fantasia" };
	private static Object[][] tableData = { { "Fornecedor 1 LTDA", "11111111111111", "Fornecedor 1" } };

	public InternalFrameFornecedor() {
		super("Consulta de fornecedores cadastrados", "Fornecedores Cadastrados", columnNames, tableData);
	}

	@Override
	public ButtonsPanelRelatorio getButtonsPanelRelatorio() {
		if(buttonsPanelRelatorio == null){
			buttonsPanelRelatorio = new ButtonsPanelRelatorio();
			buttonsPanelRelatorio.addButtonsListenerRelatorios(new ButtonsListenerRelatorios() {

				@Override
				public void novoPerformed() {
					JOptionPane.showMessageDialog(null, "Clicou botão salvar - Tela pesquisa fornecedor");

				}

				@Override
				public void listarPerformed() {
					JOptionPane.showMessageDialog(null, "Clicou botão listar - Tela pesquisa fornecedor");

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

}
