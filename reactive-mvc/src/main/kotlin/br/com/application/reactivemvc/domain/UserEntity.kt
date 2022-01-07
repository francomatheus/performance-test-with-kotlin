package br.com.application.reactivemvc.domain

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document("user")
data class UserEntity(
    @Id
    val id: String,
    val code: Long,
    val name: String,
    val profissao: String,
    val type: String,
    val data: Any
)
