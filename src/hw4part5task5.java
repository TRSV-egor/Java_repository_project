public class hw4part5task5 {


        public static void main(String[] args) {
            String safe = searchAndReplaceDiamonds("Номер кредитной карты <4008 1234 5678> 8912", "***");
            System.out.println(safe);
        }

        public static String searchAndReplaceDiamonds(String text, String
                placeholder){
            String safe = text.replaceAll("<\\d+ \\d+ \\d+>", placeholder);
            return safe;
        }


}
