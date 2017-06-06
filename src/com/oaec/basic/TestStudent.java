package com.oaec.basic;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.oaec.basic.pojo.Student;
import com.oaec.common.HibernateSessionFactory;

public class TestStudent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Student stu = new Student();
		stu.setName("Alva");
		stu.setSex("男");
		stu.setAge(20);
		
	/*	Configuration config = new Configuration();
		config.configure("hibernate.cfg.xml");
		//如果用hibernate.properties的话就不需要调用configure方法了，只是得在后面增加映像文件。
		
		//增加映像文件的方法，注意：这里调用了方法，就不能再在cfg.xml中写<mapping>，二者只能存在一个。
		//推荐用<mapping>，不推荐用这种硬编码的方法。
//		config.addResource("com/oaec/basic/pojo/Student.hbm.xml");
//		config.addClass(Student.class);
		
//		SessionFactory factory = config.buildSessionFactory();//已过时
		
		ServiceRegistryBuilder builder = new ServiceRegistryBuilder();
		builder.applySettings(config.getProperties());
		ServiceRegistry serviceRegistry = builder.buildServiceRegistry();
		SessionFactory factory = config.buildSessionFactory(serviceRegistry);
	
		Session session = factory.openSession();
		
		*/
		
		//封装好以后
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = null;
		try{
			trans = session.beginTransaction();
			session.save(stu);
			System.out.println(session.get(Student.class, 1L));
			trans.commit();
		}catch(Exception e) {
			trans.rollback();
		}/*finally {
//			session.close();
			HibernateSessionFactory.closeSession();
		}*/
	}

}
