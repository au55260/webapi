package org.web.api.service;

import java.util.List;

import org.web.api.beans.Member;
import org.web.api.beans.Search;

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
	
	/**
	 * Parse out the Data in the Hashmap and register the User.
	 */
	public Member editMemberDetails (Member prm_objMember);
	
	/**
	 * Parse out the Data in the Hashmap and register the User.
	 */
	public String deleteMember (int id);
	
	public List<Member> getMembersDetail();
	public List<Member> getMemberByName(String name);
	public Member getMemberById(int id);
	
	public List<Member> search(Search search);
	 

	
	
}
