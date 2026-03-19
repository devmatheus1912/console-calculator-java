# 🚀 Console Calculator (Java)

Uma calculadora de console desenvolvida em Java com foco em boas práticas de programação orientada a objetos (POO), organização de código e evolução incremental do projeto.

## 📌 Sobre o projeto

Este projeto simula uma calculadora interativa no terminal, permitindo ao usuário realizar operações matemáticas, visualizar histórico e limpar registros.

O principal objetivo foi evoluir de uma implementação simples para uma arquitetura mais organizada e escalável.

## 🧠 Principais conceitos aplicados

Programação Orientada a Objetos (POO)

Separação de responsabilidades

Interfaces e polimorfismo

Sobrecarga de métodos

Tratamento de exceções

Estrutura modular (camadas)

Refatoração de código

Boas práticas de legibilidade

## 🏗️ Estrutura do projeto

O projeto foi organizado em duas camadas principais:

### 📂 application

Responsável pelo controle da aplicação (interface com o usuário)

Main → ponto de entrada

AplicacaoCalculadora → controla o fluxo do sistema

Menu → exibe e valida opções

ValidadorEntrada → valida dados digitados pelo usuário

### 📂 entities

Responsável pela lógica de negócio

Calculadora → executa operações

Historico → armazena operações realizadas

Interfaces:

OperacaoBinaria

OperacaoUnaria

Operações implementadas:

Soma

Subtração

Multiplicação

Divisão

Potência

Logaritmo

Raiz Quadrada

Seno

## ⚙️ Como funciona

O usuário escolhe uma operação no menu

O sistema identifica se é:

operação binária (2 números)

operação unária (1 número)

Os valores são validados

A operação é executada

O resultado é exibido

A operação é registrada no histórico

## 🧩 Arquitetura (evolução do projeto)
Antes

Main centralizava toda a lógica

Uso de switch

Todas operações com mesma assinatura

Depois (versão atual)

Separação em OperacaoBinaria e OperacaoUnaria

Uso de Map para mapear operações

Criação da classe AplicacaoCalculadora

Remoção de lógica condicional baseada no menu

Criação da classe RegistroOperacao para estruturar o histórico

Histórico mais rico com data, hora, expressão e resultado

Código mais limpo, organizado e escalável

## 📝 Exemplo de uso
```
================================
CONSOLE CALCULATOR v3.0
================================
1 - Somar
2 - Subtrair
3 - Multiplicar
...
Escolha uma opção: 1

Digite o primeiro número: 10
Digite o segundo número: 5

✓ Operação realizada com sucesso!
Operação: Soma
Resultado: 15.0
Total de operações: 1
```
## 📊 Funcionalidades

✔️ Operações matemáticas básicas e avançadas

✔️ Histórico de operações

✔️ Limpeza do histórico

✔️ Registro detalhado com data e hora

✔️ Validação de entrada do usuário

✔️ Tratamento de erros (ex: divisão por zero)

✔️ Estrutura preparada para expansão

## 🔧 Tecnologias utilizadas

Java 17+

IntelliJ IDEA

Git & GitHub

## 📈 Evolução do projeto

Este projeto foi evoluído em etapas:

✔️ Versão inicial com switch

✔️ Refatoração para uso de interfaces

✔️ Implementação de histórico

✔️ Separação em operações binárias/unárias

✔️ Criação de camada de aplicação (AplicacaoCalculadora)

✔️ Implementação de histórico estruturado com RegistroOperacao

✔️ Melhoria de legibilidade e organização

## 💡 Melhorias futuras

Criar classe RegistroOperacao (histórico estruturado)

Adicionar testes unitários

Persistir histórico em arquivo

Interface gráfica (GUI)

Suporte a mais funções matemáticas

## 🧑‍💻 Autor

Desenvolvido por Matheus Oliveira