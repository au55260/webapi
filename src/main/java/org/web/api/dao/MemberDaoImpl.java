package org.web.api.dao;

import org.hibernate.Session;
import org.web.api.beans.Member;
import org.web.api.service.UserType;
import org.web.api.utils.HibernateUtils;

public class MemberDaoImpl implements MemberDao {
 
	
	//HibernateUtils hibernate = new HibernateUtils();
	
	@Override
	public Member loginUser(String userId, String password, UserType uType) {
	
		Session session = HibernateUtils.getSessionFactory().getCurrentSession();
		Member member= null;
		MemberAuthLogin authLogin;
		try {
			authLogin = new MemberAuthLogin();
			authLogin.setPassword(password);
			authLogin.setUserId(userId);
			authLogin.startFunction();
			member = authLogin.getReturn();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return member;
	}

	@Override
	public void logout() {
		// TODO Auto-generated method stub

	}

}
