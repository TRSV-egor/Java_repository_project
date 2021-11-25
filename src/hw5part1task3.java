public class hw5part1task3 {


 public static void main(String[] args) {
  String[][] theX = {
          {"x", " ", " ", " ", " ", " ", "x"},
          {" ", "x", " ", " ", " ", "x", " "},
          {" ", " ", "x", " ", "x", " ", " "},
          {" ", " ", " ", "x", " ", " ", " "},
          {" ", " ", "x", " ", "x", " ", " "},
          {" ", "x", " ", " ", " ", "x", " "},
          {"x", " ", " ", " ", " ", " ", "x"},
  };

  for (int i = 0; i < theX.length; i++) {

   for (int j = 0; j < theX[i].length; j++) {

    if (j == theX[i].length - 1) {
     System.out.println(theX[i][j]);
    } else {
     System.out.print(theX[i][j]);
    }

   }

  }

 }

}



