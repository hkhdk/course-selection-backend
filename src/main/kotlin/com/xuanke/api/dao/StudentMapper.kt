package com.xuanke.api.dao

import com.xuanke.api.entity.school.Student
import org.apache.ibatis.annotations.Mapper

@Mapper
interface StudentMapper {
    fun listStudents(offset: Int, limit: Int): List<Student>

    fun countStudents(): Int

    fun selectStudentByStudentId(studentId: Long): Student?

    fun isStudentExists(studentId: Long): Int

    fun replaceStudentByStudentId(student: Student)

    fun deleteStudentByStudentId(studentId: Long): Int
}