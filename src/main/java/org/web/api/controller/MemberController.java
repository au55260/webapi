package org.web.api.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.web.api.beans.Member;
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
	@GET
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
	 */
	
	@POST
	@Path("/registerNewMember")	
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Member registerNewMember(Member member) {
		return memberServices.registerNewMember(member);
		
	}

	
	
	
}
	