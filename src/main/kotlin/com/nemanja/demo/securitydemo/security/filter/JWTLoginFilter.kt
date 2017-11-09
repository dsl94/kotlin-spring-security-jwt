package com.nemanja.demo.securitydemo.security.filter

import com.fasterxml.jackson.databind.ObjectMapper
import com.nemanja.demo.securitydemo.security.AccountCredentials
import com.nemanja.demo.securitydemo.security.TokenAuthenticationService
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter
import org.springframework.security.web.util.matcher.AntPathRequestMatcher
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/**
 * Created by neman on 09/11/2017.
 */
class JWTLoginFilter(url: String, authManager: AuthenticationManager) : AbstractAuthenticationProcessingFilter(AntPathRequestMatcher(url)) {

	init {
		authenticationManager = authManager
	}

	override fun attemptAuthentication(request: HttpServletRequest, response: HttpServletResponse): Authentication {

		val credentials = ObjectMapper().readValue(request.inputStream, AccountCredentials::class.java)

		return authenticationManager.authenticate(UsernamePasswordAuthenticationToken(credentials.username, credentials.password, emptyList()))
	}

	override fun successfulAuthentication(request: HttpServletRequest, response: HttpServletResponse, chain: FilterChain?, auth: Authentication) {

		TokenAuthenticationService.addAuthentication(response, auth.name)
	}

}