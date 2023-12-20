package com.xuanke.api.service

import com.xuanke.api.entity.User
import com.xuanke.api.entity.UserWithPermissions

interface UserService {
    /** 登录 */
    fun login(loginName: String, password: String): Map<String, String>

    /** 注册 */
    fun register(loginName: String, password: String): Map<String, String>

    /** 获取用户信息 */
    fun readUserInfo(): UserWithPermissions

    fun listUsers(page: UInt, limit: UInt): List<User>
}