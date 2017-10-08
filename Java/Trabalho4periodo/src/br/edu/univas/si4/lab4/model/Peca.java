package br.edu.univas.si4.lab4.model;

public class Peca extends Produto {

	private String tipo = "";
	private Equipamento equipamento = null;

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Equipamento getEquipamento() {
		return equipamento;
	}

	public void setEquipamento(Equipamento equipamento) {
		this.equipamento = equipamento;
	}

}
