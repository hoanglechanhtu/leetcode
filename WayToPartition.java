class Solution {
    public int waysToPartition(int[] nums, int k) {
        int n = nums.length;
        int total = 0;
        for (int i = -1; i < nums.length; i ++) {
            total = Math.max(total, changeAndGetMax(nums, i, k));
        }
        
        return total;
    }
    
    int changeAndGetMax(int[] nums, int index, int k) {
        int temp = 0;
        if (index != -1) {
            temp = nums[index];
            nums[index] = k;
        }
       
        int n = nums.length;
        int[] preSum = new int[n];
        preSum[0] = nums[0];
        for (int i = 1; i < n; i ++) {
            preSum[i] = preSum[i - 1] + nums[i];
        }
        
        int total = 0;
        for (int i = 0; i < n - 1; i ++) {
            if (preSum[i] == preSum[n - 1] - preSum[i]) {
                total ++;
            }
        }
        
        if (index != -1) 
            nums[index] = temp;
        return total;
        
    }
}
