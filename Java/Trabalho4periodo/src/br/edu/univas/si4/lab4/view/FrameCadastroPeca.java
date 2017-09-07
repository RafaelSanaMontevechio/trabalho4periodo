package br.edu.univas.si4.lab4.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FrameCadastroPeca extends JFrame {

	private static final long serialVersionUID = -7860829342439937591L;

	private JPanel panel;
	private JLabel codigo;
	private JLabel nome;
	private JLabel tipo;
	private JLabel quantidade;
	private JLabel equipamento;
	private JLabel fornecedor;
	private JTextField jtCodigo;
	private JTextField jtNome;
	private JTextField jtQuantidade;
	private JButton btSalvar;
	private JButton btCancelar;

	public FrameCadastroPeca() {
		this.setSize(500, 300);
		this.setTitle("Cadastro de peça");
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		montaTalaCadPeca();
	}

	private void montaTalaCadPeca() {

		panel = new JPanel();
		panel.setBorder(BorderFactory.createTitledBorder(""));
		panel.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		nome = new JLabel("Nome:");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		// c.insets = new Insets(15, 15,10, 15);
		c.anchor = GridBagConstraints.FIRST_LINE_START;
		panel.add(nome, c);

		jtNome = new JTextField(30);
		c.fill = GridBagConstraints.NONE;
		c.gridx = 1;
		c.gridy = 0;
		c.anchor = GridBagConstraints.FIRST_LINE_START;
		panel.add(jtNome, c);

		codigo = new JLabel("Codigo:");
		c.fill = GridBagConstraints.NONE;
		c.gridx = 0;
		c.gridy = 1;
		c.anchor = GridBagConstraints.FIRST_LINE_START;
		panel.add(codigo, c);

		jtCodigo = new JTextField(10);
		c.fill = GridBagConstraints.NONE;
		c.gridx = 1;
		c.gridy = 1;
		c.anchor = GridBagConstraints.FIRST_LINE_START;
		panel.add(jtCodigo, c);

		quantidade = new JLabel("Quantidade:");
		c.fill = GridBagConstraints.NONE;
		c.gridx = 1;
		c.gridy = 1;
		c.anchor = GridBagConstraints.CENTER;
		panel.add(quantidade, c);

		jtQuantidade = new JTextField(10);
		c.fill = GridBagConstraints.NONE;
		c.gridx = 1;
		c.gridy = 1;
		c.anchor = GridBagConstraints.LINE_END;
		panel.add(jtQuantidade, c);

		equipamento = new JLabel("Equipamento:");
		c.fill = GridBagConstraints.NONE;
		c.gridx = 0;
		c.gridy = 2;
		c.anchor = GridBagConstraints.FIRST_LINE_END;
		panel.add(equipamento, c);

		String[] equipamento = new String[] { "Equipamento 1", "Equipamento 2", "Equipamento 3", "Equipamento 4",
				"Equipamento 5" };
		JComboBox<String> comboEquipamento = new JComboBox<String>(equipamento);
		c.fill = GridBagConstraints.NONE;
		c.gridx = 1;
		c.gridy = 2;
		c.anchor = GridBagConstraints.FIRST_LINE_START;
		panel.add(comboEquipamento, c);

		fornecedor = new JLabel("Fornecedor:");
		c.fill = GridBagConstraints.NONE;
		c.gridx = 1;
		c.gridy = 2;
		c.anchor = GridBagConstraints.CENTER;
		panel.add(fornecedor, c);

		String[] Fornecedores = new String[] { "Fornecedor 1", "Fornecedor 2", "Fornecedor 3", "Fornecedor 4",
				"Fornecedor 5" };
		JComboBox<String> comboForncedores = new JComboBox<String>(Fornecedores);
		c.fill = GridBagConstraints.NONE;
		c.gridx = 1;
		c.gridy = 2;
		c.anchor = GridBagConstraints.FIRST_LINE_END;
		panel.add(comboForncedores, c);

		tipo = new JLabel("Tipo:");
		c.fill = GridBagConstraints.NONE;
		c.gridx = 0;
		c.gridy = 3;
		c.anchor = GridBagConstraints.FIRST_LINE_START;
		panel.add(tipo, c);

		String[] tipo = new String[] { "Unidade", "Caixa", "Conjunto", "Pacote" };
		JComboBox<String> comboTipo = new JComboBox<String>(tipo);
		c.fill = GridBagConstraints.NONE;
		c.gridx = 1;
		c.gridy = 3;
		c.anchor = GridBagConstraints.FIRST_LINE_START;
		panel.add(comboTipo, c);

		btSalvar = new JButton("Salvar");
		c.gridx = 1;
		c.gridy = 4;
		c.fill = GridBagConstraints.NONE;
		c.anchor = GridBagConstraints.CENTER;
		panel.add(btSalvar, c);

		btCancelar = new JButton("Cancelar");
		c.gridx = 1;
		c.gridy = 4;
		c.fill = GridBagConstraints.NONE;
		c.anchor = GridBagConstraints.LINE_END;
		panel.add(btCancelar, c);

		setContentPane(panel);

	}
}
