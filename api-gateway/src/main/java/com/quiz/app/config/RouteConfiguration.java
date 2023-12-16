package com.quiz.app.config;

import com.quiz.app.filter.AuthenticationFilter;
import com.quiz.app.filter.TestFilter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouteConfiguration {

    private final AuthenticationFilter authFilter;
    private final TestFilter testFilter;

    public RouteConfiguration(AuthenticationFilter authFilter, TestFilter testFilter) {
        this.authFilter = authFilter;
        this.testFilter = testFilter;
    }

    @Bean
        public RouteLocator gatewayRouter(RouteLocatorBuilder builder){
            return builder.routes()
                    .route(p -> p.path("/login", "/register", "/refreshToken")
                            .filters(f -> f.filter(testFilter))
                            .uri("lb://auth-service"))

                    .route(p -> p.path("/quiz/test-quiz")
                            .filters(f -> f.filter(testFilter))
                            .uri("lb://quiz-service"))

                    .route(p -> p.path("/logout")
                            .filters(f -> f.filter(authFilter))
                            .uri("lb://auth-service"))

                    .route(p -> p.path("/quiz/**")
                            .filters(f -> f.filter(authFilter))
                            .uri("lb://quiz-service"))

                    .route(p -> p.path("/submission/**")
                            .filters(f -> f.filter(authFilter))
                            .uri("lb://scoring-service"))

//                    .route(p -> p.path("/quiz-submission/**")
//                            .filters(f -> f
//                                    .filter(authFilter)
//                                    .rewritePath(
//                                            "/quiz-submission/(?<segment>.*)",
//                                            "/${segment}"))
//                            .uri("lb://scoring-service"))

                .build();

    }




}
