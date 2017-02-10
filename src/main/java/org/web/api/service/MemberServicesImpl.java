package org.web.api.service;

import java.util.List;

import org.web.api.beans.Member;
import org.web.api.beans.Search;
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

	@Override
	public Member registerNewMember(Member prm_objMember) {
		System.out.println("Hello");
		
		return dao.registerNewMember(prm_objMember);
	}

	@Override
	public Member editMemberDetails(Member prm_objMember) {
		// TODO Auto-generated method stub
		System.out.println("Json objects details : "+ prm_objMember);
		
		return dao.editMemberDetails(prm_objMember);
	}

	@Override
	public String deleteMember(int id) {
		// TODO Auto-generated method stub
		System.out.println("ID to be deleted :" +id);
		
		return  dao.deleteMember(id);
	}

	@Override
	public List<Member> getMembersDetail() {
		// TODO Auto-generated method stub
		return dao.getMembersDetail();
	}
	
	@Override
	public List<Member> getMemberByName(String name) {
		// TODO Auto-generated method stub
		return dao.getMemberByName(name);
	}

	@Override
	public Member getMemberById(int id) {
		// TODO Auto-generated method stub
		return dao.getMemberById(id);
	}

	@Override
	public List<Member> search(Search search) {
		// TODO Auto-generated method stub
		return dao.search(search);
	}
	
	
	

	
	
	
	 

	
	 
	

}
