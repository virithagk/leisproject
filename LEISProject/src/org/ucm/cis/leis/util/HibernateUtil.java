package org.ucm.cis.leis.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateUtil {

	private static final SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {

		try {
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			return sessionFactory;
			
		} catch (Throwable ex) {

			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {

		return sessionFactory;
	}
}
