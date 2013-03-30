package com.excel.associations6.one2onepk;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.excel.user.StudentEntity;
import com.excel.util.HibernateUtil;

public class TestClient5 {
	public static void main(String[] args) {
		Session sess =  HibernateUtil.getSessionFactory().openSession();
		Transaction txn = sess.beginTransaction();
		StudentEntity se = (StudentEntity) sess.get(StudentEntity.class,
				new Long(6));
		System.out.println(se.getSname());
		sess.delete(se);
		txn.commit();
	}
}