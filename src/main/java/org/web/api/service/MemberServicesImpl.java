package org.web.api.service;

import org.web.api.beans.Member;
import org.web.api.dao.MemberDao;

public  class MemberServicesImpl implements MemberServices {
	MemberDao dao;

	@Override
	public Member loginUser(String prm_sUserId, String prm_sPassword, UserType uType) {
		// TODO Auto-generated method stub
		
		return dao.loginUser(prm_sUserId, prm_sPassword, uType);
	}

	@Override
	public void logout() {
		// TODO Auto-generated method stub
		
	}

	
 

}
