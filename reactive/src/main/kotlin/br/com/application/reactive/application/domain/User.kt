package br.com.application.reactive.application.domain

data class User(
    val id: String,
    val code: Long,
    val name: String,
    val profissao: String,
    val type: String,
    val data: UserInterface
)