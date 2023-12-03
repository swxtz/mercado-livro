package com.mercadolivro.service

import com.mercadolivro.model.CustomerModel
import org.springframework.stereotype.Service

@Service
class CustomerService {
    val customers = mutableListOf<CustomerModel>()

    fun getAll(query: String?): List<CustomerModel> {
        query?.let {
            return customers.filter {
                it.name.contains(query, true)
            }
        }
        return customers
    }

    fun create(customeer: CustomerModel) {
        val id = customers.size + 1
        customers.add(customeer)
        println("usuario criado, id :" + id)
    }

    fun getCustomer(id: Int): CustomerModel {
        return customers.filter { it.id == id }.first()
    }

    fun updateCustomer(customeer: CustomerModel) {
        customers.filter { it.id == customeer.id }.first().let {
            it.name = customeer.name
            it.email = customeer.email
        }
    }

    fun deleteCustomer(id: Int) {
        customers.removeIf {
            it.id == id
        }
    }

}