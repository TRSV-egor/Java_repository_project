import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class hw4part6task1 {
    public static void main(String[] args) {
        int day = 19;
        int month = 7;
        int year = 1997;

        Calendar calendar = Calendar.getInstance();
        // System.out.println(calendar.getWeekYear());
        // calendar.set(year, month, day);
        // System.out.println(calendar.getTime());
        System.out.println(calendar.getWeekYear() - year);
        // calendar.add(calendar.YEAR, 1);
        // System.out.println(calendar.getWeekYear());

        int age = calendar.getWeekYear() - year;
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy - EEE");

        for (int i = 0; i <= age; i++) {
            calendar.set(year, month, day);
            calendar.add(calendar.YEAR, i);
            System.out.println(i + " - " + dateFormat.format(calendar.getTime()));
        }
    }
}


