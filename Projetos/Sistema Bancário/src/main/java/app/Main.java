package app;

import java.util.Scanner;

import model.Cliente;
import model.Conta;
import model.ContaCorrente;
import model.ContaPoupanca;
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
    Cliente cliente = new Cliente(nome, cpf);
    banco.adicionarCliente(cliente);
    System.out.println("Cliente criado com sucesso!");
    break;
                case 2:
    System.out.print("CPF do titular: ");
    String cpfBusca = scanner.nextLine();
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
case 0:
    System.out.println("Até logo!");
    return;
                default:
                    System.out.println("Opção inválida");
            }
        }
    }
}