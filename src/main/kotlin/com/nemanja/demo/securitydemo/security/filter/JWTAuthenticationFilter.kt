package com.nemanja.demo.securitydemo.security.filter

import com.nemanja.demo.securitydemo.security.TokenAuthenticationService
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.filter.GenericFilterBean
import javax.servlet.FilterChain
import javax.servlet.ServletRequest
import javax.servlet.ServletResponse
import javax.servlet.http.HttpServletRequest

/**
 * Created by neman on 09/11/2017.
 */
class JWTAuthenticationFilter : GenericFilterBean(){

	override fun doFilter(servletRequest: ServletRequest, servletResponse: ServletResponse, filterChain: FilterChain) {

		val authentication = TokenAuthenticationService.getAuthentication(servletRequest as HttpServletRequest)

		SecurityContextHolder.getContext().authentication = authentication
		filterChain.doFilter(servletRequest, servletResponse)
	}

}