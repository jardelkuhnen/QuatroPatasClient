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
		return 5;
	}

	@Override
	public int getRowCount() {
		return list.size();
	}

	@Override
	public Object getValueAt(int row, int col) {

		Animal a = this.list.get(row);

		switch (col) {
		case 0:
			return a.getId();
		case 1:
			return a.getNome();
		case 2:
			return a.getEspecie();
		case 3:
			return a.getProprietario();
		case 4: return a;
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
			return "Nome";
		case 2:
			return "Espécie";
		case 3:
			return "Proprietário";

		default:
			return "";
		}

	}

}
