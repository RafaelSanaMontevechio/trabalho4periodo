package br.edu.univas.si4.lab4.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
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
	private JButton btSalvar;

	private GridBagConstraints jLabelInfoGridBagConstraints;
	private GridBagConstraints jlEquipamentoGridBagConstraints;
	private GridBagConstraints jlPecaGridBagConstraints;
	private GridBagConstraints jlCodigoGridBagConstraints;
	private GridBagConstraints jlQuantidadeGridBagConstraints;
	private GridBagConstraints jlRetirarGridBagConstraints;
	private GridBagConstraints jlAdicionarGridBagConstraints;
	private GridBagConstraints jtCodigoGridBagConstraints;
	private GridBagConstraints jtQuantidadeGridBagConstraints;
	private GridBagConstraints jrbEquipamentoGridBagConstraints;
	private GridBagConstraints jrbPecaGridBagConstraints;
	private GridBagConstraints jrRetirarGridBagConstraints;
	private GridBagConstraints jrAdicionarGridBagConstraints;
	private GridBagConstraints btSalvarGridBagConstraints;

	public PanelEstoque() {
		addComponents();
	}

	private void addComponents() {
		setBorder(new EmptyBorder(10, 10, 10, 10));
		setLayout(new GridBagLayout());
	}

	public JLabel getjLabelInfo() {
		if (jLabelInfo == null) {
			jLabelInfo = new JLabel();
			jLabelInfo.setText("Selecione as opções desejadas");
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
			jlCodigo.setText("Codigo");
		}
		return jlCodigo;
	}

	public JLabel getJlQuantidade() {
		if (jlQuantidade == null) {
			jlQuantidade = new JLabel();
			jlQuantidade.setText("Quantidade");
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

	public JButton getBtSalvar() {
		if (btSalvar == null) {
			btSalvar = new JButton();
		}
		return btSalvar;
	}

	/**
	 * Getters constraints
	 */

	public GridBagConstraints getjLabelInfoGridBagConstraints() {
		return jLabelInfoGridBagConstraints;
	}

	public GridBagConstraints getJlEquipamentoGridBagConstraints() {
		return jlEquipamentoGridBagConstraints;
	}

	public GridBagConstraints getJlPecaGridBagConstraints() {
		return jlPecaGridBagConstraints;
	}

	public GridBagConstraints getJlCodigoGridBagConstraints() {
		return jlCodigoGridBagConstraints;
	}

	public GridBagConstraints getJlQuantidadeGridBagConstraints() {
		return jlQuantidadeGridBagConstraints;
	}

	public GridBagConstraints getJlRetirarGridBagConstraints() {
		return jlRetirarGridBagConstraints;
	}

	public GridBagConstraints getJlAdicionarGridBagConstraints() {
		return jlAdicionarGridBagConstraints;
	}

	public GridBagConstraints getJtCodigoGridBagConstraints() {
		return jtCodigoGridBagConstraints;
	}

	public GridBagConstraints getJtQuantidadeGridBagConstraints() {
		return jtQuantidadeGridBagConstraints;
	}

	public GridBagConstraints getJrbEquipamentoGridBagConstraints() {
		return jrbEquipamentoGridBagConstraints;
	}

	public GridBagConstraints getJrbPecaGridBagConstraints() {
		return jrbPecaGridBagConstraints;
	}

	public GridBagConstraints getJrRetirarGridBagConstraints() {
		return jrRetirarGridBagConstraints;
	}

	public GridBagConstraints getJrAdicionarGridBagConstraints() {
		return jrAdicionarGridBagConstraints;
	}

	public GridBagConstraints getBtSalvarGridBagConstraints() {
		return btSalvarGridBagConstraints;
	}

}
