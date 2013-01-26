package com.excel.associations6.one2onepk;



import org.hibernate.Session;
import org.hibernate.Transaction;

import com.excel.user.NameEntity;
import com.excel.util.HibernateUtil;

public class TestClient2 {
	public static void main(String[] args) {
		Session sess = HibernateUtil.getSessionFactory().openSession();
		Transaction txn = sess.beginTransaction();
	
		
		/*StudentEntity se = (StudentEntity) sess.load(StudentEntity.class, new Long(6));
		System.out.println(se.getSname());
		System.out.println(se.getNe().getLastname());
		*/
		
		NameEntity ne=(NameEntity)sess.load(NameEntity.class, new Long(6));
		System.out.println(ne.getSurname());
		System.out.println(ne.getSe().getSname());
	}
}
