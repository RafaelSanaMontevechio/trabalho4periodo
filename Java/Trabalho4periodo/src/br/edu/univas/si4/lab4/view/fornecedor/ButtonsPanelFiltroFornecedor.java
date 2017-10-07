package br.edu.univas.si4.lab4.view.fornecedor;

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

public class ButtonsPanelFiltroFornecedor extends JPanel {

	private static final long serialVersionUID = -1759312264043457519L;

	private ArrayList<ButtonsListernerFiltroPesquisa> listeners = new ArrayList<>();

	private JLabel jlFiltrarPor;
	private JLabel jlCnpj;
	private JLabel jlRazao;
	private JLabel jlTodos;
	private JRadioButton jrbCnpj;
	private JRadioButton jrbRazao;
	private JRadioButton jrbTodos;
	private JTextField jtDados;
	private JButton jbBuscar;

	private ButtonGroup group;

	private GridBagConstraints jlFiltrarPorConstraints;
	private GridBagConstraints jlCnpjConstraint;
	private GridBagConstraints jlRazaoConstraint;
	private GridBagConstraints jlTodosConstraints;
	private GridBagConstraints jrbCnpjConstraint;
	private GridBagConstraints jrbRazaoConstraint;
	private GridBagConstraints jrbTodosConstraint;
	private GridBagConstraints jtDadosConstraint;
	private GridBagConstraints jbBuscarConstraint;

	public ButtonsPanelFiltroFornecedor() {
		setBorder(BorderFactory.createTitledBorder("Filtros"));
		setLayout(new GridBagLayout());

		addComponents();

	}

	private void addComponents() {
		add(getJlFiltrarPor(), getjlFiltarPorConstraints());

		add(getJrbCnpj(), getJrbCnpjConstraint());
		add(getJlCnpj(), getJlCnpjConstraint());

		add(getJrbRazao(), getJrbRazaoConstraint());
		add(getJlRazao(), getJlRazaoConstraint());

		add(getJrbTodos(), getJrbTodosConstraint());
		add(getJlTodos(), getJlTodosConstraints());

		add(getJtDados(), getJtDadosConstraint());
		add(getJbBuscar(), getJbBuscarConstraint());

		getGroup().add(getJrbCnpj());
		getGroup().add(getJrbRazao());
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

	private JLabel getJlCnpj() {
		if (jlCnpj == null) {
			jlCnpj = new JLabel();
			jlCnpj.setText("CNPJ");
		}
		return jlCnpj;
	}

	private JLabel getJlRazao() {
		if (jlRazao == null) {
			jlRazao = new JLabel();
			jlRazao.setText("Razão social");
		}
		return jlRazao;
	}

	private JLabel getJlTodos() {
		if (jlTodos == null) {
			jlTodos = new JLabel();
			jlTodos.setText("Todos");
		}
		return jlTodos;
	}

	public JRadioButton getJrbCnpj() {
		if (jrbCnpj == null) {
			jrbCnpj = new JRadioButton();
			jrbCnpj.setSelected(true);
		}
		return jrbCnpj;
	}

	public JRadioButton getJrbRazao() {
		if (jrbRazao == null) {
			jrbRazao = new JRadioButton();
		}
		return jrbRazao;
	}

	private JRadioButton getJrbTodos() {
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

	private JButton getJbBuscar() {
		if (jbBuscar == null) {
			jbBuscar = new JButton();
			jbBuscar.setText("Buscar");
			jbBuscar.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					pesquisarClicked();
				}
			});
		}
		return jbBuscar;
	}

	private ButtonGroup getGroup() {
		if (group == null) {
			group = new ButtonGroup();
		}
		return group;
	}

	// Getters

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

	private GridBagConstraints getJrbCnpjConstraint() {
		if (jrbCnpjConstraint == null) {
			jrbCnpjConstraint = new GridBagConstraints();
			jrbCnpjConstraint.gridx = 0;
			jrbCnpjConstraint.gridy = 1;
			jrbCnpjConstraint.insets = new Insets(5, 5, 5, 5);
			jrbCnpjConstraint.anchor = GridBagConstraints.LINE_START;
		}
		return jrbCnpjConstraint;
	}

	private GridBagConstraints getJlCnpjConstraint() {
		if (jlCnpjConstraint == null) {
			jlCnpjConstraint = new GridBagConstraints();
			jlCnpjConstraint.gridx = 1;
			jlCnpjConstraint.gridy = 1;
			jlCnpjConstraint.insets = new Insets(5, 5, 5, 5);
			jlCnpjConstraint.anchor = GridBagConstraints.LINE_START;
		}
		return jlCnpjConstraint;
	}

	private GridBagConstraints getJrbRazaoConstraint() {
		if (jrbRazaoConstraint == null) {
			jrbRazaoConstraint = new GridBagConstraints();
			jrbRazaoConstraint.gridx = 2;
			jrbRazaoConstraint.gridy = 1;
			jrbRazaoConstraint.insets = new Insets(5, 5, 5, 5);
			jrbRazaoConstraint.anchor = GridBagConstraints.LINE_START;
		}
		return jrbRazaoConstraint;
	}

	private GridBagConstraints getJlRazaoConstraint() {
		if (jlRazaoConstraint == null) {
			jlRazaoConstraint = new GridBagConstraints();
			jlRazaoConstraint.gridx = 3;
			jlRazaoConstraint.gridy = 1;
			jlRazaoConstraint.insets = new Insets(5, 5, 5, 5);
			jlRazaoConstraint.anchor = GridBagConstraints.LINE_START;
		}
		return jlRazaoConstraint;
	}

	private GridBagConstraints getJrbTodosConstraint() {
		if (jrbTodosConstraint == null) {
			jrbTodosConstraint = new GridBagConstraints();
			jrbTodosConstraint.gridx = 4;
			jrbTodosConstraint.gridy = 1;
			jrbTodosConstraint.insets = new Insets(5, 5, 5, 5);
			jrbTodosConstraint.anchor = GridBagConstraints.LINE_START;
		}
		return jrbTodosConstraint;
	}

	private GridBagConstraints getJlTodosConstraints() {
		if (jlTodosConstraints == null) {
			jlTodosConstraints = new GridBagConstraints();
			jlTodosConstraints.gridx = 5;
			jlTodosConstraints.gridy = 1;
			jlTodosConstraints.insets = new Insets(5, 5, 5, 5);
			jlTodosConstraints.anchor = GridBagConstraints.LINE_START;
		}
		return jlTodosConstraints;
	}

	private GridBagConstraints getJtDadosConstraint() {
		if (jtDadosConstraint == null) {
			jtDadosConstraint = new GridBagConstraints();
			jtDadosConstraint.gridx = 0;
			jtDadosConstraint.gridy = 3;
			jtDadosConstraint.gridwidth = 6;
			jtDadosConstraint.ipadx = 100;
			jtDadosConstraint.insets = new Insets(5, 5, 5, 5);
			jtDadosConstraint.fill = GridBagConstraints.HORIZONTAL;

		}
		return jtDadosConstraint;
	}

	private GridBagConstraints getJbBuscarConstraint() {
		if (jbBuscarConstraint == null) {
			jbBuscarConstraint = new GridBagConstraints();
			jbBuscarConstraint.gridx = 0;
			jbBuscarConstraint.gridy = 4;
			jbBuscarConstraint.gridwidth = 6;
			jbBuscarConstraint.insets = new Insets(5, 5, 5, 5);
		}
		return jbBuscarConstraint;
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
