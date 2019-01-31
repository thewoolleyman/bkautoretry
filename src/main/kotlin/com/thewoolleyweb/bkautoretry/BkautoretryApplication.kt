package com.thewoolleyweb.bkautoretry

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BkautoretryApplication

fun main(args: Array<String>) {
    runApplication<BkautoretryApplication>(*args)

    val gwc = GreetingWebClient()
    System.out.println(gwc.getResult())
}

