package br.edu.univas.si4.lab4.main;

import javax.swing.UIManager;

import br.edu.univas.si4.lab4.controller.PrincipalController;

public class MainTrabalho {

	public static void main(String[] args) {

		// try {
		// UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		// } catch (Throwable e) {
		// e.printStackTrace();
		// }

		try {
			// select Look and Feel
			UIManager.setLookAndFeel("com.jtattoo.plaf.graphite.GraphiteLookAndFeel");
			
			new PrincipalController().initialize();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
