package com.redhat.demo;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

@Path( "/quarkus" )
public class GreetingController {

    @Inject
    GreetingService greetingService;

    @GET
    @Produces( MediaType.TEXT_PLAIN )
    @Path( "/hello" )
    public String hello() {
        return this.greetingService.greeting("quarkus" );
    }

    @GET
    @Produces( MediaType.TEXT_PLAIN )
    @Path( "/serverinfo" )
    public String serverInfo( @Context HttpServletRequest req ) {
        return "Hello from quarkus running at: " + req.getServerName();
    }
}