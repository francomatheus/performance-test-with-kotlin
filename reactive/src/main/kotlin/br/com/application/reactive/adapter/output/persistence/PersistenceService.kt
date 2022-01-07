package br.com.application.reactive.adapter.output.persistence

import br.com.application.reactive.adapter.output.persistence.model.CoreData
import br.com.application.reactive.adapter.output.persistence.model.CoreEntity
import br.com.application.reactive.adapter.output.persistence.model.CoreExampleAData
import br.com.application.reactive.adapter.output.persistence.model.CoreExampleBData
import br.com.application.reactive.adapter.output.persistence.repository.CoreRepository
import br.com.application.reactive.application.domain.CoreExampleADataDomain
import br.com.application.reactive.application.domain.CoreExampleBDataDomain
import br.com.application.reactive.application.domain.User
import br.com.application.reactive.application.domain.UserInterface
import br.com.application.reactive.application.port.output.CoreRepositoryPort
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux

@Service
class PersistenceService(
    val coreRepository: CoreRepository
): CoreRepositoryPort {

    private val logger = LoggerFactory.getLogger(javaClass)

    override fun retrieveUserFromCode(code: Long): Flux<CoreEntity> {

        val count = coreRepository.countByCode(code)
        val documents = coreRepository.findByCode(code)
        logger.info("class=PersistenceService, method=retrieveUserFromCode, code=${code}, numberElements=${count}")
        return count
            .map {
                logger.info("Numero de elementos: $it, thread=${Thread.currentThread().name}")
            }.flatMapMany {
                coreRepository.findByCode(code)
            }
//            .map {
//                deserializeDocumentData(it)
//            }
    }

    private fun deserializeDocumentData(coreEntity: CoreEntity): User {
        val coreData =  when(coreEntity.type){
            "ExampleA" -> converterExampleA(coreEntity.data.toString())
            "ExampleB" -> converterExampleB(coreEntity.data.toString())
            else -> RuntimeException("")
        }

        return User(
            id = coreEntity.id,
            code = coreEntity.code,
            type = coreEntity.type,
            name = coreEntity.name,
            profissao = coreEntity.profissao,
            data = coreData as UserInterface
        )

    }

    private fun converterExampleA(message: String): UserInterface {
        val readValue = ObjectMapper().registerModules(KotlinModule())
            .readValue(message, CoreExampleAData::class.java)

        return CoreExampleADataDomain(readValue.transaction)
    }

    private fun converterExampleB(message: String): UserInterface {
        val readValue = ObjectMapper().registerModules(KotlinModule())
            .readValue(message, CoreExampleBData::class.java)

        return CoreExampleBDataDomain(readValue.statement, readValue.other)
    }

}