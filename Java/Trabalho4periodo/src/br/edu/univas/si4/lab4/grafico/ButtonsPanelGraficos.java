package br.edu.univas.si4.lab4.grafico;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.edu.univas.si4.lab4.interfaces.ButtonsListenerGrafico;

public class ButtonsPanelGraficos extends JPanel {

	private static final long serialVersionUID = -5265873060965545711L;

	private JButton jbGerar;

	private ArrayList<ButtonsListenerGrafico> listeners = new ArrayList<>();

	public ButtonsPanelGraficos() {
		setBorder(new EmptyBorder(10, 10, 10, 10));
		addComponents();
	}

	public void addComponents() {
		add(getJbGerar());
	}

	public JButton getJbGerar() {
		if (jbGerar == null) {
			jbGerar = new JButton();
			jbGerar.setText("Gerar gráfico");
			jbGerar.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					gerarClicked();

				}
			});
		}
		return jbGerar;
	}

	public void addButtonsListenerGrafico(ButtonsListenerGrafico listener) {
		listeners.add(listener);
	}

	private void gerarClicked() {
		for (ButtonsListenerGrafico listener : listeners) {
			listener.gerarPerformed();
		}
	}
}
