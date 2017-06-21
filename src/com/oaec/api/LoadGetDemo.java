package com.oaec.api;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.oaec.association.one2many.pojo.Order;
import com.oaec.basic.pojo.Student;
import com.oaec.common.HibernateSessionFactory;

public class LoadGetDemo {

	public static void main(String[] args) {
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = null;
		try{
			trans = session.beginTransaction();
			
			
//			Student stu = (Student) session.get(Student.class, 99L);
			/*Student stu = (Student) session.load(Student.class, 99L);
			System.out.println(stu);*/
			
			Order order = (Order) session.get(Order.class, 24L);
			System.out.println(order.getOrderlines());
			
//			Order order = (Order) session.load(Order.class, 24L);
//			System.out.println(order.getTotal());
//			System.out.println(order.getOrdered_date());
			
			trans.commit();
		}catch(Exception e) {
			e.printStackTrace();
			trans.rollback();
		}
	}
}
