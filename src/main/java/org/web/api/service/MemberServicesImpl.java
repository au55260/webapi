package org.web.api.service;

import org.web.api.beans.Member;
import org.web.api.dao.MemberDao;
import org.web.api.dao.MemberDaoImpl;

public  class MemberServicesImpl implements MemberServices {
	MemberDao dao = new MemberDaoImpl();  

	@Override
	public Member loginUser(String prm_sUserId, String prm_sPassword, UserType uType) {
		// TODO Auto-generated method stub
		System.out.println("Hello");
		return dao.loginUser(prm_sUserId, prm_sPassword, uType);
	}

	@Override
	public void logout() {
		// TODO Auto-generated method stub
		
	}

	
 

}
