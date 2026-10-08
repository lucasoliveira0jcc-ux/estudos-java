# Sistema Bancário

Simulação de um banco em Java, executada pelo console. O projeto permite cadastrar clientes, abrir contas correntes e poupanças e fazer depósitos, saques e transferências, com histórico de transações.

Foi feito para praticar programação orientada a objetos: herança, polimorfismo, interfaces, encapsulamento e exceções próprias.

## Tecnologias

- Java 21
- Maven
- JUnit 5

## Funcionalidades

- Criar cliente, com validação de CPF (precisa ter 11 dígitos; pontos e traço são removidos)
- Abrir conta corrente (com limite) ou conta poupança (com taxa de rendimento)
- Depositar
- Sacar, com validação de saldo (e de limite, na conta corrente)
- Transferir entre contas
- Consultar saldo
- Ver o extrato de uma conta

## Como rodar

O projeto fica dentro da pasta `Projetos/Sistema Bancário` do repositório.

```bash
git clone https://github.com/lucasoliveira0jcc-ux/estudos-java.git
cd "estudos-java/Projetos/Sistema Bancário"
mvn clean test
```

Para executar o programa, abra o projeto na IDE e rode a classe `app.Main`. Também dá para rodar pelo terminal:

```bash
mvn compile
java -cp target/classes app.Main
```

> **Windows:** para os acentos aparecerem corretamente no terminal, rode `chcp 65001` antes de executar o programa.

## Exemplo do menu

```text
BANCO
1. Criar Cliente
2. Abrir conta
3. Depositar
4. Sacar
5. Transferir
6. Consultar saldo
7. Extrato
0. Sair
```

## Estrutura de pacotes

```text
src/main/java
├── app
│   └── Main.java
├── exception
│   ├── CpfInvalidoException.java
│   └── SaldoInsuficienteException.java
├── model
│   ├── Cliente.java
│   ├── Conta.java
│   ├── ContaCorrente.java
│   ├── ContaPoupanca.java
│   ├── Rendavel.java
│   ├── TipoTransacao.java
│   └── Transacao.java
└── service
    └── Banco.java
```

**app**
- `Main`: menu interativo no console.

**model**
- `Cliente`: nome e CPF; valida o CPF na criação.
- `Conta`: classe abstrata com número, agência, saldo, titular e histórico; tem o método `transferir`.
- `ContaCorrente`: permite sacar até o saldo mais o limite.
- `ContaPoupanca`: só saca até o saldo; aplica rendimento.
- `Rendavel`: interface para contas que rendem juros.
- `Transacao`: registro de uma movimentação (tipo, valor e data).
- `TipoTransacao`: enum com `DEPOSITO`, `SAQUE` e `TRANSFERENCIA`.

**service**
- `Banco`: guarda clientes e contas, busca conta por número e cliente por CPF e lista os dois.

**exception**
- `CpfInvalidoException`: lançada quando o CPF não tem 11 dígitos.
- `SaldoInsuficienteException`: lançada quando o saque passa do que a conta permite.

## Conceitos aplicados

- **Abstração e herança** <!-- revisar -->: `Conta` é abstrata porque não existe uma conta "genérica" no banco: toda conta é corrente ou poupança. Ela guarda o que é comum (saldo, titular, histórico) e deixa `sacar` e `depositar` para as subclasses, que têm regras diferentes.
- **Polimorfismo** <!-- revisar -->: `transferir()` está em `Conta` e recebe qualquer `Conta` como destino. Ele chama `sacar` na origem e `depositar` no destino, e cada objeto aplica a sua própria regra. Por isso funciona entre corrente e poupança sem `if` para o tipo.
- **Interface `Rendavel`**: define que uma conta pode aplicar rendimento (`aplicarRendimento()`). Só `ContaPoupanca` a implementa. Qualquer conta futura que renda juros pode implementá-la também.
- **Encapsulamento**: o `saldo` é privado e não tem setter. Ele só muda pelos métodos protegidos `creditar` e `debitar`, que também registram a transação no histórico.
- **Exceções próprias**: `SaldoInsuficienteException` e `CpfInvalidoException` dizem o motivo do erro com clareza. O `Main` captura as duas e mostra a mensagem em vez de encerrar o programa.
- **Enum**: `TipoTransacao` limita os tipos de movimentação a valores fixos, sem risco de digitar um texto errado.

## Testes

São **21 testes** com JUnit 5, todos passando em `mvn clean test`:

- `ClienteTest`: 3 testes (validação e normalização do CPF)
- `ContaCorrenteTest`: 9 testes (depósito, saque, limite, histórico, transferência)
- `ContaPoupancaTest`: 9 testes (depósito, saque, rendimento, histórico, transferência)

## Melhorias futuras (fase 2)

- Validar os dígitos verificadores do CPF
- Tratar CPF nulo
- Persistência dos dados (arquivo ou banco de dados)
- API REST com Spring Boot
- Front-end
