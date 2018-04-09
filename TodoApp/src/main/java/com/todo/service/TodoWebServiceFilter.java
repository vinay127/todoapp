package com.todo.service;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import org.springframework.beans.factory.annotation.Autowired;

import com.todo.exception.TransactionalInfo;

@Provider
public class TodoWebServiceFilter implements ContainerResponseFilter, ContainerRequestFilter {

	@Autowired
	AuthenticationTokenService authTokenService;

	@Autowired
	TransactionalInfo transactional;

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		validateRequest(requestContext);
	}

	@Override
	public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext)
			throws IOException {
	}

	public void validateRequest(ContainerRequestContext request) {
		if (!request.getUriInfo().getPath().contains("demodata") && !request.getUriInfo().getPath().contains("login")) {
			String token = request.getHeaderString("token");
			Boolean isValidReq = authTokenService.isValidToken(token);
			if (!isValidReq) {
				request.abortWith(Response.status(401).build());
			}
		}
	}
}
