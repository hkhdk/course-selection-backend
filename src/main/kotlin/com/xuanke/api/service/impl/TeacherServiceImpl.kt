package com.xuanke.api.service.impl

import com.xuanke.api.dao.TeacherMapper
import com.xuanke.api.entity.Permission
import com.xuanke.api.entity.school.Teacher
import com.xuanke.api.notFound
import com.xuanke.api.service.PermissionService
import com.xuanke.api.service.TeacherService
import com.xuanke.api.unauthorized
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class TeacherServiceImpl(
    @Autowired private val _mapper: TeacherMapper,
    @Autowired private val _permissionService: PermissionService,
) : TeacherService {
    /** 检查读取所有教师信息的权限 */
    private fun checkTeacherReadPermission() {
        if (!_permissionService.hasPermission(Permission.READ_ALL_TEACHER)) {
            throw unauthorized("You only have access to your own teacher information.")
        }
    }

    /** 检查修改所有教师信息的权限 */
    private fun checkTeacherWritePermission() {
        if (!_permissionService.hasPermission(Permission.WRITE_ALL_TEACHER)) {
            throw unauthorized("You don't have access to teacher information.")
        }
    }

    override fun readTeacherList(page: Int, limit: Int): List<Teacher> {
        checkTeacherReadPermission()
        return _mapper.listTeachers((page - 1) * limit, limit)
    }

    override fun readTeachersCount(): UInt {
        checkTeacherReadPermission()
        return _mapper.countTeachers().toUInt()
    }

    override fun readTeacherByTeacherId(teacherId: Teacher.Id): Teacher {
        checkTeacherReadPermission()
        return _mapper.selectTeacherByTeacherId(teacherId.str) ?: throw notFound("The teacher not exists.")
    }

    override fun writeTeacher(teacher: Teacher) {
        checkTeacherWritePermission()
        _mapper.replaceTeacherByTeacherId(teacher)
    }

    override fun deleteTeacher(teacherId: Teacher.Id) {
        checkTeacherWritePermission()
        _mapper.deleteTeacherByTeacherId(teacherId.str)
    }
}