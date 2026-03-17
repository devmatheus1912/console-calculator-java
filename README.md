# 🧮 Console Calculator v3.0

Calculadora de console desenvolvida em Java com foco em aprendizado de programação orientada a objetos (POO), boas práticas e organização de código.

---

## 🚀 Funcionalidades

A calculadora permite realizar as seguintes operações:

- ➕ Soma
- ➖ Subtração
- ✖️ Multiplicação
- ➗ Divisão (com validação de divisão por zero)
- 🔼 Potência (a^b)
- √ Raiz Quadrada
- 📊 Logaritmo (log de a na base b)
- 🌊 Seno (em radianos)

---

## 🧠 Funcionalidades extras

- 📜 Histórico de operações
- 🧹 Limpeza do histórico
- 🔢 Validação de entrada numérica
- ⚠️ Tratamento de erros matemáticos

---

## 🏗️ Estrutura do projeto
application/
├── Main.java
├── Menu.java
├── ValidadorEntrada.java

entities/
├── Calculadora.java
├── Historico.java
├── Operacao.java
├── Somar.java
├── Subtrair.java
├── Multiplicar.java
├── Divisao.java
├── Potencia.java
├── RaizQuadrada.java
├── Logaritmo.java
├── Seno.java

---

## ⚙️ Tecnologias utilizadas

- Java 17+
- Programação Orientada a Objetos (POO)
- Collections (Map, List)
- Tratamento de exceções

---

## 🧩 Conceitos aplicados

### 🔹 Interface (Polimorfismo)

Todas as operações implementam a interface:

```java
public interface Operacao {
    double calcular(double a, double b);
    String formatar(double a, double b, double resultado);
}
````
👉 Permite tratar todas as operações de forma genérica.

### 🔹 Polimorfismo

A calculadora executa qualquer operação sem saber qual é:
```
double resultado = operacao.calcular(a, b);
```
### 🔹 Substituição do switch por Map

Antes:
```
switch(opcao) { ... }
```
Agora:
```
Map<Integer, Operacao> operacoes = new HashMap<>();
operacoes.put(1, new Somar());
```
👉 Código mais limpo e escalável.
### 🔹 Princípio Open/Closed

Antes:

A classe Calculadora usava instanceof

Agora:

Cada operação sabe se formatar
```
operacao.formatar(a, b, resultado);
````
👉 A calculadora não precisa ser alterada para novas operações.

### 🔹 Tratamento de exceções

Exemplo:
```
if (b == 0) {
    throw new ArithmeticException("Não é possível dividir por zero");
}
````

## 📈 Evolução do projeto
### 🔹 Versão 1.0

Operações básicas

Menu simples

### 🔹 Versão 2.0

Histórico de operações

Validação de entrada

Organização em pacotes

### 🔹 Versão 3.0 (Atual)

Remoção do switch → uso de Map

Remoção de instanceof

Melhor arquitetura (mais orientada a objetos)

Novas operações:

Logaritmo

Seno

Potência

Raiz Quadrada

Código mais limpo e escalável

## ▶️ Como executar

Clone o repositório:
````
git clone https://github.com/seu-usuario/console-calculator-java.git
````
Abra no IntelliJ ou VS Code.

Execute a classe:
````
Main.java
````
## ‍💻 Autor

Matheus Oliveira
Projeto desenvolvido para aprendizado e evolução em Java e POO.

## ⭐ Se gostou do projeto

Deixe uma estrela ⭐ no repositório!