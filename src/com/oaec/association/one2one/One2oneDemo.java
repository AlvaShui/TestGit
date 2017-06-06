package com.oaec.association.one2one;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.oaec.association.one2one.pojo.Passport;
import com.oaec.association.one2one.pojo.Person;
import com.oaec.common.HibernateSessionFactory;

public class One2oneDemo {
	public static void main(String[] args) {
		Person p = new Person();
		p.setName("哈方法");
		p.setGender("男");
		p.setAge(34);

		Passport pp = new Passport();
		pp.setBh("GB1231323414");

		p.setPassport(pp);
		pp.setPerson(p);

		Session session = HibernateSessionFactory.getSession();
		Transaction trans = null;
		try {
//			级联增加
			trans = session.beginTransaction();
//			 session.save(p);
//			级联查询
			Person person = (Person) session.get(Person.class, 1L);
//			 System.out.println(person);

			// 级联更新
//			 person.setName("Alva Chen");
//			 person.setAge(21);
//			 person.getPassport().setBh("gb123345");
//			 session.update(person);

			// 级联删除
			session.delete(person);

			trans.commit();
		} catch (Exception e) {
			trans.rollback();
		}
	}
}