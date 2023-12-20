package com.xuanke.api.util

/** 用户名格式检查 */
object LoginNameChecker {
    const val MESSAGE_LENGTH = "The user login name is too short or too long."
    const val MESSAGE_CONTENT = "Only digit, letter and '_' were allowed in user login name."

    fun checkLength(loginName: String) = loginName.length in 4..24

    fun checkContent(loginName: String): Boolean {
        return loginName.all { it.isLetterOrDigit() || it == '_' }
    }
}