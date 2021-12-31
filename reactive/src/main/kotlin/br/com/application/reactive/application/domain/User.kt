package br.com.application.reactive.application.domain

import org.springframework.data.mongodb.core.mapping.Document

@Document("user")
data class User(
        val code: Int,
        val name: String,
        val profissao: String,
        val data: UserData
){
    data class UserData(
        val salary: Long
    )
}