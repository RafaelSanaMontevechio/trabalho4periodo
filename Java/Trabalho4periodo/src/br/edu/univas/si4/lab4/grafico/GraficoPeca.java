package br.edu.univas.si4.lab4.grafico;

import java.awt.BorderLayout;

import javax.swing.JInternalFrame;

public class GraficoPeca extends JInternalFrame{

	private static final long serialVersionUID = 5397677075760892691L;
	
	public GraficoPeca() {
		setTitle("Grafico de peças");
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setLayout(new BorderLayout());
		setClosable(true);// Se o frame vai poder ser fechado pelo botão fechar
		setIconifiable(true);// Se o frame vai poder ser minimizado.
		setResizable(true);// Pemite editar o tamanho.
		setMaximizable(true);
		setBorder(null);
	}
}
