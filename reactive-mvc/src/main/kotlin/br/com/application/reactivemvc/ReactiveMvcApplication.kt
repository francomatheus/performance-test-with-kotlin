package br.com.application.reactivemvc

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.reactive.config.EnableWebFlux

@EnableWebFlux
@SpringBootApplication
class ReactiveMvcApplication

fun main(args: Array<String>) {
	runApplication<ReactiveMvcApplication>(*args)
}
