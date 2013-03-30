package com.tajiba.hibernate.association.one2one;
import java.util.Date;

import org.hibernate.Session;

import com.tajiba.hibernate.association.one2one.stock.Stock;
import com.tajiba.hibernate.association.one2one.stock.StockDetail;
import com.tajiba.hibernate.util.HibernateUtil;

public class App {
	public static void main(String[] args) {
		System.out.println("Hibernate one to one (Annotation)");
		Session session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();

		Stock stock = new Stock();

		stock.setStockCode("7058");
		stock.setStockName("PADINI8");

		StockDetail stockDetail = new StockDetail();
		stockDetail.setCompName("PADINI Holding Malaysia");
		stockDetail.setCompDesc("one stop shopping");
		stockDetail.setRemark("vinci vinci");
		stockDetail.setListedDate(new Date());

		stock.setStockDetail(stockDetail);
		stockDetail.setStock(stock);

//		session.save(stock);
		session.load(stock,54);
		System.out.println("App.main()" + stock.getStockCode() +" "+ stock.getStockDetail());
		
		session.getTransaction().commit();

		System.out.println("Done");
	}
}
