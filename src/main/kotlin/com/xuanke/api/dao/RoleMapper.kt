package com.xuanke.api.dao

import org.apache.ibatis.annotations.Mapper

@Mapper
interface RoleMapper {
    /** 查询角色权限列表 */
    fun listRolePermissionsByRoleId(roleId: Int): List<Int>

    /** 更新角色权限列表 */
    fun updatePermissionsByRoleId(roleId: Int, permissionIds: List<Int>): Int
}