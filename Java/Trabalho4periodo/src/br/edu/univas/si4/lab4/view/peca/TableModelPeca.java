package br.edu.univas.si4.lab4.view.peca;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.edu.univas.si4.lab4.to.PecaTO;

public class TableModelPeca extends AbstractTableModel {

	private static final long serialVersionUID = -3338458740900151250L;

	private String[] columnNames = { "CODIGO", "NOME", "QUANTIDADE", "TIPO", "EQUIPAMENTO", "FORNECEDOR" };

	// Constantes representando o índice das colunas
	private static final int CODIGO = 0;
	private static final int NOME = 1;
	private static final int QUANTIDADE = 2;
	private static final int TIPO = 3;
	private static final int EQUIPAMENTO = 4;
	private static final int FORNECEDOR = 5;

	// Lista de Fornecedores a serem exibidos na tabela
	private List<PecaTO> linhas;

	// Cria um FornecedorTableModel sem nenhuma linha
	public TableModelPeca() {
		linhas = new ArrayList<PecaTO>();
	}

	// Cria um FornecedorTableModel contendo a lista recebida por parâmetro
	public TableModelPeca(List<PecaTO> listaDePecas) {
		linhas = new ArrayList<PecaTO>(listaDePecas);
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
			return int.class;
		case NOME:
			return String.class;
		case QUANTIDADE:
			return int.class;
		case TIPO:
			return String.class;
		case EQUIPAMENTO:
			return String.class;
		case FORNECEDOR:
			return String.class;
		default:
			// Não deve ocorrer, pois só existem 6 colunas
			throw new IndexOutOfBoundsException("columnIndex out of bounds");
		}
	}

	// Deixa as celulas não editaveis
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return true;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// Pega o fornecedor referente a linha especificada.
		PecaTO peca = linhas.get(rowIndex);

		switch (columnIndex) {
		case CODIGO:
			return peca.getCodigo();
		case NOME:
			return peca.getNome();
		case QUANTIDADE:
			return peca.getQuantidade();
		case TIPO:
			return peca.getTipo();
		case EQUIPAMENTO:
			return peca.getEquipamento();
		case FORNECEDOR:
			return peca.getFornecedor();
		default:
			// Não deve ocorrer, pois só existem 3 colunas
			throw new IndexOutOfBoundsException("columnIndex out of bounds");
		}
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		// Pega o fornecedor referente a linha especificada.
		PecaTO peca = linhas.get(rowIndex);

		switch (columnIndex) {
		case CODIGO:
			peca.setCodigo((int) aValue);
			break;
		case NOME:
			peca.setNome((String) aValue);
			break;
		case QUANTIDADE:
			peca.setQuantidade((int) aValue);
			break;
		case TIPO:
			peca.setTipo((String) aValue);
			break;
		case EQUIPAMENTO:
			peca.setEquipamento((String) aValue);
			break;
		case FORNECEDOR:
			peca.setFornecedor((String) aValue);
			break;
		default:
			// Não deve ocorrer, pois só existem 6 colunas
			throw new IndexOutOfBoundsException("columnIndex out of bounds");
		}

		fireTableCellUpdated(rowIndex, columnIndex); // Notifica a atualização da célula
	}
}
