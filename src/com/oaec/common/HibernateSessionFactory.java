package com.oaec.common;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateSessionFactory {

	private static Configuration config;
	private static SessionFactory factory;
//	private static ThreadLocal<Session> local = new ThreadLocal<Session>();
	
	static {
		config = new Configuration();
		config.configure("hibernate.cfg.xml");
		ServiceRegistryBuilder builder = new ServiceRegistryBuilder();
		builder.applySettings(config.getProperties());
		ServiceRegistry serviceRegistry = builder.buildServiceRegistry();
		factory = config.buildSessionFactory(serviceRegistry);
	}
	
	public static Session getSession() {//将当前线程与session绑定起来，解决session的安全性
		/*Session session = local.get();
		if(session == null) {
			session = factory.openSession();
			local.set(session);
		}*/
		Session session = factory.getCurrentSession();
		return session;
	}
	
	/*public static void closeSession() {
		Session session = local.get();
		if(session != null) {
			session.close();
			local.set(null);
		}
	}*/
}
