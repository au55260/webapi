package org.web.api.filter;

import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import org.glassfish.jersey.internal.util.Base64;
import org.web.api.beans.Member;
import org.web.api.service.MemberServices;
import org.web.api.service.MemberServicesImpl;
import org.web.api.service.UserType;

@Provider
public class SecurityFilter implements ContainerRequestFilter {
	
	private static final String AUTHORIZATION_HEADER_KEY = "Authorization";
	private static final String AUTHORIXATION__HEADER_PREFIX = "Basic ";
	private static final String SECURE_URL_PREFIX = "secure";
	private static final Response ACCESS_DENIED = Response.status(Response.Status.UNAUTHORIZED)
			.entity("You cannot access this resource").build();
	
	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		System.out.println("Under Security filter !!");
		if (requestContext.getUriInfo().getPath().contains(SECURE_URL_PREFIX)) {
		
		List<String> authHeader = requestContext.getHeaders().get(AUTHORIZATION_HEADER_KEY);
		System.out.println("authHeader " +authHeader);
		if(authHeader != null && authHeader.size()>0){
			String authToken = authHeader.get(0);
			authToken = authToken.replaceFirst(AUTHORIXATION__HEADER_PREFIX, "");
			String decodeAuthToken = Base64.decodeAsString(authToken);
			StringTokenizer tokenizer = new StringTokenizer(decodeAuthToken, ":");
			String userName = tokenizer.nextToken();
			String password = tokenizer.nextToken();
			
			 //Is user valid?
            if( isUserAllowed(userName, password))
            {
               // requestContext.abortWith(ACCESS_DENIED);
                return;
            }
		}
		
		Response unAuthorizationStatus = Response
											.status(Response.Status.UNAUTHORIZED)
											.entity("you cannot authorise to access the resource")
											.build();
		requestContext.abortWith(unAuthorizationStatus);
											
		
	}
    }
	

	 private boolean isUserAllowed(final String username, final String password)
	    {
	        boolean isAllowed = false;
	        MemberServices memberServices = new MemberServicesImpl();
	        Member member = new Member();
			
	          
	        //Step 1. Fetch password from database and match with password in argument
	        //If both match then get the defined role for user from database and continue; else return isAllowed [false]
	        //Access the database and do this part yourself
	        //String userRole = userMgr.getUserRole(username);
	         
	        if(!username.equals("") && !password.equals(""))
	        {
	        	member = memberServices.loginUser(username,password, UserType.MEMBER);
	        	 if(! member.equals(null)){
	        		 isAllowed=true;
	        	 }
	        }
	        return isAllowed;
	    }

}
