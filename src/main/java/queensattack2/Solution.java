package queensattack2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the queensAttack function below.
    // n = 보드 판 수
    // k = 장애물 수
    // r_q = 여왕의 row num
    // c_q = 여왕의 column num
    // obstacles = 장애물의 이차 배열
    static int queensAttack(int n, int k, int x, int y, int[][] obstacles) {

        int result = 0;
        Map<String,String> obstaclesMap = convertObstacles(obstacles);


        // 오른쪽으로
        for (int i = 1; i < n; i++) {

            if (y == n) {
                break;
            }

            int right = y + i;

            if (hasObstacles(x, right, obstaclesMap)) {
                break;
            } else {
                result++;
            }

            if (right == n) {
                break;
            }
        }

        //왼쪽으로
        for (int i = 1; i < n; i++) {

            if (y == 1 ){
                break;
            }

            int left = y - i;


            if (hasObstacles(x, left, obstaclesMap)) {
                break;
            } else {
                result++;
            }

            if (left == 1) {
                break;
            }
        }

        //위로
        for (int i = 1; i < n; i++) {
            if (x == n) {
                break;
            }

            int up = x + i;

            if (hasObstacles(up, y, obstaclesMap)) {
                break;
            } else {
                result++;
            }

            if (up == n) {
                break;
            }
        }

        //아래로
        for (int i = 1; i < n; i++) {
            if (x == 1) {
                break;
            }

            int down = x - i;

            if (hasObstacles(down, y, obstaclesMap)) {
                break;
            } else {
                result++;
            }

            if (down == 1) {
                break;
            }
        }


        //대각선 오른쪽 위로
        for (int i = 1; i < n; i++) {
            if (x == n || y == n) {
                break;
            }

            int left = x + i;
            int right = y + i;


            if (hasObstacles(left, right, obstaclesMap)) {
                break;
            } else {
                result++;
            }

            if (left == n || right == n) {
                break;
            }
        }

        //대각선 왼쪽 위로
        for (int i = 1; i < n; i++) {
            if (x == n || y == 1) {
                break;
            }

            int left = x + i;
            int right = y - i;


            if (hasObstacles(left, right, obstaclesMap)) {
                break;
            } else {
                result++;
            }

            if (left == n || right == 1) {
                break;
            }
        }


        //대각선 왼쪽 아래
        for (int i = 1; i < n; i++) {
            if (x == 1 || y == 1) {
                break;
            }

            int left = x - i;
            int right = y - i;


            if (hasObstacles(left, right, obstaclesMap)) {
                break;
            } else {
                result++;
            }

            if (left == 1 || right == 1) {
                break;
            }
        }

        //대각선 오른쪽 아래
        for (int i = 1; i < n; i++) {
            if ( x == 1 || y == n) {
                break;
            }

            int left = x - i;
            int right = y + i;


            if (hasObstacles(left, right, obstaclesMap)) {
                break;
            } else {
                result++;
            }

            if (left == 1 || right == n) {
                break;
            }
        }

        return result;
    }




    private static Map<String,String> convertObstacles(int[][] obstacles) {
        Map<String, String> map = new HashMap<>();

        for (int i = 0; i < obstacles.length; i++) {
            String key = "";
            for (int j = 0; j < obstacles[i].length; j++) {
                int num = obstacles[i][j];
                key += num;
                if (j != 1) {
                    key += "-";
                }
            }
            map.putIfAbsent(key, key);
        }
        return map;
    }

    private static boolean hasObstacles(int x, int y, Map<String, String> obstacles) {
        String key = ""+x+"-"+y;

        if (Objects.isNull(obstacles.get(key))) {
            return false;
        }
        return true;
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File("src/main/java/queensattack2/result.txt")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        String[] r_qC_q = scanner.nextLine().split(" ");

        int r_q = Integer.parseInt(r_qC_q[0]);

        int c_q = Integer.parseInt(r_qC_q[1]);

        int[][] obstacles = new int[k][2];

        for (int i = 0; i < k; i++) {
            String[] obstaclesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 2; j++) {
                int obstaclesItem = Integer.parseInt(obstaclesRowItems[j]);
                obstacles[i][j] = obstaclesItem;
            }
        }

        int result = queensAttack(n, k, r_q, c_q, obstacles);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}