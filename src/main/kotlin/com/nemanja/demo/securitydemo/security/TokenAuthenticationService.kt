package com.nemanja.demo.securitydemo.security

import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import java.util.*
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/**
 * Created by neman on 09/11/2017.
 */
object TokenAuthenticationService {

	internal val EXPIRATION_TIME = 1800000L
	internal val SECRET = "ThisIsSecret"
	internal val TOKEN_PREFIX = "Bearer"
	internal val HEADER_STRING = "Authorization"

	fun addAuthentication(response: HttpServletResponse, username: String) {
		val JWT = Jwts.builder()
			.setSubject(username)
			.setExpiration(Date(System.currentTimeMillis() + EXPIRATION_TIME))
			.signWith(SignatureAlgorithm.HS512, SECRET)
			.compact()

		response.addHeader(HEADER_STRING, TOKEN_PREFIX + " " + JWT)
	}

	fun getAuthentication(request: HttpServletRequest) : Authentication? {
		val token = request.getHeader(HEADER_STRING)
		if (token != null) {
			val user = Jwts.parser()
				.setSigningKey(SECRET)
				.parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
				.body
				.subject

			if (user != null) {
				return UsernamePasswordAuthenticationToken(user, null, emptyList())
			} else {
				return null
			}
		}

		return null
	}
}