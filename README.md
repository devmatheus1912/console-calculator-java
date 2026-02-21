# 🧮 Console Calculator - Java

Calculadora de console desenvolvida em Java com foco em aplicar conceitos de Programação Orientada a Objetos (POO) e boas práticas de arquitetura.

---

## 🚀 Objetivo do Projeto

Este projeto começou como uma calculadora simples para praticar:

- Estruturas condicionais (`switch`)
- Estruturas de repetição (`do-while`)
- Entrada de dados com `Scanner`

Com a evolução do aprendizado, o projeto foi refatorado para aplicar:

- Interface
- Polimorfismo
- Delegação de responsabilidade
- Separação de camadas
- Baixo acoplamento

---

## 🏗 Estrutura do Projeto
src
├── application
│ ├── Main.java
│ └── Menu.java
│
└── entities
├── Operacao.java
├── Calculadora.java
├── Somar.java
├── Subtrair.java
├── Multiplicar.java
└── Divisao.java


---

## 📦 Camadas

### 📌 application (Camada de Interface)
Responsável pela interação com o usuário.

- `Main` → Controla o fluxo do programa.
- `Menu` → Exibe opções e valida entrada.

### 📌 entities (Camada de Regra de Negócio)
Responsável pela lógica da aplicação.

- `Operacao` → Interface que define o contrato das operações.
- `Somar`, `Subtrair`, `Multiplicar`, `Divisao` → Implementações concretas.
- `Calculadora` → Executa a operação recebida.

---

## 🧠 Conceitos Aplicados

### 🔹 Interface

A interface `Operacao` define o contrato:

```java
double calcular(double a, double b);
````
Todas as operações implementam esse método.

### 🔹 Polimorfismo

A classe Calculadora recebe uma abstração (Operacao) e não depende de classes concretas.

Isso permite adicionar novas operações sem modificar a estrutura principal.

### 🔹 Separação de Responsabilidades

Main → Controle do fluxo

Menu → Interface com usuário

Calculadora → Executa operação

Classes concretas → Implementam regra matemática

## 🔄 Fluxo da Aplicação

Menu
↓
Usuário escolhe operação
↓
Main instancia a operação correspondente
↓
Calculadora executa
↓
Classe concreta calcula
↓
Resultado exibido


## 🛠 Tecnologias Utilizadas

Java 17+

Programação Orientada a Objetos

IntelliJ IDEA

Git & GitHub

## 🔮 Melhorias Futuras

Implementar Factory de Operações

Adicionar histórico de cálculos

Criar testes unitários

Transformar em API REST

Criar interface gráfica

##  👨‍💻 Autor

Matheus Oliveira
Estudante de Análise e Desenvolvimento de Sistemas
Foco em desenvolvimento Back-end
