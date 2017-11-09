package com.nemanja.demo.securitydemo.rest.dto

/**
 * Created by neman on 09/11/2017.
 */
class RegisterUserResponseDTO{

	var id: Long
	var username: String
	var fullName: String
	var email : String

	constructor(id: Long, username: String, fullName: String, email: String) {
		this.id = id
		this.username = username
		this.fullName = fullName
		this.email = email
	}
}