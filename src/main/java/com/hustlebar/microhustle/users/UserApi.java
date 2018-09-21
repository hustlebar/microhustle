package com.hustlebar.microhustle.users;

import org.eclipse.microprofile.metrics.annotation.Metric;
import org.eclipse.microprofile.metrics.annotation.Timed;

import javax.inject.Inject;
import javax.ws.rs.core.Response;

/**
 * @author tham
 */

public class UserApi implements IUserApi {
    @Inject UserManager userManager;

    @Override
    @Timed(name = "users.all.timed")
    @Metric(name = "users.all.metric")
    public Response all() {
        return Response.ok()
                .entity(userManager.all())
                .build();
    }

    @Override
    public Response get(String name) {
        final User user = userManager.get(name);
        if (user == null) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("User not found with name: " + name)
                    .build();
        }

        return Response.ok()
                .entity(user)
                .build();
    }
}
