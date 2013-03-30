package com.excel.associations6.one2manymany2one_3;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import com.excel.util.HibernateUtil;

public class TestClient2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Configuration config=new Configuration();
		Session sess=HibernateUtil.getSessionFactory().openSession();

		CollegeEntity ce=(CollegeEntity)sess.load(CollegeEntity.class, 1l);
		System.out.println(ce.getCname());
		for(java.util.Iterator it=ce.getStudents().iterator();it.hasNext();) {
			StudentEntity se=(StudentEntity)it.next();
			System.out.println(se.getSname());
		}
	}
}