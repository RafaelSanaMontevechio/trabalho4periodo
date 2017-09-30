package br.edu.univas.si4.lab4.view;


import javax.swing.JButton;
import javax.swing.JPanel;

public class ButtonsPanelCadastros extends JPanel{
	
	private JButton btSalvar;
	private JButton btCancelar;

	private static final long serialVersionUID = 8479718910353411028L;
	
	public ButtonsPanelCadastros() {
		addComponents();
	}
	
	private void addComponents(){
		add(getBtSalvar());
		add(getBtCancelar());
	}

	private JButton getBtSalvar() {
		if(btSalvar == null){
			btSalvar = new JButton();
			btSalvar.setText("Salvar");
		}
		return btSalvar;
	}

	private JButton getBtCancelar() {
		if(btCancelar == null ){
			btCancelar = new JButton();
			btCancelar.setText("Cancelar");
		}
		return btCancelar;
	}
}
