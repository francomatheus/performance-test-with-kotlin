package br.com.application.reactive.adapter.output.persistence.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document("user")
data class CoreEntity(
    @Id
    val id: String,
    val code: Long,
    val name: String,
    val profissao: String,
    val type: String,
    val data: Any
)