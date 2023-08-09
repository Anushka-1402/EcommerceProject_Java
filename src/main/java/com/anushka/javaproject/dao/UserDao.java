package com.anushka.javaproject.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.anushka.javaproject.entities.Catalog;
import com.anushka.javaproject.entities.User;

public class UserDao {
	
	private SessionFactory factory;

	public UserDao(SessionFactory factory) {
		super();
		this.factory = factory;
	}
	
	
	//add user to db
	public int addUser(User user) {
	
		Session hibernateSession= this.factory.openSession();
		Transaction tx= hibernateSession.beginTransaction();
		int userId= (int) hibernateSession.save(user);
		tx.commit();
		hibernateSession.close();
		return userId;
	}
	
	
	//fetch user from db with given email, password
	public User getUser(String email, String password) {
		
		User user= null;
		
		try {
			
			String query= "from User where uEmail=:e and uPassword=:p";
			Session session= this.factory.openSession();
			Query q= session.createQuery(query);
			q.setParameter("e",email);
			q.setParameter("p",password);
			
			user= (User)q.uniqueResult();
			session.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return user;
	}

	//get all users
	public List<User> getUser(){
		
		Session s= this.factory.openSession();
		Query query= s.createQuery("From User");
		List<User>list= query.list();
		
		return list;
	}
}
