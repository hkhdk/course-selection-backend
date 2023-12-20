package com.xuanke.api.service.impl

import com.xuanke.api.dao.StudentMapper
import com.xuanke.api.entity.Permission
import com.xuanke.api.entity.school.Student
import com.xuanke.api.notFound
import com.xuanke.api.service.PermissionService
import com.xuanke.api.service.StudentService
import com.xuanke.api.unauthorized
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class StudentServiceImpl(
    @Autowired private val _studentMapper: StudentMapper,
    @Autowired private val _permissionService: PermissionService,
) : StudentService {
    /** 检查读取所有学生信息的权限 */
    private fun checkStudentReadPermission() {
        if (!_permissionService.hasPermission(Permission.READ_ALL_STUDENT)) {
            throw unauthorized("You only have access to your own student information.")
        }
    }

    /** 检查修改所有学生信息的权限 */
    private fun checkStudentWritePermission() {
        if (!_permissionService.hasPermission(Permission.WRITE_ALL_STUDENT)) {
            throw unauthorized("You don't have access to student information.")
        }
    }

    override fun readStudentList(page: Int, limit: Int): List<Student> {
        checkStudentReadPermission()
        return _studentMapper.listStudents((page - 1) * limit, limit)
    }

    override fun readStudentsCount(): UInt {
        checkStudentReadPermission()
        return _studentMapper.countStudents().toUInt()
    }

    override fun readStudentByStudentId(studentId: Student.Id): Student {
        checkStudentReadPermission()
        return _studentMapper.selectStudentByStudentId(studentId.value)
            ?: throw notFound("The student not exists.")
    }

    override fun isStudentExists(studentId: Student.Id): Boolean {
        checkStudentReadPermission()
        return _studentMapper.isStudentExists(studentId.value) > 0
    }

    override fun writeStudent(student: Student) {
        checkStudentWritePermission()
        _studentMapper.replaceStudentByStudentId(student)
    }

    override fun deleteStudent(studentId: Student.Id) {
        checkStudentWritePermission()
        _studentMapper.deleteStudentByStudentId(studentId.value)
    }
}