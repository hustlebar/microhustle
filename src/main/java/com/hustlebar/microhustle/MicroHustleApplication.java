package com.hustlebar.microhustle;

import com.hustlebar.microhustle.faulttolerance.IFaultTolerance;
import com.hustlebar.microhustle.faulttolerance.MicroFallbackHandler;
import com.hustlebar.microhustle.users.IUserApi;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

/**
 * @author tham
 */

@ApplicationPath("api/v1")
public class MicroHustleApplication extends Application {
//    @Override
//    public Set<Class<?>> getClasses() {
//        Set<Class<?>> classes = new HashSet<>();
//        classes.add(IUserApi.class);
//        classes.add(IFaultTolerance.class);
//        classes.add(MicroFallbackHandler.class);
//        return classes;
//    }
}
