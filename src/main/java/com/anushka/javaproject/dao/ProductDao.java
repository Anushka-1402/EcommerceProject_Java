package com.anushka.javaproject.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.anushka.javaproject.entities.Product;


public class ProductDao {

	private SessionFactory factory;

	public ProductDao(SessionFactory factory) {
		super();
		this.factory = factory;
	}
	
	public int addProduct(Product p) {
		
		Session hibernateSession= this.factory.openSession();
		Transaction tx= hibernateSession.beginTransaction();
		int pId= (int) hibernateSession.save(p);
		tx.commit();
		hibernateSession.close();
		return pId;	
	
	}
	
	public List<Product> getAllProducts(){
		
		Session session= this.factory.openSession();
		Query query= session.createQuery("from Product");
		List<Product> list= query.list();
		return list;
	}
	
	//product by category
	public List<Product> getProductByCategory(int cId){
		
		Session session= this.factory.openSession();
		Query query= session.createQuery("from Product as p where p.pCat.catalogId=: id");
		query.setParameter("id", cId);
		List<Product> list= query.list();
		return list;
	}
	
}
