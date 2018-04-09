package com.todo.webservice;

import javax.websocket.server.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;

import com.todo.model.AuthenticationToken;
import com.todo.service.AuthenticationTokenService;

@Path("/auth")
public class AuthenticationTokenResource {

	@Autowired
	AuthenticationTokenService authTokenService;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/authId/{authId}")
	public AuthenticationToken getAuth(@PathParam("authId") long authId) {
		return authTokenService.getByAuthId(authId);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/token/{tokenId}")
	public AuthenticationToken getAuthByToken(@PathParam("tokenId") String tokenId) {
		return authTokenService.getByToken(tokenId);
	}

	@POST()
	@Path("/insertAuth")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response insertAuth(AuthenticationToken authenticationToken) {
		return Response.ok().type(MediaType.APPLICATION_JSON).entity(authenticationToken).build();
	}
}
