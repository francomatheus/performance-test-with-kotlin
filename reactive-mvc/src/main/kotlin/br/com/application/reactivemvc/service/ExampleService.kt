package br.com.application.reactivemvc.service

import br.com.application.reactivemvc.domain.UserEntity
import reactor.core.publisher.Flux

interface ExampleService {

    fun retrieveDocumentsByCode(codeId: Long): Flux<UserEntity>
}
