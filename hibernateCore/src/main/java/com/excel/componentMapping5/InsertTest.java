package com.excel.componentMapping5;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.excel.user.JobType;
import com.excel.user.Person;
import com.excel.util.HibernateUtil;

public class InsertTest
{
	public static void main(String args[])
	{
		Session ses=null;
		try
		{
			ses = HibernateUtil.getSessionFactory().openSession();
			Transaction tx= ses.beginTransaction();
			Person p1= new Person();
			
			JobType jt1 = new JobType();
			jt1.setJob("Software Engineer");
			jt1.setSalary(50000);
			jt1.setDepartment(101);

			p1.setPname("Sampath");
			p1.setPjob(jt1);

			Person p2 = new Person();
			JobType jt2 = new JobType();
			jt2.setJob("SE");
			jt2.setSalary(25000);
			jt2.setDepartment(102);

			p2.setPname("Tirupathi");
			p2.setPjob(jt2);

			ses.save(p1);
			ses.save(p2);

			tx.commit();
			System.out.println("records  are inserted successfully");
		}
		catch(HibernateException he) {
			he.printStackTrace();
		}
		ses.close();
	}//main
}//class