import java.lang.reflect.Array;
import java.util.*;

public class hw5part5task1 {

    private static void generateNumbersSlow(String[] letters, ArrayList<String> numbers){

        String carCode = "";

        //gen 1st symbol
        for (int firstLetter = 0; firstLetter < letters.length; firstLetter++) {
            //get 2nd symbol
            for (int secondNumber = 0; secondNumber <= 9; secondNumber++) {
                //get 3rd symbol
                for (int thirdNumber = 0; thirdNumber <= 9; thirdNumber++) {
                    //get 4rd symbol
                    for (int forthNumber = 0; forthNumber <= 9; forthNumber++) {

                        if (secondNumber == 0 & thirdNumber == 0 & forthNumber == 0){
                            continue;
                        }

                        //get 5th symbol
                        for (int fifthLetter = 0; fifthLetter < letters.length; fifthLetter++) {
                            //get 6th symbol
                            for (int sixthLetter = 0; sixthLetter < letters.length; sixthLetter++) {

                                for (int region = 1; region <= 95; region++){
                                    carCode = "";
                                    if (region <= 9){
                                        carCode = carCode + letters[firstLetter] + secondNumber + thirdNumber + forthNumber + letters[fifthLetter] + letters[sixthLetter] + "0" + region;
                                        numbers.add(carCode);
                                    } else {
                                        carCode = carCode + letters[firstLetter] + secondNumber + thirdNumber + forthNumber + letters[fifthLetter] + letters[sixthLetter] + region;
                                        numbers.add(carCode);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private static void generateNumbersCorrect(String[] letters, ArrayList<String> numbers) {

        String carCode = "";

        //gen 1st symbol
        for (int firstLetter = 0; firstLetter < letters.length; firstLetter++) {
            //get 2nd - 4th symbol
            for (int stfNumber = 1; stfNumber <= 9; stfNumber++) {
                //get 5th symbol
                for (int fifthLetter = 0; fifthLetter < letters.length; fifthLetter++) {
                    //get 6th symbol
                    for (int sixthLetter = 0; sixthLetter < letters.length; sixthLetter++) {

                        for (int region = 1; region <= 199; region++) {
                            carCode = "";
                            if (region <= 9) {
                                carCode = carCode + letters[firstLetter] + stfNumber + stfNumber + stfNumber + letters[fifthLetter] + letters[sixthLetter] + "0" + region;
                                numbers.add(carCode);

                            } else {
                                carCode = carCode + letters[firstLetter] + stfNumber + stfNumber + stfNumber + letters[fifthLetter] + letters[sixthLetter] + region;
                                numbers.add(carCode);

                            }

                        }
                    }
                }
            }
        }


    }

    private static void generateNumbersFast(String[] letters, ArrayList<String> numbers) {

        String carCode = "";

        for (int letter = 0; letter < letters.length; letter++) {

            for (int number = 1; number <= 9; number++) {

                for (int region = 1; region <= 95; region++) {
                    carCode = "";
                    if (region <= 9) {
                        carCode = carCode + letters[letter] + number + number + number + letters[letter] + letters[letter] + "0" + region;
                        numbers.add(carCode);
                        System.out.println(carCode);
                    } else {
                        carCode = carCode + letters[letter] + number + number + number + letters[letter] + letters[letter] + region;
                        numbers.add(carCode);
                        System.out.println(carCode);
                    }
                    carCode = "";
                }
            }
        }
    }

    public static void main(String[] args) {
        //CMTBAPOHEY
        //У666ОР109

        ArrayList<String> numbers0 = new ArrayList<>();
        HashSet<String> numbers1 = new HashSet<>();
        TreeSet<String> numbers2 = new TreeSet<>();

        String[] letters = {"С", "М", "Т", "В", "А", "Р", "О", "Н", "Е", "У" };

        //generateNumbersLong(letters, numbers0);
        //generateNumbersFast(letters, numbers0);
        generateNumbersCorrect(letters, numbers0);

        Collections.sort(numbers0);
        numbers1.addAll(numbers0);
        numbers2.addAll(numbers1);

        Scanner scanner = new Scanner(System.in);

        System.out.println(numbers0.size());

        while (true){
            System.out.print("Введите номер : ");
            String numberString = scanner.next();

            //Прямой поиск
            System.out.print("Поиск перебором: ");
            long start = System.nanoTime();
            if (numbers0.contains(numberString)) {
                System.out.print("номер найден, ");
            } else {
                System.out.print("номер не найден, ");
            }
            System.out.println("поиск занял " + (System.nanoTime()- start) + " нс");

            //Бинарный поиск
            System.out.print("Бинарный поиск: ");

            start = System.nanoTime();

            int index = Collections.binarySearch(numbers0, numberString);

            if (index > 0) {
                System.out.print("номер найден, ");
            } else {
                System.out.print("номер не найден, ");
            }
            System.out.println("поиск занял " + (System.nanoTime()- start) + " нс");

            //Поиск в HashSet
            System.out.print("Поиск в HashSet: ");

            start = System.nanoTime();

            if (numbers1.contains(numberString)) {
                System.out.print("номер найден, ");
            } else {
                System.out.print("номер не найден, ");
            }
            System.out.println("поиск занял " + (System.nanoTime() - start) + " нс");

            //Поиск в TreeSet
            System.out.print("Поиск в TreeSet: ");

            start = System.nanoTime();

            if (numbers2.contains(numberString)) {
                System.out.print("номер найден, ");
            } else {
                System.out.print("номер не найден, ");
            }
            System.out.println("поиск занял " + (System.nanoTime() - start) + " нс");

            break;
        }


    }
}
