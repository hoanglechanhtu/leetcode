class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] maxs = new int[n];
        maxs[n - 1] = prices[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            maxs[i] = Math.max(prices[i], maxs[i + 1]);
        }
        
        int profit = 0;
        for (int i = 0; i < n; i ++) {
            profit = Math.max(profit, maxs[i] - prices[i]);
        }
        
        return profit;
    }
}

class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int minPrice = Integer.MAX_VALUE;
        int profit = 0;
        for (int i = 0; i < n; i ++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else {
                profit = Math.max(profit, prices[i] - minPrice);
            }
        }
        return profit;
    }
}
