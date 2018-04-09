package com.todo.webservice;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;

import com.todo.exception.NotificationType;
import com.todo.exception.TransactionalInfo;
import com.todo.model.AuthenticationToken;
import com.todo.model.Users;
import com.todo.service.AuthenticationTokenService;
import com.todo.service.UserService;

@Path("/login")
public class LoginResource {

	@Autowired
	UserService userService;

	Users user = new Users();
	AuthenticationToken authToken = new AuthenticationToken();

	@Autowired
	TransactionalInfo transactionalInfo;

	@Autowired
	AuthenticationTokenService authService;

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response loginService(Users user) {
		user = userService.getUserByEmailAndPassword(user.getEmail(), user.getPassword());
		if (user != null) {
			authToken = authService.geneateAuthToken(user.getUserId());
			return Response.status(200).entity(authToken.getToken()).type(MediaType.APPLICATION_JSON).build();
		} else {
			transactionalInfo.generateException("Invalid Username or Password", 500, NotificationType.ERROR);
			return Response.status(500).build();
		}

	}

}
