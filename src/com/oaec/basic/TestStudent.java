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
		stu.setSex("��");
		stu.setAge(20);
		
	/*	Configuration config = new Configuration();
		config.configure("hibernate.cfg.xml");
		//�����hibernate.properties�Ļ��Ͳ���Ҫ����configure�����ˣ�ֻ�ǵ��ں�������ӳ���ļ���
		
		//����ӳ���ļ��ķ�����ע�⣺��������˷������Ͳ�������cfg.xml��д<mapping>������ֻ�ܴ���һ����
		//�Ƽ���<mapping>�����Ƽ�������Ӳ����ķ�����
//		config.addResource("com/oaec/basic/pojo/Student.hbm.xml");
//		config.addClass(Student.class);
		
//		SessionFactory factory = config.buildSessionFactory();//�ѹ�ʱ
		
		ServiceRegistryBuilder builder = new ServiceRegistryBuilder();
		builder.applySettings(config.getProperties());
		ServiceRegistry serviceRegistry = builder.buildServiceRegistry();
		SessionFactory factory = config.buildSessionFactory(serviceRegistry);
	
		Session session = factory.openSession();
		
		*/
		
		//��װ���Ժ�
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
