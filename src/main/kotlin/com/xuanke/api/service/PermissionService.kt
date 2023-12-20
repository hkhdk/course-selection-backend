package com.xuanke.api.service

import com.xuanke.api.entity.Permission

/**
 * 权限管理接口，无法直接添加权限，需要通过修改用户组或角色来完成
 */
interface PermissionService {
    /**
     * 读取用户拥有的权限列表
     */
    fun readUserPermissions(): Map<String, List<Int>>

    /**
     * 判断用户是否有指定权限
     */
    fun hasPermission(permission: Permission): Boolean
}