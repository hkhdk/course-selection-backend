package com.xuanke.api.service

import com.xuanke.api.entity.school.Teacher

interface TeacherService {
    fun readTeacherList(page: Int, limit: Int): List<Teacher>

    fun readTeachersCount(): UInt

    /** 根据教工号读取教师信息 */
    fun readTeacherByTeacherId(teacherId: Teacher.Id): Teacher

    /** 根据教工号修改教师信息 */
    fun writeTeacher(teacher: Teacher)

    /** 根据教工号删除教师信息 */
    fun deleteTeacher(teacherId: Teacher.Id)
}