package com.hustlebar.microhustle.faulttolerance;

import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.faulttolerance.Timeout;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.core.Response;

@ApplicationScoped
public class FaultTolerance implements IFaultTolerance {
    @Override
    @Timeout(value = 100)
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

    @Override
    @Timeout(value = 50)
    @Retry(retryOn = RuntimeException.class)
    public Response retry(long sleep) {
        System.out.println("Enters FaultTolerance.retry()");

        System.out.println("Before delay");
        if (sleep > 0) {
            forcedDelay(sleep);
        }
        System.out.println("After delay");
        return Response.ok()
                .entity("FaultTolerance.retry() success!")
                .build();
    }

    @Override
    @Timeout(value = 100)
//    @Fallback(fallbackMethod = "fallbackHandler")
    @Fallback(MicroFallbackHandler.class)
    public Response fallback(long sleep) {
        System.out.println("Enters FaultTolerance.fallback()");
        if (sleep > 0) {
            forcedDelay(sleep);
        }
        return Response.ok()
                .entity("FaultTolerance.fallback() success!")
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

    public Response fallbackHandler() {
        System.out.println("Enters FaultTolerance.fallbackHandler()");
        return Response.ok()
                .entity("Success from fallback handler")
                .build();
    }
}
