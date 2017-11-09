package com.nemanja.demo.securitydemo.model

import javax.persistence.*

/**
 * Created by neman on 09/11/2017.
 */
@Entity
@Table(name = "users")
data class User(

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	var id: Long? = null,
    var username: String? = null,
	var fullName: String? = null,
    var password: String? = null,
    var email: String? = null
)
