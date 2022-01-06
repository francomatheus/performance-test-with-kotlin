package br.com.application.coroutine.service

import br.com.application.coroutine.domain.UserEntity

interface ExampleService {

    suspend fun retrieveDocumentsByCode(codeId: Long): List<UserEntity>
}
