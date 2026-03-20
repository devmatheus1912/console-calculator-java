# 🚀 Console Calculator (Java)

Uma calculadora de console desenvolvida em Java com foco em boas práticas de programação orientada a objetos (POO), testes automatizados e evolução incremental do projeto.

---

## 📌 Sobre o projeto

Este projeto simula uma calculadora interativa no terminal, permitindo ao usuário realizar operações matemáticas básicas e avançadas, além de visualizar e gerenciar o histórico das operações realizadas.

O projeto foi evoluído em versões com foco em simular um ambiente real de desenvolvimento backend, incluindo testes automatizados, validações e organização por camadas.

---

## 🧠 Conceitos aplicados

- Programação Orientada a Objetos (POO)
- Encapsulamento
- Polimorfismo
- Interfaces
- Separação de responsabilidades
- Tratamento de exceções
- Testes unitários e de integração
- Simulação de entrada/saída (System.in / System.out)
- Cobertura de código com JaCoCo
- Gerenciamento de dependências com Maven

---

## ⚙️ Funcionalidades

### ➕ Operações básicas
- Soma
- Subtração
- Multiplicação
- Divisão

### 📐 Operações avançadas
- Potência
- Raiz quadrada
- Logaritmo
- Seno

### 📜 Histórico
- Registro de todas as operações
- Exibição do histórico
- Limpeza do histórico

---

## 🛡️ Validações implementadas

- Divisão por zero
- Raiz quadrada de número negativo
- Logaritmo com valores inválidos
- Base de logaritmo inválida
- Entrada inválida do usuário (Scanner)
- Intervalo de valores permitidos

---

## 🧪 Testes automatizados

O projeto possui testes completos utilizando **JUnit 5**, cobrindo:

- Operações matemáticas
- Tratamento de exceções
- Classe Calculadora
- Classe Historico
- Classe RegistroOperacao
- Menu e fluxo da aplicação
- Validação de entrada do usuário
- Execução completa da aplicação (testes de fluxo)

---

## 📊 Cobertura de testes

- ✅ **Cobertura total: 96%**
- ✅ **Cobertura de branches: 90%**
- ✅ Testes unitários e de integração

> Relatório gerado com JaCoCo

---

## 📈 Resultado

- ✔️ 51 testes executados
- ✔️ 51 testes aprovados
- ✔️ Alta confiabilidade do sistema

---

## 📁 Estrutura do projeto

```text
src
├── main
│   └── java
│       ├── application
│       │   ├── AplicacaoCalculadora.java
│       │   ├── Main.java
│       │   ├── Menu.java
│       │   └── ValidadorEntrada.java
│       └── entities
│           ├── Calculadora.java
│           ├── Historico.java
│           ├── RegistroOperacao.java
│           ├── OperacaoBinaria.java
│           ├── OperacaoUnaria.java
│           ├── Somar.java
│           ├── Subtrair.java
│           ├── Multiplicar.java
│           ├── Divisao.java
│           ├── Potencia.java
│           ├── RaizQuadrada.java
│           ├── Logaritmo.java
│           └── Seno.java
└── test
    └── java
        ├── application
        │   ├── AplicacaoCalculadoraTest.java
        │   ├── MenuTest.java
        │   ├── ValidadorEntradaTest.java
        │   └── MainTest.java
        └── entities
            ├── CalculadoraTest.java
            ├── HistoricoTest.java
            ├── RegistroOperacaoTest.java
            ├── SomarTest.java
            ├── SubtrairTest.java
            ├── MultiplicarTest.java
            ├── DivisaoTest.java
            ├── PotenciaTest.java
            ├── RaizQuadradaTest.java
            ├── LogaritmoTest.java
            └── SenoTest.java
```
# ▶️ Como executar
🔧 Pré-requisitos

Java 17+ (ou Java 25)

Maven

# ▶️ Rodar aplicação
```
mvn compile
mvn exec:java
````
# 🧪 Rodar testes
````
mvn test
````
# 📊 Gerar relatório de cobertura
````
mvn clean test
````
Abrir:
````
target/site/jacoco/index.html
````

# 🔖 Versionamento
## 🚀 v3.0

Testes automatizados completos (JUnit 5)

Cobertura de 96% com JaCoCo

Testes de fluxo da aplicação

Validações robustas de entrada

Melhor organização e arquitetura

## 🔄 v2.0

Histórico de operações

Novas operações matemáticas

Separação de responsabilidades

# 📌 Próximos passos

🔥 Transformar em API REST (Spring Boot)

Persistência de dados (arquivo ou banco)

Implementar DTOs e camada de serviço

Criar versionamento de API

Melhorar tratamento de erros (HTTP responses)

# 👨‍💻 Autor

Desenvolvido por Matheus Oliveira 🚀