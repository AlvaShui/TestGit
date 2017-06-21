package com.oaec.batch;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.oaec.basic.pojo.Student;
import com.oaec.common.HibernateSessionFactory;

public class HibernateBatchDemo {

	public static void main(String[] args) {
		Long start = System.currentTimeMillis();
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = null;

		try {
			trans = session.beginTransaction();

			for (int i = 0; i < 10000; i++) {
				Student stu = new Student(null, "chens" + i, "ÄÐ", 22);
				session.save(stu);
				if (i % 50 == 0) {
					session.flush();
					session.clear();
				}
			}

			trans.commit();

		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
		}

		long end = System.currentTimeMillis();
		System.out.println("¹²ºÄÊ±"+(end-start)+"ºÁÃë");
	}

}
