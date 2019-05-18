package com.hustlebar.microhustle.faulttolerance;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import java.util.concurrent.Future;

@Path("tolerance")
public interface IFaultTolerance {
    @GET
    @Path("timeout")
    Response timeout(@QueryParam("sleep") long sleep);

    @GET
    @Path("retry")
    Response retry(@QueryParam("sleep") long sleep);

    @GET
    @Path("fallback")
    Response fallback(@QueryParam("sleep") long sleep);

    @GET
    @Path("bulkhead")
    Response bulkhead();

    @GET
    @Path("bulkheadAsync")
    Future<Response> bulkheadAsync();

    @GET
    @Path("circuitbreak")
    Response circuitbreak();
}
