package com.xuanke.api.service

import com.xuanke.api.XuankeException
import com.xuanke.api.entity.school.Department

/**
 * 院系信息管理接口
 */
interface DepartmentService {
    /**
     * 读取所有院系信息
     */
    fun readDepartmentList(page : UInt, limit : UInt): List<Department>

    /**
     * 根据给定院系 id 查找院系
     * @param departmentId 给定院系 id
     * @throws XuankeException 找不到对应院系时抛出异常
     */
    @Throws(XuankeException::class)
    fun readDepartmentByDepartmentId(departmentId: Department.Id): Department

    /**
     * 如果对应 id 的院系已经存在则更新院系信息，否则创建新的院系
     */
    fun writeDepartment(department: Department)

    /**
     * 删除对应 id 院系
     */
    fun deleteDepartment(departmentId: Department.Id)
}