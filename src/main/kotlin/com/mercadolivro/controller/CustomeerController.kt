package com.mercadolivro.controller

import  com.mercadolivro.controller.request.PostCustomeer
import com.mercadolivro.controller.request.PutCustomeer
import com.mercadolivro.model.CustomeerModel
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.HttpStatusCodeException

@RestController
@RequestMapping("/customeers")
class CustomeerController {

    val customeers = mutableListOf<CustomeerModel>()
    @GetMapping
    fun getAll(@RequestParam query: String?): List<CustomeerModel> {
        query?.let {
            return customeers.filter {
                it.name.contains(query, true)
            }
        }
        return customeers
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody customeer: PostCustomeer) {
        val id = customeers.size + 1
        customeers.add(CustomeerModel(id, customeer.name, customeer.email))
        println("usuario criado, id :" + id)
    }

    @GetMapping("/{id}")
    fun getCustomeer(@PathVariable id: Int): CustomeerModel {
            return customeers.filter { it.id == id }.first()
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun updateCustomeer(@PathVariable id: Int, @RequestBody customeer: PutCustomeer) {
        customeers.filter { it.id == id }.first().let {
            it.name = customeer.name
            it.email = customeer.email
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.GONE)
    fun deleteCustomeer(@PathVariable id: Int) {
        customeers.removeIf {
            it.id == id
        }
    }

}