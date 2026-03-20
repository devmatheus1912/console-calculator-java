# 🧮 Console Calculator Java

Uma calculadora de console desenvolvida em **Java**, com foco em **boas práticas de arquitetura**, **POO**, **testes automatizados** e preparação para evolução em uma **API REST com Spring Boot**.

---

## 📌 Sobre o projeto

O projeto começou como uma simples calculadora de terminal e evoluiu para uma aplicação estruturada em camadas, aplicando conceitos utilizados no desenvolvimento backend profissional.

Hoje, o sistema possui:

- separação de responsabilidades
- arquitetura em camadas
- testes automatizados completos
- abstrações para entrada/saída
- persistência desacoplada
- validações robustas

---

## 🚀 Melhorias implementadas

### ✅ Arquitetura em camadas

O projeto foi organizado em módulos bem definidos:

- `application` → fluxo da aplicação e interface de console
- `service` → regras de negócio
- `entities` → domínio da aplicação
- `repository` → persistência de dados
- `validation` → validações
- `exceptions` → tratamento de erros

---

### ✅ Abstração de IO (entrada/saída)

Introdução da interface:

```java
IO
````
Implementações:

- ConsoleIO

- FakeIO (para testes)

Benefícios:

- desacoplamento de System.in/out

- melhor testabilidade

- base pronta para API

### ✅ Service Layer

A classe CalculadoraService centraliza:

- execução de operações

- validações

- persistência de histórico

### ✅ Repository Pattern

Interface:
```
HistoricoRepository
```
Implementações:

- HistoricoEmMemoriaRepository

- HistoricoArquivoRepository

- Permite trocar persistência sem alterar a regra de negócio.

### ✅ Strategy Pattern

Cada operação matemática é uma classe:

Binárias

- Soma

- Subtração

- Multiplicação

- Divisão

- Potência

- Logaritmo

Unárias

- Raiz quadrada

- Seno

### ✅ Exceções de domínio
```
RegraDeNegocioException
````
Usada para:

- divisão por zero

- logaritmo inválido

- valores fora do intervalo

- operações inválidas

### ✅ Uso de record

- RegistroOperacao

- ResultadoOperacao

Mais legibilidade e menos boilerplate.

### ✅ Testes automatizados

- JUnit 5

- testes unitários

- testes de integração

- testes de fluxo da aplicação

Cobertura:

- application

- service

- repository

- entities

- validation

## ⚙️ Funcionalidades
➕ Operações básicas

- Soma

- Subtração

- Multiplicação

- Divisão

## 📐 Operações avançadas

- Potência

- Raiz quadrada

- Logaritmo

- Seno

## 📜 Histórico

- Registro automático

- Listagem

- Limpeza

- Persistência em memória

- Persistência em arquivo

## 🛡️ Validações

- divisão por zero

- raiz de número negativo

- logaritmo inválido

- base inválida

- valores fora do intervalo permitido

- entrada inválida do usuário

## 🧠 Conceitos aplicados

- POO

- Encapsulamento

- Polimorfismo

- Interfaces

- Strategy Pattern

- Repository Pattern

- Service Layer

- Clean Code

- SOLID

- Testes automatizados

- JaCoCo

- Maven

📁 Estrutura do projeto
````
src
├── main
│   └── java
│       ├── application
│       │   ├── AplicacaoCalculadora.java
│       │   ├── ConsoleIO.java
│       │   ├── IO.java
│       │   ├── Main.java
│       │   ├── Menu.java
│       │   └── ValidadorEntrada.java
│       │
│       ├── entities
│       │   ├── Calculadora.java
│       │   ├── Divisao.java
│       │   ├── Logaritmo.java
│       │   ├── Multiplicar.java
│       │   ├── OperacaoBinaria.java
│       │   ├── OperacaoUnaria.java
│       │   ├── Potencia.java
│       │   ├── RaizQuadrada.java
│       │   ├── RegistroOperacao.java
│       │   ├── ResultadoOperacao.java
│       │   ├── Seno.java
│       │   ├── Somar.java
│       │   ├── Subtrair.java
│       │   └── TipoOperacao.java
│       │
│       ├── exceptions
│       │   └── RegraDeNegocioException.java
│       │
│       ├── repository
│       │   ├── HistoricoArquivoRepository.java
│       │   ├── HistoricoEmMemoriaRepository.java
│       │   └── HistoricoRepository.java
│       │
│       ├── service
│       │   ├── CalculadoraService.java
│       │   └── RegistroOperacoes.java
│       │
│       └── validation
│           └── ValidarNumero.java
│
└── test
└── java
├── application
│   ├── AplicacaoCalculadoraCoverageTest.java
│   ├── AplicacaoCalculadoraTest.java
│   ├── ConsoleIOTest.java
│   ├── MainTest.java
│   ├── MenuTest.java
│   └── ValidadorEntradaTest.java
│
├── entities
│   ├── CalculadoraTest.java
│   ├── DivisaoTest.java
│   ├── LogaritmoTest.java
│   ├── MultiplicarTest.java
│   ├── PotenciaTest.java
│   ├── RaizQuadradaTest.java
│   ├── RegistroOperacaoTest.java
│   ├── ResultadoOperacaoTest.java
│   ├── SenoTest.java
│   ├── SomarTest.java
│   ├── SubtrairTest.java
│   └── TipoOperacaoTest.java
│
├── repository
│   ├── HistoricoArquivoRepositoryTest.java
│   └── HistoricoEmMemoriaRepositoryTest.java
│
├── service
│   ├── CalculadoraServiceTest.java
│   └── RegistroOperacoesTest.java
│
└── validation
└── ValidarNumeroTest.java
````
## ▶️ Como executar
Pré-requisitos

- Java 25

- Maven 3.9+

Compilar
````
mvn compile
````
Executar
````
mvn exec:java
````

ou rodar a classe:
````
application.Main
````
## 🧪 Testes
````
mvn test
````

Rebuild completo:
````
mvn clean test
````
## 📊 Cobertura

Gerar relatório:
````
mvn clean test
`````
Abrir:
````
target/site/jacoco/index.html
````
## 🔖 Versionamento
### 🚀 v3.0

- arquitetura em camadas

- service layer

- repository pattern

- abstração de IO

- testes completos

- validações robustas

### 🔄 v2.0

- histórico de operações

- novas operações

- organização inicial

### 🟢 v1.0

- calculadora básica

## 🎯 Próximos passos

- Spring Boot (API REST)

- DTOs

- tratamento global de exceções

- banco de dados

- Swagger

- autenticação

## 👨‍💻 Autor

Matheus Oliveira
GitHub: https://github.com/devmatheus1912

## 📄 Licença

Projeto para fins educacionais e portfólio.