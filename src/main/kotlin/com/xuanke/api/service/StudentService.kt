package com.xuanke.api.service

import com.xuanke.api.entity.school.Student

interface StudentService {
    fun readStudentList(page: Int, limit: Int): List<Student>

    fun readStudentsCount(): UInt

    fun isStudentExists(studentId: Student.Id): Boolean
    
    fun readStudentByStudentId(studentId: Student.Id): Student

    fun writeStudent(student: Student)

    fun deleteStudent(studentId: Student.Id)
}