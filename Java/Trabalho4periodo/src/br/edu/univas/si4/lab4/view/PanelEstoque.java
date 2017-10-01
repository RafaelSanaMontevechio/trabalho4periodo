package br.edu.univas.si4.lab4.view;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class PanelEstoque extends JPanel {

	private static final long serialVersionUID = 415555295843769004L;

	private JLabel jLabelInfo;
	private JLabel jlEquipamento;
	private JLabel jlPeca;
	private JLabel jlCodigo;
	private JLabel jlQuantidade;
	private JLabel jlRetirar;
	private JLabel jlAdicionar;
	private JTextField jtCodigo;
	private JTextField jtQuantidade;
	private JRadioButton jrbEquipamento;
	private JRadioButton jrbPeca;
	private JRadioButton jrbRetirar;
	private JRadioButton jrbAdicionar;

	private GridBagConstraints jLabelInfoConstraints;
	private GridBagConstraints jlEquipamentoConstraints;
	private GridBagConstraints jlPecaConstraints;
	private GridBagConstraints jlCodigoConstraints;
	private GridBagConstraints jlQuantidadeConstraints;
	private GridBagConstraints jlRetirarConstraints;
	private GridBagConstraints jlAdicionarConstraints;
	private GridBagConstraints jtCodigoConstraints;
	private GridBagConstraints jtQuantidadeConstraints;
	private GridBagConstraints jrbEquipamentoConstraints;
	private GridBagConstraints jrbPecaConstraints;
	private GridBagConstraints jrbRetirarConstraints;
	private GridBagConstraints jrbAdicionarConstraints;

	public PanelEstoque() {
		addComponents();
	}

	private void addComponents() {
		setBorder(new EmptyBorder(10, 10, 10, 10));
		setLayout(new GridBagLayout());

		add(getjLabelInfo(), getjLabelInfoConstraints());
		
		add(getJrbAdicionar(), getJrbAdicionarConstraints());
		add(getJlAdicionar(), getJlAdicionarConstraints());
		
		add(getJrbRetirar(), getJrbRetirarConstraints());
		add(getJlRetirar(), getJlRetirarConstraints());
		
		add(getJrbEquipamento(), getJrbEquipamentoConstraints());
		add(getJlEquipamento(), getJlEquipamentoConstraints());
		
		add(getJrbPeca(), getJrbPecaConstraints());
		add(getJlPeca(), getJlPecaConstraints());
		
		add(getJlCodigo(), getJlCodigoConstraints());
		add(getJtCodigo(), getJtCodigoConstraints());
		
		add(getJlQuantidade(), getJlQuantidadeConstraints());
		add(getJtQuantidade(), getJtQuantidadeConstraints());
	}

	public JLabel getjLabelInfo() {
		if (jLabelInfo == null) {
			jLabelInfo = new JLabel();
			jLabelInfo.setText("Selecione as opções desejadas");
			jLabelInfo.setFont(new Font("SansSerif", Font.PLAIN, 17));
		}
		return jLabelInfo;
	}

	public JLabel getJlEquipamento() {
		if (jlEquipamento == null) {
			jlEquipamento = new JLabel();
			jlEquipamento.setText("Equipamento");
		}
		return jlEquipamento;
	}

	public JLabel getJlPeca() {
		if (jlPeca == null) {
			jlPeca = new JLabel();
			jlPeca.setText("Peça");
		}
		return jlPeca;
	}

	public JLabel getJlCodigo() {
		if (jlCodigo == null) {
			jlCodigo = new JLabel();
			jlCodigo.setText("Codigo:");
		}
		return jlCodigo;
	}

	public JLabel getJlQuantidade() {
		if (jlQuantidade == null) {
			jlQuantidade = new JLabel();
			jlQuantidade.setText("Quantidade:");
		}

		return jlQuantidade;
	}

	public JLabel getJlRetirar() {
		if (jlRetirar == null) {
			jlRetirar = new JLabel();
			jlRetirar.setText("Retirar");
		}
		return jlRetirar;
	}

	public JLabel getJlAdicionar() {
		if (jlAdicionar == null) {
			jlAdicionar = new JLabel();
			jlAdicionar.setText("Adicionar");
		}
		return jlAdicionar;
	}

	public JTextField getJtCodigo() {
		if (jtCodigo == null) {
			jtCodigo = new JTextField();
		}
		return jtCodigo;
	}

	public JTextField getJtQuantidade() {
		if (jtQuantidade == null) {
			jtQuantidade = new JTextField();
		}
		return jtQuantidade;
	}

	public JRadioButton getJrbEquipamento() {
		if (jrbEquipamento == null) {
			jrbEquipamento = new JRadioButton();
		}
		return jrbEquipamento;
	}

	public JRadioButton getJrbPeca() {
		if (jrbPeca == null) {
			jrbPeca = new JRadioButton();
		}
		return jrbPeca;
	}

	public JRadioButton getJrbRetirar() {
		if (jrbRetirar == null) {
			jrbRetirar = new JRadioButton();
		}
		return jrbRetirar;
	}

	public JRadioButton getJrbAdicionar() {
		if (jrbAdicionar == null) {
			jrbAdicionar = new JRadioButton();
		}
		return jrbAdicionar;
	}

	/**
	 * Getters constraints
	 */

	public GridBagConstraints getjLabelInfoConstraints() {
		if (jLabelInfoConstraints == null) {
			jLabelInfoConstraints = new GridBagConstraints();
			jLabelInfoConstraints.gridx = 0;
			jLabelInfoConstraints.gridy = 0;
			jLabelInfoConstraints.gridwidth = 4;
			jLabelInfoConstraints.ipadx = 100;
			jLabelInfoConstraints.insets = new Insets(5, 5, 10, 5);
			jLabelInfoConstraints.anchor = GridBagConstraints.LINE_START;
		}
		return jLabelInfoConstraints;
	}

	public GridBagConstraints getJlEquipamentoConstraints() {
		if (jlEquipamentoConstraints == null) {
			jlEquipamentoConstraints = new GridBagConstraints();
			jlEquipamentoConstraints.gridx = 1;
			jlEquipamentoConstraints.gridy = 2;
			jlEquipamentoConstraints.insets = new Insets(5, 5, 5, 5);
			jlEquipamentoConstraints.anchor = GridBagConstraints.LINE_START;
		}
		return jlEquipamentoConstraints;
	}

	public GridBagConstraints getJlPecaConstraints() {
		if (jlPecaConstraints == null) {
			jlPecaConstraints = new GridBagConstraints();
			jlPecaConstraints.gridx = 3;
			jlPecaConstraints.gridy = 2;
			jlPecaConstraints.insets = new Insets(5, 5, 5, 5);
			jlPecaConstraints.anchor = GridBagConstraints.LINE_START;
		}
		return jlPecaConstraints;
	}

	public GridBagConstraints getJlCodigoConstraints() {
		if (jlCodigoConstraints == null) {
			jlCodigoConstraints = new GridBagConstraints();
			jlCodigoConstraints.gridx = 0;
			jlCodigoConstraints.gridy = 3;
			jlCodigoConstraints.insets = new Insets(5, 5, 5, 5);
			jlCodigoConstraints.anchor = GridBagConstraints.LINE_START;
		}
		return jlCodigoConstraints;
	}

	public GridBagConstraints getJlQuantidadeConstraints() {
		if(jlQuantidadeConstraints == null) {
			jlQuantidadeConstraints = new GridBagConstraints();
			jlQuantidadeConstraints.gridx = 0;
			jlQuantidadeConstraints.gridy = 4;
			jlQuantidadeConstraints.insets = new Insets(5,5,5,5);
			jlQuantidadeConstraints.anchor = GridBagConstraints.LINE_START;
		}
		return jlQuantidadeConstraints;
	}

	public GridBagConstraints getJlRetirarConstraints() {
		if (jlRetirarConstraints == null) {
			jlRetirarConstraints = new GridBagConstraints();
			jlRetirarConstraints.gridx = 3;
			jlRetirarConstraints.gridy = 1;
			jlRetirarConstraints.insets = new Insets(5, 5, 5, 5);
			jlRetirarConstraints.anchor = GridBagConstraints.LINE_START;
		}
		return jlRetirarConstraints;
	}

	public GridBagConstraints getJlAdicionarConstraints() {
		if (jlAdicionarConstraints == null) {
			jlAdicionarConstraints = new GridBagConstraints();
			jlAdicionarConstraints.gridx = 1;
			jlAdicionarConstraints.gridy = 1;
			jlAdicionarConstraints.insets = new Insets(5, 5, 5, 5);
			jlAdicionarConstraints.anchor = GridBagConstraints.LINE_START;
		}
		return jlAdicionarConstraints;
	}

	public GridBagConstraints getJtCodigoConstraints() {
		if(jtCodigoConstraints == null) {
			jtCodigoConstraints = new GridBagConstraints();
			jtCodigoConstraints.gridx = 1;
			jtCodigoConstraints.gridy = 3;
			jtCodigoConstraints.ipadx = 100;
			jtCodigoConstraints.insets = new Insets(5,5,5,5);
			jtCodigoConstraints.anchor = GridBagConstraints.LINE_START;
		}
		return jtCodigoConstraints;
	}

	public GridBagConstraints getJtQuantidadeConstraints() {
		if(jtQuantidadeConstraints == null) {
			jtQuantidadeConstraints = new GridBagConstraints();
			jtQuantidadeConstraints.gridx = 1;
			jtQuantidadeConstraints.gridy = 4;
			jtQuantidadeConstraints.ipadx = 100;
			jtQuantidadeConstraints.insets = new Insets(5,5,5,5);
			jtQuantidadeConstraints.anchor = GridBagConstraints.LINE_START;
		}
		return jtQuantidadeConstraints;
	}

	public GridBagConstraints getJrbEquipamentoConstraints() {
		if (jrbEquipamentoConstraints == null) {
			jrbEquipamentoConstraints = new GridBagConstraints();
			jrbEquipamentoConstraints.gridx = 0;
			jrbEquipamentoConstraints.gridy = 2;
			jrbEquipamentoConstraints.insets = new Insets(5, 5, 5, 5);
			jrbEquipamentoConstraints.anchor = GridBagConstraints.LINE_END;
		}
		return jrbEquipamentoConstraints;
	}

	public GridBagConstraints getJrbPecaConstraints() {
		if (jrbPecaConstraints == null) {
			jrbPecaConstraints = new GridBagConstraints();
			jrbPecaConstraints.gridx = 2;
			jrbPecaConstraints.gridy = 2;
			jrbPecaConstraints.insets = new Insets(5, 5, 5, 5);
		}
		return jrbPecaConstraints;
	}

	public GridBagConstraints getJrbRetirarConstraints() {
		if (jrbRetirarConstraints == null) {
			jrbRetirarConstraints = new GridBagConstraints();
			jrbRetirarConstraints.gridx = 2;
			jrbRetirarConstraints.gridy = 1;
			jrbRetirarConstraints.insets = new Insets(5, 5, 5, 5);
			// jrbRetirarConstraints.anchor = GridBagConstraints.LINE_END;
		}
		return jrbRetirarConstraints;
	}

	public GridBagConstraints getJrbAdicionarConstraints() {
		if (jrbAdicionarConstraints == null) {
			jrbAdicionarConstraints = new GridBagConstraints();
			jrbAdicionarConstraints.gridx = 0;
			jrbAdicionarConstraints.gridy = 1;
			jrbAdicionarConstraints.insets = new Insets(5, 5, 5, 5);
			jrbAdicionarConstraints.anchor = GridBagConstraints.LINE_END;
		}
		return jrbAdicionarConstraints;
	}
}
