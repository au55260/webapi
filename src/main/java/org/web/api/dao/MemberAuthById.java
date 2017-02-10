package org.web.api.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.web.api.beans.Member;
import org.web.api.utils.HibernateUtils;

public class MemberAuthById {
	
	private int id;
	private List<Member> list;
	private Member gResult ;

	public void setId(int id) {
		// TODO Auto-generated method stub
		this.id= id;
		
	}

	public void startFunction() {
		// TODO Auto-generated method stub
		if(getAllMemberById().size()>0){
			
		}else {
			this.gResult= null;
		}
		
	}
	
	private List<Member> getAllMemberById() {
		// TODO Auto-generated method stub
		Session session = HibernateUtils.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Query  query = session.createQuery("from Member where id= ?");
		query.setInteger(0, this.id);
		System.out.println("QUERY :"+ query);
		list = query.list();
		if(list.size()>0){
			gResult= list.get(0);
		}else {
			gResult = null;
		}
		session.getTransaction().commit();
		
		return list;
		
	}

	public Member getResult() {
		// TODO Auto-generated method stub
		return gResult;
	}

}
