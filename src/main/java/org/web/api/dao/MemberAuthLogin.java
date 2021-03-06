package org.web.api.dao;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Query;
import org.hibernate.Session;
import org.web.api.beans.Member;
import org.web.api.service.UserType;
import org.web.api.utils.HibernateUtils;

public class MemberAuthLogin {

	
	private UserType uType;
	private Member Return;
	private Member objMemberFoundWithTheEmail = null;
	private String userId;
	private String password;
	
	
	public void startFunction() {
		try {
			
			if (StringUtils.isBlank(this.password)) {
			}else if (StringUtils.isBlank(this.userId)) {
			} else {
				this.findTheUserWithThisEmail();
			}
			if (null == this.objMemberFoundWithTheEmail) {
			}
			else if (this.passwordsMatch()) {
				this.Return = this.objMemberFoundWithTheEmail;
			}
			 
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	private void findTheUserWithThisEmail () {
		
		Session session = HibernateUtils.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Query query = session.createQuery("from Member where userId= ? and password = ?");
		query.setString(0, userId);
		query.setString(1, password);
		List<Member>  list = query.list();
		//this.objMemberFoundWithTheEmail = (Member) session.get(Member.class, 5);
		this.objMemberFoundWithTheEmail= list.get(0);
		System.out.println("Hello  "+ objMemberFoundWithTheEmail);
	}
	
  private boolean passwordsMatch () {
		return  this.password.equals(this.objMemberFoundWithTheEmail.getPassword());
	}  

	
	
	
	public UserType getuType() {
		return uType;
	}
	public void setuType(UserType uType) {
		this.uType = uType;
	}
	public Member getReturn() {
		return Return;
	}
	public void setReturn(Member return1) {
		Return = return1;
	}
	public Member getObjMemberFoundWithTheEmail() {
		return objMemberFoundWithTheEmail;
	}
	public void setObjMemberFoundWithTheEmail(Member objMemberFoundWithTheEmail) {
		this.objMemberFoundWithTheEmail = objMemberFoundWithTheEmail;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
