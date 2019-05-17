package com.hustlebar.microhustle.faulttolerance;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.core.Response;

@ApplicationScoped
public class FaultTolerance implements IFaultTolerance {
    @Override
    public Response timeout(long sleep) {
        System.out.println("Enters FaultTolerance.timeout()");

        System.out.println("Before delay");
        forcedDelay(sleep);
        System.out.println("After delay");
        return Response.ok()
            .entity("FaultTolerance.timeout() success!")
            .build();
    }

    private void forcedDelay(long sleep) {
        try {
            Thread.sleep(sleep);
        } catch (InterruptedException e) {
            throw new RuntimeException("Error inside forcedDelay()");
        }
    }
}
