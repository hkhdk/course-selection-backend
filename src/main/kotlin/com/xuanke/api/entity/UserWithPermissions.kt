package com.xuanke.api.entity

import com.fasterxml.jackson.annotation.JsonUnwrapped

data class UserWithPermissions(
    @JsonUnwrapped
    val user: User,
    val permissions: List<Int>,
)