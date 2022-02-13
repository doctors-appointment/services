package com.manoj.gateway.config;

import com.manoj.gateway.filter.JwtAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {
	
	@Autowired
	JwtAuthenticationFilter filter;

    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {
        return builder.routes()

                .route(p -> p 
                		.path("/usermgt/**")
                		.filters(f -> f.rewritePath("/usermgt/(?<segment>.*)", "/${segment}").filter(filter))
                		.uri("lb://usermgt"))
                .build();
    }

	
}
