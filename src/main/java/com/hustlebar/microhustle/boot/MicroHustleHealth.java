package com.hustlebar.microhustle.boot;

import org.eclipse.microprofile.health.Health;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.HealthCheckResponseBuilder;

import javax.enterprise.context.ApplicationScoped;

/**
 * @author tham
 */

@Health
@ApplicationScoped
public class MicroHustleHealth implements HealthCheck {
    @Override
    public HealthCheckResponse call() {
//        HealthCheckResponseBuilder builder = HealthCheckResponse.named(MicroHustleHealth.class.getSimpleName());
//        builder.withData("Available Memory", Runtime.getRuntime().freeMemory());
//        builder.withData("Available Processors", Runtime.getRuntime().availableProcessors());
//        return builder.state(true).build();

        return HealthCheckResponse.named("microhustle-health")
                .withData("Health", "I am in good health")
                .up()
                .build();
    }
}
