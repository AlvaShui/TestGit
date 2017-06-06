package com.oaec.basic;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.oaec.basic.pojo.Book;
import com.oaec.common.HibernateSessionFactory;

public class TestBook {

	public static void main(String[] args) {
		Book book = new Book();
//		book.setIsbn("111wwww");
		book.setName("java2");
		book.setAuthor("alva");
		book.setPrice(100.99);
		
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = null;
		try {
			trans = session.beginTransaction();
			session.save(book);
			trans.commit();
		}catch(Exception e) {
			trans.rollback();
		}
	}

}
