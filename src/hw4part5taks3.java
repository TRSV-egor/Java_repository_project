import java.util.Scanner;

public class hw4part5taks3 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите ФИО:");
        String line = scanner.nextLine();

        String massive[] = line.split("\\s");

        String firstName = massive[0];
        String lastName = massive[1];
        String patronymic = massive[2];

        System.out.println("Фамилия " + firstName + "\nИмя " + lastName + "\nОтчество " + patronymic);

    }

}
