package br.edu.univas.si4.lab4.model;

public class Peca extends Produto{
	
	private String Tipo = "";
	private Equipamento equipamento = null;
	
	
	public String getTipo() {
		return Tipo;
	}
	public void setTipo(String tipo) {
		Tipo = tipo;
	}
	public Equipamento getEquipamento() {
		return equipamento;
	}
	public void setEquipamento(Equipamento equipamento) {
		this.equipamento = equipamento;
	}
	
}
