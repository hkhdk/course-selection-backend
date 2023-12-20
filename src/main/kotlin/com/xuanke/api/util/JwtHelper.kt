package com.xuanke.api.util

import com.xuanke.api.entity.User
import io.jsonwebtoken.CompressionCodecs
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.security.Keys
import java.util.*

object JwtHelper {
    private const val USER_ID_KEY = "userId"
    private const val TOKEN_EXPIRATION_MILLIS = 90L * 24 * 60 * 60 * 1000

    private val signKey = Keys.hmacShaKeyFor("e4037d85368547b296a2c4af65d649257a208ed87ca74253acc3cc9246c8cea0cd376be403264a20988b0baaee4df8a4".toByteArray())

    fun createToken(userId: User.Id): String {
        return Jwts.builder()
            .setSubject("xuankeUser")
            .setExpiration(Date(System.currentTimeMillis() + TOKEN_EXPIRATION_MILLIS))
            .claim(USER_ID_KEY, userId.value)
            .signWith(signKey)
            .compressWith(CompressionCodecs.GZIP)
            .compact()
    }

    fun getUserId(token: String): User.Id? {
        if (token.isEmpty()) {
            return null
        }

        return try {
            val id = Jwts.parserBuilder()
                .setSigningKey(signKey)
                .build()
                .parseClaimsJws(token)
                .body[USER_ID_KEY] as? Int
            id?.let(User::Id)
        } catch (e: Exception) {
            null
        }
    }
}