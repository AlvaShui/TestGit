package com.oaec.transaction;

import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.oaec.transaction.pojo.Account;

public class PessimisticLockTest1 {

	public static void main(String[] args) {
		Configuration config = new Configuration();
		config.configure("hibernate.cfg.xml");
		ServiceRegistryBuilder builder = new ServiceRegistryBuilder();
		builder.applySettings(config.getProperties());
		
		ServiceRegistry serviceRegistry = builder.buildServiceRegistry();
		SessionFactory factory = config.buildSessionFactory(serviceRegistry);
		
		Session session = factory.openSession();
		Transaction trans = session.beginTransaction();
		
		Account account = (Account) session.get(Account.class, 1L,LockMode.PESSIMISTIC_WRITE );
		System.out.println(account);
		System.out.println("事物1查询完毕。。");
		try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		account.setBalance(8000);
		session.update(account);
		trans.commit();
		System.out.println("事务1更新完毕。。");
		
		session.close();
	}

}
