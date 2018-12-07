import java.time.*;


public class PseudoRandomNumberGenerator {

    public static void main (String[] argc) {

        Instant now = Instant.now();
        double seed = now.toEpochMilli();              //seed initialized with ms from a specific date
        int times = 1000;                               // number of repetitions
        generatePseudoRandomNumbers(seed, times);
    }

    public static void generatePseudoRandomNumbers(double actual, int repetitions) {        //main function, generates pseudo random numbers and
                                                                                            //stores them in array "results"
        int[] results = new int[repetitions];
        int[] intensity = new int[10];
        for(int i = 0; i < repetitions; i++) {
            double nextNumber = Math.pow(7,5)* actual % (Math.pow(2,31)- 1);    //algorithm to generate next pseudo random number
            actual = nextNumber;
            int singleResult = (int)(101*(actual / (Math.pow(2,31) - 2)));      //equation to shrink random numbers in a little range (0..100 in this case)
            results[i]=singleResult;
            populateIntensityArray(singleResult, intensity);
        }
        printValuesIntensity(intensity);
        }



    public static void populateIntensityArray(int value, int[] intensity) {                 //used to populate array "intensity" to test variance
        if (value < 11)
            intensity[0]++;
        else if (value < 21)
            intensity[1]++;
        else if (value < 31)
            intensity[2]++;
        else if (value < 41)
            intensity[3]++;
        else if (value < 51)
            intensity[4]++;
        else if (value < 61)
            intensity[5]++;
        else if (value < 71)
            intensity[6]++;
        else if (value < 81)
            intensity[7]++;
        else if (value < 91)
            intensity[8]++;
        else if (value < 101)
            intensity[9]++;
    }

    public static void printValuesIntensity(int[] array) {                                  //prints the values of array "intensity"
        for (int i = 0; i < 10; i++) {
            System.out.println(array[i]);
        }
    }
}
