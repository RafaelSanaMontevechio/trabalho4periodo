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

	private JMenu jmMenu;
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

	private FrameCadastroFornecedor fCadFornecedor;
	private FrameCadastroEquipamentos fCadEquipamento;
	private FrameCadastroPeca fCadPeca;
	private FrameEstoque fEstoque;

	public JmenuBar(Principal principal) {
		this.principal = principal;
		criaJmenuBar();
	}

	/**
	 * Metodo responsavel por criar a barra de menu.
	 */
	private void criaJmenuBar() {

		getJmCadastro().add(getJmiCadastroFornecedor());
		getJmCadastro().add(getJmiCadastroEquipamento());
		getJmCadastro().add(getJmiCadastroPeca());

		getJmPesquisa().add(getJmiListaFornecedor());
		getJmPesquisa().add(getJmiListaEquipamento());
		getJmPesquisa().add(getJmiListaPecas());

		getJmEstoque().add(getJmiInserirEstoque());
		//getJmEstoque().add(getJmiRetirarEstoque());

		getJmMenu().add(getJmCadastro());
		getJmMenu().add(getJmPesquisa());
		getJmMenu().add(getJmEstoque());

		add(getJmMenu());
	}

	/**
	 * Getters componentes da barra de menu
	 */
	public JMenu getJmMenu() {
		if (jmMenu == null) {
			jmMenu = new JMenu("Menu");
			ImageIcon iconMenu = new ImageIcon("imagens/menu.png");
			jmMenu.setFont(new Font("SansSerif", Font.PLAIN, 17));
			jmMenu.setIcon(iconMenu);
		}
		return jmMenu;
	}

	public JMenu getJmCadastro() {
		if (jmCadastro == null) {
			jmCadastro = new JMenu("Cadastros");
			ImageIcon iconCadastro = new ImageIcon("imagens/cadastro2.png");
			jmCadastro.setIcon(iconCadastro);
		}
		return jmCadastro;
	}

	public JMenu getJmPesquisa() {
		if (jmPesquisa == null) {
			ImageIcon iconListar = new ImageIcon("imagens/listar.png");
			jmPesquisa = new JMenu();
			jmPesquisa.setText("Listar");
			jmPesquisa.setIcon(iconListar);
		}
		return jmPesquisa;
	}

	public JMenu getJmEstoque() {
		if (jmEstoque == null) {
			jmEstoque = new JMenu("Estoque");
			ImageIcon iconEstoque = new ImageIcon("imagens/estoque.png");
			jmEstoque.setIcon(iconEstoque);
		}
		return jmEstoque;
	}

	public JMenuItem getJmiCadastroFornecedor() {
		if (jmiCadastroFornecedor == null) {
			jmiCadastroFornecedor = new JMenuItem("Fornecedor", new ImageIcon("imagens/fornecedor2.png"));
			jmiCadastroFornecedor.addActionListener(new ListenerJmenuCadastro());
		}
		return jmiCadastroFornecedor;
	}

	public JMenuItem getJmiCadastroEquipamento() {
		if (jmiCadastroEquipamento == null) {
			jmiCadastroEquipamento = new JMenuItem("Equipamentos", new ImageIcon("imagens/equip2.png"));
			jmiCadastroEquipamento.addActionListener(new ListenerJmenuCadastro());
		}
		return jmiCadastroEquipamento;
	}

	public JMenuItem getJmiCadastroPeca() {
		if (jmiCadastroPeca == null) {
			jmiCadastroPeca = new JMenuItem("Peças", new ImageIcon("imagens/pecas2.png"));
			jmiCadastroPeca.addActionListener(new ListenerJmenuCadastro());
		}
		return jmiCadastroPeca;
	}

	public JMenuItem getJmiListaFornecedor() {
		if (jmiListaFornecedor == null) {
			jmiListaFornecedor = new JMenuItem("Fornecedor", new ImageIcon("imagens/fornecedor2.png"));
			jmiListaFornecedor.addActionListener(new ListenerJmenuPesquisa());
		}
		return jmiListaFornecedor;
	}

	public JMenuItem getJmiListaEquipamento() {
		if (jmiListaEquipamento == null) {
			jmiListaEquipamento = new JMenuItem("Equipamento", new ImageIcon("imagens/equip2.png"));
			jmiListaEquipamento.addActionListener(new ListenerJmenuPesquisa());
		}
		return jmiListaEquipamento;
	}

	public JMenuItem getJmiListaPecas() {
		if (jmiListaPecas == null) {
			jmiListaPecas = new JMenuItem("Peças", new ImageIcon("imagens/pecas2.png"));
			jmiListaPecas.addActionListener(new ListenerJmenuPesquisa());
		}
		return jmiListaPecas;
	}

	public JMenuItem getJmiInserirEstoque() {
		if (jmiInserirEstoque == null) {
			jmiInserirEstoque = new JMenuItem("Adicionar/Retirar", new ImageIcon("imagens/PlusMinus.png"));
			jmiInserirEstoque.addActionListener(new ListenerJmenuEstoque());
		}
		return jmiInserirEstoque;
	}

	public JMenuItem getJmiRetirarEstoque() {
		if (jmiRetirarEstoque == null) {
			jmiRetirarEstoque = new JMenuItem("Retirar do estoque");
			ImageIcon iconMenos = new ImageIcon("imagens/menos.png");
			jmiRetirarEstoque.setIcon(iconMenos);
		}
		return jmiRetirarEstoque;
	}

	/**
	 * Getters Frames de cadastros
	 */

	public FrameCadastroFornecedor getfCadFornecedor() {
		if (fCadFornecedor == null) {
			fCadFornecedor = new FrameCadastroFornecedor();
			fCadFornecedor.setLocationRelativeTo(null);
		}
		return fCadFornecedor;
	}

	public FrameCadastroEquipamentos getfCadEquipamento() {
		if (fCadEquipamento == null) {
			fCadEquipamento = new FrameCadastroEquipamentos();
			fCadEquipamento.setLocationRelativeTo(null);
		}
		return fCadEquipamento;
	}

	public FrameCadastroPeca getfCadPeca() {
		if (fCadPeca == null) {
			fCadPeca = new FrameCadastroPeca();
			fCadPeca.setLocationRelativeTo(null);
		}
		return fCadPeca;
	}

	public FrameEstoque getfEstoque() {
		if (fEstoque == null) {
			fEstoque = new FrameEstoque();
			fEstoque.setLocationRelativeTo(null);
		}
		return fEstoque;
	}

	/**
	 * Getters Internal frames
	 */
	public InternalFrameFornecedor getiFrameFornecedor() {
		if (iFrameFornecedor == null) {
			iFrameFornecedor = new InternalFrameFornecedor();
			principal.addInternalFrame(iFrameFornecedor);
			principal.mazimizeFrame(iFrameFornecedor);
		}
		iFrameFornecedor.setVisible(true);
		return iFrameFornecedor;
	}

	public InternalFrameEquipamentos getiFrameEquipamento() {
		if (iFrameEquipamento == null) {
			iFrameEquipamento = new InternalFrameEquipamentos();
			principal.addInternalFrame(iFrameEquipamento);
			principal.mazimizeFrame(iFrameEquipamento);
		}
		iFrameEquipamento.setVisible(true);
		return iFrameEquipamento;
	}

	public InternalFramePecas getiFramePeca() {
		if (iFramePeca == null) {
			iFramePeca = new InternalFramePecas();
			principal.addInternalFrame(iFramePeca);
			principal.mazimizeFrame(iFramePeca);
		}
		iFramePeca.setVisible(true);
		return iFramePeca;
	}

	/***
	 * Classes internas que irão controlar os eventos dos JMenuItens
	 */

	// inner class controla eventos dentro do Jmenu Cadastro
	private class ListenerJmenuCadastro implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent evt) {
			if (evt.getSource() == jmiCadastroFornecedor) {
				getfCadFornecedor().setVisible(true);
				;
			} else if (evt.getSource() == jmiCadastroEquipamento) {
				getfCadEquipamento().setVisible(true);
				;
			} else {
				getfCadPeca().setVisible(true);
			}
		}
	}

	// inner class controla eventos dentro do Jmenu Pesquisa
	private class ListenerJmenuPesquisa implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent evt) {
			if (evt.getSource() == jmiListaFornecedor) {
				getiFrameFornecedor();
			} else if (evt.getSource() == jmiListaEquipamento) {
				getiFrameEquipamento();
			} else {
				getiFramePeca();
			}
		}
	}

	// inner class controla eventos jmenu estoque
	private class ListenerJmenuEstoque implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent evt) {
			if (evt.getSource() == jmiInserirEstoque) {
				getfEstoque().setVisible(true);
			}
		}
	}
}
