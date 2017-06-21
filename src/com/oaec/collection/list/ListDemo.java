package com.oaec.collection.list;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.oaec.common.HibernateSessionFactory;

public class ListDemo {

	public static void main(String[] args) {

		ItemsList items = new ItemsList();
		items.setName("Alva");
		
		List<String> images = new ArrayList<>();
		images.add("d:/lix/a.png");
		images.add("d:/lix/b.png");
		images.add("f:/lix/c.png");
		
		items.setImagesList(images);
		
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = null;
		try{
			trans = session.beginTransaction();
			session.save(items);
			
			
			trans.commit();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
