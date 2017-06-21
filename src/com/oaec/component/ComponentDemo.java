package com.oaec.component;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.oaec.common.HibernateSessionFactory;
import com.oaec.component.pojo.Address;
import com.oaec.component.pojo.Customer;

public class ComponentDemo {

	public static void main(String[] args) {
		Customer customer = new Customer();
		customer.setName("ЦЦ");
		
		Address address = new Address();
		address.setProvince("����");
		address.setCity("��ɳ");
		address.setStreet("��һ���");
		
		customer.setAddress(address);
		
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = null;
		try {
			trans = session.beginTransaction();
//			session.save(customer);
			
			Customer cus = (Customer) session.get(Customer.class, 1L);
			System.out.println(cus.getAddress().getCustomer());
			trans.commit();
			
		}catch(Exception e) {
			trans.rollback();
		}

	}

}
