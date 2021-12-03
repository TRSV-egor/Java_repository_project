import java.lang.reflect.Array;
import java.util.ArrayList;

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
                                    carCode = "";
                                }
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
        //H592BH777

        ArrayList<String> numbers = new ArrayList<>();

        String[] letters = {"С", "М", "Т", "В", "А", "Р", "О", "Н", "Е", "У" };

        //generateNumbersLong(letters, numbers);
        generateNumbersFast(letters, numbers);




    }
}
