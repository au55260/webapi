package org.web.api.service;

import org.web.api.beans.Member;

public interface MemberServices {
	/**
	 * Basic Member Login
	 */
	public Member loginUser (String prm_sUserId, String prm_sPassword, UserType uType);
	/**
	 * Logout API.
	 */
	public void logout();
	/**
	 * Parse out the Data in the Hashmap and register the User.
	 */
	public Member registerNewMember (Member prm_objMember);

	
	
}
