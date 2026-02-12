package Exercicios.ContaBancaria;
import java.util.Scanner;
public class main_ {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Número da conta: ");
            Integer number = sc.nextInt();
            System.out.print("Titular da conta: ");

            sc.nextLine(); 

            String holder = sc.nextLine();
            System.out.print("Saldo inicial: ");
            Double balance = sc.nextDouble();
            System.out.print("Limite de saque: ");
            Double withdrawLimit = sc.nextDouble();
            Account account = new Account(number, holder, balance, withdrawLimit);
            System.out.print("Valor para saque: ");
            Double amount = sc.nextDouble();
            account.withdraw(amount);
            System.out.println("Novo saldo: " + account.getBalance());

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
        sc.close();
    }

}
