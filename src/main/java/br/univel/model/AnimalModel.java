package br.univel.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class AnimalModel extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6606242254644688342L;

	private ArrayList<Animal> list;

	public AnimalModel(ArrayList animais) {
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
		default:
			return "";
		}

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
