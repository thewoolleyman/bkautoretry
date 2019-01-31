package com.thewoolleyweb.bkautoretry.repo


import org.hamcrest.Matchers.equalTo
import org.junit.Assert.assertThat
import org.junit.Assert.assertTrue
import org.junit.Test

class JobEventDaoTest {
    @Test
    fun testJobEvent() {
        val id = "f7bdcb19-46c8-4611-aa7a-1c6e480b5484"
        val event = """
            {
                "event": "job.finished",
                "job": {
                    "id": "f3e4f33a-0771-49d8-8b52-58960c80bfa1",
                    "state": "failed"
                }
            }
        """.trimIndent()

        val dao = JobEventDao()
        val result = dao.createEvent(id, event)
        assertTrue(result)
//       TODO: read the event back
        assertThat(event, equalTo(event))
    }
}
