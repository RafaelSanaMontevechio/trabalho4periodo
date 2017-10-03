package br.edu.univas.si4.lab4.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class PanelFiltroPesquisas extends JPanel {

	private static final long serialVersionUID = 1942300339171629445L;

	private JLabel jlFiltrarPor;
	private JLabel jlNome;
	private JLabel jlCodigo;
	private JLabel jlFornecedor;
	private JLabel jlTodos;
	private JRadioButton jrbNome;
	private JRadioButton jrbCodigo;
	private JRadioButton jrbFornecedor;
	private JRadioButton jrbTodos;
	private JTextField jtDados;
	private JButton jbPesquisar;

	private GridBagConstraints jlFiltrarPorConstraints;
	private GridBagConstraints jlNomeConstraints;
	private GridBagConstraints jlCodigoConstraints;
	private GridBagConstraints jlFornecedorConstraints;
	private GridBagConstraints JlTodosConstraints;
	private GridBagConstraints jrbNomeConstraints;
	private GridBagConstraints jrbCodigoConstraints;
	private GridBagConstraints jrbFornecedorConstraints;
	private GridBagConstraints jrbTodosConstraints;
	private GridBagConstraints jtDadosConstraints;
	private GridBagConstraints jbPesquisarConstraints;

	public PanelFiltroPesquisas() {
		setBorder(new EmptyBorder(10, 10, 10, 10));
		setLayout(new GridBagLayout());

		add(getJlFiltrarPor(), getjlFiltarPorConstraints());

		add(getJrbNome(), getJrbNomeConstraints());
		add(getJlNome(), getJlNomeConstraints());

		add(getJrbCodigo(), getJrbCodigoConstraints());
		add(getJlCodigo(), getJlCodigoConstraints());

		add(getJrbFornecedor(), getJrbFornecedorConstraints());
		add(getJlFornecedor(), getJlFornecedorConstraints());

		add(getJrbTodos(), getjrbTodosConstraints());
		add(getJlTodos(), getJlTodosConstraints());

		add(getJtDados(), getJtDadosConstraints());

		add(getJbPesquisar(), getJbPesquisarConstraints());

	}

	private JLabel getJlFiltrarPor() {
		if (jlFiltrarPor == null) {
			jlFiltrarPor = new JLabel();
			jlFiltrarPor.setText("Filtrar por: ");
		}
		return jlFiltrarPor;
	}

	private JLabel getJlNome() {
		if (jlNome == null) {
			jlNome = new JLabel();
			jlNome.setText("Nome");
		}
		return jlNome;
	}

	private JLabel getJlCodigo() {
		if (jlCodigo == null) {
			jlCodigo = new JLabel();
			jlCodigo.setText("Codigo");
		}
		return jlCodigo;
	}

	private JLabel getJlFornecedor() {
		if (jlFornecedor == null) {
			jlFornecedor = new JLabel();
			jlFornecedor.setText("Fornecedor");
		}
		return jlFornecedor;
	}

	private JLabel getJlTodos() {
		if (jlTodos == null) {
			jlTodos = new JLabel();
			jlTodos.setText("Todos");
		}
		return jlTodos;
	}

	private JRadioButton getJrbNome() {
		if (jrbNome == null) {
			jrbNome = new JRadioButton();
			jrbNome.setSelected(true);
		}
		return jrbNome;
	}

	private JRadioButton getJrbCodigo() {
		if (jrbCodigo == null) {
			jrbCodigo = new JRadioButton();
		}
		return jrbCodigo;
	}

	private JRadioButton getJrbFornecedor() {
		if (jrbFornecedor == null) {
			jrbFornecedor = new JRadioButton();
		}
		return jrbFornecedor;
	}

	private JRadioButton getJrbTodos() {
		if (jrbTodos == null) {
			jrbTodos = new JRadioButton();
		}
		return jrbTodos;
	}

	private JTextField getJtDados() {
		if (jtDados == null) {
			jtDados = new JTextField();
		}
		return jtDados;
	}

	private JButton getJbPesquisar() {
		if (jbPesquisar == null) {
			jbPesquisar = new JButton();
			jbPesquisar.setText("Pesquisar");
		}
		return jbPesquisar;
	}

	private GridBagConstraints getjlFiltarPorConstraints() {
		if (jlFiltrarPorConstraints == null) {
			jlFiltrarPorConstraints = new GridBagConstraints();
			jlFiltrarPorConstraints.gridx = 0;
			jlFiltrarPorConstraints.gridy = 0;
			jlFiltrarPorConstraints.gridwidth = 4;
			jlFiltrarPorConstraints.anchor = GridBagConstraints.LINE_START;
			jlFiltrarPorConstraints.insets = new Insets(5, 5, 5, 5);
		}
		return jlFiltrarPorConstraints;
	}
	

	private GridBagConstraints getJlCodigoConstraints() {
		if (jlCodigoConstraints == null) {
			jlCodigoConstraints = new GridBagConstraints();
			jlCodigoConstraints.gridx = 1;
			jlCodigoConstraints.gridy = 1;
			jlCodigoConstraints.insets = new Insets(5, 5, 5, 5);
			jlCodigoConstraints.anchor = GridBagConstraints.LINE_START;

		}
		return jlCodigoConstraints;
	}

	private GridBagConstraints getJlNomeConstraints() {
		if (jlNomeConstraints == null) {
			jlNomeConstraints = new GridBagConstraints();
			jlNomeConstraints.gridx = 3;
			jlNomeConstraints.gridy = 1;
			jlNomeConstraints.insets = new Insets(5, 5, 5, 5);
			jlNomeConstraints.anchor = GridBagConstraints.LINE_START;
		}
		return jlNomeConstraints;
	}

	private GridBagConstraints getJlFornecedorConstraints() {
		if (jlFornecedorConstraints == null) {
			jlFornecedorConstraints = new GridBagConstraints();
			jlFornecedorConstraints.gridx = 1;
			jlFornecedorConstraints.gridy = 2;
			jlFornecedorConstraints.insets = new Insets(5, 5, 5, 5);
			jlFornecedorConstraints.anchor = GridBagConstraints.LINE_START;
		}
		return jlFornecedorConstraints;
	}

	private GridBagConstraints getJlTodosConstraints() {
		if (JlTodosConstraints == null) {
			JlTodosConstraints = new GridBagConstraints();
			JlTodosConstraints.gridx = 3;
			JlTodosConstraints.gridy = 2;
			JlTodosConstraints.insets = new Insets(5, 5, 5, 5);
			JlTodosConstraints.anchor = GridBagConstraints.LINE_START;
		}
		return JlTodosConstraints;
	}
	

	private GridBagConstraints getJrbCodigoConstraints() {
		if (jrbCodigoConstraints == null) {
			jrbCodigoConstraints = new GridBagConstraints();
			jrbCodigoConstraints.gridx = 0;
			jrbCodigoConstraints.gridy = 1;
			jrbCodigoConstraints.insets = new Insets(5, 5, 5, 5);
			jrbCodigoConstraints.anchor = GridBagConstraints.LINE_START;
		}
		return jrbCodigoConstraints;
	}

	private GridBagConstraints getJrbNomeConstraints() {
		if (jrbNomeConstraints == null) {
			jrbNomeConstraints = new GridBagConstraints();
			jrbNomeConstraints.gridx = 2;
			jrbNomeConstraints.gridy = 1;
			jrbNomeConstraints.insets = new Insets(5, 5, 5, 5);
		}
		return jrbNomeConstraints;
	}

	private GridBagConstraints getJrbFornecedorConstraints() {
		if (jrbFornecedorConstraints == null) {
			jrbFornecedorConstraints = new GridBagConstraints();
			jrbFornecedorConstraints.gridx = 0;
			jrbFornecedorConstraints.gridy = 2;
			jrbFornecedorConstraints.insets = new Insets(5, 5, 5, 5);
		}
		return jrbFornecedorConstraints;
	}

	private GridBagConstraints getjrbTodosConstraints() {
		if (jrbTodosConstraints == null) {
			jrbTodosConstraints = new GridBagConstraints();
			jrbTodosConstraints.gridx = 2;
			jrbTodosConstraints.gridy = 2;
			jrbTodosConstraints.insets = new Insets(5, 5, 5, 5);
		}
		return jrbTodosConstraints;
	}

	private GridBagConstraints getJtDadosConstraints() {
		if (jtDadosConstraints == null) {
			jtDadosConstraints = new GridBagConstraints();
			jtDadosConstraints.gridx = 0;
			jtDadosConstraints.gridy = 5;
			jtDadosConstraints.gridwidth = 4;
			jtDadosConstraints.ipadx = 100;
			jtDadosConstraints.fill = GridBagConstraints.HORIZONTAL;
			jtDadosConstraints.insets = new Insets(5, 5, 5, 5);
		}
		return jtDadosConstraints;
	}

	private GridBagConstraints getJbPesquisarConstraints() {
		if (jbPesquisarConstraints == null) {
			jbPesquisarConstraints = new GridBagConstraints();
			jbPesquisarConstraints.gridx = 0;
			jbPesquisarConstraints.gridy = 6;
			jbPesquisarConstraints.gridwidth = 2;
			jbPesquisarConstraints.anchor = GridBagConstraints.CENTER;
		}
		return jbPesquisarConstraints;
	}

}
