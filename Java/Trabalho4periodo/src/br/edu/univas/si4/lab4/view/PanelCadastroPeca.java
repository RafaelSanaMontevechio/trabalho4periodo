package br.edu.univas.si4.lab4.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class PanelCadastroPeca extends JPanel {

	private static final long serialVersionUID = 835562920083229527L;

	private JLabel jlCodigo;
	private JLabel jlNome;
	private JLabel jlTipo;
	private JLabel jlQuantidade;
	private JLabel jlEquipamento;
	private JLabel jlFornecedor;
	private JTextField jtCodigo;
	private JTextField jtNome;
	private JTextField jtQuantidade;
	private JComboBox<String> jcTipo;
	private JComboBox<String> jcEquipamento;
	private JComboBox<String> jcFornecedor;

	private String[] tipos = { "Unidade", "Kit", "Conjunto", "Pacote", "Caixa" };
	private String[] equipamentos = { "Equipamento 1", "Equipamento 2" };
	private String[] fornecedores = { "Fornecedor 1", "Fornecedor 2", "Fornecedor 3" };

	private GridBagConstraints jlCodigoConstraints;
	private GridBagConstraints jlNomeConstraints;
	private GridBagConstraints jlTipoConstraints;
	private GridBagConstraints jlQuantidadeConstraints;
	private GridBagConstraints jlEquipamentoConstraints;
	private GridBagConstraints jlFornecedorConstraints;
	private GridBagConstraints jtCodigoConstraints;
	private GridBagConstraints jtNomeConstraints;
	private GridBagConstraints jtQuantidadeConstraints;
	private GridBagConstraints jcTipoConstraints;
	private GridBagConstraints jcEquipamentoConstraints;
	private GridBagConstraints jcFornecedorConstraints;

	public PanelCadastroPeca() {
		setBorder(new EmptyBorder(10, 10, 10, 10));
		setLayout(new GridBagLayout());

		add(getJlCodigo(), getJlCodigoConstraints());
		add(getJtCodigo(), getJtCodigoConstraints());
		add(getJlQuantidade(), getJlQuantidadeConstraints());
		add(getJtQuantidade(), getJtQuantidadeConstraints());
		add(getJlTipo(), getJlTipoConstraints());
		add(getJcTipo(), getJcTipoConstraints());
		add(getJlNome(), getJlNomeConstraints());
		add(getJtNome(), getJtNomeConstraints());
		add(getJlEquipamento(), getJlEquipamentoConstraints());
		add(getJcEquipamento(), getJcEquipamentoConstraints());
		add(getJlFornecedor(), getJlFornecedorConstraints());
		add(getJcFornecedor(), getJcFornecedorConstraints());
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

	private JLabel getJlTipo() {
		if (jlTipo == null) {
			jlTipo = new JLabel();
			jlTipo.setText("Tipo:");
		}
		return jlTipo;
	}

	private JLabel getJlQuantidade() {
		if (jlQuantidade == null) {
			jlQuantidade = new JLabel();
			jlQuantidade.setText("Quantidade:");
		}
		return jlQuantidade;
	}

	private JLabel getJlEquipamento() {
		if (jlEquipamento == null) {
			jlEquipamento = new JLabel();
			jlEquipamento.setText("Equipamento:");
		}
		return jlEquipamento;
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
		}
		return jtCodigo;
	}

	private JTextField getJtNome() {
		if (jtNome == null) {
			jtNome = new JTextField();
		}
		return jtNome;
	}

	private JComboBox<String> getJcTipo() {
		if (jcTipo == null) {
			jcTipo = new JComboBox<>(tipos);
		}
		return jcTipo;
	}

	private JTextField getJtQuantidade() {
		if (jtQuantidade == null) {
			jtQuantidade = new JTextField();
		}
		return jtQuantidade;
	}

	private JComboBox<String> getJcEquipamento() {
		if (jcEquipamento == null) {
			jcEquipamento = new JComboBox<>(equipamentos);
		}
		return jcEquipamento;
	}

	private JComboBox<String> getJcFornecedor() {
		if (jcFornecedor == null) {
			jcFornecedor = new JComboBox<>(fornecedores);
		}
		return jcFornecedor;
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
			jlNomeConstraints.gridx = 0;
			jlNomeConstraints.gridy = 1;
			jlNomeConstraints.insets = new Insets(5, 5, 5, 5);
			jlNomeConstraints.anchor = GridBagConstraints.LINE_START;
		}
		return jlNomeConstraints;
	}

	private GridBagConstraints getJlTipoConstraints() {
		if (jlTipoConstraints == null) {
			jlTipoConstraints = new GridBagConstraints();
			jlTipoConstraints.gridx = 4;
			jlTipoConstraints.gridy = 0;
			jlTipoConstraints.insets = new Insets(5, 5, 5, 5);
		}
		return jlTipoConstraints;
	}

	private GridBagConstraints getJlQuantidadeConstraints() {
		if (jlQuantidadeConstraints == null) {
			jlQuantidadeConstraints = new GridBagConstraints();
			jlQuantidadeConstraints.gridx = 2;
			jlQuantidadeConstraints.gridy = 0;
			jlQuantidadeConstraints.insets = new Insets(5, 5, 5, 5);
		}
		return jlQuantidadeConstraints;
	}

	private GridBagConstraints getJlEquipamentoConstraints() {
		if (jlEquipamentoConstraints == null) {
			jlEquipamentoConstraints = new GridBagConstraints();
			jlEquipamentoConstraints.gridx = 0;
			jlEquipamentoConstraints.gridy = 2;
			jlEquipamentoConstraints.insets = new Insets(5, 5, 5, 5);
		}
		return jlEquipamentoConstraints;
	}

	private GridBagConstraints getJlFornecedorConstraints() {
		if (jlFornecedorConstraints == null) {
			jlFornecedorConstraints = new GridBagConstraints();
			jlFornecedorConstraints.gridx = 2;
			jlFornecedorConstraints.gridy = 2;
			jlFornecedorConstraints.insets = new Insets(5, 5, 5, 5);
		}
		return jlFornecedorConstraints;
	}

	private GridBagConstraints getJtCodigoConstraints() {
		if (jtCodigoConstraints == null) {
			jtCodigoConstraints = new GridBagConstraints();
			jtCodigoConstraints.gridx = 1;
			jtCodigoConstraints.gridy = 0;
			jtCodigoConstraints.ipadx = 50;
			jtCodigoConstraints.insets = new Insets(5, 5, 5, 5);
			jtCodigoConstraints.fill = GridBagConstraints.HORIZONTAL;
		}
		return jtCodigoConstraints;
	}

	private GridBagConstraints getJtNomeConstraints() {
		if (jtNomeConstraints == null) {
			jtNomeConstraints = new GridBagConstraints();
			jtNomeConstraints.gridx = 1;
			jtNomeConstraints.gridy = 1;
			jtNomeConstraints.gridwidth = 6;
			jtNomeConstraints.ipadx = 100;
			jtNomeConstraints.insets = new Insets(5, 5, 5, 5);
			jtNomeConstraints.fill = GridBagConstraints.BOTH;
			jtNomeConstraints.anchor = GridBagConstraints.LINE_START;
		}
		return jtNomeConstraints;
	}

	private GridBagConstraints getJtQuantidadeConstraints() {
		if (jtQuantidadeConstraints == null) {
			jtQuantidadeConstraints = new GridBagConstraints();
			jtQuantidadeConstraints.gridx = 3;
			jtQuantidadeConstraints.gridy = 0;
			jtQuantidadeConstraints.ipadx = 100;
			jtQuantidadeConstraints.insets = new Insets(5, 5, 5, 5);
		}
		return jtQuantidadeConstraints;
	}

	private GridBagConstraints getJcTipoConstraints() {
		if (jcTipoConstraints == null) {
			jcTipoConstraints = new GridBagConstraints();
			jcTipoConstraints.gridx = 5;
			jcTipoConstraints.gridy = 0;
			jcTipoConstraints.insets = new Insets(5, 5, 5, 5);
		}
		return jcTipoConstraints;
	}

	private GridBagConstraints getJcEquipamentoConstraints() {
		if (jcEquipamentoConstraints == null) {
			jcEquipamentoConstraints = new GridBagConstraints();
			jcEquipamentoConstraints.gridx = 1;
			jcEquipamentoConstraints.gridy = 2;
			jcEquipamentoConstraints.insets = new Insets(5, 5, 5, 5);
		}
		return jcEquipamentoConstraints;
	}

	private GridBagConstraints getJcFornecedorConstraints() {
		if (jcFornecedorConstraints == null) {
			jcFornecedorConstraints = new GridBagConstraints();
			jcFornecedorConstraints.gridx = 3;
			jcFornecedorConstraints.gridy = 2;
			jcFornecedorConstraints.insets = new Insets(5, 5, 5, 5);
		}
		return jcFornecedorConstraints;
	}

}
