package com.nemanja.demo.securitydemo.rest.dto

import org.jetbrains.annotations.NotNull

/**
 * Created by neman on 09/11/2017.
 */
class RegisterUserRequestDTO {

	@NotNull
	var username: String = ""
	@NotNull
	var fullName: String = ""
	@NotNull
	var password: String = ""
	@NotNull
	var email: String = ""

	constructor(username: String, fullName: String, password: String, email: String) {
		this.username = username
		this.fullName = fullName
		this.password = password
		this.email = email
	}

	constructor() {}
}