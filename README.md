# desafio-conexa
https://gitlab.com/conexasaude-public/desafio-tecnico-backend-conexa

## Backend

Spring Boot incluindo as dependências do spring para desenvolvimento de rest api.

#### Banco
    H2 e mysql

#### Provedor JPA
    Spring Data JPA com Hibernate.

#### Testes: 
    Spring boot tester com JUnit.

#### Actuator: 
    http://host:port/conexa-api/actuator
    Ao realizar uma requisição GET no link do atuator a resposta será uma série de 
    recursos para monitoramento da API do aplicação.

#### Log:
    - Arquivo de log centralizado de nome conexa.log
    - Configurações de log realizada no properties da aplicação.

#### Exceptions: 
    - Anotação @RestControllerAdvice para padronizar as respostas.
    - Dentro da msg de erro contém um atributo "codeErrorRandom" para facilitar a busca de erros no log.
    - Em caso de erro na api rest o projeto irá retornar msg em formato json padronizado, segue exemplo abaixo:
 ```bash
{
    "timestamp": "yyyy-MM-dd hh:mm:ss",
    "code": xxx,
    "status": "xxx",
    "error": "xxx",
    "codeErrorRandom": "xxx"
}
```

#### JWT: 
    Para realizar login na aplicação faça a requisição de post para http://localhost:8080/conexa-api/auth com o seguinte body: 
```bash
{
  "usuario": "medico@email.com",
  "senha": "senhamedico"
}
```

Para executar o projeto spring boot navegue até a raiz do projeto e execute os comandos abaixo:
```bash
mvn spring-boot:run
```
