package app;

import java.util.Scanner;

import exception.CpfInvalidoException;
import exception.SaldoInsuficienteException;
import model.Cliente;
import model.Conta;
import model.ContaCorrente;
import model.ContaPoupanca;
import model.Transacao;
import service.Banco;

public class Main {
    public static void main(String[] args) {
        Banco banco = new Banco ("Meu banco");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("BANCO");
            System.out.println("1. Criar Cliente");
            System.out.println("2. Abrir conta");
             System.out.println("3. Depositar");
             System.out.println("4. Sacar");
             System.out.println("5. Transferir");
             System.out.println("6. Consultar saldo");
             System.out.println("7. Extrato");
             System.out.println("0. Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                   case 1:
    System.out.print("Nome: ");
    String nome = scanner.nextLine();
    System.out.print("CPF: ");
    String cpf = scanner.nextLine();
    try {
        Cliente cliente = new Cliente(nome, cpf);
        banco.adicionarCliente(cliente);
        System.out.println("Cliente criado com sucesso!");
    } catch (CpfInvalidoException e) {
        System.out.println(e.getMessage());
    }
    break;
                case 2:
    System.out.print("CPF do titular: ");
    String cpfBusca = scanner.nextLine().replaceAll("[^0-9]", "");
    Cliente titular = banco.buscarClientePorCpf(cpfBusca);
    if (titular == null) {
        System.out.println("Cliente não encontrado.");
        break;
    }
    System.out.print("Número da conta: ");
    String numero = scanner.nextLine();
    System.out.print("Agência: ");
    String agencia = scanner.nextLine();
    System.out.println("Tipo: 1. Corrente  2. Poupança");
    int tipo = scanner.nextInt();
    scanner.nextLine();

    Conta conta = null;

    if (tipo == 1) {
        System.out.print("Limite: ");
    double limite = scanner.nextDouble();
    scanner.nextLine();
     conta = new ContaCorrente(limite, numero, agencia, titular);
    banco.adicionarConta(conta);
    } else {
        System.out.print("Rendimento (ex: 0.005): ");
    double rendimento = scanner.nextDouble();
    scanner.nextLine();
     conta = new ContaPoupanca(rendimento, numero, agencia, titular);
    banco.adicionarConta(conta);
    }
    System.out.println("Conta criada com sucesso!");
    break;


case 3:
    System.out.print("Número da conta: ");
    String numDeposito = scanner.nextLine();
    Conta contaDeposito = banco.buscarContaPorNumero(numDeposito);
    if (contaDeposito == null) {
        System.out.println("Conta não encontrada.");
        break;
    }
    System.out.print("Valor: ");
    double valorDeposito = scanner.nextDouble();
    scanner.nextLine();
    contaDeposito.depositar(valorDeposito);
    System.out.println("Depósito realizado!");
    break;

case 4: 
    System.out.print("Número da conta: ");
    String numSacar = scanner.nextLine();
    Conta contaSacar = banco.buscarContaPorNumero(numSacar);
    if (contaSacar == null) {
        System.out.println("Conta não encontrada");
        break;
    }
    System.out.print("Valor: ");
    double valorSaque = scanner.nextDouble();
    scanner.nextLine();
    try {
        contaSacar.sacar(valorSaque);
        System.out.println("Saque realizado!");
    } catch (SaldoInsuficienteException e) {
        System.out.println(e.getMessage());
    }
    break;

case 5:
    System.out.print("Conta de origem: ");
    String numOrigem = scanner.nextLine();
    Conta contaOrigem = banco.buscarContaPorNumero(numOrigem);
    System.out.print("Conta de destino: ");
    String numDestino = scanner.nextLine();
    Conta contaDestino = banco.buscarContaPorNumero(numDestino);
    if (contaOrigem == null || contaDestino == null) {
        System.out.println("Conta de origem ou destino não encontrada.");
        break;
    }
    System.out.print("Valor: ");
    double valorTransf = scanner.nextDouble();
    scanner.nextLine();
    try {
        contaOrigem.transferir(valorTransf, contaDestino);
        System.out.println("Transferência realizada!");
    } catch (SaldoInsuficienteException e) {
        System.out.println(e.getMessage());
    }
    break;

    case 6:
    System.out.print("Número da conta: ");
    String numSaldo = scanner.nextLine();
    Conta contaSaldo = banco.buscarContaPorNumero(numSaldo);
    if (contaSaldo == null) {
        System.out.println("Conta não encontrada.");
        break;
    }
    System.out.println("Saldo: R$ " + contaSaldo.getSaldo());
    break;

    case 7:
    System.out.print("Número da conta: ");
    String numExtrato = scanner.nextLine();
    Conta contaExtrato = banco.buscarContaPorNumero(numExtrato);
    if (contaExtrato == null) {
        System.out.println("Conta não encontrada.");
        break;
    }
    for (Transacao t : contaExtrato.getHistorico()) {
        System.out.println(t);
    }
    break;

case 0:
    System.out.println("Até logo!");
    return;
                default:
                    System.out.println("Opção inválida");
            }
        }
    }
}