package br.edu.univas.si4.lab4.grafico;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.toedter.calendar.JDateChooser;

import br.edu.univas.si4.lab4.interfaces.ButtonsListenerGrafico;

public class ButtonsPanelGraficos extends JPanel {

	private static final long serialVersionUID = -5265873060965545711L;

	private JLabel label1;
	private JLabel label2;
	private JDateChooser dataChooserInitial;
	private JDateChooser dataChooserEnd;
	private JButton jbGerar;

	private ArrayList<ButtonsListenerGrafico> listeners = new ArrayList<>();

	public ButtonsPanelGraficos() {
		setBorder(BorderFactory.createTitledBorder("Selecionar periodo"));
		addComponents();
	}

	public void addComponents() {
		add(getLabel1());
		add(getDataChooserInitial());
		add(getLabel2());
		add(getDataChooserEnd());
		add(getJbGerar());
	}

	public JLabel getLabel1() {
		if (label1 == null) {
			label1 = new JLabel("Data inicial:");
		}
		return label1;
	}

	public JLabel getLabel2() {
		if (label2 == null) {
			label2 = new JLabel("Data final:");
		}
		return label2;
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

	public JDateChooser getDataChooserInitial() {
		if (dataChooserInitial == null) {
			dataChooserInitial = new JDateChooser();
		}
		return dataChooserInitial;
	}

	public JDateChooser getDataChooserEnd() {
		if (dataChooserEnd == null) {
			dataChooserEnd = new JDateChooser();
		}
		return dataChooserEnd;
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
