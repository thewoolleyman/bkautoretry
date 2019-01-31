package com.thewoolleyweb.bkautoretry.repo

import com.thewoolleyweb.bkautoretry.domain.JobEvent
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.queryForObject
import java.sql.ResultSet

class JobEventDao(private val template: JdbcTemplate) {
    fun createEvent(id: String, eventJson: String): Boolean {
        try {
            template.update("INSERT INTO jobevents VALUES (?, ?)", "id", """{"foo":"bar"}""");
            return true
        } catch (e: EmptyResultDataAccessException) {
            return false
        }
    }

//    private fun mapToJobEvent(rs: ResultSet, rowNum: Int) = JobEvent(
//        id = rs.getInt("id")
//        , job = rs.getString("email")
//    )

//    fun findAllUsers() = template.query("SELECT * FROM users;", this::mapToUser)
//
//    fun findUser(id: Int) = try {
//        template.queryForObject("SELECT * FROM users WHERE id = $id;", this::mapToUser)
//    } catch (e: EmptyResultDataAccessException) {
//        null
//    }
//
//    private fun mapToUser(rs: ResultSet, rowNum: Int) = User(
//        id = rs.getInt("id")
//        , email = rs.getString("email")
//        , name = mergeNames(rs) // execute custom mapping logic
//        , role = if (rs.getBoolean("guest")) Role.GUEST else Role.USER //understandable and direct type conversion
//        , dateCreated = rs.getTimestamp("date_created").toInstant()
//        , state = State.valueOf(rs.getString("state"))
//    )
}