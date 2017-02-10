package org.web.api.dao;

import java.util.List;

import org.web.api.beans.Member;
import org.web.api.beans.Search;
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
	/**
	 * Parse out the Data in the Hashmap and register the User.
	 */
	public List<Member> getMembersDetail();
	/**
	 * Parse out the Data in the Hashmap and register the User.
	 */
	public List<Member> getMemberByName(String name);
	/**
	 * Parse out the Data in the Hashmap and register the User.
	 */
	public Member getMemberById(int id);
	/**
	 * Parse out the Data in the Hashmap and register the User.
	 */
	public List<Member>search(Search search);
	
	
	
	
	 

}
