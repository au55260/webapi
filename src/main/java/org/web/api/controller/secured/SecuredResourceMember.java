package org.web.api.controller.secured;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("secure")
public class SecuredResourceMember {

	@GET
	@Path("message")
	@Produces(MediaType.TEXT_HTML)
	public String getSecuredInfo(){
		System.out.println("this is secured call !!");
		return "this is secured call !!";
	}
}
