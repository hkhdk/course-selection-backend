package com.xuanke.api.dao

import org.apache.ibatis.annotations.Mapper

@Mapper
interface UserGroupMapper {
    fun selectUserGroupIdByUserId(userId: Int)

    fun replaceUserGroup(userId: Int, userGroupId: Int?)
}