package org.web.api.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.web.api.beans.Member;
import org.web.api.utils.HibernateUtils;

public class MemberAuthDelete {
 
	private int id;
	private String string;
	private Member g_Return;
	
	
	public void startFunction() {
		if(dataExists()){
			deleteMemberFromDatabase();
			string = "Data associated with  id : "+this.getId()+"Get deleted form DB" ;
		}else {
			string = "No data associated with  id : "+this.getId() ;
		}
	}
	
	
	
	private boolean dataExists() {
		 boolean result;
		 List list;
		 Session session = HibernateUtils.getSessionFactory().getCurrentSession();
		 session.beginTransaction();
		 Query  query = session.createQuery("from Member where id= ?");
		 query.setInteger(0, this.getId());
		 list =  query.list();
		 result = list.size()>0;
		 if(result){
			 this.g_Return = (Member)list.get(0);
			 result = true;
		 }
		return result;
	}
	
	private void deleteMemberFromDatabase() {
		Session session = HibernateUtils.getSessionFactory().getCurrentSession();
		session.getTransaction();
		session.delete(this.g_Return);
		session.getTransaction().commit();
	}

	public String getRssult() {
		return this.string;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getString() {
		return string;
	}



	public void setString(String string) {
		this.string = string;
	}
	
	

}
