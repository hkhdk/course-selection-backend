package com.xuanke.api.dao

import com.xuanke.api.entity.NewUser
import com.xuanke.api.entity.User
import org.apache.ibatis.annotations.Mapper

@Mapper
interface UserMapper {
    fun selectUserByUserId(userId: Int): User?

    fun selectUserIdByLoginNameAndPasswordSign(loginName: String, passwordSign: String): Int?

    fun insertUser(user: NewUser): Int?

    fun listUsers(offset: Int, limit: Int): List<User>
}