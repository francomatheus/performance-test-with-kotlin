package br.com.application.coroutine.repository

import br.com.application.coroutine.domain.UserEntity
import org.springframework.data.mongodb.repository.MongoRepository

interface ExampleRepository: MongoRepository<UserEntity, String> {

    fun findAllByCode(code: Long): List<UserEntity>
    fun countByCode(code: Long): Long
}
