class Solution {
        public int twoCitySchedCost(int[][] costs) {
            int n = costs.length;
            Arrays.sort(costs, Comparator.comparing(x -> x[0] - x[1]));
            int totalCost = 0;
            for (int i = 0; i < n/2; i ++) {
                totalCost += (costs[i][0] + costs[n/2 + i][1]);
            }
            return totalCost;
        }
}
