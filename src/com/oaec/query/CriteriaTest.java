package com.oaec.query;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.oaec.basic.pojo.Student;
import com.oaec.common.HibernateSessionFactory;

/**
 * @author Administrator
 *	QBC≤È—Ø
 */
public class CriteriaTest {
	

	public void QBCQuery(String name,int age) {
		Session session = HibernateSessionFactory.getSession();
		
		Transaction trans = null;
		
		try{
			trans = session.beginTransaction();
			Criteria criteria = session.createCriteria(Student.class);
			List<Student> list = criteria.list();
			System.out.println(list);
			
			/*Criterion cr = Restrictions.like("name", name);
			criteria.add(cr);
			Student stu = (Student) criteria.uniqueResult();
			System.out.println(stu);
			
			cr = Restrictions.ge("age", age);
			criteria.add(cr);
			List<Student> list1 = criteria.list();
			System.out.println(list1);
			*/
			
			criteria.addOrder(Order.asc("age"));
			criteria.setFirstResult(1);
			criteria.setMaxResults(3);
			List<Student> list2 = criteria.list();
			System.out.println(list2);
			
			trans.commit();
		}catch(Exception e) {
			e.printStackTrace();
			trans.rollback();
		}
		
	}
	
	public static void main(String[] args) {
		new CriteriaTest().QBCQuery("bob", 12);

	}

}
