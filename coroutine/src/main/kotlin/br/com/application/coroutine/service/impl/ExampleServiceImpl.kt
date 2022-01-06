package br.com.application.coroutine.service.impl

import br.com.application.coroutine.domain.UserEntity
import br.com.application.coroutine.repository.ExampleRepository
import br.com.application.coroutine.service.ExampleService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class ExampleServiceImpl(
    val exampleRepository: ExampleRepository
): ExampleService {

    private val logger = LoggerFactory.getLogger(javaClass)
    
    override suspend fun retrieveDocumentsByCode(codeId: Long): List<UserEntity> {
        val coroutineScope = CoroutineScope(Dispatchers.Default)
        logger.info("class=ExampleServiceImpl, method=retrieveDocumentByCode, threadName=${Thread.currentThread().name}")
        coroutineScope.launch {

            val countByCode = exampleRepository.countByCode(codeId)

            logger.info("Numero de elementos=${countByCode}")

            exampleRepository.findAllByCode(codeId)
        }
    }
}
