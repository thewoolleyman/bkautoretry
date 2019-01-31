package com.thewoolleyweb.bkautoretry.hook


import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.reactive.server.WebTestClient
import org.springframework.test.web.reactive.server.expectBody

@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class HookRouterTest {

    @Autowired
    private lateinit var webTestClient: WebTestClient

    @Test
    fun testHello() {
        webTestClient
            .get().uri("/hook")
            .accept(MediaType.TEXT_PLAIN)
            .exchange()
            .expectStatus().isOk
            .expectBody<String>().isEqualTo("Job webhook successfully processed")
    }
}
