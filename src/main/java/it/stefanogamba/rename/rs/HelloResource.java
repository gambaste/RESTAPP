package it.stefanogamba.rename.rs;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.*;


@Path("/hello")
public class HelloResource {

    @GET
    @Path("/text")  // http://localhost:8080/api/hello/text
    public Response hello() {

        return Response.status(Response.Status.OK).entity("Hello World!").type(MediaType.TEXT_PLAIN).build();

    }



}