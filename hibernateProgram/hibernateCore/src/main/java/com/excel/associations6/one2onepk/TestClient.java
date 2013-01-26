package com.excel.associations6.one2onepk;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.excel.user.NameEntity;
import com.excel.user.StudentEntity;
import com.excel.util.HibernateUtil;
public class TestClient {
	public static void main(String[] args) {
		// Below code drops table from db and create new table in the database.
		
//		Configuration config=new Configuration();
//		config.configure("hibernate.cfg.xml");
//		new SchemaExport(config).create(true, true);
//		SessionFactory factory=config.buildSessionFactory();
//		Session sess = factory.openSession();
		
		Session sess=HibernateUtil.getSessionFactory().openSession(); 
		Transaction txn=sess.beginTransaction();
		
		NameEntity ne=new NameEntity();
		ne.setId(new Long(6));
		ne.setLastname("Kumar");
		ne.setSurname("Prasad");
		
		//transient instance
		StudentEntity model=new StudentEntity();
		model.setId(new Long(6));
		model.setSage(22l);
		model.setSname("Rajesh");
		model.setNe(ne);
		ne.setSe(model);

		sess.save(model);// persistent
		sess.save(ne);

		txn.commit(); 
		sess.close();
	}
}