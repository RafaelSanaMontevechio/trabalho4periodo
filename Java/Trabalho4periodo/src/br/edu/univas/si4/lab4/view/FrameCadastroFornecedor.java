package br.edu.univas.si4.lab4.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FrameCadastroFornecedor extends JFrame {

	private JPanel panelCadastro;
	private JLabel jlNomeRazao;
	private JLabel jlFantasia;
	private JLabel jlCnpj;
	private JTextField jtNomeRazao;
	private JTextField jtFantasia;
	private JTextField jtCnpj;
	private JButton btSalvar;

	private static final long serialVersionUID = 8703398655774672349L;

	public FrameCadastroFornecedor() {
		this.setSize(550, 300);

		this.setTitle("Cadastro de Fornecedor");
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		criaPanelCadastros();
	}

	public void criaPanelCadastros() {

		panelCadastro = new JPanel();
		panelCadastro.setBorder(BorderFactory.createTitledBorder("Cadastro de Fornecedor"));
		panelCadastro.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		jlNomeRazao = new JLabel("Nome/Razão Social:");
		c.fill = GridBagConstraints.NONE;
		c.gridx = 0;
		c.gridy = 0;
		c.insets = new Insets(5, 5, 10, 5);
		c.anchor = GridBagConstraints.FIRST_LINE_START;
		panelCadastro.add(jlNomeRazao, c);

		jtNomeRazao = new JTextField(30);
		c.fill = GridBagConstraints.NONE;
		c.gridx = 1;
		c.gridy = 0;
		c.insets = new Insets(5, 3, 10, 5);
		c.anchor = GridBagConstraints.FIRST_LINE_START;
		panelCadastro.add(jtNomeRazao, c);

		jlFantasia = new JLabel("Nome Fantasia:");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 2;
		panelCadastro.add(jlFantasia, c);

		jtFantasia = new JTextField(30);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 2;
		c.anchor = GridBagConstraints.WEST;
		panelCadastro.add(jtFantasia, c);

		jlCnpj = new JLabel("CNPJ:");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 3;
		c.anchor = GridBagConstraints.CENTER;
		panelCadastro.add(jlCnpj, c);

		jtCnpj = new JTextField(30);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 3;
		c.anchor = GridBagConstraints.SOUTHEAST;
		panelCadastro.add(jtCnpj, c);

		btSalvar = new JButton("Salvar");
		c.fill = GridBagConstraints.NONE;
		c.gridx = 1;
		c.gridy = 5;
		c.anchor = GridBagConstraints.LINE_END;
		panelCadastro.add(btSalvar, c);

		setContentPane(panelCadastro);
	}
}
