package com.nemanja.demo.securitydemo.rest

import com.nemanja.demo.securitydemo.error.ErrorMessage
import com.nemanja.demo.securitydemo.error.UserException
import com.nemanja.demo.securitydemo.rest.dto.RegisterUserRequestDTO
import com.nemanja.demo.securitydemo.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

/**
 * Created by neman on 09/11/2017.
 */
@RestController
@RequestMapping("/api")
class UserController {

	@Autowired
	private lateinit var service: UserService

	@RequestMapping(value = "/register", method = arrayOf(RequestMethod.POST), produces = arrayOf(MediaType.APPLICATION_JSON_VALUE))
	fun register(@Valid @RequestBody userRequestDTO: RegisterUserRequestDTO): ResponseEntity<Any> {
		try {
			return ResponseEntity.ok(service.register(userRequestDTO))
		} catch (e: UserException) {
			return ResponseEntity.badRequest().body(ErrorMessage(e.errorCode, e.errorMessage))
		}

	}
}