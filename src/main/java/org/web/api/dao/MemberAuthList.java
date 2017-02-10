package org.web.api.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.web.api.beans.Member;
import org.web.api.utils.HibernateUtils;

public class MemberAuthList {
	
	private List<Member> list;
	private List<Member> gResult;
	
	
	public void startFunction() {
		
		if(getAllMembersList().size()>0){
			this.gResult = getAllMembersList();
		}else {
			this.gResult= null;
		}
	}


	private List<Member> getAllMembersList() {
		// TODO Auto-generated method stub
		Session session = HibernateUtils.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Query  query = session.createQuery("from Member");
		list = query.list();
		session.getTransaction().commit();
		
		return list;
		
	}
	public List getResult(){
		return gResult;
	}


	
	
	
	

}
