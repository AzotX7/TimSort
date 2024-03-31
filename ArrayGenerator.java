package Test_5;

import java.io.*;
import java.util.Random;

public class ArrayGenerator {
    private static final int MIN_ARRAYS = 50;
    private static final int MAX_ARRAYS = 100;
    private static final int MIN_LENGTH = 100;
    private static final int MAX_LENGTH = 10000;
    private static final int MIN_VALUE = -10000;
    private static final int MAX_VALUE = 100000;

    public static void main(String[] args) {
        Random random = new Random();
        int numArrays = random.nextInt(MAX_ARRAYS - MIN_ARRAYS + 1) + MIN_ARRAYS;

        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("arrays.txt"))) {
            for (int i = 0; i < numArrays; i++) {
                int length = random.nextInt(MAX_LENGTH - MIN_LENGTH + 1) + MIN_LENGTH;
                int[] arr = new int[length];
                for (int j = 0; j < length; j++) {
                    arr[j] = random.nextInt(MAX_VALUE - MIN_VALUE + 1) + MIN_VALUE;
                }
                bufferedWriter.write("Длина массива " + length + "\n");
                for (int j = 0; j < length; j++) {
                    bufferedWriter.write(arr[j] + " ");
                }
                bufferedWriter.write("\n");
                }
            }
           catch(IOException e){
        throw new RuntimeException(e);

        }
    }
}
