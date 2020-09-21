package largestpermutation;

//https://www.hackerrank.com/challenges/largest-permutation/problem
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the largestPermutation function below.
    static int[] largestPermutation(int k, int[] arr) {

        int[] index = new int[arr.length+1];

        for (int i = 0; i < arr.length; ++i) {
            index[arr[i]] = i;
        }

        int count = 0;
        for (int i=0; i < arr.length; ++i) {
            if (count == k) {
                break;
            }

            if (arr[i] == arr.length - i) {
                continue;
            }

            int maxIndex = index[arr.length - i];

            index[arr[i]] = index[arr.length - i];
            index[arr.length - i] = i;

            int maxValue = arr[maxIndex];
            arr[maxIndex] = arr[i];
            arr[i] = maxValue;

            count++;
        }

// timeout
//        for (int i = 0; i < arr.length -1; i++) {
//            int max = arr[i];
//            int maxIndex = i;
//
//            if (sorted[sorted.length-1-i] == max) {
//                continue;
//            }
//
//            for (int j = i; j < arr.length - 1; j++) {
//
//                if (max < arr[j+1]) {
//                    max = arr[j+1];
//                    maxIndex = j+1;
//                }
//            }
//
//            if (max > arr[i]) {
//                int tmp = arr[i];
//                arr[i]  = max;
//                arr[maxIndex] = tmp;
//                count++;
//            }
//
//            if (count == k) {
//                break;
//            }
//        }
        return arr;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File("src/main/java/largestpermutation/result.txt")));

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

        int[] result = largestPermutation(k, arr);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
