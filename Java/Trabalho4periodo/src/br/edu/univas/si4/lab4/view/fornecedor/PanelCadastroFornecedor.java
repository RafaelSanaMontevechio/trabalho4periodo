package br.edu.univas.si4.lab4.view.fornecedor;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.text.ParseException;

import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class PanelCadastroFornecedor extends JPanel {

	private static final long serialVersionUID = -1890024518665882457L;

	private JLabel jlNomeRazao;
	private JLabel jlFantasia;
	private JLabel jlCnpj;
	private JTextField jtNomeRazao;
	private JTextField jtFantasia;
	private JFormattedTextField jtCnpj;

	private GridBagConstraints jlNomeRazaoConstraints;
	private GridBagConstraints jlFantasiaConstraints;
	private GridBagConstraints jlCnpjConstraints;
	private GridBagConstraints jtNomeRazaoConstraints;
	private GridBagConstraints jtFantasiaConstraints;
	private GridBagConstraints jtCnpjConstraints;

	public PanelCadastroFornecedor() {
		setBorder(new EmptyBorder(10, 10, 10, 10));
		setLayout(new GridBagLayout());

		add(getJlNomeRazao(), getJlNomeRazaoConstraints());
		add(getJtNomeRazao(), getJtNomeRazaoConstraints());
		add(getJlFantasia(), getJlFantasiaConstraints());
		add(getJtFantasia(), getJtFantasiaConstraints());
		add(getJlCnpj(), getJlCnpjConstraints());
		add(getJtCnpj(), getJtCnpjConstraints());
	}

	public JLabel getJlNomeRazao() {
		if (jlNomeRazao == null) {
			jlNomeRazao = new JLabel();
			jlNomeRazao.setText("Razão Social:");
		}
		return jlNomeRazao;
	}

	public JLabel getJlFantasia() {
		if (jlFantasia == null) {
			jlFantasia = new JLabel();
			jlFantasia.setText("Nome Fantasia:");
		}
		return jlFantasia;
	}

	public JLabel getJlCnpj() {
		if (jlCnpj == null) {
			jlCnpj = new JLabel();
			jlCnpj.setText("CNPJ:");
		}
		return jlCnpj;
	}

	public JTextField getJtNomeRazao() {
		if (jtNomeRazao == null) {
			jtNomeRazao = new JTextField();
		}
		return jtNomeRazao;
	}

	public JTextField getJtFantasia() {
		if (jtFantasia == null) {
			jtFantasia = new JTextField();
		}
		return jtFantasia;
	}

	public JFormattedTextField getJtCnpj() {
		if (jtCnpj == null) {
			javax.swing.text.MaskFormatter maskCnpj = null;
			try {
				maskCnpj = new javax.swing.text.MaskFormatter("##.###.###/####-##");
			} catch (ParseException e) {
				e.printStackTrace();
			}
			jtCnpj = new JFormattedTextField(maskCnpj);
		}
		return jtCnpj;
	}

	private GridBagConstraints getJlNomeRazaoConstraints() {
		if (jlNomeRazaoConstraints == null) {
			jlNomeRazaoConstraints = new GridBagConstraints();
			jlNomeRazaoConstraints.gridx = 0;
			jlNomeRazaoConstraints.gridy = 0;
			jlNomeRazaoConstraints.insets = new Insets(5, 5, 5, 5);
			jlNomeRazaoConstraints.anchor = GridBagConstraints.LINE_START;
		}
		return jlNomeRazaoConstraints;
	}

	private GridBagConstraints getJlFantasiaConstraints() {
		if (jlFantasiaConstraints == null) {
			jlFantasiaConstraints = new GridBagConstraints();
			jlFantasiaConstraints.gridx = 2;
			jlFantasiaConstraints.gridy = 1;
			jlFantasiaConstraints.insets = new Insets(5, 5, 5, 5);
			jlFantasiaConstraints.anchor = GridBagConstraints.LINE_START;
		}
		return jlFantasiaConstraints;
	}

	private GridBagConstraints getJlCnpjConstraints() {
		if (jlCnpjConstraints == null) {
			jlCnpjConstraints = new GridBagConstraints();
			jlCnpjConstraints.gridx = 0;
			jlCnpjConstraints.gridy = 1;
			jlCnpjConstraints.insets = new Insets(5, 5, 5, 5);
			jlCnpjConstraints.anchor = GridBagConstraints.LINE_START;
		}
		return jlCnpjConstraints;
	}

	private GridBagConstraints getJtNomeRazaoConstraints() {
		if (jtNomeRazaoConstraints == null) {
			jtNomeRazaoConstraints = new GridBagConstraints();
			jtNomeRazaoConstraints.gridx = 1;
			jtNomeRazaoConstraints.gridy = 0;
			jtNomeRazaoConstraints.ipadx = 100;
			jtNomeRazaoConstraints.gridwidth = 3;
			jtNomeRazaoConstraints.insets = new Insets(5, 5, 5, 5);
			jtNomeRazaoConstraints.fill = GridBagConstraints.BOTH;
		}
		return jtNomeRazaoConstraints;
	}

	private GridBagConstraints getJtFantasiaConstraints() {
		if (jtFantasiaConstraints == null) {
			jtFantasiaConstraints = new GridBagConstraints();
			jtFantasiaConstraints.gridx = 3;
			jtFantasiaConstraints.gridy = 1;
			jtFantasiaConstraints.ipadx = 100;
			jtFantasiaConstraints.insets = new Insets(5, 5, 5, 5);
			jtFantasiaConstraints.fill = GridBagConstraints.HORIZONTAL;
		}
		return jtFantasiaConstraints;
	}

	private GridBagConstraints getJtCnpjConstraints() {
		if (jtCnpjConstraints == null) {
			jtCnpjConstraints = new GridBagConstraints();
			jtCnpjConstraints.gridx = 1;
			jtCnpjConstraints.gridy = 1;
			jtCnpjConstraints.ipadx = 100;
			jtCnpjConstraints.insets = new Insets(5, 5, 5, 5);
			jtCnpjConstraints.fill = GridBagConstraints.HORIZONTAL;
		}
		return jtCnpjConstraints;
	}
}
