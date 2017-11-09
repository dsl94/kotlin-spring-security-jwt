package com.nemanja.demo.securitydemo.security

import com.nemanja.demo.securitydemo.model.User
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import java.util.*

/**
 * Created by neman on 09/11/2017.
 */
class MyUserPrinciple(private val user: User): UserDetails {

	override fun getAuthorities(): MutableCollection<out GrantedAuthority>  = Collections.emptyList()

	override fun isEnabled(): Boolean = true

	override fun getUsername(): String? = user.username

	override fun isCredentialsNonExpired(): Boolean = true

	override fun getPassword(): String? = user.password

	override fun isAccountNonExpired(): Boolean = true

	override fun isAccountNonLocked(): Boolean = true
}