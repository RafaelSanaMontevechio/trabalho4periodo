package br.edu.univas.si4.lab4.main;

import javax.swing.UIManager;

import br.edu.univas.si4.lab4.controller.PrincipalController;

public class MainTrabalho {

	public static void main(String[] args) {
		//
		// try {
		// UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		// new PrincipalController().initialize();
		// } catch (Throwable e) {
		// e.printStackTrace();
		// }

		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.graphite.GraphiteLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			new PrincipalController().initialize();
		}
	}
}
