package com.xuanke.api.controller

import com.xuanke.api.UserTokenInterceptor
import com.xuanke.api.badRequest
import com.xuanke.api.entity.User
import com.xuanke.api.entity.UserWithPermissions
import com.xuanke.api.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.config.annotation.InterceptorRegistration

@RestController
@RequestMapping(path = ["/user"])
class UserController(@Autowired private val _userService: UserService) {
    @Component
    private class UserTokenTarget : UserTokenInterceptor.Target {
        override fun addRules(registration: InterceptorRegistration) {
            registration
                .addPathPatterns("/user/**")
                .excludePathPatterns("/user/login", "/user/register")
        }
    }

    data class LoginRegisterParam(
        val loginName: String?,
        val password: String?,
    )

    @PostMapping(path = ["/login"])
    fun login(@RequestBody param: LoginRegisterParam?): Map<String, String> {
        if (param == null || param.loginName.isNullOrEmpty() || param.password.isNullOrEmpty()) {
            throw badRequest("Please provide 'loginName' and 'sign' in JSON.")
        }
        return _userService.login(param.loginName, param.password)
    }

    @PostMapping(path = ["/register"])
    fun register(@RequestBody param: LoginRegisterParam?): Map<String, String> {
        if (param == null || param.loginName.isNullOrEmpty() || param.password.isNullOrEmpty()) {
            throw badRequest("Please provide 'loginName' and 'sign' in JSON.")
        }
        return _userService.register(param.loginName, param.password)
    }

    @GetMapping(path = ["/info"])
    fun getInfo(): UserWithPermissions {
        return _userService.readUserInfo()
    }

    @GetMapping("/list")
    fun getUsers(
        @RequestParam(name = "page", defaultValue = "1") page: Int,
        @RequestParam(name = "limit", defaultValue = "1") limit: Int,
    ): List<User> {
        if (page <= 0) {
            throw badRequest("page must > 0")
        }
        if (limit <= 0) {
            throw badRequest("limit must > 0")
        }
        return _userService.listUsers(page.toUInt(), limit.toUInt())
    }
}