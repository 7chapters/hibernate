package com.excel.associations6.one2manymany2one_3;

 
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

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
		Transaction txn=sess.beginTransaction();

		//transient instance
		StudentEntity se1=new StudentEntity();
		se1.setSid(new Long(1));
		
		se1.setSname("sone");
	   
		StudentEntity se2=new StudentEntity();
		se2.setSid(new Long(2));
		se2.setSname("stwo");
		
		java.util.Set students=new java.util.HashSet();
		students.add(se1);
		students.add(se2);
		
		
		CollegeEntity ce1=new CollegeEntity();
		ce1.setCollegecode(1l);
		ce1.setCname("cone");
		ce1.setStudents(students);
		
		se1.setCe(ce1);
		se2.setCe(ce1);
		
		sess.save(ce1);
		/*sess.save(se1);
		sess.save(se2);*/
		
		txn.commit();
		
		sess.close();
		
		factory.close();
		
		
	}

}
