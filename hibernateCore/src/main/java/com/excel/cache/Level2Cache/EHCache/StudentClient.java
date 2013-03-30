package com.excel.cache.Level2Cache.EHCache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

class StudentClient 
{
	public static void main(String[] args) throws Exception {
		//activate hibernate software
		Configuration cfg = new Configuration();
		//read configuration file
		cfg  = cfg.configure();
		// create SessionFactory 
		SessionFactory factory = cfg.buildSessionFactory();
		System.out.println("Factory is: "+factory);
		//getting session from session factory
		Session ses1 = factory.openSession();
		Session ses2 = factory.openSession();
		//creation of StudentBean class object

		StudentBean st1, st2;// = new StudentBean();

		//st1.setSid(5);

		//creation of Transaction object as we are modifying database table

		//Transaction tx = ses1.beginTransaction();


		//ses1.evict(st1);
		//Thread.sleep(5000);
		//st1 = (StudentBean) ses1.get(StudentBean.class, new Integer(105));

		

		//Thread.sleep(5000);
		st1 = (StudentBean) ses1.get(StudentBean.class, new Integer(105));
		st2 = (StudentBean) ses2.get(StudentBean.class, new Integer(105));
	
		System.out.println("Record Values r: ");
		ses1.close();	
		ses2.close();
		System.out.println(st1.getSid()+" "+st1.getSname()+" "+st1.getTot_m());
		System.out.println(st2.getSid()+" "+st2.getSname()+" "+st2.getTot_m());
		/*
		ses = factory.openSession();
		st1 = (StudentBean) ses1.get(StudentBean.class, new Integer(105));
*/
		factory.close();

	}
}
