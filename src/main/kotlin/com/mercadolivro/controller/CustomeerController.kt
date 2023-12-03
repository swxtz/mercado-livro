package com.mercadolivro.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/customeers")
class CustomeerController {
    @GetMapping
    fun helloWorld(): String {
        return "Hello world";
    }

}