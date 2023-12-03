package com.mercadolivro.controller

import com.mercadolivro.controller.request.PostCustomer
import com.mercadolivro.controller.request.PutCustomer
import com.mercadolivro.extension.toCustomerModel
import com.mercadolivro.model.CustomerModel
import com.mercadolivro.service.CustomerService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/customeers")
class CustomerController(
    val customerService: CustomerService
) {


    @GetMapping
    fun getAll(@RequestParam query: String?): List<CustomerModel> {
        return customerService.getAll(query)
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody customeer: PostCustomer) {
        customerService.create(customeer.toCustomerModel())
    }

    @GetMapping("/{id}")
    fun getCustomeer(@PathVariable id: Int): CustomerModel {
        return customerService.getCustomer(id)
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun updateCustomer(@PathVariable id: Int, @RequestBody customeer: PutCustomer) {
        customerService.updateCustomer(customeer.toCustomerModel(id))
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.GONE)
    fun deleteCustomeer(@PathVariable id: Int) {
        customerService.deleteCustomer(id)
    }

}