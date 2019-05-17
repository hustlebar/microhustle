package com.hustlebar.microhustle.faulttolerance;

import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.faulttolerance.Timeout;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.core.Response;

@ApplicationScoped
public class FaultTolerance implements IFaultTolerance {
    @Override
    @Timeout(value = 50)
    @Retry(retryOn = RuntimeException.class)
    public Response timeout(long sleep) {
        System.out.println("Enters FaultTolerance.timeout()");

        System.out.println("Before delay");
        if (sleep > 0) {
            forcedDelay(sleep);
        }
        System.out.println("After delay");
        return Response.ok()
            .entity("FaultTolerance.timeout() success!")
            .build();
    }

    private void forcedDelay(long sleep) {
        System.out.println("Enters sleep with: " + sleep + " value");
        try {
            Thread.sleep(sleep);
        } catch (InterruptedException e) {
            throw new RuntimeException("Error inside forcedDelay()");
        }
    }

    @Retry(retryOn = RuntimeException.class)
    public void onRetry() {
        System.out.println("Enters FaultTolerance.onRetry()");
    }
}
