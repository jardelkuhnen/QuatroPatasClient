package br.univel.model;

import java.util.List;

import javax.swing.table.AbstractTableModel;

public class AnimalModel extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6606242254644688342L;

	private List<Animal> list;

	public AnimalModel(List animais) {
		this.list = animais;
	}

	@Override
	public int getColumnCount() {
		return list.size();
	}

	@Override
	public int getRowCount() {

		return 3;
	}

	@Override
	public Object getValueAt(int row, int col) {

		Animal a = this.list.get(row);

		switch (col) {
		case 0:
			return a.getId();
		case 1:
			return a.getEspecie();
		case 2:
			return a.getProprietario();
		case 3:
			return a.getNome();
		case 4:
			return "";
		case 5:
			return "";
		}

		throw new RuntimeException("Coluna " + col + " solicitada, não existe.");

	}

	@Override
	public String getColumnName(int col) {

		switch (col) {
		case 0:
			return "Id";
		case 1:
			return "Espécie";
		case 2:
			return "Proprietário";
		case 3:
			return "Nome";

		default:
			return "";
		}

	}

}
