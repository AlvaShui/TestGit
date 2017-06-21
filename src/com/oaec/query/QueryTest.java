package com.oaec.query;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.oaec.basic.pojo.Student;
import com.oaec.common.HibernateSessionFactory;

public class QueryTest {
	Query query = null;
	Transaction trans = null;
	Session session = HibernateSessionFactory.getSession();
	
	public void queryObj(Long id) {
		try{
			trans = session.beginTransaction();
			query = session.createQuery("from Student where id = 1");
			Student stu = (Student) query.uniqueResult();
			stu = (Student) query.uniqueResult();
			System.out.println(stu);
			
			System.out.println("*******************************************");
			query = session.createQuery("from Student s where s.id =:id");
			query.setLong("id", id);
			stu = (Student) query.uniqueResult();
			System.out.println(stu);
			
//			此方法在hibernate3.x后就停止了使用，最好不要使用			
			/*System.out.println("*******************************************");
			query = session.createQuery("from Student s where s.id =?");
			query.setLong(0, id);
			stu = (Student) query.uniqueResult();
			System.out.println(stu);*/
			
			System.out.println("*******************************************");
			query = session.createQuery("from Student s where s.id =?1");
			query.setParameter("1", id);
			stu = (Student) query.uniqueResult();
			System.out.println(stu);
			
			trans.commit();
		}catch(Exception e) {
			e.printStackTrace();
			trans.rollback();
		}
		
	}
	
	public void queryList() {
		try{
			trans = session.beginTransaction();
			query = session.createQuery("from Student");
			List list = query.list();
			System.out.println(list);
			
			System.out.println("*******************************************");
			query = session.createQuery("from Student s where s.sex =?1 and age between ?2 and ?3");
			query.setParameter("1", "男");
			query.setParameter("2", 12);
			query.setParameter("3", 15);
			list = query.list();
			System.out.println(list);

			System.out.println("*******************************************");
			query = session.createQuery("from Student s where s.name like ?1");
			query.setParameter("1", "%om%");
			list = query.list();
			System.out.println(list);

			System.out.println("*******************************************");
			query = session.createQuery("select name from Student");
			list = query.list();
			System.out.println(list);

			System.out.println("*******************************************");
			query = session.createQuery("select name from Student s where s.id = ?1");
			query.setParameter("1", 3L);
			String name = (String) query.uniqueResult();
			System.out.println(name);

			System.out.println("*******************************************");
			query = session.createQuery("select count(*) from Student");
			Long total = (Long) query.uniqueResult();
			System.out.println("total:"+total);

			System.out.println("*******************************************");
			query = session.createQuery("select max(age) from Student");
			Integer max = (Integer) query.uniqueResult();
			System.out.println("max age:"+max);
			
			trans.commit();
		}catch(Exception e) {
			e.printStackTrace();
			trans.rollback();
		}
	}
	
	//动态查询
	public void dynamicQuery(String sex,Integer age) {
		
		String HQL = "from Student where 1=1";
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = null;
		
		try{
			trans = session.beginTransaction();
			if(sex != null)
				HQL += " and sex = '"+sex+"'";
			if(age != null)
				HQL += " and age > " +age;
			Query query = session.createQuery(HQL);
			List list = query.list();
			System.out.println(list);
			trans.commit();
		}catch(Exception e) {
			e.printStackTrace();
			trans.rollback();
		}
	}
	
	//原生SQL查询
	public void SQLQuery() {
		String SQL = "select * from STUDENT order by age";
		
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = null;
		
		try{
			trans = session.beginTransaction();
			Query query = session.createSQLQuery(SQL);
			List<Object[]> list = query.list();
			for (Object[] objs : list) {
				for (Object object : objs) {
					System.out.print(object+" ");
				}
				System.out.println();
			}
			trans.commit();
		}catch(Exception e) {
			e.printStackTrace();
			trans.rollback();
		}
	}
	
	//分页查询
	public void pagesQuery() {
		String SQL = "from Student order by age";
		
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = null;
		
		try{
			trans = session.beginTransaction();
			Query query = session.createQuery(SQL);
			query.setFirstResult(1);
			query.setMaxResults(3);
			List list = query.list();
			System.out.println(list);
			
			trans.commit();
		}catch(Exception e) {
			e.printStackTrace();
			trans.rollback();
		}
		
	}
	//
	
	public static void main(String[] args) {
//		new QueryTest().queryObj(2L);
//		new QueryTest().queryList();
//		new QueryTest().dynamicQuery("男", 10);
//		new QueryTest().SQLQuery();
		new QueryTest().pagesQuery();
		
		
		
		
	}
}
