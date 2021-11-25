public class hw4part5task2 {
    public static void main(String[] args) {
        String text = "Abroad the school year begins in September; they call this moment like ‘back to school’." +
                "The first holidays start at the end of October. Students and their teachers have two weeks of having a rest.\n " + "\n" +
                "Then it is time for Christmas holidays. Christmas is a very important " +
                "holiday in Europe and USA.All the family members meet together.They can see " +
                "their parents, grandparents, uncles and aunts, cousins, and so on.The " +
                "holiday meal lasts for a long time and they exchange gifts on the 25 th of " +
                "December.They have a vacation to have time to meet up with family.There are " +
                "almost two weeks for it.\n " +
                "\n" +
                "In winter there are also winter holidays; these holidays are different from " +
                "Christmas holidays.It happens in February for a week.Many people go skiing " +
                "or snowboarding.But winter sports are very expensive, that is why not " +
                "everyone can afford it.\n " +
                "\n" +
                "After the winter holidays, there is a spring break. It happens in March and " +
                "it is the last vacation before the end of the school year.High school " +
                "students have to study a lot during these holidays because they are just " +
                "before their school finishing.\n " +
                "\n" +
                "The most anticipated moment of the year is summer holidays. These holidays " +
                "last during two months.Boys and girls often try to work a bit to earn some " +
                "pocket money.";
        String massive[] = text.split("\\s+");
        for (int i = 0; i < massive.length; i++) {
            System.out.println(massive[i]);
        }
    }
}
