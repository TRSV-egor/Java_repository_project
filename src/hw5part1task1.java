public class hw5part1task1 {

    public static void main(String[] args) {
        String line = "Каждый охотник желает знать, где сидит фазан";
        //System.out.println(line);
        String[] words = line.split("\\s");

        for (int i = 0; i < words.length; i++) {
            System.out.println(i + " " + words[i]);
        }

        String temp = "";

        for (int index = 0; index < (words.length - 1) / 2; index++) {

            int lastIndex = (words.length - 1) - index;

//            System.out.println("Начальный индекс " + index + " конечный индекс " +
//                    lastIndex);

            temp = words[index];
            words[index] = words[lastIndex];
            words[lastIndex] = temp;

        }

        for (int i = 0; i < words.length; i++) {
            System.out.println(words[i]);
        }
    }

}
