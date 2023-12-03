package com.mercadolivro.extension

import com.mercadolivro.controller.request.PostCustomeer
import com.mercadolivro.controller.request.PutCustomeer
import com.mercadolivro.model.CustomeerModel

fun PostCustomeer.toCustomeerModel(): CustomeerModel {
    return CustomeerModel(name = this.name, email = this.email)
}

fun PutCustomeer.toCustomeerModel(id: Int): CustomeerModel {
    return CustomeerModel(id = id,name = this.name, email = this.email)
}