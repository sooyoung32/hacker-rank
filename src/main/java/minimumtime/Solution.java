package minimumtime;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
    // Complete the minTime function below.
    static long minTime(long[] machines, long goal) {
        Arrays.sort(machines);
        long min = machines[0];
        long max = machines[machines.length-1];
        long estimatedMaxDay = max * goal / machines.length;
        long estimatedMinDay = min * goal / machines.length;

        long minDay = 0;

        while (estimatedMinDay <= estimatedMaxDay) {

            long midDay = (estimatedMaxDay + estimatedMinDay) / 2;

            long item = 0;
            for (Long value : machines) {
                long quotient = midDay / value;
                item  = item + quotient;
            }

            if (item >= goal) {
                minDay = midDay;
                estimatedMaxDay = midDay -1;

            } else if (item < goal) {
                estimatedMinDay = midDay +1;
            }
        }
        return minDay;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("src/main/java/minimumtime/result.txt")));

        String[] nGoal = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nGoal[0]);

        long goal = Long.parseLong(nGoal[1]);

        long[] machines = new long[n];

        String[] machinesItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            long machinesItem = Long.parseLong(machinesItems[i]);
            machines[i] = machinesItem;
        }

        long ans = minTime(machines, goal);

        bufferedWriter.write(String.valueOf(ans));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}