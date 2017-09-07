package br.edu.univas.si4.lab4.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class FrameCadastroEquipamentos extends JFrame {

	private static final long serialVersionUID = 6411516047271744522L;

	private JLabel codigo;
	private JLabel nome;
	private JLabel quantidade;
	private JLabel fornecedor;

	private JTextField jtCodigo;
	private JTextField jtNome;
	private JTextField jtQuantidade;

	private JButton btSalvar;
	private JButton btsCancelar;

	public FrameCadastroEquipamentos() {
		this.setSize(500, 210);
		setLayout(new GridBagLayout());
		this.setTitle("Cadastro de equipamentos");
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		criaTelaCadEquipamento();
	}

	private void criaTelaCadEquipamento() {

		GridBagConstraints c = new GridBagConstraints();

		nome = new JLabel("Nome:");
		c.fill = GridBagConstraints.NONE;
		c.gridx = 0;
		c.gridy = 0;
		c.anchor = GridBagConstraints.FIRST_LINE_START;
		add(nome, c);

		jtNome = new JTextField(30);
		c.fill = GridBagConstraints.NONE;
		c.gridx = 1;
		c.gridy = 0;
		c.anchor = GridBagConstraints.FIRST_LINE_START;
		add(jtNome);

		codigo = new JLabel("Codigo:");
		c.fill = GridBagConstraints.NONE;
		c.gridx = 0;
		c.gridy = 1;
		c.anchor = GridBagConstraints.FIRST_LINE_START;
		add(codigo, c);

		jtCodigo = new JTextField(10);
		c.fill = GridBagConstraints.NONE;
		c.gridx = 1;
		c.gridy = 1;
		c.anchor = GridBagConstraints.FIRST_LINE_START;
		add(jtCodigo, c);

		quantidade = new JLabel("Quantidade:");
		c.fill = GridBagConstraints.NONE;
		c.gridx = 1;
		c.gridy = 1;
		c.anchor = GridBagConstraints.CENTER;
		add(quantidade, c);

		jtQuantidade = new JTextField(5);
		c.fill = GridBagConstraints.NONE;
		c.gridx = 1;
		c.gridy = 1;
		c.ipadx = 20;
		c.anchor = GridBagConstraints.FIRST_LINE_END;
		add(jtQuantidade, c);

		fornecedor = new JLabel("Fornecedor:");
		c.fill = GridBagConstraints.NONE;
		c.gridx = 0;
		c.gridy = 3;
		c.anchor = GridBagConstraints.FIRST_LINE_END;
		add(fornecedor, c);

		String[] Fornecedores = new String[] { "Fornecedor 1", "Fornecedor 2", "Fornecedor 3", "Fornecedor 4",
				"Fornecedor 5" };
		JComboBox<String> comboForncedores = new JComboBox<String>(Fornecedores);
		c.fill = GridBagConstraints.NONE;
		c.gridx = 1;
		c.gridy = 3;
		c.anchor = GridBagConstraints.FIRST_LINE_START;
		add(comboForncedores, c);

		btSalvar = new JButton("Salvar");
		c.fill = GridBagConstraints.NONE;
		c.gridx = 1;
		c.gridy = 5;
		c.insets = new Insets(5, 5, 0, 0);
		c.anchor = GridBagConstraints.CENTER;
		add(btSalvar, c);

		btsCancelar = new JButton("Cancelar");
		c.fill = GridBagConstraints.NONE;
		c.gridx = 1;
		c.gridy = 5;
		c.insets = new Insets(5, 5, 0, 0);
		c.anchor = GridBagConstraints.FIRST_LINE_END;
		add(btsCancelar, c);
	}
}
