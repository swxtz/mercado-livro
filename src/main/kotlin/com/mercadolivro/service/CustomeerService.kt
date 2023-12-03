package com.mercadolivro.service

import com.mercadolivro.model.CustomeerModel
import org.springframework.stereotype.Service

@Service
class CustomeerService {
    val customeers = mutableListOf<CustomeerModel>()

    fun getAll(query: String?): List<CustomeerModel> {
        query?.let {
            return customeers.filter {
                it.name.contains(query, true)
            }
        }
        return customeers
    }

    fun create(customeer: CustomeerModel) {
        val id = customeers.size + 1
        customeers.add(customeer)
        println("usuario criado, id :" + id)
    }

    fun getCustomeer(id: Int): CustomeerModel {
        return customeers.filter { it.id == id }.first()
    }

    fun updateCustomeer(customeer: CustomeerModel) {
        customeers.filter { it.id == customeer.id }.first().let {
            it.name = customeer.name
            it.email = customeer.email
        }
    }

    fun deleteCustomeer(id: Int) {
        customeers.removeIf {
            it.id == id
        }
    }

}