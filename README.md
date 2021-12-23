# performance-test-with-kotlin

- Objetivo: Realizar um teste de performace entre 3 aplicações construidas com algumas particularidades. 

- Regra: 
    - Todas as aplicações irá acessar o banco   de dados noSQL (MongoDB), processar esse dado e retornar na controller. 

- Stack utilizada: 
    - Kotlin
    - Gradle
    - MongoDB

- Configuração das aplicações: 
    0. Todas serão utilizando Spring, Kotlin, Java 11.
    0. Será utilizado de uma arquitetura hexagonal

- Particularidades: 
    0. Uma aplicação irá utilizar o Spring WebFlux para realizar a query no banco de dados e retornar o resultado
    0. Uma aplicação irá utilizar Spring MVC para realizar a query no banco de dados e retornar o resultado.
    0. Uma aplicação irá utilizar o Spring MVC com coroutine para realizar a query no banco de dados e retornar o resultado.

- Teste de Performance: 
    - Para realizar o teste de performance, será gerado a imagem da aplicação e executa-lá limitando o recurso utilizado pelo container.

