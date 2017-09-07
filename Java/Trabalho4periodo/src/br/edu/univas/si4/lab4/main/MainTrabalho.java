package br.edu.univas.si4.lab4.main;

import javax.swing.UIManager;

import br.edu.univas.si4.lab4.view.Principal;

public class MainTrabalho {

	public static void main(String[] args) {

		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}

		Principal tela = new Principal();
		tela.setVisible(true);

	}
}
