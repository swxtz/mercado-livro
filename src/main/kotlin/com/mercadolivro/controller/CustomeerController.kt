package com.mercadolivro.controller

import com.mercadolivro.controller.request.PostCustomeer
import com.mercadolivro.controller.request.PutCustomeer
import com.mercadolivro.extension.toCustomeerModel
import com.mercadolivro.model.CustomeerModel
import com.mercadolivro.service.CustomeerService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/customeers")
class CustomeerController(
    val customeerService: CustomeerService
) {


    @GetMapping
    fun getAll(@RequestParam query: String?): List<CustomeerModel> {
        return customeerService.getAll(query)
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody customeer: PostCustomeer) {
        customeerService.create(customeer.toCustomeerModel())
    }

    @GetMapping("/{id}")
    fun getCustomeer(@PathVariable id: Int): CustomeerModel {
        return customeerService.getCustomeer(id)
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun updateCustomeer(@PathVariable id: Int, @RequestBody customeer: PutCustomeer) {
        customeerService.updateCustomeer(customeer.toCustomeerModel(id))
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.GONE)
    fun deleteCustomeer(@PathVariable id: Int) {
        customeerService.deleteCustomeer(id)
    }

}