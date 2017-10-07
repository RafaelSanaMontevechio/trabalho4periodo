package br.edu.univas.si4.lab4.view.commonButtonsPanels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

import br.edu.univas.si4.lab4.interfaces.ButtonsListenerRelatorios;

public class ButtonsPanelRelatorio extends JPanel {

	private static final long serialVersionUID = 475371782583018355L;

	private JButton btNovo;
	private JButton btAlterar;
	private JButton btDeletar;
	private JButton btImprimir;

	private ArrayList<ButtonsListenerRelatorios> listeners = new ArrayList<>();

	public ButtonsPanelRelatorio() {
		setBorder(BorderFactory.createTitledBorder(""));
		addComponents();
	}

	public void addComponents() {
		add(getBtNovo());
		add(getBtAlterar());
		add(getBtDeletar());
		add(getBtImprimir());
	}

	public JButton getBtNovo() {
		if (btNovo == null) {
			btNovo = new JButton();
			btNovo.setText("Novo");
			btNovo.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					novoClicked();
				}
			});
		}
		return btNovo;
	}

	public JButton getBtAlterar() {
		if (btAlterar == null) {
			btAlterar = new JButton();
			btAlterar.setText("Alterar");
			btAlterar.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					alterarClicked();

				}
			});
		}
		return btAlterar;
	}

	public JButton getBtDeletar() {
		if (btDeletar == null) {
			btDeletar = new JButton();
			btDeletar.setText("Deletar");
			btDeletar.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					deletarClicked();

				}
			});
		}
		return btDeletar;
	}

	public JButton getBtImprimir() {
		if (btImprimir == null) {
			btImprimir = new JButton();
			btImprimir.setText("Imprimir");
			btImprimir.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					imprimirClicked();

				}
			});
		}
		return btImprimir;
	}

	public void addButtonsListenerRelatorios(ButtonsListenerRelatorios listener) {
		listeners.add(listener);
	}

	private void novoClicked() {
		for (ButtonsListenerRelatorios listener : listeners) {
			listener.novoPerformed();
		}
	}

	private void alterarClicked() {
		for (ButtonsListenerRelatorios listener : listeners) {
			listener.alterarPerformed();
		}
	}

	private void deletarClicked() {
		for (ButtonsListenerRelatorios listener : listeners) {
			listener.deletarPerformed();
		}
	}
	
	private void imprimirClicked() {
		for (ButtonsListenerRelatorios listener : listeners) {
			listener.imprimirPerformed();
		}
	}

}
