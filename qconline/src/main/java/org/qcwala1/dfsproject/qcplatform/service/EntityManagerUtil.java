package org.qcwala1.dfsproject.qcplatform.service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerUtil {
	private static EntityManagerFactory entityManagerFactory;
	static {
		Map<String, String> persistenceMap = new HashMap<>();
		URI dbUri = null;
		try {
			dbUri = new URI(System.getenv("DATABASE_URL"));
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		if (dbUri != null) {

			String username = dbUri.getUserInfo().split(":")[0];
			String password = dbUri.getUserInfo().split(":")[1];
			String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();

			persistenceMap.put("javax.persistence.jdbc.url", dbUrl);
			persistenceMap.put("javax.persistence.jdbc.user", username);
			persistenceMap.put("javax.persistence.jdbc.password", password);
			persistenceMap.put("javax.persistence.jdbc.driver", "org.postgresql.Driver");
			persistenceMap.put("javax.persistence.schema-generation.database.action", "create");
			try {
				// entityManagerFactory =
				// Persistence.createEntityManagerFactory("QCportalPU");
				entityManagerFactory = Persistence.createEntityManagerFactory("<current persistence unit>",
						persistenceMap);

			} catch (Throwable ex) {
				throw new ExceptionInInitializerError(ex);
			}

		}
	}

	public static EntityManager getEntityManager() {
		return entityManagerFactory.createEntityManager();
	}
}
