package com.xuanke.api.controller

import com.fasterxml.jackson.annotation.JsonProperty
import com.xuanke.api.UserTokenInterceptor
import com.xuanke.api.badRequest
import com.xuanke.api.entity.school.Course
import com.xuanke.api.entity.school.Teacher
import com.xuanke.api.service.CourseService
import com.xuanke.api.service.TeacherService
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.config.annotation.InterceptorRegistration

@RestController
@RequestMapping("/course")
class CourseController(private val _courseService: CourseService, private val _teacherService: TeacherService) {
    @Component
    private class UserTokenTarget : UserTokenInterceptor.Target {
        override fun addRules(registration: InterceptorRegistration) {
            registration.addPathPatterns("/course/**")
        }
    }

    data class PagedCourseList(
        val page: Int,
        val limit: Int,
        val total: Int,
        val list: List<Course>,
    )

    @GetMapping(path = ["/list"])
    fun getCourseList(
        @RequestParam(name = "page", defaultValue = "1") page: Int,
        @RequestParam(name = "limit", defaultValue = "50") limit: Int
    ): PagedCourseList {
        if (page <= 0) {
            throw badRequest("page must > 0.")
        }
        if (limit <= 0) {
            throw badRequest("limit must > 0.")
        }
        return PagedCourseList(
            page,
            limit,
            _courseService.readCourseCount().toInt(),
            _courseService.readCourseList(page.toUInt(), limit.toUInt()),
        )
    }

    @GetMapping(path = ["/{id}"])
    fun getCourse(@PathVariable(value = "id") courseId: Long?): Course {
        courseId ?: throw badRequest("Please provide course id in request path.")
        return _courseService.readCourseByCourseId(Course.Id(courseId))
    }

    data class CourseParam(
        @JsonProperty("id")
        val id: Long?,
        @JsonProperty("name")
        val name: String?,
        @JsonProperty("teacherId")
        val teacherId: Long?,
    )

    private fun CourseParam?.checked(): Course? {
        this ?: return null
        return Course(
            Course.Id(id ?: return null),
            name ?: return null,
            _teacherService.readTeacherByTeacherId(Teacher.Id(teacherId ?: return null)),
        )
    }

    @PostMapping
    fun setupCourse(@RequestBody param: CourseParam?) {
        val checked = param.checked() ?: throw badRequest("Please provide a legal course object.")
        _courseService.writeCourse(checked)
    }

    @DeleteMapping("/{id}")
    fun deleteCourse(@PathVariable(value = "id") courseId: Long?) {
        courseId ?: throw badRequest(
            "Please provide course id in request path."
        )
        _courseService.deleteCourse(Course.Id(courseId))
    }
}
