package com.generation.task4e5.model

import java.text.SimpleDateFormat
import java.util.*

data class Post(

    val id: Long,
    val titulo: String,
    val descricao: String,
    val imagem: String,
    val dataHora: String,
    val autor: String,
    val tema: Temas
)

