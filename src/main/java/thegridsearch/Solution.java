package thegridsearch;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {

    // Complete the gridSearch function below.
    static String gridSearch(String[] G, String[] P) {

        int width = G[0].length() - P[0].length() +1;
        int height = G.length - P.length +1 ;
        if (G.length == P.length) {
            height = G.length;
        }

        int widthIndex = 0;
        int heightIndex = 0;
        int patternRow = 0;
        int hasCount = 0;

        boolean isFirstPattern = true;

        for (int i = 0; i < height; i++) {
            while (widthIndex <= width) {
                int rowIndex = G[i].indexOf(P[patternRow], widthIndex);
                if (rowIndex >= 0) {
                    if (isFirstPattern) {
                        isFirstPattern = false;
                        widthIndex = rowIndex;
                        heightIndex = i;
                    }
                    if (widthIndex == rowIndex) {
                        patternRow++;
                        hasCount++;
                    } else {
                        patternRow = 0;
                        hasCount = 0;
                        i = -1;
                        widthIndex++;
                        isFirstPattern = true;
                        break;
                    }
                } else {
                    patternRow = 0;
                    hasCount = 0;
                    i = heightIndex++;
                    isFirstPattern = true;
                }
                break;
            }

            if (hasCount == P.length) {
                return "YES";
            }

            if (widthIndex == width || height == heightIndex) {
                break;
            }
        }

        return "NO";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File("src/main/java/thegridsearch/result.txt")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String[] RC = scanner.nextLine().split(" ");

            int R = Integer.parseInt(RC[0]);

            int C = Integer.parseInt(RC[1]);

            String[] G = new String[R];

            for (int i = 0; i < R; i++) {
                String GItem = scanner.nextLine();
                G[i] = GItem;
            }

            String[] rc = scanner.nextLine().split(" ");

            int r = Integer.parseInt(rc[0]);

            int c = Integer.parseInt(rc[1]);

            String[] P = new String[r];

            for (int i = 0; i < r; i++) {
                String PItem = scanner.nextLine();
                P[i] = PItem;
            }

            String result = gridSearch(G, P);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
