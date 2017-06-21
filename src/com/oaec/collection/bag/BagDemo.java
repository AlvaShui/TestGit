package com.oaec.collection.bag;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.oaec.collection.list.ItemsList;
import com.oaec.common.HibernateSessionFactory;

/**
 * @author Administrator
 * bag指的是backpack，指包的映射，是无序的
 */
public class BagDemo {

	public static void main(String[] args) {
		ItemsBag items = new ItemsBag();
		items.setName("Alva");
		
		List<String> images = new ArrayList<>();
		images.add("d:/lix/a.png");
		images.add("d:/lix/b.png");
		images.add("f:/lix/c.png");
		
		items.setBags(images);
		
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = null;
		try{
			trans = session.beginTransaction();
//			session.save(items);
			
			ItemsBag item = (ItemsBag) session.get(ItemsBag.class, 1L);
			System.out.println(item);
			
			trans.commit();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
