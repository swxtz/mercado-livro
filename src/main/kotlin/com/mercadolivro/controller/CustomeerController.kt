package com.mercadolivro.controller

import com.mercadolivro.model.CustomeerModel
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/customeers")
class CustomeerController {
    @GetMapping
    fun helloWorld(): CustomeerModel {
        return CustomeerModel("1", "Gustavo", "email@email.com")
    }

    @PostMapping
    fun create(@RequestBody customeer: CustomeerModel): CustomeerModel {
        return customeer
    }

}