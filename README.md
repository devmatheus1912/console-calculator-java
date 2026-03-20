# 🚀 Console Calculator (Java)

Uma calculadora de console desenvolvida em Java com foco em boas práticas de programação orientada a objetos (POO), organização de código e evolução incremental do projeto.

---

## 📌 Sobre o projeto

Este projeto simula uma calculadora interativa no terminal, permitindo ao usuário realizar operações matemáticas básicas e avançadas, além de visualizar e gerenciar o histórico das operações realizadas.

O projeto foi evoluído em versões para aplicar conceitos reais de desenvolvimento backend.

---

## 🧠 Conceitos aplicados

* Programação Orientada a Objetos (POO)
* Encapsulamento
* Polimorfismo
* Interfaces
* Separação de responsabilidades
* Tratamento de exceções
* Testes automatizados com JUnit
* Gerenciamento de dependências com Maven

---

## ⚙️ Funcionalidades

### ➕ Operações básicas

* Soma
* Subtração
* Multiplicação
* Divisão

### 📐 Operações avançadas

* Potência
* Raiz quadrada
* Logaritmo
* Seno

### 📜 Histórico

* Registro de todas as operações
* Exibição do histórico
* Limpeza do histórico

---

## 🛡️ Validações implementadas

* Divisão por zero
* Raiz quadrada de número negativo
* Logaritmo com valores inválidos
* Base de logaritmo inválida
* Ângulos muito grandes no seno

---

## 🧪 Testes automatizados

A versão 3.0 introduz testes unitários utilizando **JUnit 5**, garantindo maior confiabilidade do sistema.

### 📊 Cobertura de testes

* ✔️ Operações matemáticas
* ✔️ Tratamento de exceções
* ✔️ Classe Calculadora
* ✔️ Classe Historico

### 📈 Resultado

* **28 testes executados**
* **28 testes aprovados**

---

## 📁 Estrutura do projeto

```
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
        └── entities
            ├── CalculadoraTest.java
            ├── HistoricoTest.java
            ├── SomarTest.java
            ├── SubtrairTest.java
            ├── MultiplicarTest.java
            ├── DivisaoTest.java
            ├── PotenciaTest.java
            ├── RaizQuadradaTest.java
            ├── LogaritmoTest.java
            └── SenoTest.java
```

---

## ▶️ Como executar

### 🔧 Pré-requisitos

* Java 17+ (ou Java 25)
* Maven

### ▶️ Rodar aplicação

```
mvn compile
mvn exec:java
```

---

### 🧪 Rodar testes

```
mvn test
```

---

## 🔖 Versionamento

### 🚀 v3.0

* Testes automatizados com JUnit
* Validação de operações
* Testes do histórico
* Melhor organização do código

### 🔄 v2.0

* Histórico de operações
* Novas operações matemáticas
* Melhor separação de classes

---

## 📌 Próximos passos

* Transformar o projeto em API REST (Spring Boot)
* Criar interface gráfica (GUI)
* Persistência de dados (banco)
* Melhorar cobertura de testes

---

## 👨‍💻 Autor

Desenvolvido por **Matheus Oliveira** 🚀

---
