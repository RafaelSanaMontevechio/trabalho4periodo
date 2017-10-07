package br.edu.univas.si4.lab4.view.commonButtonsPanels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

import br.edu.univas.si4.lab4.interfaces.ButtonsListener;

public class ButtonsPanelCadastros extends JPanel {
	
	private static final long serialVersionUID = 8479718910353411028L;

	private JButton btSalvar;
	private JButton btCancelar;

	private ArrayList<ButtonsListener> listeners = new ArrayList<>();

	public ButtonsPanelCadastros() {
		addComponents();
	}

	private void addComponents() {
		add(getBtSalvar());
		add(getBtCancelar());
	}

	private JButton getBtSalvar() {
		if (btSalvar == null) {
			btSalvar = new JButton();
			btSalvar.setText("Salvar");
			btSalvar.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					salvarClicked();
				}
			});
		}
		return btSalvar;
	}

	private JButton getBtCancelar() {
		if (btCancelar == null) {
			btCancelar = new JButton();
			btCancelar.setText("Cancelar");
			btCancelar.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					cancelarClicked();
				}
			});
		}
		return btCancelar;
	}

	public void addButtonsListener(ButtonsListener listener) {
		listeners.add(listener);
	}

	private void salvarClicked() {
		for (ButtonsListener listener : listeners) {
			listener.salvarPerformed();
		}
	}

	private void cancelarClicked() {
		for (ButtonsListener listener : listeners) {
			listener.cancelarPerformed();
		}
	}
}
