package com.xuanke.api.controller

import com.fasterxml.jackson.annotation.JsonProperty
import com.xuanke.api.badRequest
import com.xuanke.api.entity.school.Department
import com.xuanke.api.service.DepartmentService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/department")
class DepartmentController(private val _departmentService: DepartmentService) {
    @GetMapping(path = ["/list"])
    fun getDepartmentList(
        @RequestParam(name = "page") page: Int?,
        @RequestParam(name = "limit") limit: Int?
    ): List<Department> {
        if (page != null && page <= 0) {
            throw badRequest("page must > 0.")
        }
        if (limit != null && limit <= 0) {
            throw badRequest("limit must > 0.")
        }
        return _departmentService.readDepartmentList(page?.toUInt() ?: 1u, limit?.toUInt() ?: 50u)
    }

    @GetMapping(path = ["/{id}"])
    fun getDepartment(@PathVariable(value = "id") departmentId: Int?): Department {
        departmentId ?: throw badRequest("Please provide Department id int request path.")
        return _departmentService.readDepartmentByDepartmentId(Department.Id(departmentId.toUInt()))
    }

    data class DepartmentParam(
        @JsonProperty("id")
        val id: Long?,
        @JsonProperty("name")
        val name: String?,
        @JsonProperty("manager")
        val manager : String?
    )

    private fun DepartmentParam?.checked(): Department? {
        this ?: return null
        return Department(
            Department.Id(id?.toUInt() ?: return null),
            name ?: return null,
            manager ?: return null,
        )
    }

    @PostMapping
    fun setupDepartment(@RequestBody param: DepartmentParam?) {
        val checked = param.checked() ?: throw badRequest("Please provide a legal Department object.")
        _departmentService.writeDepartment(checked)
    }

    @DeleteMapping("/{id}")
    fun deleteDepartment(@PathVariable(value = "id") departmentId: Long?) {
        departmentId ?: throw badRequest(
            "Please provide Department id in request path."
        )
        _departmentService.deleteDepartment(Department.Id(departmentId.toUInt()))
    }
}