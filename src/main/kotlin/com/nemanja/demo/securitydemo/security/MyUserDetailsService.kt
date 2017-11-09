package com.nemanja.demo.securitydemo.security

import com.nemanja.demo.securitydemo.model.User
import com.nemanja.demo.securitydemo.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

/**
 * Created by neman on 09/11/2017.
 */
@Service
class MyUserDetailsService : UserDetailsService {

	@Autowired
	private lateinit var userRepository: UserRepository

	@Throws(UsernameNotFoundException::class)
	override fun loadUserByUsername(username: String): UserDetails {
		val user = userRepository.findByUsernameIgnoreCase(username) ?: UsernameNotFoundException(username)

		return MyUserPrinciple(user as User)
	}
}