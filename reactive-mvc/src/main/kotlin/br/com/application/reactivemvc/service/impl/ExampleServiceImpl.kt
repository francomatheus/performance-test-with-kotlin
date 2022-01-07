package br.com.application.reactivemvc.service.impl

import br.com.application.reactivemvc.domain.UserEntity
import br.com.application.reactivemvc.repository.ExampleRepository
import br.com.application.reactivemvc.service.ExampleService
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux

@Service
class ExampleServiceImpl(
    val exampleRepository: ExampleRepository
) : ExampleService {

    private val logger = LoggerFactory.getLogger(javaClass)

    override fun retrieveDocumentsByCode(codeId: Long): Flux<UserEntity> {
        logger.info("class=ExampleServiceImpl, method=retrieveDocumentByCode")

        return exampleRepository.countByCode(codeId)
            .map {
                logger.info("Numero de elementos=${it}")
            }
            .flatMapMany {
                exampleRepository.findAllByCode(codeId)
            }
    }
}
