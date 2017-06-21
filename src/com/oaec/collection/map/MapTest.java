package com.oaec.collection.map;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.oaec.common.HibernateSessionFactory;

public class MapTest {

	public static void main(String[] args) {
		ItemsMap items = new ItemsMap();
		items.setName("tom");
		
		Map<String, String> images = new HashMap<String, String>();
		images.put("image1", "f:/images/image1.jpg");
		images.put("image2", "f:/images/image2.jpg");
		images.put("image3", "f:/images/image3.jpg");

		items.setImages(images);
		
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = null;
		
		try{
			trans = session.beginTransaction();
//			session.save(items);
			ItemsMap item = (ItemsMap) session.get(ItemsMap.class, 1L);
			System.out.println(item);
			
			trans.commit();
		}catch(Exception e){
			e.printStackTrace();
			trans.rollback();
		}
		
	}

}
