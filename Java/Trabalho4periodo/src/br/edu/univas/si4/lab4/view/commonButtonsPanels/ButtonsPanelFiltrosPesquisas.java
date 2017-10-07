package br.edu.univas.si4.lab4.view.commonButtonsPanels;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import br.edu.univas.si4.lab4.interfaces.ButtonsListernerFiltroPesquisa;

public class ButtonsPanelFiltrosPesquisas extends JPanel {

	private static final long serialVersionUID = 1942300339171629445L;

	private ArrayList<ButtonsListernerFiltroPesquisa> listeners = new ArrayList<>();

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
	private JButton btPesquisar;
	
	private ButtonGroup group;

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
	private GridBagConstraints btPesquisarConstraints;

	public ButtonsPanelFiltrosPesquisas() {
		//setBorder(new EmptyBorder(10, 10, 10, 10));
		setBorder(BorderFactory.createTitledBorder("Filtros"));
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

		add(getBtPesquisar(), getBtPesquisarConstraints());
		
		//Group Buttons
		getGroup().add(getJrbCodigo());
		getGroup().add(getJrbNome());
		getGroup().add(getJrbFornecedor());
		getGroup().add(getJrbTodos());

	}

	private JLabel getJlFiltrarPor() {
		if (jlFiltrarPor == null) {
			jlFiltrarPor = new JLabel();
			jlFiltrarPor.setText("Filtrar por: ");
			jlFiltrarPor.setFont(new Font("SansSerif", Font.PLAIN, 17));
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

	public JRadioButton getJrbNome() {
		if (jrbNome == null) {
			jrbNome = new JRadioButton();
		}

		return jrbNome;
	}

	public JRadioButton getJrbCodigo() {
		if (jrbCodigo == null) {
			jrbCodigo = new JRadioButton();
		}
		return jrbCodigo;
	}

	public JRadioButton getJrbFornecedor() {
		if (jrbFornecedor == null) {
			jrbFornecedor = new JRadioButton();
		}
		return jrbFornecedor;
	}

	public JRadioButton getJrbTodos() {
		if (jrbTodos == null) {
			jrbTodos = new JRadioButton();
		}
		return jrbTodos;
	}

	public JTextField getJtDados() {
		if (jtDados == null) {
			jtDados = new JTextField();
		}
		return jtDados;
	}

	private JButton getBtPesquisar() {
		if (btPesquisar == null) {
			btPesquisar = new JButton();
			btPesquisar.setText("Pesquisar");
			btPesquisar.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					pesquisarClicked();
				}
			});
		}
		return btPesquisar;
	}
	
	private ButtonGroup getGroup() {
		if (group == null) {
			group = new ButtonGroup();
		}
		return group;
	}

	
	//Constraints

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

	private GridBagConstraints getBtPesquisarConstraints() {
		if (btPesquisarConstraints == null) {
			btPesquisarConstraints = new GridBagConstraints();
			btPesquisarConstraints.gridx = 0;
			btPesquisarConstraints.gridy = 6;
			btPesquisarConstraints.gridwidth = 4;
			btPesquisarConstraints.anchor = GridBagConstraints.CENTER;
		}
		return btPesquisarConstraints;
	}

	public void addButtonsListenerFiltroPesquisa(ButtonsListernerFiltroPesquisa listener) {
		listeners.add(listener);
	}
	
	private void pesquisarClicked() {
		for (ButtonsListernerFiltroPesquisa listener : listeners) {
			listener.pesquisarPerformed();
		}
	}


}
