package org.web.api.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.web.api.beans.Member;
import org.web.api.utils.HibernateUtils;

public class MemberAuthUpdate {
	private String id;
	private Member resultReturn;
	private Member requestedData;
	
	public void setMemberData (Member prm_hMemberData) {
		this.requestedData = prm_hMemberData;
	}
	
	public void startFunction() {
		if(this.memberExists()){
			this.updateMemberToDatabase();
			this.findTheResultantMember ();
		}
		
	}
	private void updateMemberToDatabase() {
		Session session = HibernateUtils.getSessionFactory().getCurrentSession();
		session.getTransaction();
		//requestedData.setId(Integer.parseInt(this.getId()));
		System.out.println("requestedData ::: "+ requestedData.toString());
		session.save(requestedData);
		session.getTransaction().commit();
	}
	private boolean memberExists() {
		 boolean result;
		 List list;
		 Session session = HibernateUtils.getSessionFactory().getCurrentSession();
		 session.beginTransaction();
		 Query  query = session.createQuery("from Member where id= ?");
		 query.setString(0, this.getId());
		 list =  query.list();
		 result = list.size()>0;
		 if(result){
			this.resultReturn = (Member)list.get(0);
		 }
		return result;
	}
	
	private void findTheResultantMember () {
		 List<Member> list;
		 Session session = HibernateUtils.getSessionFactory().getCurrentSession();
		 session.beginTransaction();
		 Query  query = session.createQuery("from Member where id= ?");
		 query.setString(0, this.getId());
		 list =  query.list();
		 session.getTransaction().commit();
		 if(list.size()>0){
			this.resultReturn = list.get(0);
		 }
		
	}
	
	
	public Member getResult() {
		return resultReturn;
	}
	public void setResult(Member result) {
		this.resultReturn = result;
	}
	public Member getRequestedData() {
		return requestedData;
	}
	public void setRequestedData(Member requestedData) {
		this.requestedData = requestedData;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
	
	

}
