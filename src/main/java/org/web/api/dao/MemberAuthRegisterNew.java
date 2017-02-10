package org.web.api.dao;

import java.util.List;



import org.apache.commons.lang3.StringUtils;
import org.hibernate.Query;
import org.hibernate.Session;
import org.web.api.beans.Member;
import org.web.api.utils.HibernateUtils;
/*
 * This function call helps to register the Member.
 * @author Anurag Upadhyay
 */
public class MemberAuthRegisterNew {
	private Member g_Return;
	private Member requestedData;
	
	public void setMemberData (Member prm_hMemberData) {
		this.requestedData = prm_hMemberData;
	}

	public void startFunction() {
		if (false == this.validateMemberData()) {
		} else if (this.borrowerAlreadyExists()) {
			this.g_Return=null;
			return;
		} else {
			this.addNewMemberToDatabase();
			this.findTheResultantMember();
		}
		
	}
	
	private void addNewMemberToDatabase() {
		Session session = HibernateUtils.getSessionFactory().getCurrentSession();
		session.getTransaction();
		session.save(requestedData);
		session.getTransaction().commit();
	}
	
	private boolean borrowerAlreadyExists() {
		 boolean result;
		 List list;
		 Session session = HibernateUtils.getSessionFactory().getCurrentSession();
		 session.beginTransaction();
		 Query  query = session.createQuery("from Member where userId= ?");
		 query.setString(0, this.requestedData.getUserId());
		 list =  query.list();
		 result = list.size()>0;
		 if(result){
			this.g_Return = (Member)list.get(0);
		 }
		return result;
	}
	
	private void findTheResultantMember () {
		 List<Member> list;
		 Session session = HibernateUtils.getSessionFactory().getCurrentSession();
		 session.beginTransaction();
		 Query  query = session.createQuery("from Member where email= ?");
		 query.setString(1, this.requestedData.getEmail());
		 list =  query.list();
		 session.getTransaction().commit();
		 if(list.size()>0){
			this.g_Return = list.get(0);
		 }
		
	}
	private boolean validateMemberData () {
		boolean v_Return = false;
		if (null == this.requestedData) {
		} else if (StringUtils.isBlank(this.requestedData.getFirstName())) {
		} else if (StringUtils.isBlank(this.requestedData.getLastName())) {
		} else if (StringUtils.isBlank(this.requestedData.getEmail())) {
		} else if (StringUtils.isBlank(this.requestedData.getPassword())) {
		} else {
			v_Return = true;
		}
		return v_Return;
	}
	
	public Member getResult() {
		return g_Return;
	}
	public void setResult(Member g_Return) {
		this.g_Return = g_Return;
	}

	public Member getRequestedData() {
		return requestedData;
	}

	public void setRequestedData(Member requestedData) {
		this.requestedData = requestedData;
	}
	
	
	
	

		 
		
}
