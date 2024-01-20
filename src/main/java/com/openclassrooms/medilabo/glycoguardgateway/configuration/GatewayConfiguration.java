package com.openclassrooms.medilabo.glycoguardgateway.configuration;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfiguration {

	@Bean
	public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
		return builder.routes()
				.route("patients-service", r -> r.path("/patients/**").uri("lb://microservice-patients"))
				.route("notes-service", r -> r.path("/notes/**").uri("lb://microservice-notes"))
				.route("evaluation-service", r -> r.path("/evaluator/**").uri("lb://microservice-eval"))
				.build();
	}
}