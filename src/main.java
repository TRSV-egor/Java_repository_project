import java.util.Scanner;

public class main {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Enter FIO: ");
//        String fullName = scanner.next();

        String fullName = "Tarasov Egor Olegovich";

        String familia = fullName.substring(0, fullName.indexOf(" "));
        String name = fullName.substring(fullName.indexOf(" ") + 1, fullName.lastIndexOf(" "));
        String otchestvo = fullName.substring(fullName.lastIndexOf(" ") + 1, fullName.length());

        System.out.println("Фамилия: " + familia);
        System.out.println("Имя: " + name);
        System.out.println("Отчество: " + otchestvo);

    }
}
