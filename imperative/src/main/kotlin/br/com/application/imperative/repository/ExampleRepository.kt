package br.com.application.imperative.repository

import br.com.application.imperative.domain.UserEntity
import org.springframework.data.mongodb.repository.MongoRepository
import java.util.*

interface ExampleRepository: MongoRepository<UserEntity, String> {

    fun findAllByCode(code: Long): List<UserEntity>
    fun countByCode(code: Long): Long
}
