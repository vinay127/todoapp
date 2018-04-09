package com.todo.webservice;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;

import com.todo.model.Todo;
import com.todo.repository.ToDoRepository;
import com.todo.service.TodoService;

@Path("/todos")
public class TodoResource {

	@Autowired
	ToDoRepository todoRepository;

	@Autowired
	TodoService todoService;

	@GET
	@Path("/{todoid}")
	@Produces(MediaType.APPLICATION_JSON)
	public Todo getTodo(@PathParam("todoid") long todoid) {
		return todoRepository.findByToDoId(todoid);
	}

	@GET
	@Path("/title/{title}/description/{description}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Todo> getTodoByTitleAndDescription(@PathParam("title") String title,
			@PathParam("description") String description) {
		return todoRepository.findByTitleAndDescription(title, description);
	}

	@POST
	@Path("/todoInsert")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response insertTodo(Todo todo) {
		return Response.status(200).entity(todo).type(MediaType.APPLICATION_JSON).build();
	}

}
