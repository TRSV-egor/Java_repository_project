import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class main {
    public static void main(String[] args) {

    }
}

//Задание 4.5задание 1
//class main {
//    public static void main(String[] args) {
//        String text = "Вася заработал 5000 рублей, Петя - 7563 рубля, а Маша - 30000 рублей";
//        Pattern pattern = Pattern.compile("\\d+");
//        Matcher matcher = pattern.matcher(text);
//        double sum = 0;
//        while (matcher.find()){
//            sum += Integer.parseInt(text.substring(matcher.start(), matcher.end()));
//        }
//        System.out.println("Итого: " + sum);
//    }
//}

//домашнее задание 4.4 упражнение 5*
//public class main {
//    public static void main(String[] args) {
//        String safe = searchAndReplaceDiamonds("Номер кредитной карты <4008 1234 5678> 8912", "***");
//        System.out.println(safe);
//    }
//
//    public static String searchAndReplaceDiamonds(String text, String placeholder){
//        String safe = text.replace(text.substring(text.indexOf('<'), text.indexOf('>') + 1), placeholder);
//        return safe;
//    }
//}

//дз 4,4 задание 3
//public class main {
//    public static void main(String[] args) {
//
//        while (true) {
//
//            Scanner scanner = new Scanner(System.in);
//            System.out.print("Enter FIO: ");
//            String fullName = scanner.nextLine();
//
//            if (fullName.length() != 0){
//                if (fullName.indexOf(' ') != -1){
//                    String familia = fullName.substring(0, fullName.indexOf(' '));
//                    System.out.println("Фамилия: " + familia);
//                } else {
//                    System.out.println("Name NotFound");
//                    continue;
//                }
//
//                if ((fullName.indexOf(" ") + 1) < fullName.lastIndexOf(" ") ){
//                    String name = fullName.substring(fullName.indexOf(" ") + 1, fullName.lastIndexOf(" "));
//                    System.out.println("Имя: " + name);
//                } else {
//                    System.out.println("Otchestvo Not Found");
//                    continue;
//                }
//
//                if (fullName.lastIndexOf(" ")+1 != fullName.length()){
//                    String otchestvo = fullName.substring(fullName.lastIndexOf(" ") + 1);
//                    System.out.println("Отчество: " + otchestvo);
//                } else {
//                    System.out.println("Otchestvo Not Found");
//                    continue;
//                }
//            } else {
//                System.out.println("Введите ФИО!");
//                continue;
//            }
//            break;
//        }
//
//    }
//}
