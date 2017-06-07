package com.oaec.association.one2many;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.oaec.association.many2many.pojo.Engineer;
import com.oaec.association.many2many.pojo.Technology;
import com.oaec.common.HibernateSessionFactory;

public class Many2manyDemo {

	public static void main(String[] args) {
		Engineer e1 = new Engineer();
		e1.setName("Resse");
		e1.setAge(40);
		e1.setGender("��");
		e1.setCompany("Watching Cmp");
		
		Engineer e2 = new Engineer();
		e2.setName("Fitch");
		e2.setAge(40);
		e2.setGender("��");
		e2.setCompany("Watching Cmp");
		
		Technology t1 = new Technology();
		t1.setName("�ڿ�");
		t1.setCategory("���ֱ��˵���");
		
		Technology t2 = new Technology();
		t2.setName("���");
		t2.setCategory("�����Ի�ȡ������Ϣ");
		
		e1.getTechs().add(t1);
		e1.getTechs().add(t2);
		e2.getTechs().add(t1);
		e2.getTechs().add(t2);
		
		t1.getEngis().add(e1);
		t1.getEngis().add(e2);
		t2.getEngis().add(e1);
		t2.getEngis().add(e2);
		
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = null;
		try{
			trans = session.beginTransaction();
//			session.save(e1);
//			session.save(e2);
			
			Engineer e3 = (Engineer) session.get(Engineer.class, 6L);
			session.delete(e3);
			trans.commit();
		}catch(Exception e){
			trans.rollback();
		}
		
	}

}
