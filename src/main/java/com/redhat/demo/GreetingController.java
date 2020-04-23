package com.redhat.demo;

import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path( "/quarkus" )
public class GreetingController {

    private final GreetingService service;

    @Inject
    public GreetingController(GreetingService service) {
        this.service = service;
    }

    @GET
    @Produces( MediaType.TEXT_PLAIN )
    @Path( "/greeting/{name}" )
    public String greeting( @PathParam String name ) {
        return service.greeting(name);
    }

    @GET
    @Produces( MediaType.TEXT_PLAIN )
    public String hello() {
        return "hello from quarkus";
    }
}