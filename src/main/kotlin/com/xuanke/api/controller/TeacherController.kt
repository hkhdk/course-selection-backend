package com.xuanke.api.controller

import com.fasterxml.jackson.annotation.JsonProperty
import com.xuanke.api.UserTokenInterceptor
import com.xuanke.api.badRequest
import com.xuanke.api.entity.school.Department
import com.xuanke.api.entity.school.Sex
import com.xuanke.api.entity.school.Student
import com.xuanke.api.entity.school.Teacher
import com.xuanke.api.service.DepartmentService
import com.xuanke.api.service.TeacherService
import jakarta.annotation.Resource
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.config.annotation.InterceptorRegistration

@RestController
@RequestMapping("/teacher")
class TeacherController(
    @Resource private val _service: TeacherService,
    @Autowired private val _departmentService: DepartmentService
) {
    @Component
    private class UserLoginTarget : UserTokenInterceptor.Target {
        override fun addRules(registration: InterceptorRegistration) {
            registration.addPathPatterns("/teacher/**")
        }
    }

    data class PagedTeacherList(
        val page: Int,
        val limit: Int,
        val total: Int,
        val list: List<Teacher>,
    )

    @GetMapping(path = ["/list"])
    fun getTeacherList(
        @RequestParam(name = "page", defaultValue = "1") page: Int,
        @RequestParam(name = "limit", defaultValue = "20") limit: Int,
    ): PagedTeacherList {
        if (page <= 0) {
            throw badRequest("page must > 0.")
        }
        if (limit <= 0) {
            throw badRequest("limit must > 0.")
        }
        return PagedTeacherList(
            page,
            limit,
            _service.readTeachersCount().toInt(),
            _service.readTeacherList(page, limit),
        )
    }

    /**
     * 获取指定教工号教师信息，需要管理员令牌
     *
     * @param teacherId 指定的教工号
     */
    @GetMapping(value = ["/{id}"])
    fun getTeacher(@PathVariable(value = "id") teacherId: Long?): Teacher {
        teacherId ?: throw badRequest("Please provide teacher id in request path.")
        return _service.readTeacherByTeacherId(Teacher.Id(teacherId))
    }

    data class TeacherParam(
        @JsonProperty("id")
        val id: Long?,
        @JsonProperty("name")
        val name: String?,
        @JsonProperty("sex")
        val sex: Sex?,
        @JsonProperty("age")
        val age: UInt?,
        @JsonProperty("eduBackground")
        val eduBackground: String?,
        @JsonProperty("title")
        val title: String?,
        @JsonProperty("deptId")
        val deptId: UInt?,
    )

    private fun TeacherParam?.checked(): Teacher? {
        this ?: return null
        return Teacher(
            Teacher.Id(id ?: return null),
            name ?: return null,
            sex ?: return null,
            age ?: return null,
            eduBackground ?: return null,
            title ?: return null,
            _departmentService.readDepartmentByDepartmentId(Department.Id(deptId ?: return null)),
        )
    }

    /**
     * 设置对应教工号教师信息，需要用户令牌。若未指定教工号，则查询当前用户对应教师。
     *
     * @param param 教师信息
     */
    @PostMapping
    fun setupTeacher(@RequestBody param: TeacherParam?) {
        val checked = param.checked() ?: throw badRequest("Please provide a legal teacher object.")
        _service.writeTeacher(checked)
    }

    @DeleteMapping(value = ["/{id}"])
    fun deleteTeacher(@PathVariable(value = "id") teacherId: Long?) {
        teacherId ?: throw badRequest(
            "Please provide teacher id in request path."
        )
        _service.deleteTeacher(Teacher.Id(teacherId))
    }
}