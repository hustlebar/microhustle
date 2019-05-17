package com.hustlebar.microhustle.faulttolerance;

import org.eclipse.microprofile.faulttolerance.Timeout;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

@Path("tolerance")
public interface IFaultTolerance {
    @GET
    @Path("timeout")
    @Timeout(value = 10)
    Response timeout(@QueryParam("sleep") long sleep);
}
