package com.oaec.collection.set;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.oaec.common.HibernateSessionFactory;

public class SetDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ItemsSet items = new ItemsSet();
		items.setName("user name");
		Set<String> images = new HashSet<>();
		images.add("f:/pic/a.jpg");
		images.add("f:/pic/1.jpg");
		images.add("f:/pic/one.jpg");
		
		items.setImagesSet(images);
		
		Session session = HibernateSessionFactory.getSession();
		
		Transaction trans = null;
		
		try{
			trans = session.beginTransaction();
//			session.save(items);
			ItemsSet item = (ItemsSet) session.get(ItemsSet.class, 1L);
			System.out.println(item);
			session.delete(item);
			
			trans.commit();
		}catch(Exception e) {
			trans.rollback();
		}
		
	}

}
