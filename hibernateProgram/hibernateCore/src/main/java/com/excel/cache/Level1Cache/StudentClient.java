package com.excel.cache.Level1Cache;

import org.hibernate.cfg.*;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.hibernate.*;

import com.excel.util.HibernateUtil;

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
//		Session ses1 = factory.openSession();
		Session ses1 = HibernateUtil.getSessionFactory().openSession();
//		Configuration config=new Configuration();
//		config.configure("hibernate.cfg.xml");
//		new SchemaExport(config).create(true, true);
//		SessionFactory factory=config.buildSessionFactory();
//		Session ses1=factory.openSession();
//		
		
		ses1.beginTransaction();
		//creation of StudentBean class object
		StudentBean st1= new StudentBean();
//		st1.setSid(105);
//		st1.setSname("Jag");
//		st1.setTot_m(23f);
//		
//		ses1.save(st1);
//		ses1.getTransaction().commit();
		st1 = (StudentBean) ses1.get(StudentBean.class, new Integer(105)); // 1st min
		System.out.println(st1.getSid()+" "+st1.getSname()+" "+st1.getTot_m());
		
//		ses1.evict(st1);
		st1 = (StudentBean) ses1.get(StudentBean.class, new Integer(105)); // 10th min
		System.out.println("Record Values r: ");
		System.out.println(st1.getSid()+" "+st1.getSname()+" "+st1.getTot_m());
//		ses1.close();	
//		factory.close();
	}
}
