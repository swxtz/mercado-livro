package com.mercadolivro.service

import com.mercadolivro.model.CustomerModel
import com.mercadolivro.repository.CustomerRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class CustomerService (
    val customerRepository: CustomerRepository
) {
    val customers = mutableListOf<CustomerModel>()

    fun getAll(query: String?): List<CustomerModel> {
        query?.let {
            return customerRepository.findByName(query)
        }
        return customerRepository.findAll().toList()
    }

    fun create(customer: CustomerModel) {
        customerRepository.save(customer)
    }

    fun getCustomer(id: Int): Optional<CustomerModel> {
        return customerRepository.findById(id)
    }

    fun updateCustomer(customer: CustomerModel) {
        if(!customerRepository.existsById(customer.id!!)) {
            throw Exception()
        }

        customerRepository.save(customer)
    }

    fun deleteCustomer(id: Int) {
        customerRepository.deleteById(id)
    }

}