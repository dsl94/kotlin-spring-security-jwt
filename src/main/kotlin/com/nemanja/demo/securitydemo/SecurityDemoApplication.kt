package com.nemanja.demo.securitydemo

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class SecurityDemoApplication

fun main(args: Array<String>) {
    SpringApplication.run(SecurityDemoApplication::class.java, *args)
}


