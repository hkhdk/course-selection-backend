package com.xuanke.api.entity

import com.fasterxml.jackson.annotation.JsonFormat
import java.util.*

data class User(
    val id: Id,
    val loginName: LoginName,
    val nickname: String?,
    val createTime: Date,
) {
    @JvmInline
    value class Id(val value: Int)

    @JvmInline
    value class LoginName(val str: String)

    constructor() : this(Id(0), LoginName(""), null, Date())
}