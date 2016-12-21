package org.web.api.dao;

import org.web.api.beans.Member;
import org.web.api.service.UserType;



public interface MemberDao {
	

	/**
	 * Basic Member Login
	 */
	public Member loginUser (String prm_sUserId, String prm_sPassword, UserType uType);
	/**
	 * Logout API.
	 */
	public void logout();
	
	

}
