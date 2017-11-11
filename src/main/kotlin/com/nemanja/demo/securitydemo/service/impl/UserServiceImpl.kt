package com.nemanja.demo.securitydemo.service.impl

import com.nemanja.demo.securitydemo.error.ErrorCode
import com.nemanja.demo.securitydemo.error.UserException
import com.nemanja.demo.securitydemo.model.User
import com.nemanja.demo.securitydemo.repository.UserRepository
import com.nemanja.demo.securitydemo.rest.dto.RegisterUserRequestDTO
import com.nemanja.demo.securitydemo.rest.dto.RegisterUserResponseDTO
import com.nemanja.demo.securitydemo.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service

/**
 * Created by neman on 09/11/2017.
 */
@Service
class UserServiceImpl : UserService {

    @Autowired
    private lateinit var userRepo: UserRepository

    override fun register(request: RegisterUserRequestDTO): RegisterUserResponseDTO {

        val encoder = BCryptPasswordEncoder()

        val forSave = User()
        forSave.username = request.username
        forSave.email = request.email
        forSave.password = encoder.encode(request.password)
        forSave.fullName = request.fullName


        if (userRepo.findByEmailIgnoreCase(forSave.email!!) != null) {
            throw UserException(ErrorCode.EMAIL_EXIST, "Email exist")
        }

        if (userRepo.findByUsernameIgnoreCase(forSave.username!!) != null) {
            throw UserException(ErrorCode.USERNAME_EXIST, "Username exist")
        }

        val result = userRepo.save(forSave)

        return RegisterUserResponseDTO(result.id!!, result.username!!, result.fullName!!, result.email!!)
    }
}