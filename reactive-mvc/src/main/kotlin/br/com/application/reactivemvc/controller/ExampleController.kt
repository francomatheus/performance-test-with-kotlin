package br.com.application.reactivemvc.controller

import br.com.application.reactivemvc.domain.UserEntity
import br.com.application.reactivemvc.service.ExampleService
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import java.time.LocalDateTime
import java.time.ZoneOffset

@RestController
@RequestMapping("/reactive-mvc")
class ExampleController(
    val exampleService: ExampleService
) {

    private val logger = LoggerFactory.getLogger(javaClass)

    @GetMapping("/v1/code/{codeId}")
    fun retrieveAllByCode(
        @PathVariable codeId: Long
    ): Flux<UserEntity> {
        val startRequest = LocalDateTime.now()
        logger.info("class=ExampleController, method=getAllByCode, startRequest=${startRequest}, threadName=${Thread.currentThread().name}")

        return exampleService.retrieveDocumentsByCode(codeId)
            .doOnComplete {
                logger.info("class=ExampleController, method=getAllByCode, endRequest=${LocalDateTime.now()}, between=${LocalDateTime.now().second.minus(startRequest.second)}, diff=${LocalDateTime.now().toInstant(ZoneOffset.UTC).epochSecond.minus(startRequest.toInstant(ZoneOffset.UTC).epochSecond)} threadName=${Thread.currentThread().name}")
            }
    }
}