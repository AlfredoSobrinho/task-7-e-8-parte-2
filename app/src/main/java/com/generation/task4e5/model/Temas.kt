package com.generation.task4e5.model

class Temas(

    val id: Long,
    var descricao: String?,
    var post: List<Post?>?

) {
    override fun toString(): String {
        return descricao!!
    }

}