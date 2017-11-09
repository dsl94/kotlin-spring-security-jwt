package com.nemanja.demo.securitydemo.repository

import com.nemanja.demo.securitydemo.model.User
import org.springframework.data.jpa.repository.JpaRepository

/**
 * Created by neman on 09/11/2017.
 */
interface UserRepository : JpaRepository<User, Long> {

	fun findByUsernameIgnoreCase(username: String): User?
	fun findByEmailIgnoreCase(email: String): User?
}