package com.anushka.javaproject.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.anushka.javaproject.entities.Catalog;
import org.hibernate.query.Query;


import java.util.*;

public class CategoryDao {

	private SessionFactory factory;

	public CategoryDao(SessionFactory factory) {
		super();
		this.factory = factory;
	}
	
	public int addCategory(Catalog cat) {
		
		Session hibernateSession= this.factory.openSession();
		Transaction tx= hibernateSession.beginTransaction();
		int catId= (int) hibernateSession.save(cat);
		tx.commit();
		hibernateSession.close();
		return catId;
	}
	
	public List<Catalog> getCategories(){
		
		Session s= this.factory.openSession();
		Query query= s.createQuery("From Catalog");
		List<Catalog>list= query.list();
		
		return list;
	}
	
	public Catalog getCategoryById(int cId) {
		
		Catalog cat= null;
		try {
			Session s= this.factory.openSession();
			cat= s.get(Catalog.class,cId);
			s.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return cat;
		
	}
}
