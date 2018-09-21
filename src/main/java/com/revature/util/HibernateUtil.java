package com.revature.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
<<<<<<< HEAD
	
=======

>>>>>>> c96a7c10968082faaa8ead982eb7bdad04968a01
	private HibernateUtil() {
		super();
	}
	
	private static SessionFactory sessionFactory;
	
	private static SessionFactory getSessionFactory(String filename) {
		if(HibernateUtil.sessionFactory == null) {
			Configuration c = new Configuration().configure(filename);
			ServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(c.getProperties()).build();
			HibernateUtil.sessionFactory = c.buildSessionFactory(sr);
		}
<<<<<<< HEAD
=======
		
>>>>>>> c96a7c10968082faaa8ead982eb7bdad04968a01
		return HibernateUtil.sessionFactory;
	}
	
	public static Session getSession() {
		return getSessionFactory("hibernate.cfg.xml").openSession();
	}
<<<<<<< HEAD

=======
	
>>>>>>> c96a7c10968082faaa8ead982eb7bdad04968a01
}
