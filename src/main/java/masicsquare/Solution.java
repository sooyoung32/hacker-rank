package masicsquare;

import java.util.Arrays;

public class Solution {
    static int formingMagicSquare(int[][] square) {

        int[][] result01 = {{8,1,6}, {3,5,7}, {4,9,2}};
        int[][] result02 = {{6,1,8}, {7,5,3}, {2,9,4}};
        int[][] result03 = {{4,9,2}, {3,5,7}, {8,1,6}};
        int[][] result04 = {{2,9,4}, {7,5,3}, {6,1,8}};
        int[][] result05 = {{8,3,4}, {1,5,9}, {6,7,2}};
        int[][] result06 = {{4,3,8}, {9,5,1}, {2,7,6}};
        int[][] result07 = {{6,7,2}, {1,5,9}, {8,3,4}};
        int[][] result08 = {{2,7,6}, {9,5,1}, {4,3,8}};

        int[] sum = new int[8];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                sum[0] += Math.abs(square[i][j] - result01[i][j]);
                sum[1] += Math.abs(square[i][j] - result02[i][j]);
                sum[2] += Math.abs(square[i][j] - result03[i][j]);
                sum[3] += Math.abs(square[i][j] - result04[i][j]);
                sum[4] += Math.abs(square[i][j] - result05[i][j]);
                sum[5] += Math.abs(square[i][j] - result06[i][j]);
                sum[6] += Math.abs(square[i][j] - result07[i][j]);
                sum[7] += Math.abs(square[i][j] - result08[i][j]);
            }
        }

        Arrays.sort(sum);

        return sum[0];

    }
}
