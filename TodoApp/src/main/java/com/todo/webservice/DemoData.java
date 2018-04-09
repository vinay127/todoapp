package com.todo.webservice;

import java.util.Date;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;

import com.todo.codetype.StatusCode;
import com.todo.model.Address;
import com.todo.model.Todo;
import com.todo.model.Users;
import com.todo.repository.ToDoRepository;
import com.todo.repository.UserRepository;
import com.todo.service.AddressService;
import com.todo.service.TodoService;

@Path("/demodata")
public class DemoData {

	@Autowired
	UserRepository userRepository;

	@Autowired
	ToDoRepository todoRespository;

	@Autowired
	TodoService todoService;

	@Autowired
	AddressService addressService;

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response insertData() {
		Users users = new Users();
		Address address = new Address();
		users.setUserName("Vinay");
		users.setPassword("p");
		users.setEmail("s");
		users.setStatus(StatusCode.ACTIVE);
		users = userRepository.save(users);

		address.setHouseNumber(251);
		address.setAddressLineOne("Jp Nagar");
		address.setCity("Bangaluru");
		address.setPincode(560078);
		address.setState("Karnataka");
		address.setUser(users);
		address = addressService.saveAddress(address);

		Todo todo = new Todo();
		todo.setTitle("First todo");
		todo.setDescription("This is my first todo description");
		todo.setReminderDateTime(new Date());
		todo.setStatus(StatusCode.ACTIVE);
		todo.setUser(users);

		todoService.saveTodo(todo);
		return Response.ok().build();
	}
}
