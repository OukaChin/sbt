package com.wanhe.springboottest.controller.advice

import com.wanhe.springboottest.entity.ResultEntity
import com.wanhe.springboottest.exception.TestException
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class ExceptionHandler {
    @ExceptionHandler(TestException::class)
    fun testExceptionHandler(e: TestException): ResponseEntity<ResultEntity> {
        return ResponseEntity.ok(ResultEntity(status = false, message = e.localizedMessage))
    }
}