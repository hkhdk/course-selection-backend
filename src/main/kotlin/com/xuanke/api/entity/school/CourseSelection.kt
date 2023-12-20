package com.xuanke.api.entity.school

data class CourseSelection(
    val id: Id,
    val student: Student,
    val course: Course,
) {
    @JvmInline
    value class Id(val value: Int)

    constructor() : this(Id(0), Student(), Course())
}