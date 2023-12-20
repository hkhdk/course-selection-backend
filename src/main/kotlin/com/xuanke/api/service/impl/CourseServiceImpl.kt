package com.xuanke.api.service.impl

import com.xuanke.api.dao.CourseMapper
import com.xuanke.api.entity.Permission
import com.xuanke.api.entity.school.Course
import com.xuanke.api.notFound
import com.xuanke.api.service.CourseService
import com.xuanke.api.service.PermissionService
import com.xuanke.api.unauthorized
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CourseServiceImpl(
    @Autowired private val _mapper: CourseMapper,
    @Autowired private val _permissionService: PermissionService,
) : CourseService{

    private fun checkCourseReadPermission() {
        if (!_permissionService.hasPermission(Permission.READ_ALL_COURSE)) {
            throw unauthorized("You can not access to your own student information.")
        }
    }

    private fun checkCourseWritePermission() {
        if (!_permissionService.hasPermission(Permission.WRITE_ALL_COURSE)) {
            throw unauthorized("You don't have access to course information.")
        }
    }
    
    override fun readCourseList(page: UInt, limit: UInt): List<Course> {
        checkCourseReadPermission()
        return _mapper.listCourses(((page - 1u) * limit).toInt(), limit.toInt())
    }

    override fun readCourseCount(): UInt {
        checkCourseReadPermission()
        return _mapper.countCourses().toUInt()
    }

    override fun readCourseByCourseId(courseId: Course.Id): Course {
        checkCourseReadPermission()
        return _mapper.selectCourseByCourseId(courseId.value) ?: throw notFound("The Course not exists.")
    }

    override fun isCourseExists(courseId: Course.Id): Boolean {
        checkCourseReadPermission()
        return _mapper.isCourseExists(courseId.value) > 0
    }

    override fun writeCourse(course: Course) {
        checkCourseWritePermission()
        _mapper.replaceCourseByCourseId(course)
    }

    override fun deleteCourse(courseId: Course.Id) {
        checkCourseWritePermission()
        _mapper.deleteCourseByCourseId(courseId.value)
    }
}