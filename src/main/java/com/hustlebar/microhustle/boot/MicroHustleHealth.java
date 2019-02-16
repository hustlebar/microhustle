package com.hustlebar.microhustle.boot;

import org.eclipse.microprofile.health.Health;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;

import javax.enterprise.context.ApplicationScoped;

/**
 * @author tham
 */

@Health
@ApplicationScoped
public class MicroHustleHealth implements HealthCheck {
    @Override
    public HealthCheckResponse call() {
        return HealthCheckResponse.named("microhustle-health").withData("Health", "I am in good health").up().build();
    }
}
