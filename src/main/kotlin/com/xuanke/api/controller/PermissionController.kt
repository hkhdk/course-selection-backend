package com.xuanke.api.controller

import com.xuanke.api.service.PermissionService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/permission")
class PermissionController(@Autowired private val _permissionServices: PermissionService) {
    /** 读取当前用户拥有的权限 */
    @GetMapping(path = ["/list"])
    fun getUserPermissions(): Map<String, List<Int>> {
        return _permissionServices.readUserPermissions()
    }
}