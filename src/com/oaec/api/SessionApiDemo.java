package com.oaec.api;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.oaec.basic.pojo.Student;
import com.oaec.common.HibernateSessionFactory;

public class SessionApiDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Session session = HibernateSessionFactory.getSession();
		Transaction trans = null;
		
		try{
			trans = session.beginTransaction();
			/* save ���� */
/*//		Student stu = new Student(null, "xiaozhang", "��", 33);
			Student stu = (Student) session.get(Student.class, 94L);
//			stu.setName("zhangsanfeng");
			session.clear();
			session.save(stu);*/
			
			/* update����*/
/*//			Student stu = new Student(73L, "xiaozhang", "��", 33);
			Student stu = (Student) session.get(Student.class, 73L);
//			stu.setName("zhangsanfeng");
			session.evict(stu);
			session.update(stu);//��������״̬�Ĳ�����������ζ������
*/			
			/* saveOrUpdate����  */
/*//			Student stu = new Student(null, "xiaozhang", "��", 33);
			Student stu = (Student) session.get(Student.class, 73L);
//			stu.setName("С��");
			session.evict(stu);
			session.saveOrUpdate(stu);*/
			
			/*delete����*/
//			Student stu = new Student(73L,"Bob","Ů",22);
			Student stu = (Student) session.get(Student.class, 68L);
//			stu.setName("С��");
			session.clear();
//			session.evict(stu);
			session.delete(stu);
			
			trans.commit();
		}catch(Exception e) {
			e.printStackTrace();
			trans.rollback();
		}
	}

}
