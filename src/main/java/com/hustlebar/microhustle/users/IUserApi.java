package com.hustlebar.microhustle.users;

import org.eclipse.microprofile.metrics.annotation.Metric;
import org.eclipse.microprofile.metrics.annotation.Timed;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
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

    @Path("id")
    @GET
    User get(@PathParam("id") String id);
}
