package com.xuanke.api.entity

import java.util.Date

data class NewUser(
    val id: Int? = null,
    val loginName: User.LoginName,
    val passwordSign: String,
    val createTime: Date,
)