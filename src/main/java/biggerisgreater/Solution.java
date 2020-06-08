package biggerisgreater;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    private static final int EQUAL = 0;
    private static final int BIGGER = 1;
    private static final int SMALLER = -1;


    // Complete the biggerIsGreater function below.
    static String biggerIsGreater(String w) {
        String[] array = w.split("");

        for (int i = array.length-1; i >0; i--) {
            String character = array[i];
            String preCharacter = array[i-1];

            if (character.compareTo(preCharacter) >= BIGGER) {
                array[i] = preCharacter;
                array[i-1] = character;
                break;
            } else if (character.compareToIgnoreCase(preCharacter) == SMALLER) {
                continue;
            }

        }


        return Arrays.toString(array);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File("src/main/java/biggerisgreater/result.txt")));

        int T = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int TItr = 0; TItr < T; TItr++) {
            String w = scanner.nextLine();

            String result = biggerIsGreater(w);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }


}
