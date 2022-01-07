package br.com.application.reactive.adapter.input.web.controller

import br.com.application.reactive.adapter.output.persistence.model.CoreEntity
import br.com.application.reactive.application.domain.User
import br.com.application.reactive.application.port.input.UserUseCase
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import java.time.Duration
import java.time.LocalDateTime
import java.time.ZoneOffset

@RequestMapping("/reactive")
@RestController
class ExampleController(
        private val userUseCase: UserUseCase
) {

    private val logger = LoggerFactory.getLogger(javaClass)

    @GetMapping("/v1/code/{codeId}")
    fun getAllByCode(
            @PathVariable codeId:Long
    ): Flux<CoreEntity> {
        val startRequest = LocalDateTime.now()
        logger.info("class=ExampleController, method=getAllByCode, startRequest=${startRequest}, threadName=${Thread.currentThread().name}")
        println("Inicio da requisição: ${startRequest}")

        return userUseCase.findAllUserByCode(codeId)
            .doOnComplete {
                logger.info("class=ExampleController, method=getAllByCode, endRequest=${LocalDateTime.now()}, between=${LocalDateTime.now().second.minus(startRequest.second)}, diff=${LocalDateTime.now().toInstant(ZoneOffset.UTC).epochSecond.minus(startRequest.toInstant(ZoneOffset.UTC).epochSecond)} threadName=${Thread.currentThread().name}")
            }
    }

}