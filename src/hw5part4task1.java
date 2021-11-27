import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class hw5part4task1 {

    private static void printMap(Map<String, String> map) {

        if (map.isEmpty()) {
            System.out.println("Notification: Address book is empty");
        } else {
            for (String key : map.keySet()) {
                System.out.println(key + ": " + map.get(key));
            }
        }


    }

    private static String formatPhone(String phone) {

        phone = phone.replaceAll("[^0-9]", "");

        if (phone.length() > 11) {
            System.out.println("Error: Wrong phone length - too long!");
            return "";
        } else if (phone.length() == 10 & phone.charAt(0) == '9') {
            phone = "7" + phone;
            System.out.println("Attention: Added code of country. Number is " + phone);
        } else if (phone.length() < 10) {
            System.out.println("Error: Wrong phone length - too short!");
            return "";
        }

        if (phone.charAt(0) == '8') {
            phone = phone.replaceAll("8", "7");
            System.out.println("Attention: Changed 8 to 7 " + phone);
        } else if (phone.charAt(0) != '7') {
            System.out.println("Error: Wrong country code!");
            return "";
        }
        //System.out.println("The number " + phone + " has been acepted!");

        return phone;
    }

    public static void main(String[] args) {
        TreeMap<String, String> DB = new TreeMap<>();
        Scanner scanner = new Scanner(System.in);
        Pattern patternNumber = Pattern.compile("\\+?[0-9]+");
        Pattern patternName = Pattern.compile("[A-Za-z]*|[А-Яа-я]*");


        while (true) {
            System.out.println("");
            System.out.print("\tName or phone to add/find entry\n\tLIST - to show available entries \n What do you want to do: ");

            String line = scanner.nextLine();

            Matcher matcherNumber = patternNumber.matcher(line);
            Matcher matcherName = patternName.matcher(line);

            if (line.equals("LIST")) {

                printMap(DB);

            } else if (matcherName.matches()) {
                //System.out.println("This is name " + matcherName.group());
                if (DB.containsKey(matcherName.group())) {
                    System.out.println(matcherName.group() + ": " + DB.get(matcherName.group()));
                } else {
                    System.out.println("Notification: Enter phone number of " + matcherName.group() + ": ");
                    String number = scanner.nextLine();

                    if (number == "") {
                        System.out.println("Error: Invalid number");
                    } else {
                        number = formatPhone(number);
                        DB.put(matcherName.group(), number);
                        System.out.println("Notification: Entry created");
                    }
                }
            } else if (matcherNumber.matches()) {
                //System.out.println("This is phone " + matcherNumber.group());
                line = formatPhone(line);
                if (DB.containsValue(line)) {
                    //
                    //Have to search key by value
                    //
                    System.out.println(DB.get(line) + ": " + line);
                    //
                    //Result: null: 79101234567
                    //
                } else {
                    System.out.println("Notification: Enter name to number " + line);
                    String name = scanner.nextLine();
                    if (name == "") {
                        System.out.println("Error: Invalid name");
                    } else {
                        DB.put(name, line);
                        System.out.println("Notification: Entry created");
                    }
                }
            } else {
                System.out.println("Error: Try again");
            }

        }

    }
}
