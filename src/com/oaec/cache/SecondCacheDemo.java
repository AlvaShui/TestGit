package com.oaec.cache;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.oaec.basic.pojo.Student;
import com.oaec.common.HibernateSessionFactory;

public class SecondCacheDemo {

	public static void main(String[] args) {
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = null;
		try {
			trans = session.beginTransaction();//从DB里查
//			Student stu = (Student)session.load(Student.class, 1L);
//			System.out.println(stu);
			Query query = session.createQuery("from Student");
			//设置开启查询的二级缓存
			query.setCacheable(true);
			List<Student> list = query.list();
			System.out.println(list.size());
			
			
			trans.commit();
			
			session = HibernateSessionFactory.getSession();
			trans = session.beginTransaction();//从缓存里拿，有可能从一级缓存也可能从二级
//			stu = (Student)session.load(Student.class, 1L);
//			System.out.println(stu);
			query = session.createQuery("from Student");
			query.setCacheable(true);
			list = query.list();
			System.out.println(list.size());
			trans.commit();
			
		} catch (Exception e) {
			trans.rollback();
		}
		
	}
}
