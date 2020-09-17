package stockmax;

import java.util.List;

public class Result {
    public static long stockmax(List<Integer> prices) {

        long max = prices.get(prices.size() - 1);
        long profit = 0L;

        for (int i = prices.size() - 2; i >= 0; i--) {

            if (prices.get(i) > max) {
                max = prices.get(i);
            } else {
                profit = profit +  max - prices.get(i);
            }
        }

        return profit;
    }
}
