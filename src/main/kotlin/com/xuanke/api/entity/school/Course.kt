package com.xuanke.api.entity.school

data class Course(
    val id: Id,
    val name: String,
    val teacher: Teacher,
) {
    @JvmInline
    value class Id(val value: Long)

    constructor(): this(Id(0), "", Teacher())
}