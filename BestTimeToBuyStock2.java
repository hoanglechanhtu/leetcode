class Solution {
    // prices = [7,1,5,3,6,4]
    //slowP 5
    //fastP 6   < 6
    //profit 0 + 5 - 1 + 6 - 3 = 7
    public int maxProfit(int[] prices) {
        int profit = 0;
        int slowP = 0;
        int fastP = 1;
        while(fastP < prices.length){
            if (prices[fastP] < prices[fastP - 1]) {
                //sell stock the day before
                profit += prices[fastP - 1] - prices[slowP];
                slowP = fastP;
                fastP ++;
            } else {
                fastP ++;
            }
        }
        profit += prices[fastP - 1] - prices[slowP];
        return profit;
    }
}
