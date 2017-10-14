package br.edu.univas.si4.lab4.view.equipamento;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.edu.univas.si4.lab4.to.EquipamentoTO;

public class TableModelEquipamento extends AbstractTableModel {

	private static final long serialVersionUID = 7993185046938027113L;

	private String[] columnNames = { "CODIGO", "NOME", "QUANTIDADE", "FORNECEDOR" };

	// Constantes representando o �ndice das colunas
	private static final int CODIGO = 0;
	private static final int NOME = 1;
	private static final int QUANTIDADE = 2;
	private static final int FORNECEDOR = 3;

	// Lista de Fornecedores a serem exibidos na tabela
	private List<EquipamentoTO> linhas;

	// Cria um FornecedorTableModel sem nenhuma linha
	public TableModelEquipamento() {
		linhas = new ArrayList<EquipamentoTO>();
	}

	// Cria um FornecedorTableModel contendo a lista recebida por par�metro
	public TableModelEquipamento(List<EquipamentoTO> listaDeEquipamentos) {
		linhas = new ArrayList<EquipamentoTO>(listaDeEquipamentos);
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		return linhas.size();
	}

	@Override
	public String getColumnName(int columnIndex) {
		return columnNames[columnIndex];
	};

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		switch (columnIndex) {
		case CODIGO:
			return Long.class;
		case NOME:
			return String.class;
		case QUANTIDADE:
			return int.class;
		case FORNECEDOR:
			return String.class;
		default:
			// N�o deve ocorrer, pois s� existem 3 colunas
			throw new IndexOutOfBoundsException("columnIndex out of bounds");
		}
	}

	// Deixa as celulas n�o editaveis
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// Pega o fornecedor referente a linha especificada.
		EquipamentoTO equipamento = linhas.get(rowIndex);

		switch (columnIndex) {
		case CODIGO:
			return equipamento.getCodigo();
		case NOME:
			return equipamento.getNome();
		case QUANTIDADE:
			return equipamento.getQuantidade();
		case FORNECEDOR:
			return equipamento.getFornecedor();
		default:
			// N�o deve ocorrer, pois s� existem 4 colunas
			throw new IndexOutOfBoundsException("columnIndex out of bounds");
		}
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		// Pega o fornecedor referente a linha especificada.
		EquipamentoTO equipamento = linhas.get(rowIndex);

		switch (columnIndex) {
		case CODIGO:
			equipamento.setCodigo((int) aValue);
			break;
		case NOME:
			equipamento.setNome((String) aValue);
			break;
		case QUANTIDADE:
			equipamento.setQuantidade((int) aValue);
			break;
		case FORNECEDOR:
			equipamento.setFornecedor((String) aValue);
			break;
		default:
			// N�o deve ocorrer, pois s� existem 4 colunas
			throw new IndexOutOfBoundsException("columnIndex out of bounds");
		}

		fireTableCellUpdated(rowIndex, columnIndex); // Notifica a atualiza��o da c�lula
	}

}
