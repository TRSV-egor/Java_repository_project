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
        //??666????109

        ArrayList<String> numbers0 = new ArrayList<>();
        HashSet<String> numbers1 = new HashSet<>();
        TreeSet<String> numbers2 = new TreeSet<>();

        String[] letters = {"??", "??", "??", "??", "??", "??", "??", "??", "??", "??" };

        //generateNumbersLong(letters, numbers0);
        //generateNumbersFast(letters, numbers0);
        generateNumbersCorrect(letters, numbers0);

        Collections.sort(numbers0);
        numbers1.addAll(numbers0);
        numbers2.addAll(numbers1);

        Scanner scanner = new Scanner(System.in);

        System.out.println(numbers0.size());

        while (true){
            System.out.print("?????????????? ?????????? : ");
            String numberString = scanner.next();

            //???????????? ??????????
            System.out.print("?????????? ??????????????????: ");
            long start = System.nanoTime();
            if (numbers0.contains(numberString)) {
                System.out.print("?????????? ????????????, ");
            } else {
                System.out.print("?????????? ???? ????????????, ");
            }
            System.out.println("?????????? ?????????? " + (System.nanoTime()- start) + " ????");

            //???????????????? ??????????
            System.out.print("???????????????? ??????????: ");

            start = System.nanoTime();

            int index = Collections.binarySearch(numbers0, numberString);

            if (index > 0) {
                System.out.print("?????????? ????????????, ");
            } else {
                System.out.print("?????????? ???? ????????????, ");
            }
            System.out.println("?????????? ?????????? " + (System.nanoTime()- start) + " ????");

            //?????????? ?? HashSet
            System.out.print("?????????? ?? HashSet: ");

            start = System.nanoTime();

            if (numbers1.contains(numberString)) {
                System.out.print("?????????? ????????????, ");
            } else {
                System.out.print("?????????? ???? ????????????, ");
            }
            System.out.println("?????????? ?????????? " + (System.nanoTime() - start) + " ????");

            //?????????? ?? TreeSet
            System.out.print("?????????? ?? TreeSet: ");

            start = System.nanoTime();

            if (numbers2.contains(numberString)) {
                System.out.print("?????????? ????????????, ");
            } else {
                System.out.print("?????????? ???? ????????????, ");
            }
            System.out.println("?????????? ?????????? " + (System.nanoTime() - start) + " ????");

            break;
        }


    }
}
