package com.oaec.association.one2one;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.oaec.association.one2one.pojo.Passport;
import com.oaec.association.one2one.pojo.Person;
import com.oaec.common.HibernateSessionFactory;

public class One2oneDemo {
	public static void main(String[] args) {
		Person p = new Person();
		p.setName("������");
		p.setGender("��");
		p.setAge(34);

		Passport pp = new Passport();
		pp.setBh("GB1231323414");

		p.setPassport(pp);
		pp.setPerson(p);

		Session session = HibernateSessionFactory.getSession();
		Transaction trans = null;
		try {
//			��������
			trans = session.beginTransaction();
//			 session.save(p);
//			������ѯ
			Person person = (Person) session.get(Person.class, 1L);
//			 System.out.println(person);

			// ��������
//			 person.setName("Alva Chen");
//			 person.setAge(21);
//			 person.getPassport().setBh("gb123345");
//			 session.update(person);

			// ����ɾ��
			session.delete(person);

			trans.commit();
		} catch (Exception e) {
			trans.rollback();
		}
	}
}