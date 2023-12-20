package com.xuanke.api

import com.xuanke.api.util.RequestVariableStore
import com.xuanke.api.util.JwtHelper
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.SpringBootConfiguration
import org.springframework.web.servlet.HandlerInterceptor
import org.springframework.web.servlet.config.annotation.InterceptorRegistration
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer
import java.lang.Exception

/**
 * 用户登录拦截器
 */
@SpringBootConfiguration
class UserTokenInterceptor(@Autowired private val targets: List<Target>) : WebMvcConfigurer, HandlerInterceptor {
    companion object {
        private const val TOKEN_KEY = "Token"
    }

    /** 实现这个接口，添加需要拦截的路径 */
    fun interface Target {
        fun addRules(registration: InterceptorRegistration)
    }

    override fun addInterceptors(registry: InterceptorRegistry) {
        val registration = registry.addInterceptor(this)
        for (target in targets) {
            target.addRules(registration)
        }
    }

    override fun preHandle(request: HttpServletRequest, response: HttpServletResponse, handler: Any): Boolean {
        val token = request.getHeader(TOKEN_KEY) ?: return false
        val userId = JwtHelper.getUserId(token) ?: return false
        /** 用户信息缓存到线程对象里面 */
        RequestVariableStore.setUserId(userId)
        return true
    }

    override fun afterCompletion(request: HttpServletRequest, response: HttpServletResponse, handler: Any, ex: Exception?) {
        RequestVariableStore.removeUserId()
    }
}