package com.hustlebar.microhustle.apigee;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("apigee")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ApigeeIntegrationHookApi {
    @POST
    @Path("applications")
    public void createApplication() {

    }
}
