package br.com.application.reactive.application.service

import br.com.application.reactive.adapter.output.persistence.model.CoreEntity
import br.com.application.reactive.application.domain.User
import br.com.application.reactive.application.port.input.UserUseCase
import br.com.application.reactive.application.port.output.CoreRepositoryPort
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux

@Service
class CoreService(
    val repositoryPort: CoreRepositoryPort
) : UserUseCase {

    private val logger = LoggerFactory.getLogger(javaClass)

    override fun findAllUserByCode(codeId: Long): Flux<CoreEntity> {

        logger.info("class=CoreService, method=findAllUserByCode, threadName=${Thread.currentThread().name}")

        return repositoryPort.retrieveUserFromCode(codeId)
    }


}