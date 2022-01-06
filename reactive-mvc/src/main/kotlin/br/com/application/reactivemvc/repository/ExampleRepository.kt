package br.com.application.reactivemvc.repository

import br.com.application.reactivemvc.domain.UserEntity
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface ExampleRepository: ReactiveMongoRepository<UserEntity, String> {

    fun findAllByCode(code: Long): Flux<UserEntity>
    fun countByCode(code: Long): Mono<Long>
}
