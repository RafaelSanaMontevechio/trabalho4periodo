package br.edu.univas.si4.lab4.model;

public class Fornecedor {
	
	private String NomeRazao = "";
	private String Fantasia = "";
	private int Cnpj = 0;
	
	
	public String getNomeRazao() {
		return NomeRazao;
	}
	public void setNomeRazao(String nomeRazao) {
		NomeRazao = nomeRazao;
	}
	public String getFantasia() {
		return Fantasia;
	}
	public void setFantasia(String fantasia) {
		Fantasia = fantasia;
	}
	public int getCnpj() {
		return Cnpj;
	}
	public void setCnpj(int cnpj) {
		Cnpj = cnpj;
	}

}
