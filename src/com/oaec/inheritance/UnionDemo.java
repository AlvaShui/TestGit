package com.oaec.inheritance;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.oaec.common.HibernateSessionFactory;
import com.oaec.inheritance.pojo.BankAccount;
import com.oaec.inheritance.pojo.CreditCard;

/**
 * @author Administrator
 *每个具体子类映射一张表，映射文件用<union-subclass>
 */
public class UnionDemo {
	

	public static void main(String[] args) {
		BankAccount ba1 = new BankAccount();
		ba1.setBankName("jian she");
		ba1.setBankSwift("js");
		ba1.setOwner("Alva");
		ba1.setCreated(new Date(System.currentTimeMillis()));
		ba1.setCode("123345");
		
		CreditCard cc = new CreditCard();
		cc.setCredit_card_type("xin yong ka");
		cc.setExpired_year("2017");
		cc.setExpired_month("7");
		cc.setCode("766232");
		cc.setOwner("Alice");
		cc.setCreated(new Date(System.currentTimeMillis()));
		
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = null;
		
		try {
			trans = session.beginTransaction();
			session.save(ba1);
			session.save(cc);
			trans.commit();
		}catch(Exception e) {
			trans.rollback();
		}
	}

}
