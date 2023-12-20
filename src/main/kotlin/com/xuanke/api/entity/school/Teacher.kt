package com.xuanke.api.entity.school

data class Teacher(
    var id: Id,
    var name: String,
    var sex: Sex,
    var age: UInt,
    var eduBackground: String?,
    var title: String,
    var dept: Department?,
) {
    @JvmInline
    value class Id(val str: Long)

    constructor() : this(Id(0), "", Sex.MALE, 0u, "", "", Department())
}