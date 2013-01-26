package com.excel.associations6.one2onefk;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.excel.user.StudentEntity;

public class TestClient5 {
	public static void main(String[] args) {

		Configuration config = new Configuration();
		config.configure("hibernate.cfg.xml");
		SessionFactory factory = config.buildSessionFactory();
		Session sess = factory.openSession();
		Transaction txn = sess.beginTransaction();
		StudentEntity se = (StudentEntity) sess.get(StudentEntity.class,
				new Long(1));// select,rs, rs mapped to java object
		System.out.println(se.getSname());
		sess.delete(se);
		txn.commit();
	}
}