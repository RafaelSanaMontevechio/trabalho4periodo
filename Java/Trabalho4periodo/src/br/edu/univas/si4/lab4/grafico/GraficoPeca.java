package br.edu.univas.si4.lab4.grafico;

import java.awt.BorderLayout;

import javax.swing.JInternalFrame;

import br.edu.univas.si4.lab4.interfaces.ButtonsListenerGrafico;

public class GraficoPeca extends JInternalFrame {

	private static final long serialVersionUID = 5397677075760892691L;

	private ButtonsPanelGraficos buttonsGrafico;

	public GraficoPeca() {
		setTitle("Gr�fico de saida de pe�as");
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setLayout(new BorderLayout());
		setClosable(true);// Se o frame vai poder ser fechado pelo bot�o fechar
		setIconifiable(true);// Se o frame vai poder ser minimizado.
		setResizable(true);// Pemite editar o tamanho.
		setMaximizable(true);
		setBorder(null);

		add(getButtonsGrafico(), BorderLayout.SOUTH);
	}

	public ButtonsPanelGraficos getButtonsGrafico() {
		if (buttonsGrafico == null) {
			buttonsGrafico = new ButtonsPanelGraficos();
			buttonsGrafico.addButtonsListenerGrafico(new ButtonsListenerGrafico() {

				@Override
				public void gerarPerformed() {
					gerarClicked();
				}
			});
		}
		return buttonsGrafico;
	}

	private void gerarClicked() {
		// TODO : Implementar
	}
}
