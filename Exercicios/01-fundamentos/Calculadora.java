import java.util.Scanner;

public class Calculadora {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

      var opcao = 0;
double numero1;
double numero2;
double resultado;
double novoNumero;


while (opcao != 6) {
    System.out.println("Escolha uma operação:");
    System.out.println("1. Soma");
    System.out.println("2. Subtração");
    System.out.println("3. Multiplicação");
    System.out.println("4. Divisão");
    System.out.println("5. Potência");
    System.out.println("6. Sair");
    opcao = scanner.nextInt();

    switch (opcao) {
        case 1:
             System.out.println("Digite o primeiro número:");
            numero1 = scanner.nextDouble();
            System.out.println("Digite o segundo número:");
            numero2 = scanner.nextDouble();
            resultado = numero1 + numero2;
            System.out.println("O resultado da soma é: " + resultado);
            
                while(opcao == 1) {
                    System.out.println("Deseja continuar a soma ? (1 - Sim, 2 - Não)");
                    int escolha = scanner.nextInt();
                    if (escolha == 1) {
                        System.out.println("Digite um novo número:");
                     novoNumero = scanner.nextDouble();
                        resultado += novoNumero;
                        System.out.println("O resultado da soma é: " + resultado);
                    } 
                    else {
                        break;
                    }
                }
            break;
        case 2:
             System.out.println("Digite o primeiro número:");
            numero1 = scanner.nextDouble();
            System.out.println("Digite o segundo número:");
            numero2 = scanner.nextDouble();
            resultado = numero1 - numero2;
            System.out.println("O resultado da subtração é: " + resultado);

        while(opcao == 2) {
                    System.out.println("Deseja continuar a operação? (1 - Sim, 2 - Não)");
                    int escolha = scanner.nextInt();
                    if (escolha == 1) {
                        System.out.println("Digite um novo número:");
                     novoNumero = scanner.nextDouble();
                        resultado -= novoNumero;
                        System.out.println("O resultado da subtração é: " + resultado);
                    } else {
                        break;
                    }
                }
                
            break;
        case 3:
             System.out.println("Digite o primeiro número:");
            numero1 = scanner.nextDouble();
            System.out.println("Digite o segundo número:");
            numero2 = scanner.nextDouble();
            resultado = numero1 * numero2;
            System.out.println("O resultado da multiplicação é: " + resultado);
            break;
        case 4:
             System.out.println("Digite o primeiro número:");
            numero1 = scanner.nextDouble();
            System.out.println("Digite o segundo número:");
            numero2 = scanner.nextDouble();

            if (numero2 == 0) {
                System.out.println("Erro: Divisão por zero não é permitida.");
            } else {
                resultado = numero1 / numero2;
                System.out.println("O resultado da divisão é: " + resultado);
                System.out.println("o resto da divisão é: " + (numero1 % numero2));
            }
            break;
        case 5:
             System.out.println("Digite o primeiro número:");
            numero1 = scanner.nextDouble();
            System.out.println("Digite o segundo número:");
            numero2 = scanner.nextDouble();
            resultado = Math.pow(numero1, numero2);
            System.out.println("O resultado da potência é: " + resultado);
            break;
        case 6:
            System.out.println("Saindo da calculadora...");
            break;
        default:
            System.out.println("Opção inválida!");
    }
}
    }
}