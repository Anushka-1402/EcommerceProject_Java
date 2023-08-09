package com.anushka.javaproject.helper;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class Helper {

	
	public static String trimString(String str) {
		
		String [] strs= str.split(" ");
		
		if(strs.length>10) {
			
			String res="";
			for(int i=0;i<10;i++) {
				res= res + strs[i] + " ";
			}
			return (res+"...");
		}
		else {
			return str;
		}
	}
	
	public static Map<String,Long> getCounts(SessionFactory factory){
		
		Session session= factory.openSession();
		String q1= "select count(*) from User";
		String q2= "select count(*) from Product";
		String q3= "select count(*) from Catalog";
	
		Query query1= session.createQuery(q1);
		Query query2= session.createQuery(q2);
		Query query3= session.createQuery(q3);
		
		Long uCount= (Long)query1.list().get(0);
		Long pCount= (Long)query2.list().get(0);
		Long cCount= (Long)query3.list().get(0);
		
		Map<String, Long>mp= new HashMap<String, Long>();
		mp.put("uCount", uCount);
		mp.put("cCount", cCount);
		mp.put("pCount", pCount);
		
		session.close();
		
		return mp;
	
	}
}
