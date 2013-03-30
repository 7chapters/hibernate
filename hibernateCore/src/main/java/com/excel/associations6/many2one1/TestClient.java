package com.excel.associations6.many2one1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import com.excel.user.CollegeEntity;
import com.excel.user.StudentCollegeEntity;

public class TestClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Configuration config=new Configuration();
		config.configure("hibernate.cfg.xml");
		new SchemaExport(config).create(true, true);
		SessionFactory factory=config.buildSessionFactory();
		Session sess=factory.openSession();
//		Transaction txn=sess.beginTransaction();
//		//transient instance
//		
//		CollegeEntity college = new CollegeEntity();
//		college.setCollegecode(2l);
//		college.setCname("Srinidhi");
//
//		StudentCollegeEntity studentOne = new StudentCollegeEntity();
//		studentOne.setSid(new Long(11));
//		studentOne.setSname("Rohan");
//		studentOne.setCe(college);
//		
//		StudentCollegeEntity studentTwo=new StudentCollegeEntity();
//		studentTwo.setSid(new Long(22));
//		studentTwo.setSname("Prakash");
//		studentTwo.setCe(college);
//	
//		sess.save(college);
//		
//		sess.save(studentOne);
//		sess.save(studentTwo);	
//		
//		txn.commit();
//		sess.close();
//		factory.close();				
	}
}
