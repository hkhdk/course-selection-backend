package com.xuanke.api.service.impl

import com.xuanke.api.badRequest
import com.xuanke.api.conflict
import com.xuanke.api.dao.UserMapper
import com.xuanke.api.entity.NewUser
import com.xuanke.api.entity.User
import com.xuanke.api.entity.UserWithPermissions
import com.xuanke.api.service.PermissionService
import com.xuanke.api.service.UserService
import com.xuanke.api.unauthorized
import com.xuanke.api.util.RequestVariableStore
import com.xuanke.api.util.JwtHelper
import com.xuanke.api.util.LoginNameChecker
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.util.DigestUtils
import java.nio.charset.StandardCharsets
import java.util.*

@Service
class UserServiceImpl(
    @Autowired private val _userMapper: UserMapper,
    @Autowired private val _permissionService: PermissionService,
) : UserService {
    private fun createTokenMap(userId: User.Id) = mapOf("token" to JwtHelper.createToken(userId))

    private fun generatePasswordSign(loginName: String, password: String): String {
        return (password + loginName)
            .byteInputStream(StandardCharsets.UTF_8)
            .let(DigestUtils::md5Digest)
            .let(Arrays::toString)
    }

    override fun login(loginName: String, password: String): Map<String, String> {
        if (!LoginNameChecker.checkLength(loginName) || !LoginNameChecker.checkContent(loginName)) {
            throw badRequest("User not exists.")
        }
        val passwordSign = generatePasswordSign(loginName, password)
        val userId = _userMapper.selectUserIdByLoginNameAndPasswordSign(loginName, passwordSign)
            ?: throw unauthorized("Incorrect login name or password.")
        return createTokenMap(User.Id(userId))
    }

    override fun register(loginName: String, password: String): Map<String, String> {
        if (!LoginNameChecker.checkLength(loginName)) {
            throw badRequest(LoginNameChecker.MESSAGE_LENGTH)
        }
        if (!LoginNameChecker.checkContent(loginName)) {
            throw badRequest(LoginNameChecker.MESSAGE_CONTENT)
        }
        val user = NewUser(
            loginName = User.LoginName(loginName),
            passwordSign = generatePasswordSign(loginName, password),
            createTime = Date(),
        )
        _userMapper.insertUser(user).takeUnless { it == 0 } ?: throw conflict("The user login name is exists.")
        return createTokenMap(User.Id(user.id!!))
    }

    private inline val _userId
        get() = RequestVariableStore.getUserIdOrThrow {
            throw badRequest("Please provide 'token' in header.")
        }

    override fun readUserInfo(): UserWithPermissions {
        return UserWithPermissions(
            user = _userMapper.selectUserByUserId(_userId.value) ?: throw badRequest("Unknown user."),
            permissions = _permissionService.readUserPermissions()["permissions"]!!,
        )
    }

    override fun listUsers(page: UInt, limit: UInt): List<User> {
        return _userMapper.listUsers(((page - 1u) * limit).toInt(), limit.toInt())
    }
}