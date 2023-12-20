package com.xuanke.api.dao

import org.apache.ibatis.annotations.Mapper

@Mapper
interface PermissionMapper {
    fun listPermissionsByUserId(userId: Int): List<Int>

    fun existPermissionByUserId(userId: Int, permissionId: Int): Int
}