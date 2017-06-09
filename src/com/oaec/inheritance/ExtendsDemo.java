package com.oaec.inheritance;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.oaec.common.HibernateSessionFactory;
import com.oaec.inheritance.pojo.BankAccount;
import com.oaec.inheritance.pojo.BillingDetails;
import com.oaec.inheritance.pojo.CreditCard;

/**
 * @author Administrator
 *所有类映射一张表，映射文件用<subclass>
 */
public class ExtendsDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BankAccount ba = new BankAccount();
		ba.setBankName("china bank");
		ba.setBankSwift("cnb");
		ba.setCreated(new Date(System.currentTimeMillis()));
		ba.setCode("222");
		ba.setOwner("iotek1");
		
		CreditCard cc = new CreditCard();
		cc.setCredit_card_type("China");
		cc.setExpired_year("2016");
		cc.setExpired_month("2");
		cc.setCreated(new Date(System.currentTimeMillis()));
		cc.setOwner("iotek2");
		cc.setCode("333");
		
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = null;
		try{
			trans = session.beginTransaction();
//			session.save(bd);
//			session.save(ba);
//			session.save(cc);
			
			BillingDetails account = 
					(BillingDetails)session.get(BillingDetails.class, 1L);
			System.out.println(account);
		
			trans.commit();
		}catch(Exception e){
			e.printStackTrace();
			trans.rollback();
		}
	}

}
