package hw6part1task1;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        BankAccount TarasovEO = new BankAccount(1943515452,"Tarasov Egor Olegovich", 1000.00);

        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.println("Welcome to MyBankOS");
            System.out.println("What do you want to do?");

            String command = scanner.nextLine();

            if (command.contains("WITHDRAW")) {
                System.out.println("How much?");
                int cash = scanner.nextInt();
                TarasovEO.withdrawCash(cash);
                continue;
            }

            if (command.contains("EXIT")) {
                System.out.println("Bye!");
                break;
            }

        }
    }
}
