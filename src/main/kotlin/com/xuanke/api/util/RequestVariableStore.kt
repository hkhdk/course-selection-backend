package com.xuanke.api.util

import com.xuanke.api.entity.User

object RequestVariableStore {
    private val userId = ThreadLocal<Int?>()

    fun getUserId() = userId.get()

    fun setUserId(userId: User.Id?) {
        RequestVariableStore.userId.set(userId?.value)
    }

    fun removeUserId() = userId.remove()

    inline fun getUserIdOrThrow(onMissing: () -> Throwable) = User.Id(getUserId() ?: throw onMissing())
}