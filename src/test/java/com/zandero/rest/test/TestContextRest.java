package com.zandero.rest.test;

import com.zandero.rest.data.RouteDefinition;
import io.vertx.core.http.HttpServerRequest;
import io.vertx.core.http.HttpServerResponse;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Request;

/**
 *
 */
@Path("/context")
public class TestContextRest {

	@GET
	@Path("/route")
	public String getRoute(@Context RouteDefinition definition) {

		return definition.toString().trim();
	}

	@GET
	@Path("/context")
	public String getRoute(@Context HttpServerResponse response, @Context HttpServerRequest request) {

		response.setStatusCode(201);
		return request.uri();
	}

	@GET
	@Path("/unknown")
	public String getRoute(@Context Request request) {

		return null;
	}
}
