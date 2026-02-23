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
├── Historico.java
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
- `Historico` → Armazena e gerencia o histórico das operações.

---

## 🧠 Conceitos Aplicados

### 🔹 Interface

A interface `Operacao` define o contrato:

```java
double calcular(double a, double b);
String getSimbolo();
````
Todas as operações implementam esse método.

### 🔹 Polimorfismo

A classe Calculadora recebe uma abstração (Operacao) e não depende de classes concretas.

Isso permite adicionar novas operações sem modificar a estrutura principal.

### 🔹 Encapsulamento

O Historico é um atributo privado da Calculadora.

O acesso ao histórico é feito por meio de métodos públicos controlados:

mostrarHistorico()

limparHistorico()

### 🔹 Delegação

A Calculadora delega a responsabilidade de armazenar e listar registros para a classe Historico.

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
↓
Registro salvo no histórico

## 📜 Funcionalidades Atuais

✅ Soma

✅ Subtração

✅ Multiplicação

✅ Divisão (com tratamento de divisão por zero)

✅ Histórico de operações

✅ Limpeza de histórico

✅ Validação de entrada de menu

## 🛠 Tecnologias Utilizadas

Java 17+

Programação Orientada a Objetos

IntelliJ IDEA

Git & GitHub

## 📊 Diagrama UML

O projeto possui um diagrama UML completo com:

Interface e realizações

Composição (Calculadora → Historico)

Dependências

Separação de responsabilidades

Arquivo disponível em:

docs/uml/Console_Calculator_UML_Completo.drawio

## 🔮 Melhorias Futuras

Implementar Factory de Operações

Substituir switch por Map<Integer, Operacao>

Criar testes unitários (JUnit)

Persistir histórico em arquivo

Transformar em API REST (Spring Boot)

Criar interface gráfica

## 👨‍💻 Autor

Matheus Oliveira
Estudante de Análise e Desenvolvimento de Sistemas
Foco em desenvolvimento Back-end