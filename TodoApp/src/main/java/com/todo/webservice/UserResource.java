
package com.todo.webservice;

import java.util.Date;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;

import com.todo.codetype.StatusCode;
import com.todo.model.Users;
import com.todo.repository.UserRepository;
import com.todo.service.UserService;

@Path("/users")
public class UserResource {

	@Autowired
	UserRepository repository;

	@Autowired
	UserService userService;
	
	@GET
	@Path("/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Users getUser (@PathParam("userId") long userId) {
		return repository.findByUserId(userId);
	}

	@GET
	@Path("/name/{userName}/email/{email}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Users> getUsersByUserNameAndEmail(@PathParam("userName") String userName, @PathParam("email") String email) {
	    System.out.println("I am inside this resource..");
		return repository.findByUserNameAndEmail(userName, email);	
	}
	
	@POST
	@Path("/insertUser")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	
	public void insertUser(Users user) {
		userService.saveUser(user);
	}
	
	@GET
	@Path("/cratedDateTime/{createdDateTime}/status/{status}")
	@Produces(MediaType.APPLICATION_JSON)
	
	public List<Users> getUserByCreatedDateTimeAndStatus(@PathParam("createdDateTime") Date createdDateTime, @PathParam("status") StatusCode status) {
		return repository.findByCreatedDateTimeAfterAndStatus(createdDateTime, status);
	}
}
