package com.oaec.cache;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.oaec.basic.pojo.Student;
import com.oaec.common.HibernateSessionFactory;

public class FirstCacheDemo {

	public static void main(String[] args) {

		Session session = HibernateSessionFactory.getSession();
		Transaction trans = null;
		try {
			trans = session.beginTransaction();//��DB���
			Student stu = (Student)session.get(Student.class, 1L);
			System.out.println(stu);
			/*trans.commit();
			
			session = HibernateSessionFactory.getSession();
			trans = session.beginTransaction();*/
			stu = (Student)session.get(Student.class, 1L);//�ӻ������ѯ
			System.out.println(stu);
			
//			session.save(new Student(10L,"Ruby", "��", 28));
			stu = (Student) session.get(Student.class, 74L);
			System.out.println(stu);
			session.delete(stu);
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
		}
		
	}

}
