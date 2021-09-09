class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        //If u start at i, and get failure a j, then for every k that i < k < j, k will be fail at j too.
        int start = 0;
        int index = 0;
        int nCheck = 0;

        boolean isStop = false;
        while(nCheck < gas.length) {
            start = index; 
            int curGas = 0;
            while(curGas >= 0) {
                nCheck ++; 
                curGas += gas[index]; 
                curGas -= cost[index]; 
                index ++; 
                if (index == gas.length) index = 0; 
                if (curGas >= 0 && index == start) return start;
            }
                    
            
        }
        
        return -1;
    }
    
   
}
