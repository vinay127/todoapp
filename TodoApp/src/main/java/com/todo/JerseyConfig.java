package com.todo;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import com.todo.exception.GenericExceptionMapper;
import com.todo.exception.TodoExceptionMapper;
import com.todo.service.TodoWebServiceFilter;
import com.todo.webservice.AuthenticationTokenResource;
import com.todo.webservice.DemoData;
import com.todo.webservice.LoginResource;
import com.todo.webservice.TodoResource;
import com.todo.webservice.UserResource;

@Component
public class JerseyConfig extends ResourceConfig {
	public JerseyConfig() {
		register(TodoResource.class);
		register(DemoData.class);
		register(UserResource.class);
		register(TodoExceptionMapper.class);
		register(GenericExceptionMapper.class);
		register(AuthenticationTokenResource.class);
		register(TodoWebServiceFilter.class);
		register(LoginResource.class);
	}
}
