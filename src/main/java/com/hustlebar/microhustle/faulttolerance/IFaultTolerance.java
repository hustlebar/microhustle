package com.hustlebar.microhustle.faulttolerance;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

@Path("tolerance")
public interface IFaultTolerance {
    @GET
    @Path("timeout")
    Response timeout(@QueryParam("sleep") long sleep);
}
