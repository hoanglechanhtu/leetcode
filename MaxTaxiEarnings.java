class Solution {

    public long maxTaxiEarnings(int n, int[][] rides) {
        Arrays.sort(rides, Comparator.comparing(ride -> ride[1]));
        int[] dp = new int[n + 1];
        
        for (int[] ride : rides) {
            for (int j = 1; j <= n; j ++) {
                if (j >= ride[1]) {
                    dp[j] = Math.max(dp[j], dp[ride[0]] + ride[1] - ride[0] + ride[2]);
                } 
            }
        }
        
        return dp[n];
    }
}
