package os;

import org.hibernate.cfg.*;
import org.hibernate.*;

class StudentClient {
	public static void main(String[] args) throws Exception {
		Configuration cfg = new Configuration();
		cfg  = cfg.configure();
		SessionFactory factory = cfg.buildSessionFactory();
		
		Session ses1 = factory.openSession();
		Session ses2 = factory.openSession();
		Session ses3 = factory.openSession();
		
		StudentBean st1, st2 , st3;

		st1 = (StudentBean) ses1.get(StudentBean.class, new Integer(105));
		System.out.println(st1.getSid()+" "+st1.getSname()+" "+st1.getTot_m());
		
		try{
			System.out.println("Waiting.....");
			Thread.sleep(6000);
		}catch(Exception exp){}
		
		st2 = (StudentBean) ses2.get(StudentBean.class, new Integer(105));
		System.out.println(st2.getSid()+" "+st2.getSname()+" "+st2.getTot_m());

		st3 = (StudentBean) ses3.get(StudentBean.class, new Integer(105));
		System.out.println(st2.getSid()+" "+st3.getSname()+" "+st3.getTot_m());

		ses1.close();	
		ses2.close();
		ses3.close();

		factory.close();
	}
}
