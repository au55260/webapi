package org.web.api.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
	
private static final SessionFactory sessionFactory = buildSessionFactory();
	
	private static SessionFactory buildSessionFactory() {
		try {
			// Create the SessionFactory from hibernate.cfg.xml
			System.out.println("In Hibernate Session Factory");
			return new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		} catch (Exception ex) {
			System.err.println("Unnabale to create SessionFactory object :" + ex); 
			//throw new ExceptionInInitializerError(ex);
			return null;
		} 
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;// to get the session factory object!
	}
	public static void shutdown() {
		getSessionFactory().close();
									
	}

}
