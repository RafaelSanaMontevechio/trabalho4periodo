package br.edu.univas.si4.lab4.view;

import java.awt.BorderLayout;

import javax.swing.JInternalFrame;

public class Comum extends JInternalFrame {

	private static final long serialVersionUID = 7859729951608406473L;

	public Comum(String title) {
		setTitle(title);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setLayout(new BorderLayout());
		setClosable(true);// Se o frame vai poder ser fechado pelo botão fechar
		setIconifiable(true);// Se o frame vai poder ser minimizado.
		setResizable(true);// Pemite editar o tamanho.
		setMaximizable(true);
		setBorder(null);

	}
}