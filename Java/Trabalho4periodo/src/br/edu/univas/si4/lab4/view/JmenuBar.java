package br.edu.univas.si4.lab4.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class JmenuBar extends JMenuBar {

	private static final long serialVersionUID = 4907700397195319504L;

	private JMenu menu;
	private JMenu jmCadastro;
	private JMenu jmEstoque;
	private JMenuItem jmiCadastroFornecedor;
	private JMenuItem jmiCadastroEquipamento;
	private JMenuItem menuItem3;
	private JMenuItem jmiEntarEquipamento;
	private JMenuItem jmiRetirarEquipamento;
	private JMenuItem jmiEntrarPeca;
	private JMenuItem jmiRetirarPeca;

	private InternalFrameFornecedor iFrameFornecedor;
	private InternalFrameEquipamentos iFrameEquipamento;
	private InternalFramePecas iFramePeca;
	private Principal principal;

	public JmenuBar(Principal principal) {
		this.principal = principal;
		criaJmenuBar();
	}

	/**
	 * Metodo responsavel por criar a barra de menu.
	 */
	private void criaJmenuBar() {

		menu = new JMenu("Menu");
		ImageIcon iconMenu = new ImageIcon("imagens/menu.png");
		menu.setFont(new Font("SansSerif", Font.PLAIN, 17));
		menu.setIcon(iconMenu);

		menu.add(jmenuCadastros());
		menu.add(jmenuEstoque());

		add(menu);
	}

	/**
	 * Metodo responsavel por criar o jmenu Cadastro.
	 */
	private JMenu jmenuCadastros() {

		jmCadastro = new JMenu("Cadastros");
		ImageIcon iconCadastro = new ImageIcon("imagens/cadastro2.png");
		jmCadastro.setIcon(iconCadastro);

		jmiCadastroFornecedor = new JMenuItem("Fornecedor");
		ImageIcon iconFornecedor = new ImageIcon("imagens/fornecedor2.png");
		jmiCadastroFornecedor.setIcon(iconFornecedor);
		jmiCadastroFornecedor.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent evt) {
				if (iFrameFornecedor == null) {
					iFrameFornecedor = new InternalFrameFornecedor();
					principal.addInternalFrame(iFrameFornecedor);
					iFrameFornecedor.setPosicao();
					principal.mazimizeFrame(iFrameFornecedor);
				}
				iFrameFornecedor.setVisible(true);
			}
		});

		jmiCadastroEquipamento = new JMenuItem("Equipamentos");
		ImageIcon iconEquipamento = new ImageIcon("imagens/equip2.png");
		jmiCadastroEquipamento.setIcon(iconEquipamento);
		jmiCadastroEquipamento.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent evt) {

				if (iFrameEquipamento == null) {
					iFrameEquipamento = new InternalFrameEquipamentos();
					principal.addInternalFrame(iFrameEquipamento);
					iFrameEquipamento.setPosicao();
					principal.mazimizeFrame(iFrameEquipamento);
				}
				iFrameEquipamento.setVisible(true);
			}
		});

		menuItem3 = new JMenuItem("Peças");
		ImageIcon iconPecas = new ImageIcon("imagens/pecas2.png");
		menuItem3.setIcon(iconPecas);
		menuItem3.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent evt) {
				if (iFramePeca == null) {
					iFramePeca = new InternalFramePecas();
					principal.addInternalFrame(iFramePeca);
					iFramePeca.setPosicao();
					principal.mazimizeFrame(iFramePeca);
				}
				iFramePeca.setVisible(true);
			}
		});

		jmCadastro.add(jmiCadastroFornecedor);
		jmCadastro.add(jmiCadastroEquipamento);
		jmCadastro.add(menuItem3);

		return jmCadastro;

	}

	/**
	 * Metodo responsavel por criar o jmenu estoque.
	 */
	private JMenu jmenuEstoque() {

		ImageIcon iconEstoque = new ImageIcon("imagens/estoque.png");
		ImageIcon iconMenos = new ImageIcon("imagens/menos.png");
		ImageIcon iconAdd = new ImageIcon("imagens/add.png");

		jmEstoque = new JMenu("Estoque");
		jmEstoque.setIcon(iconEstoque);

		jmiEntarEquipamento = new JMenuItem("Adicionar Equipamento");
		jmiEntarEquipamento.setIcon(iconAdd);

		jmiRetirarEquipamento = new JMenuItem("Retirar Equipamento");
		jmiRetirarEquipamento.setIcon(iconMenos);

		jmiEntrarPeca = new JMenuItem("Adicionar peça ");
		jmiEntrarPeca.setIcon(iconAdd);

		jmiRetirarPeca = new JMenuItem("Retirar peça");
		jmiRetirarPeca.setIcon(iconMenos);

		jmEstoque.add(jmiEntarEquipamento);
		jmEstoque.add(jmiRetirarEquipamento);
		jmEstoque.add(jmiEntrarPeca);
		jmEstoque.add(jmiRetirarPeca);

		return jmEstoque;
	}

}
