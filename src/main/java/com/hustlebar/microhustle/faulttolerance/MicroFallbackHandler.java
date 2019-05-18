package com.hustlebar.microhustle.faulttolerance;

import org.eclipse.microprofile.faulttolerance.ExecutionContext;
import org.eclipse.microprofile.faulttolerance.FallbackHandler;

import javax.ws.rs.core.Response;

public class MicroFallbackHandler implements FallbackHandler<Response> {
    @Override
    public Response handle(ExecutionContext executionContext) {
        return Response.ok()
                .entity("Response from MicroFallbackHandler Success")
                .build();
    }
}
