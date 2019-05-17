package com.hustlebar.microhustle.faulttolerance;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.core.Response;

@ApplicationScoped
public class FaultTolerance implements IFaultTolerance {
    @Override
    public Response timeout() {
        return null;
    }
}
