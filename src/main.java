import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class main {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите ФИО:");
        String line = scanner.nextLine();

        String massive[] = line.split("\\s");

        String firstName = massive[0];
        String lastName = massive [1];
        String patronymic = massive [2];

        System.out.println("Фамилия " + firstName + "\nИмя " + lastName + "\nОтчество " + patronymic);



    }
}





//ДЗ 4.5 задание 2
//class main {
//    public static void main(String[] args) {
//        String text = "Abroad the school year begins in September; they call this moment like ‘back to school’. The first holidays start at the end of October. Students and their teachers have two weeks of having a rest.\n" +
//                "\n" +
//                "Then it is time for Christmas holidays. Christmas is a very important holiday in Europe and USA. All the family members meet together. They can see their parents, grandparents, uncles and aunts, cousins, and so on. The holiday meal lasts for a long time and they exchange gifts on the 25th of December. They have a vacation to have time to meet up with family. There are almost two weeks for it.\n" +
//                "\n" +
//                "In winter there are also winter holidays; these holidays are different from Christmas holidays. It happens in February for a week. Many people go skiing or snowboarding. But winter sports are very expensive, that is why not everyone can afford it.\n" +
//                "\n" +
//                "After the winter holidays, there is a spring break. It happens in March and it is the last vacation before the end of the school year. High school students have to study a lot during these holidays because they are just before their school finishing.\n" +
//                "\n" +
//                "The most anticipated moment of the year is summer holidays. These holidays last during two months. Boys and girls often try to work a bit to earn some pocket money.";
//        String massive[] = text.split("\\s+");
//        for (int i = 0; i < massive.length; i++){
//            System.out.println(massive[i]);
//        }
//    }
//}

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
