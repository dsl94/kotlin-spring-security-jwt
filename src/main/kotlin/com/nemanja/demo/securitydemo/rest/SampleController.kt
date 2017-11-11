package com.nemanja.demo.securitydemo.rest

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class SampleController {

    @GetMapping("/secured")
    fun secured() : ResponseEntity<Any> {
        return ResponseEntity.ok("You are accessing secured page")
    }
}