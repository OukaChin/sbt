package com.wanhe.springboottest.controller

import com.wanhe.springboottest.entity.EntityTest
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController
//@CrossOrigin(origins = ["http://localhost:8080"], maxAge = 3600)
class RestController {
    val log = LoggerFactory.getLogger(this::class.java)

    @GetMapping("/data")
    fun index(): List<EntityTest> {
        return listOf(EntityTest())
    }

    @PostMapping("/data")
    fun indexPost(): String {
        log.info("post action.")
        return "post"
    }
}