package com.excel.associations6.one2onepk;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.excel.user.StudentEntity;
import com.excel.util.HibernateUtil;

public class TestClient3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Session sess = HibernateUtil.getSessionFactory().openSession();
		Transaction txn=sess.beginTransaction();
		StudentEntity se = (StudentEntity)sess.get(StudentEntity.class, new Long(6));
		
		System.out.println(se.getSname());
		System.out.println(se.getSage());
		
		sess.close();
	}
}