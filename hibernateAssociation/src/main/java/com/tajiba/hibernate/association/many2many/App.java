package com.tajiba.hibernate.association.many2many;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;

import com.tajiba.hibernate.association.many2many.stock.Category;
import com.tajiba.hibernate.association.many2many.stock.Stock;
import com.tajiba.hibernate.util.HibernateUtil;

public class App {
	public static void main(String[] args) {
		System.out.println("Hibernate many to many (XML Mapping)");
		Session session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();

		Stock stock = new Stock();
        stock.setStockCode("7055");
        stock.setStockName("PADINI4");
 
        Category category1 = new Category("CONSUMER", "CONSUMER COMPANY");
        Category category2 = new Category("INVESTMENT", "INVESTMENT COMPANY");
    
        Set<Category> categories = new HashSet<Category>();
        categories.add(category1);
        categories.add(category2);
        
        stock.setCategories(categories);
        
        session.save(stock);
    
		session.getTransaction().commit();
		System.out.println("Done");
	}
}
