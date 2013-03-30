package com.excel.associations6.one2onefk;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.excel.user.StudentEntity;

public class TestClient4 {
	public static void main(String[] args) {
		Configuration config = new Configuration();
		System.out.println("-----1-----");
		config.configure("hibernate.cfg.xml");
		System.out.println("------2------");
		SessionFactory factory = config.buildSessionFactory();
		System.out.println("-------3-----");
		Session sess = factory.openSession();
		Transaction txn = sess.beginTransaction();
		Session newSess = factory.openSession();
         Transaction newtxn=newSess.beginTransaction();
		
		StudentEntity se = (StudentEntity) sess.load(StudentEntity.class,
				new Long(5));

		System.out.println(se.getSname());
		se.setSname("new sone");
		//sess.evict(se);
		sess.update(se);
		txn.commit();
		sess.close();
		newSess.merge(se);
		newtxn.commit();
	}
}
