package br.edu.univas.si4.lab4.view.fornecedor;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.edu.univas.si4.lab4.to.FornecedorTO;

public class TableModelFornecedor extends AbstractTableModel {

	private static final long serialVersionUID = -3393126111516596805L;

	private String[] columnNames = { "RAZÃO SOCIAL", "CNPJ", "NOME FANTASIA" };

	// Constantes representando o índice das colunas
	private static final int RAZAO = 0;
	private static final int CNPJ = 1;
	private static final int FANTASIA = 2;

	// Lista de Fornecedores a serem exibidos na tabela
	private List<FornecedorTO> linhas;

	// Cria um FornecedorTableModel sem nenhuma linha
	public TableModelFornecedor() {
		linhas = new ArrayList<FornecedorTO>();
	}

	// Cria um FornecedorTableModel contendo a lista recebida por parâmetro
	public TableModelFornecedor(List<FornecedorTO> listaDeFornecedores) {
		linhas = new ArrayList<FornecedorTO>(listaDeFornecedores);
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
		case CNPJ:
			return Long.class;
		case RAZAO:
			return String.class;
		case FANTASIA:
			return String.class;
		default:
			// Não deve ocorrer, pois só existem 3 colunas
			throw new IndexOutOfBoundsException("columnIndex out of bounds");
		}
	}

	// Deixa as celulas não editaveis
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// Pega o fornecedor referente a linha especificada.
		FornecedorTO fornecedor = linhas.get(rowIndex);

		switch (columnIndex) {
		case CNPJ:
			return fornecedor.getCnpj();
		case RAZAO:
			return fornecedor.getNomeRazao();
		case FANTASIA:
			return fornecedor.getFantasia();
		default:
			// Não deve ocorrer, pois só existem 3 colunas
			throw new IndexOutOfBoundsException("columnIndex out of bounds");
		}
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		// Pega o fornecedor referente a linha especificada.
		FornecedorTO fornecedor = linhas.get(rowIndex);

		switch (columnIndex) {
		case CNPJ:
			fornecedor.setCnpj((Long) aValue);
			break;
		case RAZAO:
			fornecedor.setNomeRazao((String) aValue);
			break;
		case FANTASIA:
			fornecedor.setFantasia((String) aValue);
		default:
			// Não deve ocorrer, pois só existem 3 colunas
			throw new IndexOutOfBoundsException("columnIndex out of bounds");
		}

		fireTableCellUpdated(rowIndex, columnIndex); // Notifica a atualização da célula
	}
}
