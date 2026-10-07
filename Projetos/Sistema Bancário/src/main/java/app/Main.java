package app;

import java.util.Scanner;

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

            switch (opcao) {
                case 1:
                    System.out.println("em construção");
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