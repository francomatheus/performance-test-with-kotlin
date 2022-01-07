package br.com.application.imperative

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ImperativeApplication

fun main(args: Array<String>) {
	runApplication<ImperativeApplication>(*args)
}
