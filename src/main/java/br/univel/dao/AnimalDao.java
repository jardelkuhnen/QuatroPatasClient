package br.univel.dao;

import java.util.ArrayList;

import br.univel.model.Animal;

public interface AnimalDao {

	Animal create(Animal animal);

	Animal getById(int id);

	void delete(Animal animal);

	Animal edit(Animal animal);

	ArrayList<Animal> getAll();
}
