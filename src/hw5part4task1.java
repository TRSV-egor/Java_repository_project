import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class hw5part4task1 {

    public static String formatPhone(String phone) {


        phone = phone.replaceAll("[^0-9]", "");

        if (phone.length() > 11) {
            System.out.println("Error: wrong phone lenght - too long!");
            return "";
        } else if (phone.length() == 10 & phone.charAt(0) == '9') {
            phone = "7" + phone;
            System.out.println("Added code of country. Number is " + phone);
        } else if (phone.length() < 10) {
            System.out.println("Error: wrong phone lenght - too short!");
            return "";
        }

        if (phone.charAt(0) == '8') {
            phone = phone.replaceAll("8", "7");
            System.out.println("Changed 8 to 7 " + phone);
        } else if (phone.charAt(0) != '7') {
            System.out.println("Error: wrong contry code!");
            return "";
        }


        System.out.println("The number " + phone + " has been acepted!");

        return phone;
    }

    public static void main(String[] args) {
        TreeMap<String, String> DB = new TreeMap<>();
        Scanner scanner = new Scanner(System.in);
        Pattern patternNumber = Pattern.compile("\\+?[0-9]+");
        Pattern patternName = Pattern.compile("[A-Za-z]*");


        while (true){
            String line = scanner.nextLine();

            Matcher matcherNumber = patternNumber.matcher(line);
            Matcher matcherName = patternName.matcher(line);

            if (matcherName.matches()){
                System.out.println("This is name");
            } else if (matcherNumber.matches()){
                System.out.println("This is phone");
                formatPhone(line);
            } else {
                System.out.println("Retry");
            }





        }

    }
}
