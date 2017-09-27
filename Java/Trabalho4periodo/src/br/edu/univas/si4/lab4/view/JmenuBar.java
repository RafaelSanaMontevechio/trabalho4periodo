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
	private JMenu jmPesquisa;
	private JMenu jmEstoque;
	private JMenuItem jmiCadastroFornecedor;
	private JMenuItem jmiCadastroEquipamento;
	private JMenuItem jmiCadastroPeca;
	private JMenuItem jmiListaFornecedor;
	private JMenuItem jmiListaEquipamento;
	private JMenuItem jmiListaPecas;
	private JMenuItem jmiInserirEstoque;
	private JMenuItem jmiRetirarEstoque;
	

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
		menu.add(jmenuPesquisa());
		menu.add(jmenuEstoque());

		add(menu);
	}

	/**
	 * Metodo responsavel por criar o jmenu Cadastro.
	 */
	private JMenu jmenuCadastros() {

		ListenerJmenuCadastro listenerCadastro = new ListenerJmenuCadastro();

		jmCadastro = new JMenu("Cadastros");
		ImageIcon iconCadastro = new ImageIcon("imagens/cadastro2.png");
		jmCadastro.setIcon(iconCadastro);

		jmiCadastroFornecedor = new JMenuItem("Fornecedor");
		ImageIcon iconFornecedor = new ImageIcon("imagens/fornecedor2.png");
		jmiCadastroFornecedor.setIcon(iconFornecedor);
		jmiCadastroFornecedor.addActionListener(listenerCadastro);

		jmiCadastroEquipamento = new JMenuItem("Equipamentos");
		ImageIcon iconEquipamento = new ImageIcon("imagens/equip2.png");
		jmiCadastroEquipamento.setIcon(iconEquipamento);
		jmiCadastroEquipamento.addActionListener(listenerCadastro);

		jmiCadastroPeca = new JMenuItem("Peças");
		ImageIcon iconPecas = new ImageIcon("imagens/pecas2.png");
		jmiCadastroPeca.setIcon(iconPecas);
		jmiCadastroPeca.addActionListener(listenerCadastro);

		jmCadastro.add(jmiCadastroFornecedor);
		jmCadastro.add(jmiCadastroEquipamento);
		jmCadastro.add(jmiCadastroPeca);

		return jmCadastro;
	}

	/**
	 * Metodo responsavel por criar o jmenu pesquisa.
	 */
	private JMenu jmenuPesquisa() {

		ListenerJmenuPesquisa listenerPesquisa = new ListenerJmenuPesquisa();

		ImageIcon iconListar = new ImageIcon("imagens/listar.png");
		jmPesquisa = new JMenu("Listar");
		jmPesquisa.setIcon(iconListar);

		jmiListaFornecedor = new JMenuItem("Fornecedor");
		jmiListaFornecedor.addActionListener(listenerPesquisa);

		jmiListaEquipamento = new JMenuItem("Equipamento");
		jmiListaEquipamento.addActionListener(listenerPesquisa);

		jmiListaPecas = new JMenuItem("Peças");
		jmiListaPecas.addActionListener(listenerPesquisa);

		jmPesquisa.add(jmiListaFornecedor);
		jmPesquisa.add(jmiListaEquipamento);
		jmPesquisa.add(jmiListaPecas);

		return jmPesquisa;
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

		jmiInserirEstoque = new JMenuItem("Adicionar ao estoque");
		jmiInserirEstoque.setIcon(iconAdd);

		jmiRetirarEstoque = new JMenuItem("Retirar do estoque");
		jmiRetirarEstoque.setIcon(iconMenos);


		jmEstoque.add(jmiInserirEstoque);
		jmEstoque.add(jmiRetirarEstoque);
	

		return jmEstoque;
	}

	/***
	 * Classes internas que irão controlar os eventos dos JMenuItens
	 */

	// inner class controla eventos dentro do Jmenu Cadastro
	private class ListenerJmenuCadastro implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent evt) {

			if (evt.getSource() == jmiCadastroFornecedor) {
				new FrameCadastroFornecedor().setVisible(true);
			} else if (evt.getSource() == jmiCadastroEquipamento) {
				new FrameCadastroEquipamentos().setVisible(true);
			} else {
				new FrameCadastroPeca().setVisible(true);
			}
		}
	}

	// inner class controla eventos dentro do Jmenu Pesquisa
	private class ListenerJmenuPesquisa implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent evt) {
			if (evt.getSource() == jmiListaFornecedor) {
				if (iFrameFornecedor == null) {
					iFrameFornecedor = new InternalFrameFornecedor();
					principal.addInternalFrame(iFrameFornecedor);
					iFrameFornecedor.setPosicao();
					principal.mazimizeFrame(iFrameFornecedor);
				}
				iFrameFornecedor.setVisible(true);
			} else if (evt.getSource() == jmiListaEquipamento) {
				if (iFrameEquipamento == null) {
					iFrameEquipamento = new InternalFrameEquipamentos();
					principal.addInternalFrame(iFrameEquipamento);
					iFrameEquipamento.setPosicao();
					principal.mazimizeFrame(iFrameEquipamento);
				}
				iFrameEquipamento.setVisible(true);
			} else {
				if (iFramePeca == null) {
					iFramePeca = new InternalFramePecas();
					principal.addInternalFrame(iFramePeca);
					iFramePeca.setPosicao();
					principal.mazimizeFrame(iFramePeca);
				}
				iFramePeca.setVisible(true);
			}
		}
	}
}
