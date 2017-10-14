package br.edu.univas.si4.lab4.view.equipamento;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import br.edu.univas.si4.lab4.controller.FornecedorController;

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

	public JTextField getJtCodigo() {
		if (jtCodigo == null) {
			jtCodigo = new JTextField();
		}
		return jtCodigo;
	}

	public JTextField getJtNome() {
		if (jtNome == null) {
			jtNome = new JTextField();
		}
		return jtNome;
	}

	public JTextField getJtQuantidade() {
		if (jtQuantidade == null) {
			jtQuantidade = new JTextField();
		}
		return jtQuantidade;
	}

	public JComboBox<String> getComboForncedores() {
		if (comboForncedores == null) {
			ArrayList<String> fantasia = new ArrayList<>();
			fantasia = new FornecedorController().listaFantasia();
			comboForncedores = new JComboBox<String>();

			for (String string : fantasia) {
				comboForncedores.addItem(string);
			}
		}
		return comboForncedores;
	}

	// Constraints
	private GridBagConstraints getJlCodigoConstraints() {
		if (jlCodigoConstraints == null) {
			jlCodigoConstraints = new GridBagConstraints();
			jlCodigoConstraints.gridx = 0;
			jlCodigoConstraints.gridy = 0;
			jlCodigoConstraints.insets = new Insets(5, 5, 5, 5);
			jlCodigoConstraints.anchor = GridBagConstraints.LINE_START;
		}
		return jlCodigoConstraints;
	}

	private GridBagConstraints getJlNomeConstraints() {
		if (jlNomeConstraints == null) {
			jlNomeConstraints = new GridBagConstraints();
			jlNomeConstraints.gridx = 2;
			jlNomeConstraints.ipady = 0;
			jlNomeConstraints.insets = new Insets(5, 5, 5, 5);
			jlNomeConstraints.anchor = GridBagConstraints.LINE_START;
		}
		return jlNomeConstraints;
	}

	private GridBagConstraints getJlQuantidadeConstraints() {
		if (jlQuantidadeConstraints == null) {
			jlQuantidadeConstraints = new GridBagConstraints();
			jlQuantidadeConstraints.gridx = 0;
			jlQuantidadeConstraints.gridy = 1;
			jlQuantidadeConstraints.insets = new Insets(5, 5, 5, 5);
			jlQuantidadeConstraints.anchor = GridBagConstraints.LINE_START;
		}
		return jlQuantidadeConstraints;
	}

	private GridBagConstraints getJlFornecedorConstraints() {
		if (jlFornecedorConstraints == null) {
			jlFornecedorConstraints = new GridBagConstraints();
			jlFornecedorConstraints.gridx = 2;
			jlFornecedorConstraints.gridy = 1;
			jlFornecedorConstraints.insets = new Insets(5, 5, 5, 5);
			jlFornecedorConstraints.anchor = GridBagConstraints.LINE_START;
		}
		return jlFornecedorConstraints;
	}

	private GridBagConstraints getJtCodigoConstraints() {
		if (jtCodigoConstraints == null) {
			jtCodigoConstraints = new GridBagConstraints();
			jtCodigoConstraints.gridx = 1;
			jtCodigoConstraints.gridy = 0;
			jtCodigoConstraints.ipadx = 100;
			jtCodigoConstraints.insets = new Insets(5, 5, 5, 5);
			jtCodigoConstraints.fill = GridBagConstraints.HORIZONTAL;
		}
		return jtCodigoConstraints;
	}

	private GridBagConstraints getJtNomeConstraints() {
		if (jtNomeConstraints == null) {
			jtNomeConstraints = new GridBagConstraints();
			jtNomeConstraints.gridx = 3;
			jtNomeConstraints.gridy = 0;
			jtNomeConstraints.ipadx = 200;
			jtNomeConstraints.gridwidth = 2;
			jtNomeConstraints.anchor = GridBagConstraints.LINE_START;
			jtNomeConstraints.insets = new Insets(5, 5, 5, 5);
			jtNomeConstraints.fill = GridBagConstraints.HORIZONTAL;
		}
		return jtNomeConstraints;
	}

	private GridBagConstraints getJtQuantidadeConstraints() {
		if (jtQuantidadeConstraints == null) {
			jtQuantidadeConstraints = new GridBagConstraints();
			jtQuantidadeConstraints.gridx = 1;
			jtQuantidadeConstraints.gridy = 1;
			jtQuantidadeConstraints.ipadx = 100;
			jtQuantidadeConstraints.insets = new Insets(5, 5, 5, 5);
		}
		return jtQuantidadeConstraints;
	}

	private GridBagConstraints getComboForncedoresConstraints() {
		if (comboForncedoresConstraints == null) {
			comboForncedoresConstraints = new GridBagConstraints();
			comboForncedoresConstraints.gridx = 3;
			comboForncedoresConstraints.gridy = 1;
			comboForncedoresConstraints.ipadx = 200;
			comboForncedoresConstraints.insets = new Insets(5, 5, 5, 5);
			comboForncedoresConstraints.fill = GridBagConstraints.BOTH;
			comboForncedoresConstraints.anchor = GridBagConstraints.LINE_START;
		}
		return comboForncedoresConstraints;
	}
}
