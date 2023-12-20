package com.xuanke.api.entity.school

data class Student(
    val id: Id,
    val name: String,
    val sex: Sex,
    val age: UInt,
    val dept: Department,
    var clazz: String,
) {
    @JvmInline
    value class Id(val value: Long)

    constructor() : this(Id(0), "", Sex.MALE, 0U, Department(), "")
}