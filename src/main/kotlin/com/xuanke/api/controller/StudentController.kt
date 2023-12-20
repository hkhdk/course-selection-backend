package com.xuanke.api.controller

import com.fasterxml.jackson.annotation.JsonProperty
import com.xuanke.api.UserTokenInterceptor
import com.xuanke.api.badRequest
import com.xuanke.api.entity.school.Department
import com.xuanke.api.entity.school.Sex
import com.xuanke.api.entity.school.Student
import com.xuanke.api.service.DepartmentService
import com.xuanke.api.service.StudentService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.config.annotation.InterceptorRegistration

@RestController
@RequestMapping("/student")
class StudentController(@Autowired private val _service: StudentService,
                        @Autowired private val _departmentService: DepartmentService) {
    @Component
    private class UserTokenTarget : UserTokenInterceptor.Target {
        override fun addRules(registration: InterceptorRegistration) {
            registration.addPathPatterns("/student/**")
        }
    }
    data class PagedStudentList(
        val page: Int,
        val limit: Int,
        val total: Int,
        val list: List<Student>,
    )

    @GetMapping(path = ["/list"])
    fun getStudentList(
        @RequestParam(name = "page", defaultValue = "1") page: Int,
        @RequestParam(name = "limit", defaultValue = "20") limit: Int,
    ): PagedStudentList {
        if (page <= 0) {
            throw badRequest("page must > 0.")
        }
        if (limit <= 0) {
            throw badRequest("limit must > 0.")
        }
        return PagedStudentList(
            page,
            limit,
            _service.readStudentsCount().toInt(),
            _service.readStudentList(page, limit)
        )
    }

    /**
     * 获取指定学号学生信息，需要管理员令牌
     *
     * @param studentId 指定的学号
     */
    @GetMapping(value = ["/{id}"])
    fun getStudent(@PathVariable(value = "id") studentId: Long?): Student {
        studentId ?: throw badRequest("Please provide student id in request path.")
        return _service.readStudentByStudentId(Student.Id(studentId))
    }

    data class StudentParam(
        @JsonProperty("id")
        val id: Long?,
        @JsonProperty("name")
        val name: String?,
        @JsonProperty("sex")
        val sex: Sex?,
        @JsonProperty("age")
        val age: UInt?,
        @JsonProperty("dept")
        val dept: Int?,
        @JsonProperty("clazz")
        var clazz: String?,
    )

    private fun StudentParam?.checked(): Student? {
        this ?: return null
        return Student(
            Student.Id(id ?: return null),
            name ?: return null,
            sex ?: return null,
            age ?: return null,
            _departmentService.readDepartmentByDepartmentId(Department.Id(dept?.toUInt() ?: return null)),
            clazz ?: return null
        )
    }

    /**
     * 设置对应学号学生信息，需要管理员令牌
     *
     * @param param 学生信息
     */
    @PostMapping
    fun setStudent(@RequestBody param: StudentParam) {
        val checked = param.checked() ?: throw badRequest("Please provide a student object.")
        _service.writeStudent(checked)
    }

    @DeleteMapping(value = ["/{id}"])
    fun deleteStudent(@PathVariable(value = "id") studentId: Long?) {
        studentId ?: throw badRequest("Please provide student id in request path.")
        _service.deleteStudent(Student.Id(studentId))
    }
}