# performance-test-with-kotlin

- Objetivo: Realizar um teste de performace entre 4 aplicações construidas com algumas particularidades. 

- Regra: 
    - Todas as aplicações irá acessar o banco de dados noSQL (MongoDB), processar esse dado e retornar na controller. 

- Stack utilizada: 
    - Kotlin
    - Gradle
    - MongoDB
    - Coroutine kotlin
    - Webflux
    - [Vegeta](https://github.com/tsenart/vegeta) - Teste de carga

- Configuração das aplicações: 
    0. Todas serão utilizando Spring, Kotlin, Java 11.
    0. Será utilizado de uma arquitetura hexagonal

- Particularidades: 
    0. Uma aplicação irá utilizar o Spring WebFlux e arquitetura hexagonal.
    0. Uma aplicação irá utilizar Spring MVC.
    0. Uma aplicação irá utilizar o Spring MVC com coroutine.
    0. Uma aplicação irá utilizar o Spring WebFlux com estrutura de pastas estilo MVC.

- Teste de Performance: 
    - Para realizar o teste de performance, será gerado a imagem da aplicação e executa-lá limitando o recurso utilizado pelo container.

    - Teste de carga realizado utilizando o [Vegeta](https://github.com/tsenart/vegeta). O teste foi realizado alterando o rate(quantidade de requisição por segundo) durante 10 segundos. Na tabela a seguir consta a aplicação e o tempo médio de resposta. 

        - A aplicação é reponsavel por buscar 500 items no banco de dados e retornar
        - Para realizar o teste, subiu-se um container de cada aplicação delimitando os recursos utilizados em no máximo `1 cpus` e `768M` de memória. 

| Aplicação | 10 req/s| 20 req/s | 50 req/s| 75 req/s | 100 req/s | 
|-----------|---------|----------|---------|----------|-----------|
| Imperativo|   30s   |    30s   |   30s   |   30s    |    30s    |
| coroutine |  4.163s |   6.458s | 13.899s |  14.285s |25.533s(36.30%)|
| reativo   | 19.045s |   8.53s  | 27.089s |29.481s(30.53%)|     30s      |
|reativo-mvc| 22.341s |  15.216s |  21.64s |28.774s(38%)|    30s       |


- A tabela a seguir mostra qual o número máximo de requisição durante um segundo que a aplicação suporta.


| Aplicação | Máximo req | Tempo médio de resposta| 
|--|--|--|
| Imperativo | 2 | 30s |
| coroutine | 450 | 17.258s |
| reativo | 500 | 26.827s |
| reativo-mvc | 450 | 23.497s |

> Obs.: Na tabela quando o tempo médio é 30s corresponde ao tempo de timeout. 
