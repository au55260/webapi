package org.web.api.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.web.api.beans.Member;
import org.web.api.beans.Search;
import org.web.api.utils.HibernateUtils;

public class MemberAuthSearch {
	private List<Member>  list;
	private List<Member> gResult;
	private Search search;
	public void setData(Search search) {
		 
		this.search = search;
	}

	public void startFunction() {
		// TODO Auto-generated method stub
		this.searchMembers(prepareSearch());
		
	}

	private void searchMembers(String prepareSearch) {
		
		Session session = HibernateUtils.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Query query = session.createQuery(prepareSearch);
		System.out.println("API Query ::"+prepareSearch);
		System.out.println("Query : "+ query);
		try {
			list = query.list();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(list.size()!=0)
		{
			gResult=list;
		}else {
			
			list = null;
			
		}
	}

	private String prepareSearch() {
		// TODO Auto-generated method stub
		StringBuffer query = new StringBuffer("from Member where 1=1 ");
		
		if(!"".equals(search.getBlockNo()) && search.getBlockNo() != null){
			query.append(" and blockNo = '" +  search.getBlockNo()+"'");
		}
		if(!"".equals(search.getFlatNo()) && search.getFlatNo() != null){
			query.append(" and flatNo = '" +  search.getFlatNo()+"'");
			}
		if(!"".equals(search.getName()) && search.getName() != null){
				query.append("and firstName = '" +search.getName() +"'");
		}
		if(!"".equals(search.getEmail()) && search.getEmail() != null){
			query.append(" and email = '" +  search.getEmail()+"'");
		}
		
		return query.toString();
		
		
	}

	public List<Member> getResult() {
		// TODO Auto-generated method stub
		return gResult;
	}

	public Search getSearch() {
		return search;
	}

	public void setSearch(Search search) {
		this.search = search;
	}

	public List<Member> getList() {
		return list;
	}

	public void setList(List<Member> list) {
		this.list = list;
	}

	public List<Member> getgResult() {
		return gResult;
	}

	public void setgResult(List<Member> gResult) {
		this.gResult = gResult;
	}
	
	
	

}
