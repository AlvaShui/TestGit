package com.oaec.association.one2many;

import java.util.Calendar;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.oaec.association.one2many.pojo.Order;
import com.oaec.association.one2many.pojo.OrderLine;
import com.oaec.common.HibernateSessionFactory;

public class One2manyDemo {

	public static void main(String[] args) {
		OrderLine ol1 = new OrderLine();
		ol1.setPrice(35.11);
		ol1.setProduct("J2ee");
		ol1.setQuantity(66L);
		
		OrderLine ol2 = new OrderLine();
		ol2.setPrice(55.11);
		ol2.setProduct("hibernate");
		ol2.setQuantity(100L);

		Order o = new Order();
		o.setOrdered_date(new Date());
		Calendar ca = Calendar.getInstance();
		ca.set(Calendar.DAY_OF_MONTH, Calendar.DAY_OF_MONTH+3);
		o.setShipped_date(new Date(ca.getTimeInMillis()));
		
		ol1.setOrder(o);
		ol2.setOrder(o);
		o.getOrderlines().add(ol1);
		o.getOrderlines().add(ol2);
		
		o.setTotal(ol1.getPrice()*ol1.getQuantity()+ol2.getPrice()*ol2.getQuantity());
		
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = null;
		try {
			//级联保存
			trans = session.beginTransaction();
//			session.save(o);
			
			//级联查询
			Order order = (Order) session.get(Order.class, 25L);
//			System.out.println(order);
			
			//级联更新
			double total = 0;
			for(OrderLine ol:order.getOrderlines()) {
				ol.setPrice(33.33);
				ol.setQuantity(10L);
				total += ol.getPrice()*ol.getQuantity();
			}
			order.setTotal(total);
			session.update(order);
			
			//级联删除
//			session.delete(order);
			
			trans.commit();
		}catch(Exception e) {
			trans.rollback();
		}
	}

}
