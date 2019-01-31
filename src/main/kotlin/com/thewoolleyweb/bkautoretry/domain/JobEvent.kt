package com.thewoolleyweb.bkautoretry.domain

data class JobEvent(
    val id: String,
    val event: String,
    val job: Job
)