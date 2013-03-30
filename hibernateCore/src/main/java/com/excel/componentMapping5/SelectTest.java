package com.excel.componentMapping5;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.excel.user.JobType;
import com.excel.user.Person;
import com.excel.util.HibernateUtil;

public class SelectTest
{
	public static void main(String args[])
	{
		try
		{
			Session ses = HibernateUtil.getSessionFactory().openSession();
			/*
			Query q1= ses.createQuery("from Person");
            List l=q1.list(); //excute the HQL

            for(int i = 0; i < l.size(); i++)
            {
                Person p= (Person)l.get(i);
                JobType jt = p.getPjob();

                System.out.println(p.getPid()+"  "+p.getPname()+"  "+jt.getJob()+"  "+jt.getSalary()+"  "+jt.getDepartment());
            }*/
			Person p = (Person) ses.get(Person.class, new Integer(13));
			JobType jt = p.getPjob();
			System.out.println(p.getPid()+"  "+p.getPname()+"  "+jt.getJob()+"  "+jt.getSalary()+"  "+jt.getDepartment());
			ses.close();
		}//try
		catch(HibernateException he)
		{
			he.printStackTrace();
		}

	}//main
}//class