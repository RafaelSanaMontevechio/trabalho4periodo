package br.edu.univas.si4.lab4.controller;

import br.edu.univas.si4.lab4.view.Principal;

public class PrincipalController {
	
	private Principal principal;
	
	public PrincipalController() {
		principal = new Principal();
	}
	
	public void initialize() {
		principal.setVisible(true);
	}
}
