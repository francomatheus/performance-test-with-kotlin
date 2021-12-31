package br.com.application.reactive.adapter.input.web.controller

import br.com.application.reactive.application.port.input.UserUseCase
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping

@RequestMapping("/reactive")
class ExampleController(
        private val userUseCase: UserUseCase
) {

    @GetMapping("/v1/code/{codeId}")
    fun getAllByCode(
            @PathVariable codeId:Int
    ){
        userUseCase.findAllUserByCode(codeId)
    }

}