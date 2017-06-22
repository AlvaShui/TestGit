package com.oaec.query;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.oaec.association.one2many.pojo.Order;
import com.oaec.association.one2many.pojo.OrderLine;
import com.oaec.basic.pojo.Student;
import com.oaec.common.HibernateSessionFactory;
import com.oaec.component.pojo.Address;
import com.oaec.component.pojo.Customer;
import com.oaec.inheritance.pojo.BillingDetails;

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
	//连接查询
	public void joinQuery(Long id) {
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = null;
		
		try{
			trans = session.beginTransaction();
			Query query = session.createQuery("from Order o left outer join o.orderlines ol where ol.order.id=?1");
			query.setParameter("1", id);
			List<Object[]> list = query.list();
			for (Object[] objects : list) {
				Order order = (Order) objects[0];
				System.out.println(order);
				OrderLine orderLine = (OrderLine) objects[1];
				System.out.println(orderLine);
			}
			
			trans.commit();
		}catch(Exception e) {
			e.printStackTrace();
			trans.rollback();
		}
		
	}
	
//		投影查询
	public void projectionQuery(Long id) {
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = null;
		
		try{
			trans = session.beginTransaction();
			Query query = session.createQuery("select c.name,c.address.city,c.address.street from Customer c where c.id = ?1");
			query.setParameter("1", id);
			List<Object[]> list1 = query.list();
			for (Object[] objects : list1) {
				for (Object object : objects) {
					System.out.print(object+" ");
				}
				System.out.println();
			}
			
			query = session.createQuery(
					"select new com.oaec.component.pojo.Address(c.address.province,c.address.city,c.address.street) from Customer c where c.id = ?1");
			query.setParameter("1", id);
			List<Address> list2 = query.list();
			for (Address address : list2) {
				System.out.println(address);
			}
			
			trans.commit();
		}catch(Exception e) {
			e.printStackTrace();
			trans.rollback();
		}
	}
	
	//过滤查询
	public void filterQuery(Long id) {
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = null;
		
		try{
			trans = session.beginTransaction();
			Order order = (Order) session.get(Order.class, id);
			Query query = session.createFilter(order.getOrderlines(), "where this.quantity >= 7");
			List list = query.list();
			System.out.println(list);
			
			trans.commit();
		}catch(Exception e) {
			e.printStackTrace();
			trans.rollback();
		}
	}
	
	//命名查询
		public void namedQuery(Long id) {
			Session session = HibernateSessionFactory.getSession();
			Transaction trans = null;
			
			try{
				trans = session.beginTransaction();
				Query query = session.getNamedQuery("namedStudentQuery");
				query.setParameter("1", id);
				List list = query.list();
				System.out.println(list);
				
				trans.commit();
			}catch(Exception e) {
				e.printStackTrace();
				trans.rollback();
			}
		}
	
	//多态查询
	public void polymorphismQuery(){
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = null;
		
		try{
			trans = session.beginTransaction();
			Query query = session.createQuery("from BillingDetails where id = 22L");
			List<BillingDetails> list = query.list();
			System.out.println(list);
			
			trans.commit();
		}catch(Exception e) {
			e.printStackTrace();
			trans.rollback();
		}
	}
		
	public static void main(String[] args) {
//		new QueryTest().queryObj(2L);
//		new QueryTest().queryList();
//		new QueryTest().dynamicQuery("男", 10);
//		new QueryTest().SQLQuery();
//		new QueryTest().pagesQuery();
//		new QueryTest().joinQuery(1L);
//		new QueryTest().projectionQuery(1L);
//		new QueryTest().filterQuery(1l);
//		new QueryTest().namedQuery(2l);
		new QueryTest().polymorphismQuery();
		
		
		
	}
}
