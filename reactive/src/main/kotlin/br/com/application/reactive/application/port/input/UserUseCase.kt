package br.com.application.reactive.application.port.input

import br.com.application.reactive.adapter.output.persistence.model.CoreEntity
import reactor.core.publisher.Flux

interface UserUseCase {

    fun findAllUserByCode(codeId: Long): Flux<CoreEntity>
}
