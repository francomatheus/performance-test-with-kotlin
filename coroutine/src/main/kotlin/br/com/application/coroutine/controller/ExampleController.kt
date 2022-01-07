package br.com.application.coroutine.controller

import br.com.application.coroutine.domain.UserEntity
import br.com.application.coroutine.service.ExampleService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.time.Duration
import java.time.LocalDateTime

@RestController
@RequestMapping("/courotine")
class ExampleController(
    val exampleService: ExampleService
) {

    private val logger = LoggerFactory.getLogger(javaClass)

    @GetMapping("/v1/code/{codeId}")
    fun retrieveAllByCode(
        @PathVariable codeId: Long
    ): List<UserEntity> {

        val startRequest = LocalDateTime.now()
        logger.info("class=ExampleController, method=getAllByCode, startRequest=${startRequest}, threadName=${Thread.currentThread().name}")
        println("Inicio da requisição: $startRequest")
        return runBlocking {
            val endRequest = LocalDateTime.now()
            logger.info("class=ExampleController, method=getAllByCode, endRequest=${endRequest}, between=${Duration.between(startRequest, endRequest).seconds} threadName=${Thread.currentThread().name}")
            logger.info("threadName=${Thread.currentThread().name}")
            exampleService.retrieveDocumentsByCode(codeId)
        }
    }
}