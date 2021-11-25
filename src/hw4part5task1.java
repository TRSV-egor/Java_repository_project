import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class hw4part5task1 {
    public static void main(String[] args) {
        String text = "Вася заработал 5000 рублей, Петя - 7563 рубля, а Маша - 30000 рублей";
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(text);
        double sum = 0;
        while (matcher.find()) {
            sum += Integer.parseInt(text.substring(matcher.start(), matcher.end()));
        }
        System.out.println("Итого: " + sum);
    }
}
