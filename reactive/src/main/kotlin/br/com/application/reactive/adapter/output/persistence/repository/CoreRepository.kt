package br.com.application.reactive.adapter.output.persistence.repository

import br.com.application.reactive.adapter.output.persistence.model.CoreEntity
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface CoreRepository: ReactiveMongoRepository<CoreEntity, String> {

    fun findByCode(code: Long): Flux<CoreEntity>
    fun countByCode(code: Long): Mono<Long>
}