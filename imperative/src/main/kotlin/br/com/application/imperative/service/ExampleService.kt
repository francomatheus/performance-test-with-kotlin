package br.com.application.imperative.service

import br.com.application.imperative.domain.UserEntity

interface ExampleService {

    fun retrieveDocumentsByCode(codeId: Long): List<UserEntity>
}
