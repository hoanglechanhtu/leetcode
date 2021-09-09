class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        for (int i = 0; i < gas.length; i ++) {
            if (backtrack(i, gas, cost)) return i;
        }
        return -1;
    }
    
    boolean backtrack(int start, int[] gas, int[] cost) {
        int index = start;
        int curGas = gas[index];
        
        while(curGas >= cost[index]) {
            curGas -= cost[index];
            index ++;
            if (index == gas.length) index = 0;
            if (index == start) return true;
            curGas += gas[index];
        }
        
        return false;
    }
}
