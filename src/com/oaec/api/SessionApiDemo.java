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
			/* save 方法 */
/*//		Student stu = new Student(null, "xiaozhang", "男", 33);
			Student stu = (Student) session.get(Student.class, 94L);
//			stu.setName("zhangsanfeng");
			session.clear();
			session.save(stu);*/
			
			/* update方法*/
/*//			Student stu = new Student(73L, "xiaozhang", "男", 33);
			Student stu = (Student) session.get(Student.class, 73L);
//			stu.setName("zhangsanfeng");
			session.evict(stu);
			session.update(stu);//传入游离状态的参数，无论如何都会更新
*/			
			/* saveOrUpdate方法  */
/*//			Student stu = new Student(null, "xiaozhang", "男", 33);
			Student stu = (Student) session.get(Student.class, 73L);
//			stu.setName("小鹏");
			session.evict(stu);
			session.saveOrUpdate(stu);*/
			
			/*delete方法*/
//			Student stu = new Student(73L,"Bob","女",22);
			Student stu = (Student) session.get(Student.class, 68L);
//			stu.setName("小鹏");
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
