package org.web.api.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.web.api.beans.Member;
import org.web.api.utils.HibernateUtils;

public class MemberAuthByName {
	
	private List<Member> list;
	private List<Member> gResult;
	private String name;
	
	
	public void startFunction() {
		
		if(getAllMembersByName().size()>0){
			this.gResult = getList();
		}else {
			this.gResult= null;
		}
	}


	private List<Member> getAllMembersByName() {
		// TODO Auto-generated method stub
		Session session = HibernateUtils.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Query  query = session.createQuery("from Member where firstName= ?");
		query.setString(0, this.name);
		System.out.println("QUERY :"+ query);
		list = query.list();
		if(list.size()>0){
			//gResult=list;
			setList(list);
		}else {
			gResult = null;
		}
		session.getTransaction().commit();
		
		return list;
		
	}
	public List getResult(){
		return gResult;
	}
	 

	public void setName(String name) {
		this.name=name;
		
	}

	public void setList(List<Member> list) {
		this.list = list;
	}


	public List<Member> getList() {
		return list;
	}


}
