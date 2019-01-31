package com.thewoolleyweb.bkautoretry.examples

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.*

@Configuration
class GreetingRouter {

    @Bean
    fun routeExample(greetingHandler: GreetingHandler): RouterFunction<ServerResponse> {

        return RouterFunctions
            .route(RequestPredicates.GET("/hello").and(RequestPredicates.accept(MediaType.TEXT_PLAIN)),
                HandlerFunction<ServerResponse> { greetingHandler.hello(it) })
    }
}
