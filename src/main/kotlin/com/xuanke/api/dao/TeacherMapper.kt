package com.xuanke.api.dao

import com.xuanke.api.entity.school.Student
import com.xuanke.api.entity.school.Teacher
import org.apache.ibatis.annotations.Mapper

@Mapper
interface TeacherMapper {
    fun listTeachers(offset: Int, limit: Int): List<Teacher>

    fun countTeachers(): Int

    fun selectTeacherByTeacherId(teacherId: Long): Teacher?

    fun replaceTeacherByTeacherId(teacher: Teacher)

    fun deleteTeacherByTeacherId(teacherId: Long): Int
}