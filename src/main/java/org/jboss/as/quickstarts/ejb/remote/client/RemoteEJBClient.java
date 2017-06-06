package org.jboss.as.quickstarts.ejb.remote.client;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import br.univel.dao.AnimalDao;

public class RemoteEJBClient {

	public static AnimalDao lookupRemoteStatelessCalculator() throws NamingException {

		final Hashtable<String, String> jndiProperties = new Hashtable<>();
		jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
		final Context context = new InitialContext(jndiProperties);

		return (AnimalDao) context.lookup("ejb:/QuatroPatasServer/AnimalDaoImpl!" + AnimalDao.class.getName());
	}

}
