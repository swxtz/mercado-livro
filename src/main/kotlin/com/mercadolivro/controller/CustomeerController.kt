package com.mercadolivro.controller

import com.mercadolivro.controller.request.PostCustomeer
import com.mercadolivro.model.CustomeerModel
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.HttpStatusCodeException

@RestController
@RequestMapping("/customeers")
class CustomeerController {

    val customeers = mutableListOf<CustomeerModel>()
    @GetMapping
    fun getAll(): MutableList<CustomeerModel> {
        return customeers
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody customeer: PostCustomeer) {
        customeers.add(CustomeerModel(customeers.size + 1, customeer.name, customeer.email))
    }

    @GetMapping("/{id}")
    fun getCustomeer(@PathVariable id: Int): CustomeerModel {
            return customeers.filter { it.id == id }.first()
    }

}