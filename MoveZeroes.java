class Solution {
    // 1 3 0 0 12
    //slow 2
    //fast 4 < 5
    public void moveZeroes(int[] nums) {
        int slowPointer = 0;
        int fastPointer = 0;
        
        while(fastPointer < nums.length) {
            if (nums[fastPointer] != 0) {
                swap(nums, slowPointer, fastPointer);
                slowPointer ++;
                fastPointer ++;
            } else {
                fastPointer ++;
            }
        }
    }
    
    void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
