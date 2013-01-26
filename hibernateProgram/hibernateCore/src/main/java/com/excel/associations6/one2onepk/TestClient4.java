package com.excel.associations6.one2onepk;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.excel.user.StudentEntity;
import com.excel.util.HibernateUtil;

public class TestClient4 {
	public static void main(String[] args) {
		
		Session firstSession = HibernateUtil.getSessionFactory().openSession();
		Transaction firstTxn = firstSession.beginTransaction();
		
		Session secondSession = HibernateUtil.getSessionFactory().openSession();
		Transaction secondTxn=secondSession.beginTransaction();
		
		StudentEntity studentEntityFirst = (StudentEntity) firstSession.load(StudentEntity.class, new Long(6));
		System.out.println(studentEntityFirst.getSname());
		
		studentEntityFirst.setSname("Roja");
//		firstSession.evict(studentEntityFirst);
		firstSession.update(studentEntityFirst);
		
		firstTxn.commit();
		firstSession.close();
		
		secondSession.merge(studentEntityFirst);
		secondTxn.commit();
	}
}
