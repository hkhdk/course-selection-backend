package com.xuanke.api.service.impl

import com.xuanke.api.dao.DepartmentMapper
import com.xuanke.api.entity.school.Department
import com.xuanke.api.notFound
import com.xuanke.api.service.DepartmentService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class DepartmentServiceImpl (
    @Autowired private val _mapper: DepartmentMapper,
) : DepartmentService{

    override fun readDepartmentList(page : UInt, limit : UInt): List<Department> {
        return _mapper.listDepartments(((page - 1u) * limit).toInt(), limit.toInt())
    }

    override fun readDepartmentByDepartmentId(departmentId: Department.Id): Department {
        return _mapper.selectDepartmentByDepartmentId(departmentId.value.toInt()) ?: throw notFound("The Department not exists.")
    }

    override fun writeDepartment(department: Department) {
        _mapper.replaceDepartmentByDepartmentId(department)
    }

    override fun deleteDepartment(departmentId: Department.Id) {
        _mapper.deleteDepartmentByDepartmentId(departmentId.value.toInt())
    }
}