package info._7chapters.hibernate.mappings.component;

import info._7chapters.hibernate.pojo.JobType;
import info._7chapters.hibernate.pojo.Person;
import info._7chapters.hibernate.util.HibernateUtil;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SelectTest
{
	public static void main(String args[])
	{
		try
		{
			Configuration cfg = new Configuration();
			//read configuration file
			cfg  = cfg.configure("hibernate.oracle.cfg.xml");

			SessionFactory factory = cfg.buildSessionFactory();
			Session ses = factory.openSession();

			/*Query q1= ses.createQuery("from Person");
			List l=q1.list(); //excute the HQL

			for(int i = 0; i < l.size(); i++)
			{
				Person p= (Person)l.get(i);
				JobType jt = p.getPjob();

				System.out.println(p.getPid()+"  "+p.getPname()+"  "+jt.getJob()+"  "+jt.getSalary()+"  "+jt.getDepartment());
			}*/

			Person p = (Person) ses.get(Person.class, new Integer(1));
			JobType jt = p.getPjob();
			System.out.println(p.getPid()+"  "+p.getPname()+"  "+jt.getJob()+"  "+jt.getSalary()+"  "+jt.getDepartment());
			ses.close();
		}
		catch(HibernateException he)
		{
			he.printStackTrace();
		}

	}//main
}//class