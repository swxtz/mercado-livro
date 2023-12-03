package com.mercadolivro.extension

import com.mercadolivro.controller.request.PostCustomer
import com.mercadolivro.controller.request.PutCustomer
import com.mercadolivro.model.CustomerModel

fun PostCustomer.toCustomerModel(): CustomerModel {
    return CustomerModel(name = this.name, email = this.email)
}

fun PutCustomer.toCustomerModel(id: Int): CustomerModel {
    return CustomerModel(id = id,name = this.name, email = this.email)
}