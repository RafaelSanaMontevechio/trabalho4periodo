package br.edu.univas.si4.lab4.to;

public class PecaTO extends ProdutoTO {

	private String tipo = "";
	private EquipamentoTO equipamento = null;

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public EquipamentoTO getEquipamento() {
		return equipamento;
	}

	public void setEquipamento(EquipamentoTO equipamento) {
		this.equipamento = equipamento;
	}

}
