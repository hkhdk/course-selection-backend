package com.xuanke.api

import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatusCode

class XuankeException(val code: HttpStatusCode, message: String? = null) : RuntimeException(message, null, false, false)

fun badRequest(message: String? = null): XuankeException {
    return XuankeException(HttpStatus.BAD_REQUEST, message)
}

fun notFound(message: String? = null): XuankeException {
    return XuankeException(HttpStatus.NOT_FOUND, message)
}

fun unauthorized(message: String? = null): XuankeException {
    return XuankeException(HttpStatus.UNAUTHORIZED, message)
}

fun conflict(message: String? = null): XuankeException {
    return XuankeException(HttpStatus.CONFLICT, message)
}