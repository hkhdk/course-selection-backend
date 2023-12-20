package com.xuanke.api.entity.school

class Department(
    val id: Id,
    val name: String,
    val manager: String,
) {
    @JvmInline
    value class Id(val value: UInt)

    constructor() : this(Id(0U), "", "")
}