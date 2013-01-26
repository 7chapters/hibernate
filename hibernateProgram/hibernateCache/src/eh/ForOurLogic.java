package eh;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ForOurLogic { 

	public static void main(String[] args)
	{
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml"); 
		
		SessionFactory factory = cfg.buildSessionFactory();
		
		Session session1 = factory.openSession();		
		Object o=session1.load(Product.class,new Integer(105));
		
		Product s=(Product)o;
		System.out.println("Loaded object product name is___"+s.getProName());		
		System.out.println("Object Loaded successfully.....!!");	
		session1.close();
		
		System.out.println("------------------------------");
		
		try{		
			System.out.println("Waiting......");
			Thread.sleep(6000);
		}
		catch (Exception e) {
		}		
		
		System.out.println("6 seconds compelted......!!!!!!!!");
		
		Session session2 = factory.openSession();		
		Object o2=session2.load(Product.class,new Integer(105));
		
		Product s2=(Product)o2;
		System.out.println("Loaded object product name is___"+s2.getProName());		
		System.out.println("Object loaded from the database...!!");	
		session2.close();
		
		
		Session session3 = factory.openSession();		
		Object o3=session3.load(Product.class,new Integer(105));
		
		Product s3=(Product)o3;
		System.out.println("Loaded object product name is___"+s3.getProName());		
		System.out.println("Object loaded from global cache successfully.....!!");	
		session3.close();
		
		factory.close();
	}
	
}
