package br.edu.univas.si4.lab4.view;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ButtonsPanelRelatorio extends JPanel {

	private static final long serialVersionUID = 475371782583018355L;

	private JButton btNovo;
	private JButton btAlterar;
	private JButton btDeletar;
	private JButton btListar;
	private JButton btImprimir;

	public ButtonsPanelRelatorio() {
		setBorder(BorderFactory.createTitledBorder(""));
		addComponents();
	}

	public void addComponents() {
		add(getBtNovo());
		add(getBtAlterar());
		add(getBtDeletar());
		add(getBtListar());
		add(getBtImprimir());
	}

	public JButton getBtNovo() {
		if (btNovo == null) {
			btNovo = new JButton();
			btNovo.setText("Novo");
		}
		return btNovo;
	}

	public JButton getBtAlterar() {
		if (btAlterar == null) {
			btAlterar = new JButton();
			btAlterar.setText("Alterar");
		}
		return btAlterar;
	}

	public JButton getBtDeletar() {
		if (btDeletar == null) {
			btDeletar = new JButton();
			btDeletar.setText("Deletar");
		}
		return btDeletar;
	}

	public JButton getBtListar() {
		if (btListar == null) {
			btListar = new JButton();
			btListar.setText("Buscar");
		}
		return btListar;
	}

	public JButton getBtImprimir() {
		if (btImprimir == null) {
			btImprimir = new JButton();
			btImprimir.setText("Imprimir");
		}
		return btImprimir;
	}

}
