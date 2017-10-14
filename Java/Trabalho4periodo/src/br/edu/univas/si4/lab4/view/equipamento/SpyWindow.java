package br.edu.univas.si4.lab4.view.equipamento;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import br.edu.univas.si4.lab4.controller.FornecedorController;

public class SpyWindow extends WindowAdapter {

	private FornecedorController fornecedorControll;
	private PanelCadastroEquipamento panelCadEquipamento;

	public SpyWindow() {
		fornecedorControll = new FornecedorController();
		panelCadEquipamento = new PanelCadastroEquipamento();
	}

	public void windowOpened(WindowEvent e) {
		System.out.println("A janela abriu!!! estamos espiado!" + e.getSource().getClass().getSimpleName());

		ArrayList<String> fantasia = fornecedorControll.listaFantasia();
		fantasia = fornecedorControll.listaFantasia();

		for (String string : fantasia) {
			panelCadEquipamento.getComboForncedores().addItem(string);
		}

		for (String string : fantasia) {
			System.out.println(string);
		}
	}
}
