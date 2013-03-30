package com.excel.associations6.one2onefk;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.excel.user.StudentEntity;
import com.excel.util.HibernateUtil;

public class TestClient3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Session sess = HibernateUtil.getSessionFactory().openSession();
		StudentEntity se=(StudentEntity)sess.get(StudentEntity.class, new Long(7));
		System.out.println(se.getSname());
		System.out.println(se.getSage());
		sess.close();
//		System.out.println(se.getSname());
//		System.out.println(se.getSage());
	}
}