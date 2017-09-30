package br.edu.univas.si4.lab4.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class PanelCadastroEquipamento extends JPanel {

	private static final long serialVersionUID = -1506685945811745749L;

	private JLabel jlCodigo;
	private JLabel jlNome;
	private JLabel jlQuantidade;
	private JLabel jlFornecedor;
	private JTextField jtCodigo;
	private JTextField jtNome;
	private JTextField jtQuantidade;
	private JComboBox<String> comboForncedores;

	private GridBagConstraints jlCodigoConstraints;
	private GridBagConstraints jlNomeConstraints;
	private GridBagConstraints jlQuantidadeConstraints;
	private GridBagConstraints jlFornecedorConstraints;
	private GridBagConstraints jtCodigoConstraints;
	private GridBagConstraints jtNomeConstraints;
	private GridBagConstraints jtQuantidadeConstraints;
	private GridBagConstraints comboForncedoresConstraints;

	String[] Fornecedores = new String[] { "Fornecedor 1", "Fornecedor 2", "Fornecedor 3" };

	public PanelCadastroEquipamento() {
		addComponents();
	}

	private void addComponents() {
		setBorder(new EmptyBorder(10, 10, 10, 10));
		setLayout(new GridBagLayout());

		add(getJlCodigo(), getJlCodigoConstraints());
		add(getJtCodigo(), getJtCodigoConstraints());
		add(getJlNome(), getJlNomeConstraints());
		add(getJtNome(), getJtNomeConstraints());
		add(getJlQuantidade(), getJlQuantidadeConstraints());
		add(getJtQuantidade(), getJtQuantidadeConstraints());
		add(getJlFornecedor(), getJlFornecedorConstraints());
		add(getComboForncedores(), getComboForncedoresConstraints());
	}

	private JLabel getJlCodigo() {
		if (jlCodigo == null) {
			jlCodigo = new JLabel();
			jlCodigo.setText("Codigo:");
		}
		return jlCodigo;
	}

	private JLabel getJlNome() {
		if (jlNome == null) {
			jlNome = new JLabel();
			jlNome.setText("Nome:");
		}
		return jlNome;
	}

	private JLabel getJlQuantidade() {
		if (jlQuantidade == null) {
			jlQuantidade = new JLabel();
			jlQuantidade.setText("Quantidade:");
		}
		return jlQuantidade;
	}

	private JLabel getJlFornecedor() {
		if (jlFornecedor == null) {
			jlFornecedor = new JLabel();
			jlFornecedor.setText("Fornecedor:");
		}
		return jlFornecedor;
	}

	private JTextField getJtCodigo() {
		if (jtCodigo == null) {
			jtCodigo = new JTextField();
			jtCodigo.setText("Codigo");
		}
		return jtCodigo;
	}

	private JTextField getJtNome() {
		if (jtNome == null) {
			jtNome = new JTextField();
			jtNome.setText("Nome");
		}
		return jtNome;
	}

	private JTextField getJtQuantidade() {
		if (jtQuantidade == null) {
			jtQuantidade = new JTextField();
			jtQuantidade.setText("Quantidade");
		}
		return jtQuantidade;
	}

	private JComboBox<String> getComboForncedores() {
		if (comboForncedores == null) {
			comboForncedores = new JComboBox<String>(Fornecedores);
		}
		return comboForncedores;
	}

	// Constraints

	private GridBagConstraints getJlCodigoConstraints() {
		if (jlCodigoConstraints == null) {
			jlCodigoConstraints = new GridBagConstraints();
			jlCodigoConstraints.gridx = 0;
			jlCodigoConstraints.gridy = 0;
			jlCodigoConstraints.anchor = GridBagConstraints.LINE_START;
		}
		return jlCodigoConstraints;
	}

	private GridBagConstraints getJlNomeConstraints() {
		if (jlNomeConstraints == null) {
			jlNomeConstraints = new GridBagConstraints();
			jlNomeConstraints.gridx = 2;
			jlNomeConstraints.ipady = 0;
			jlNomeConstraints.anchor = GridBagConstraints.LINE_START;
		}
		return jlNomeConstraints;
	}

	private GridBagConstraints getJlQuantidadeConstraints() {
		if (jlQuantidadeConstraints == null) {
			jlQuantidadeConstraints = new GridBagConstraints();
			jlQuantidadeConstraints.gridx = 0;
			jlQuantidadeConstraints.gridy = 1;
			jlQuantidadeConstraints.anchor = GridBagConstraints.LINE_START;
		}
		return jlQuantidadeConstraints;
	}

	private GridBagConstraints getJlFornecedorConstraints() {
		if (jlFornecedorConstraints == null) {
			jlFornecedorConstraints = new GridBagConstraints();
			jlFornecedorConstraints.gridx = 2;
			jlFornecedorConstraints.gridy = 1;
			jlFornecedorConstraints.anchor = GridBagConstraints.LINE_START;
		}
		return jlFornecedorConstraints;
	}

	private GridBagConstraints getJtCodigoConstraints() {
		if (jtCodigoConstraints == null) {
			jtCodigoConstraints = new GridBagConstraints();
			jtCodigoConstraints.gridx = 1;
			jtCodigoConstraints.gridy = 0;
			jtCodigoConstraints.fill = GridBagConstraints.HORIZONTAL;
		}
		return jtCodigoConstraints;
	}

	private GridBagConstraints getJtNomeConstraints() {
		if (jtNomeConstraints == null) {
			jtNomeConstraints = new GridBagConstraints();
			jtNomeConstraints.gridx = 3;
			jtNomeConstraints.gridy = 0;
			jtNomeConstraints.ipadx = 100;
			jtNomeConstraints.fill = GridBagConstraints.HORIZONTAL;
		}
		return jtNomeConstraints;
	}

	private GridBagConstraints getJtQuantidadeConstraints() {
		if (jtQuantidadeConstraints == null) {
			jtQuantidadeConstraints = new GridBagConstraints();
			jtQuantidadeConstraints.gridx = 1;
			jtQuantidadeConstraints.gridy = 1;
		}
		return jtQuantidadeConstraints;
	}

	private GridBagConstraints getComboForncedoresConstraints() {
		if (comboForncedoresConstraints == null) {
			comboForncedoresConstraints = new GridBagConstraints();
			comboForncedoresConstraints.gridx = 3;
			comboForncedoresConstraints.gridy = 1;
			comboForncedoresConstraints.anchor = GridBagConstraints.LINE_START;
		}
		return comboForncedoresConstraints;
	}
}
