import java.util.Scanner;

public class hw4part5task4 {

    public static void main(String[] args) {

        while (true) {
            System.out.print("Enter phone number: ");
            String line = (new Scanner(System.in).nextLine());
            //String line = "8-905-1234567";
            String phone = line.replaceAll("[^0-9]", "");

            if (phone.length() > 11) {
                System.out.println("Error: wrong phone lenght - too long!");
                continue;
            } else if (phone.length() == 10 & phone.charAt(0) == '9') {
                phone = "7" + phone;
                System.out.println("Added code of country. Number is " + phone);
                break;
            } else if (phone.length() < 10) {
                System.out.println("Error: wrong phone lenght - too short!");
                continue;
            }

            if (phone.charAt(0) == '8') {
                phone = phone.replaceAll("8", "7");
                System.out.println("Changed 8 to 7 " + phone);
                break;
            } else if (phone.charAt(0) != '7') {
                System.out.println("Error: wrong contry code!");
                continue;
            }
            break;
        }

        System.out.println("The number has been acepted!");
    }

}
