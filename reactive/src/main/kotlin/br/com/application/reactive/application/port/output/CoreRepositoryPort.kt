package br.com.application.reactive.application.port.output

import br.com.application.reactive.adapter.output.persistence.model.CoreEntity
import br.com.application.reactive.application.domain.User
import reactor.core.publisher.Flux

interface CoreRepositoryPort {

    fun retrieveUserFromCode(code: Long): Flux<CoreEntity>
}