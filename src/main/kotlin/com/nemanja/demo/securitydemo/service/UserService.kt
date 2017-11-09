package com.nemanja.demo.securitydemo.service

import com.nemanja.demo.securitydemo.rest.dto.RegisterUserRequestDTO
import com.nemanja.demo.securitydemo.rest.dto.RegisterUserResponseDTO

/**
 * Created by neman on 09/11/2017.
 */
interface UserService {

	fun register(request: RegisterUserRequestDTO) : RegisterUserResponseDTO
}