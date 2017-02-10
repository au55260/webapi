package org.web.api.dao;

import java.util.List;

import org.hibernate.Session;
import org.web.api.beans.Member;
import org.web.api.beans.Search;
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
	
	@Override
	public Member registerNewMember(Member objMember) {
		//Session session = HibernateUtils.getSessionFactory().getCurrentSession();
		Member member= null;
		MemberAuthRegisterNew authRegisterNew;
		
		try {
			member = objMember;
			authRegisterNew = new MemberAuthRegisterNew();
			authRegisterNew.setMemberData(member);
			authRegisterNew.startFunction();
			if(authRegisterNew.getResult()!=null)
			{
				member = authRegisterNew.getResult();
			}else {
				 member= null;
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return member;
	}

	@Override
	public Member editMemberDetails(Member objMember) {
		// TODO Auto-generated method stub
		
		Member member = null;
		MemberAuthUpdate authUpdate;
		try {
			member = objMember;
			authUpdate = new MemberAuthUpdate();
			
			authUpdate.setMemberData(objMember);
			authUpdate.startFunction();
			if(authUpdate.getResult()!=null)
			{
				member = authUpdate.getResult();
			}else {
				member = null;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return member;
		
		
		
	}

	@Override
	public String deleteMember(int id) {
		// TODO Auto-generated method stub
		String message = null;
		MemberAuthDelete authDelete;
		try {
			authDelete = new MemberAuthDelete();
			authDelete.setId(id);
			authDelete.startFunction();
			message  = authDelete.getRssult();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return message;
	}

	@Override
	public List<Member> getMembersDetail() {
		// TODO Auto-generated method stub
		List<Member> lMembers = null;
		MemberAuthList memberAuthList;
		
		try {
			memberAuthList = new MemberAuthList();
			memberAuthList.startFunction();
			if(memberAuthList.getResult()!= null){
				
				lMembers =memberAuthList.getResult();
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lMembers;
	}

	@Override
	public List<Member> getMemberByName(String name) {
		// TODO Auto-generated method stub
		List<Member> membersByName = null;
		MemberAuthByName memberAuthByName;
		
		try {
			memberAuthByName = new MemberAuthByName();
			memberAuthByName.setName(name);
			memberAuthByName.startFunction();
			if(memberAuthByName.getResult()!= null){
				
				membersByName =memberAuthByName.getResult();
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return membersByName;
	}

	@Override
	public Member getMemberById(int id) {
		// TODO Auto-generated method stub
		Member  membersId = null;
		MemberAuthById memberAuthById;
		
		try {
			memberAuthById = new MemberAuthById();
			memberAuthById.setId(id);
			memberAuthById.startFunction();
			if(memberAuthById.getResult()!= null){
				
				membersId = memberAuthById.getResult();
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return membersId;
	}

	@Override
	public List<Member> search(Search search) {
		 MemberAuthSearch memberAuthSearch = null;
		 List<Member> membersByName = null;
		 try {
			 memberAuthSearch = new MemberAuthSearch();
			 memberAuthSearch.setData(search);
			 memberAuthSearch.startFunction();
			 if(memberAuthSearch.getResult()!= null){
				 membersByName = memberAuthSearch.getResult();
			 }
			 
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		 
		return membersByName;
	}

	 
	
	
	
	
	
	
	
	
	
	

}
