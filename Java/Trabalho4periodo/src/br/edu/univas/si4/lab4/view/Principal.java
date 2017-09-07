package br.edu.univas.si4.lab4.view;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;

public class Principal extends JFrame {

	private static final long serialVersionUID = 1383006107346794163L;

	private JDesktopPane desktopPane;

	public Principal() {
		this.setSize(900, 600);
		//this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("::Controle de estoque::");
		this.setLocationRelativeTo(null);
		this.setResizable(true);
		setJMenuBar(new JmenuBar(this));
		addComponents();
	}

	public void addComponents() {
		desktopPane = new JDesktopPane();
		setContentPane(desktopPane);
	}

	public void addInternalFrame(JInternalFrame iframe) {
		desktopPane.add(iframe);
	}
	
	public void mazimizeFrame(JInternalFrame iframe){
		desktopPane.getDesktopManager().maximizeFrame(iframe);
	}
}
