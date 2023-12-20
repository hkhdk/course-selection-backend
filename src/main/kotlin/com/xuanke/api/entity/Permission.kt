package com.xuanke.api.entity

enum class Permission(private val _id: Int) {
    /** 读取所有的学生信息 */
    READ_ALL_STUDENT(1),

    /** 修改所有的学生信息 */
    WRITE_ALL_STUDENT(2),

    /** 读取所有的教师信息 */
    READ_ALL_TEACHER(11),

    /** 修改所有的教师信息 */
    WRITE_ALL_TEACHER(12),

    READ_ALL_DEPARTMENT(21),
    WRITE_ALL_DEPARTMENT(22),

    READ_ALL_COURSE(31),
    WRITE_ALL_COURSE(32),

    READ_ALL_USER(51),
    WRITE_ALL_USER(52),

    PERMISSION_MANAGE(61);

    @JvmInline
    value class Id private constructor(val value: Int) {
        companion object {
            operator fun invoke(permission: Permission) = Id(permission._id)
        }
    }

    inline val id get() = Id(this)
}