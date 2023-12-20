package com.xuanke.api.service.impl

import com.xuanke.api.dao.PermissionMapper
import com.xuanke.api.entity.Permission
import com.xuanke.api.service.PermissionService
import com.xuanke.api.unauthorized
import com.xuanke.api.util.RequestVariableStore
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PermissionServiceImpl(@Autowired private val _permissionMapper: PermissionMapper) : PermissionService {
    private val _userId get() = RequestVariableStore.getUserIdOrThrow {
        unauthorized("Please authorize before call this.")
    }
    override fun readUserPermissions(): Map<String, List<Int>> {
        return mapOf("permissions" to _permissionMapper.listPermissionsByUserId(_userId.value))
    }

    override fun hasPermission(permission: Permission): Boolean {
        return _permissionMapper.existPermissionByUserId(_userId.value, permission.id.value) != 0
    }
}