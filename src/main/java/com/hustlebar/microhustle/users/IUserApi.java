package com.hustlebar.microhustle.users;

import org.eclipse.microprofile.metrics.annotation.Metric;
import org.eclipse.microprofile.metrics.annotation.Timed;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @author tham
 */

@Path("users")
@Produces(MediaType.APPLICATION_JSON)
public interface IUserApi {
    @GET
    Response all();

    @Path("{name}")
    @GET
    Response get(@PathParam("name") String name);

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    void create(User user);
}
