package org.example.resource;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/books")
public class BookResource
{
    private static final Logger LOG = LoggerFactory.getLogger(BookResource.class);
    @GET
    @Path("")
    public Response helloWorld(){
        return Response.ok("Books will be here").build();
    }
}
