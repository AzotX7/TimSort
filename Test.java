package Test_5;

import java.io.*;

public class Test {
    public static void main(String[] args) {
        try(BufferedReader reader = new BufferedReader(new FileReader("arrays.txt"));
            BufferedWriter sortedWriter = new BufferedWriter(new FileWriter("sortedArrays.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("Длина массива ")) {
                    int length = Integer.parseInt(line.substring("Длина массива ".length()));
                    int[] arr = new int[length];
                    int index = 0;
                    line = reader.readLine();
                    String[] numbers = line.split(" ");
                    for (String number : numbers) {
                        arr[index++] = Integer.parseInt(number);
                    }

                    long start = System.nanoTime();
                    int iterations = TimSort.timSort(arr, length);
                    long end = System.nanoTime();
                    long time = (end - start) / 1000;

                    sortedWriter.write("Длина " + length + "\n");
                    for (int j = 0; j < length; j++) {
                        sortedWriter.write(arr[j] + " ");
                    }
                    sortedWriter.write("\n");
                    sortedWriter.write("Time " + time + "\n");
                    sortedWriter.write("Iterations " + iterations + "\n");
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
