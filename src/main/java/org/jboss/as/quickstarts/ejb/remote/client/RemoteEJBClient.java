package org.jboss.as.quickstarts.ejb.remote.client;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import br.univel.dao.AnimalDao;
import br.univel.model.Animal;

public class RemoteEJBClient implements AnimalDao {

	private static AnimalDao dao;

//	public static void main(String[] args) throws NamingException {
//
//		invokeStelessBean();
//
//	}

	private static void invokeStelessBean() throws NamingException {

		dao = lookupRemoteStatelessCalculator();

	}

	private static AnimalDao lookupRemoteStatelessCalculator() throws NamingException {

		final Hashtable<String, String> jndiProperties = new Hashtable<>();
		jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
		final Context context = new InitialContext(jndiProperties);

		return (AnimalDao) context.lookup("ejb:/AnimalServer/AnimalDaoImpl!" + AnimalDao.class.getName());
	}

	@Override
	public Animal create(Animal animal) {

		return null;
	}

	@Override
	public Animal getById(int id) {

		return null;
	}

	@Override
	public void delete(Animal animal) {

	}

	@Override
	public Animal edit(Animal animal) {

		return null;
	}

	@Override
	public ArrayList<Animal> getAll() {

		ArrayList<Animal> animais = (ArrayList<Animal>) dao.getAll();

		return animais;
	}

}
