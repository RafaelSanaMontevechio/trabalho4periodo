package br.edu.univas.si4.lab4.view.equipamento;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import br.edu.univas.si4.lab4.controller.FornecedorController;

public class SpyWindow extends WindowAdapter {

	private FornecedorController fornecedorControll;
	private PanelCadastroEquipamento panelCadEquipamento;

	public void windowOpened(WindowEvent e) {
		System.out.println("A janela abriu!!! estamos espiado!" + e.getSource().getClass().getSimpleName());

		ArrayList<String> fantasia = getFornecedorControll().listaFantasia();
		fantasia = getFornecedorControll().listaFantasia();

		for (String string : fantasia) {
			getPanelCadEquipamento().getComboForncedores().addItem(string);
		}

		for (String string : fantasia) {
			System.out.println(string);
		}

	}

	public FornecedorController getFornecedorControll() {
		if (fornecedorControll == null) {
			fornecedorControll = new FornecedorController();
		}
		return fornecedorControll;
	}

	public PanelCadastroEquipamento getPanelCadEquipamento() {
		if (panelCadEquipamento == null) {
			panelCadEquipamento = new PanelCadastroEquipamento();
		}
		return panelCadEquipamento;
	}
}
