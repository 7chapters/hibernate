package com.excel.associations6.one2onefk;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import com.excel.user.NameEntity;
import com.excel.user.StudentEntity;
import com.excel.util.HibernateUtil;
public class TestClient {
	public static void main(String[] args) {
			Configuration config=new Configuration();
			config.configure("hibernate.cfg.xml");
			new SchemaExport(config).create(true, true);
			SessionFactory factory=config.buildSessionFactory();
			Session sess= factory.openSession();

//		Session sess = HibernateUtil.getSessionFactory().openSession();
		Transaction txn=sess.beginTransaction();
		
		NameEntity nameEntity=new NameEntity();
		nameEntity.setLastname("LastName One");
		nameEntity.setSurname("SurName One");
		nameEntity.setId(7l);

		NameEntity nameEntity2=new NameEntity();
		nameEntity2.setLastname("Second Entity");
		nameEntity2.setSurname("Second SurName");
		nameEntity2.setId(8l);

		
		//transient instance
		StudentEntity studentEntity=new StudentEntity();
		studentEntity.setId(new Long(7));
		studentEntity.setSage(22l);
		studentEntity.setSname("Name One");
		studentEntity.setNe(nameEntity);

		StudentEntity studentEntity2 =new StudentEntity();
		studentEntity2.setId(new Long(8));
		studentEntity2.setSage(22l);
		studentEntity2.setSname("Name Two");
		studentEntity2.setNe(nameEntity);

		
		sess.save(studentEntity);// persistent
		sess.save(studentEntity2);// persistent
		sess.save(nameEntity);
		sess.save(nameEntity2);
		
		txn.commit();
		sess.close();
		HibernateUtil.getSessionFactory().close();
	}
}