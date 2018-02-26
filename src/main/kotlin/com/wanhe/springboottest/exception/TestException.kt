package com.wanhe.springboottest.exception

class TestException : RuntimeException {
    constructor() : super()
    constructor(message: String = "") : super(message)
    constructor(message: String = "", cause: Throwable) : super(message, cause)
    constructor(message: String = "", cause: Throwable, enableSuppression: Boolean, writableStackTrace: Boolean) : super(message, cause, enableSuppression, writableStackTrace)
    constructor(cause: Throwable) : super(cause)
}