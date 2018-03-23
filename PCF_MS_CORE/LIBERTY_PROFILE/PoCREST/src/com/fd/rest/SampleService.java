package com.fd.rest;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@ApplicationPath("rest")
@Path("sample")
public class SampleService extends Application {
	@GET
	@Path("getString")
	@Produces("application/json")
	public Response getString() {
		return Response.ok(new SampleMessage("Hello World!!!"), MediaType.APPLICATION_JSON).build();
	}
}
