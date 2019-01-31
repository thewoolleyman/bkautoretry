package com.thewoolleyweb.bkautoretry.hook

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.*

@Configuration
class HookRouter {

    @Bean
    fun routeHook(hookHandler: HookHandler): RouterFunction<ServerResponse> {

        return RouterFunctions
            .route(RequestPredicates.POST("/hook").and(RequestPredicates.accept(MediaType
                .TEXT_PLAIN)),
                HandlerFunction<ServerResponse> { hookHandler.handleJobHook(it) })
    }
}
