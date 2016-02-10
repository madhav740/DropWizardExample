package com.madhav.dwstart;

import com.madhav.dwstart.health.TemplateHealthCheck;
import com.madhav.dwstart.resources.DWGettingStartedResource;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class DWGettingStartedApplication extends Application<DWGettingStartedConfiguration> {

    public static void main(final String[] args) throws Exception {
        new DWGettingStartedApplication().run(args);
    }

    @Override
    public String getName() {
        return "DWGettingStarted";
    }

    @Override
    public void initialize(final Bootstrap<DWGettingStartedConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final DWGettingStartedConfiguration configuration,
                    final Environment environment) {
    	final DWGettingStartedResource resource = new DWGettingStartedResource(configuration.getTemplate(),configuration.getDefaultName());
    	final TemplateHealthCheck healthCheck = new TemplateHealthCheck(configuration.getTemplate());environment.healthChecks().register("template", healthCheck);    
    	environment.jersey().register(resource);
    }

}
