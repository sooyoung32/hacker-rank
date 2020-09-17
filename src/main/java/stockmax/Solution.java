package stockmax;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File("src/main/java/stockmax/result.txt")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        for (int tItr = 0; tItr < t; tItr++) {
            int n = Integer.parseInt(bufferedReader.readLine().trim());

            String[] pricesTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> prices = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                int pricesItem = Integer.parseInt(pricesTemp[i]);
                prices.add(pricesItem);
            }

            long result = Result.stockmax(prices);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedReader.close();
        bufferedWriter.close();
    }
}
