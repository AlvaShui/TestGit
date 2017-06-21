package com.oaec.cache;


import org.hibernate.Session;
import org.hibernate.Transaction;

import com.oaec.association.one2many.pojo.Order;
import com.oaec.common.HibernateSessionFactory;

public class SecondCacheDemo2 {

	public static void main(String[] args) {
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = null;
		try {
			trans = session.beginTransaction();//¥”DB¿Ô≤È
			Order order = (Order) session.get(Order.class, 1l);
			System.out.println(order);
			trans.commit();
			
			session = HibernateSessionFactory.getSession();
			trans = session.beginTransaction();
			order = (Order) session.get(Order.class, 1l);
			System.out.println(order);
			trans.commit();
			
			
		} catch (Exception e) {
			trans.rollback();
		}
		
	}
}
