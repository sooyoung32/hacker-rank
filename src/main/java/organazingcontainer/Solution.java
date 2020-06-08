package organazingcontainer;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the organizingContainers function below.
    static String organizingContainers(int[][] container) {
        int size = container.length;
        int[] containerSumArr =  new int[size];
        int[] ballTypeSumArr =  new int[size];

        for (int i = 0; i < size; i++) {
            int containerSum = 0;
            int ballTypeSum = 0;
            for (int j = 0; j < size; j++) {
                containerSum += container[i][j];
                ballTypeSum += container[j][i];

            }
            containerSumArr[i] = containerSum;
            ballTypeSumArr[i] = ballTypeSum;

        }

        Arrays.sort(containerSumArr);
        Arrays.sort(ballTypeSumArr);

        if (Arrays.equals(containerSumArr, ballTypeSumArr)) {
            return "Possible";
        } else {
            return "Impossible";
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File("src/main/java/organazingcontainer/result.txt")));


        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[][] container = new int[n][n];

            for (int i = 0; i < n; i++) {
                String[] containerRowItems = scanner.nextLine().split(" ");
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                for (int j = 0; j < n; j++) {
                    int containerItem = Integer.parseInt(containerRowItems[j]);
                    container[i][j] = containerItem;
                }
            }

            String result = organizingContainers(container);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
