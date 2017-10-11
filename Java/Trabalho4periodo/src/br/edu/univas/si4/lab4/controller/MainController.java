package br.edu.univas.si4.lab4.controller;

import br.edu.univas.si4.lab4.view.Principal;

public class MainController {
	
	private Principal principal;
	
	public MainController(Principal principal) {
		this.principal = principal;	
	}
	
	public void showMainScreen() {
		principal.setVisible(true);
	}
}
