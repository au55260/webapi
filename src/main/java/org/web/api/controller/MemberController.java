package org.web.api.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import org.apache.commons.lang3.StringUtils;
import org.web.api.beans.Member;
import org.web.api.beans.Search;
import org.web.api.service.MemberServices;
import org.web.api.service.MemberServicesImpl;
import org.web.api.service.UserType;

@Path("/member")
public class MemberController {// Anurag and KD start working together on API Of SOCIETY
	
	MemberServices memberServices = new MemberServicesImpl();
	/**
	 *  This is just a Testing API, to check the health of the Web-Service
	 *  @return Hi I am Up And Running !
	 *  @author Anurag Upadhyay
	 */
	@GET
	@Path("/hi")
	@Produces(MediaType.TEXT_HTML)
	public String helloServices(){
		return "Hi I am Up And Running !";
	}
	/**
	 * This function call handles the Member Login
	 * @param prm_sUserName Username
	 * @param prm_sPassword Password of the Member
	 * @return Member Object. Format:
	 * <pre>
	 * {
	 * 	firstName: "FirstName",
	 * 	lastName : "LastName",
	 * 	middleName : "MiddleName",
	 * 	accountType : Any value between 0-3
	 * }
	 * </pre>
	 * @author Anurag Upadhyay
	 * 
	 * public
	 */
	@POST
	@Path("/login/{user}/{password}")
	@Produces(MediaType.APPLICATION_JSON)
	public Member loginMember(@PathParam("user") String userId, @PathParam("password") String password){
		Member member = new Member();
		member = memberServices.loginUser(userId,password, UserType.MEMBER);
		System.out.println(member);
		return member;
	}
	
	
	/**
	 * Logs the Member Out from the System.
	 * @param prm_sUserName UserName
	 * @param prm_objRequest HTTP Request Object Containing All the cookies
	 * @param prm_objResponse HTTP Response Object 
	 * @author Anurag Upadhyay
	 */
	@POST
	@Path("/logout")
	public void logout () {
		this.memberServices.logout();
	}
	
	/**
	 * This functioncall, implements the Member Registration process. If the Member does not exist then create one else return the one already existing. 
	 * @param prm_hBorrowerData Format for the input data is as follows:
	 * <pre>
	 * {
	 * 	firstName: "FirstName",
	 * 	lastName : "LastName",
	 * 	middleName : "MiddleName",
	 * 	email : "test@test.com", 
	 * 	password : "DummyPassword", 
	 * 	accountType : Any value between 0-3
	 * }
	 * </pre>
	 * @return A Member Object. Format:
	 * <pre>
	 * {
	 * 	firstName: "FirstName",
	 * 	lastName : "LastName",
	 * 	middleName : "MiddleName",
	 * 	accountType : Any value between 0-3
	 * }
	 * </pre>
	 * @author Anurag Upadhyay
	 * @throws URISyntaxException 
	 */
	
	@POST
	@Path("/registerNewMember")	
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response registerNewMember(Member member, @Context UriInfo uriInfo){
		Member registerNewMember = memberServices.registerNewMember(member);
		String newId = String.valueOf(member.getId());
		URI uri = uriInfo.getAbsolutePathBuilder().path(newId).build();
		return Response.created(uri)
			.entity(registerNewMember)
			.build();
	}
	
	
	@PUT
	@Path("/updateMember/{id}")	
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_XML)
	public Member editMemberDetails(@PathParam("id") String id,Member member) {
		return memberServices.editMemberDetails(member);
		
	}
	

	@DELETE
	@Path("/delete/{id}")	
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String deleteMember(@PathParam("id") int id) {
		return memberServices.deleteMember(id);
	 
	}
	
	
	@GET
	@Path("/getMembers")	
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Member> getMembers() {
		return memberServices.getMembersDetail();
	 
	}

	@GET
	@Path("/getMemberById/{id}")	
	@Produces(MediaType.APPLICATION_JSON)
	public Member getMemberById(@PathParam("id") int id) {
		return memberServices.getMemberById(id);
	 
	}

	@GET
	@Path("/getMemberByName/{name}")	
	@Produces(MediaType.APPLICATION_JSON)
	public List<Member> getMemberByName(@PathParam("name") String name) {
		return memberServices.getMemberByName(name);
	 
	}
	
	@POST
	@Path("/search")	
	@Produces(MediaType.APPLICATION_JSON)
	public List<Member> search(Search search) {
		
	 System.out.println("API : "+ search);
	 return memberServices.search(search);
	}
	
	
}
	