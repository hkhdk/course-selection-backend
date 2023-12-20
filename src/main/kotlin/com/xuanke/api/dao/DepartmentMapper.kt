package com.xuanke.api.dao

import com.xuanke.api.entity.school.Department
import org.apache.ibatis.annotations.Mapper

@Mapper
interface DepartmentMapper {
    fun listDepartments(offset: Int, limit: Int): List<Department>

    fun selectDepartmentByDepartmentId(departmentId: Int): Department?

    fun replaceDepartmentByDepartmentId(department: Department)

    fun deleteDepartmentByDepartmentId(departmentId: Int): Int
}