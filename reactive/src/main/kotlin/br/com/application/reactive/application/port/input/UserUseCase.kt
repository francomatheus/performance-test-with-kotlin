package br.com.application.reactive.application.port.input

interface UserUseCase {

    fun findAllUserByCode(codeId: Int)
}
