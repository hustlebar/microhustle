package com.hustlebar.microhustle.faulttolerance;

import org.eclipse.microprofile.faulttolerance.*;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.core.Response;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.util.concurrent.TimeoutException;

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
    @Retry(maxRetries = 5, retryOn = {RuntimeException.class, TimeoutException.class})
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

    @Override
    @Bulkhead(value = 5)
    public Response bulkhead() {
        System.out.println("Enters FaultTolerance.bulkhead()");

        //semaphore isolation
        //maximum 5 concurrent connections are allowed

        return Response.ok()
                .entity("FaultTolerance.bulkhead() success!")
                .build();
    }

    @Override
    @Bulkhead(value = 5, waitingTaskQueue = 5)
    @Asynchronous
    public Future<Response> bulkheadAsync() {
        System.out.println("Enters FaultTolerance.bulkheadAsync()");

        //thread-pool style isolation
        //maximum 5 concurrent connections are allowed
        //maximum 5 connections are allowed in the waiting queue
        return CompletableFuture.completedFuture(
                Response.ok()
                .entity("FaultTolerance.bulkheadAsync() success!")
                .build()
        );
    }


    @Override
    @CircuitBreaker(successThreshold = 10,
            requestVolumeThreshold = 4,
            failureRatio = 0.75,
            delay = 100)
    public Response circuitbreak() {
        System.out.println("Enters FaultTolerance.circuitbreak()");

        return Response.ok()
                .entity("FaultTolerance.circuitbreak() success!")
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
