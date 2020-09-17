package goodlandelectricity;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
    //https://www.hackerrank.com/challenges/pylons/problem
    static int pylons(int k, int[] arr) {

        int range = k - 1;
        int result = 0;
        int index = range;
        int lastCoveredIndex = -1;

        while (index < arr.length) {

            if (arr[index] == 1) {

                lastCoveredIndex = index;
                int coveredCount = index + range;

                index = index + (2 * k) - 1;
                if (index >= arr.length) {
                    index = arr.length - 1;
                }

                result++;

                if (coveredCount >= arr.length - 1) {
                    break;
                }

            } else {
                index--;
                if (index <= lastCoveredIndex) {
                    return -1;
                }
            }
        }
        return result;
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File("src/main/java/goodlandelectricity/result.txt")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int result = pylons(k, arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
