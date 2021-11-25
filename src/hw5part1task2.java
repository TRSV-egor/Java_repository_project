public class hw5part1task2 {


    public static void main(String[] args) {

        //final int patientsCount = 30;

        final double highTempPatients = 40.0;

        final double lowTempPatients = 32.0;

        final double highTemp = 36.9;

        final double lowTemp = 36.2;

        int healthyPatients = 0;

        float sumTemp = 0;

        float patientsTemp[] = new float[30];

        for (int i = 0; i < patientsTemp.length; i++) {

            float number;

            while (true) {
                number = (float) Math.random() * 100;
                if (number < highTempPatients & number > lowTempPatients) {
                    break;
                } else {
                    continue;
                }
            }
            patientsTemp[i] = number;
            sumTemp += number;
            System.out.print((i+1) + ") " + patientsTemp[i] + "; ");

            if (patientsTemp[i] > lowTemp & patientsTemp[i] < highTemp ){
                healthyPatients++;
            }

        }
        System.out.println();
        System.out.println("Средняя температура в больнице " + (sumTemp / patientsTemp.length) );
        System.out.println("Количество здоровых пациентов " + healthyPatients);

    }
}
