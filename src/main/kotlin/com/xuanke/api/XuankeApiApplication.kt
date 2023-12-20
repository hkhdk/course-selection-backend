package com.xuanke.api

import jakarta.servlet.http.HttpServletRequest
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.boot.web.servlet.error.ErrorController
import org.springframework.cloud.client.loadbalancer.LoadBalanced
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer
import org.springframework.context.annotation.Bean
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.client.RestTemplate

@SpringBootApplication
@EnableEurekaServer
class XuankeApiApplication {
    @Bean
    @LoadBalanced
    fun restTemplate(): RestTemplate {
        return RestTemplate()
    }
}

fun main(args: Array<String>) {
    runApplication<XuankeApiApplication>(*args)
}


@Controller
@ControllerAdvice
@RequestMapping("\${server.error.path:\${error.path:/error}}")
class ErrorController : ErrorController {
    @RequestMapping
    @ResponseBody
    fun error(request: HttpServletRequest): ResponseEntity<Map<String, Any>> {
        return ResponseEntity(null, HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(XuankeException::class)
    @ResponseBody
    private fun handleXuankeException(e: XuankeException): ResponseEntity<Map<String, Any>> {
        return ResponseEntity(e.message?.let { mapOf("error" to it) }, e.code)
    }

    @ExceptionHandler(Exception::class)
    @ResponseBody
    private fun handleException(e: Exception): ResponseEntity<Map<String, Any>> {
        e.printStackTrace()
        return ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR)
    }
}


