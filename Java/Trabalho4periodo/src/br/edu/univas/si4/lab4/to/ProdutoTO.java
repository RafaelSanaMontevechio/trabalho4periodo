package br.edu.univas.si4.lab4.to;

public abstract class ProdutoTO {

	private int codigo;
	private String nome;
	private int quantidade;
	private FornecedorTO fornecedor;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public FornecedorTO getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(FornecedorTO fornecedor) {
		this.fornecedor = fornecedor;
	}

}
