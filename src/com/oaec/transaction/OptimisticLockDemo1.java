package com.oaec.transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.oaec.transaction.pojo.AccountTimeStamp;
import com.oaec.transaction.pojo.AccountVersion;

public class OptimisticLockDemo1 {

	public static void main(String[] args) {
		Configuration config = new Configuration();
		config.configure("hibernate.cfg.xml");
		ServiceRegistryBuilder builder = new ServiceRegistryBuilder();
		builder.applySettings(config.getProperties());
		ServiceRegistry serviceRegistry = builder.buildServiceRegistry();
		
		SessionFactory factory = config.buildSessionFactory(serviceRegistry);
		Session session = factory.openSession();
		Transaction trans = null;
		
		try{
			trans = session.beginTransaction();
			System.out.println("事务一更新...");
//			AccountVersion account = (AccountVersion) session.get(AccountVersion.class, 1l);
			AccountTimeStamp account = (AccountTimeStamp) session.get(AccountTimeStamp.class, 1l);
			System.out.println(account);
			
			try {
				Thread.sleep(7000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			account.setBalance(10000);
			session.update(account);
			
			trans.commit();
		}catch(Exception e) {
			e.printStackTrace();
			trans.rollback();
		}finally{
			session.close();
		}
	}

}
