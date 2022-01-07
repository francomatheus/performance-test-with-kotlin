package br.com.application.imperative.service.impl

import br.com.application.imperative.domain.UserEntity
import br.com.application.imperative.repository.ExampleRepository
import br.com.application.imperative.service.ExampleService
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class ExampleServiceImpl(
    val exampleRepository: ExampleRepository
): ExampleService {

    private val logger = LoggerFactory.getLogger(javaClass)
    
    override fun retrieveDocumentsByCode(codeId: Long): List<UserEntity> {
        logger.info("class=ExampleServiceImpl, method=retrieveDocumentByCode, thread=${Thread.currentThread().name}")

        val countByCode = exampleRepository.countByCode(codeId)

        logger.info("Numero de elementos=${countByCode}")

        return exampleRepository.findAllByCode(codeId)
    }
}
