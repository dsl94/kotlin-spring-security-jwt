package com.nemanja.demo.securitydemo.security

import com.nemanja.demo.securitydemo.security.filter.JWTAuthenticationFilter
import com.nemanja.demo.securitydemo.security.filter.JWTLoginFilter
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Configurable
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter

/**
 * Created by neman on 09/11/2017.
 */
@Configuration
@EnableWebSecurity
class WebSecurityConfig : WebSecurityConfigurerAdapter(){

	@Autowired
	private lateinit var userDetailsService: MyUserDetailsService

	override fun configure(http: HttpSecurity) {
		http.csrf().disable().authorizeRequests()
			.antMatchers("/api/register").permitAll()
			.antMatchers(HttpMethod.POST, "/api/login").permitAll()
			.anyRequest().authenticated()
			.and()
			// We filter the api/login requests
			.addFilterBefore(JWTLoginFilter("/api/login", authenticationManager()),
				UsernamePasswordAuthenticationFilter::class.java)
			// And filter other requests to check the presence of JWT in header
			.addFilterBefore(JWTAuthenticationFilter(),
				UsernamePasswordAuthenticationFilter::class.java)
	}

	override fun configure(auth: AuthenticationManagerBuilder) {
		val encoder = BCryptPasswordEncoder()
		auth.userDetailsService<MyUserDetailsService>(userDetailsService).passwordEncoder(encoder)
	}

}