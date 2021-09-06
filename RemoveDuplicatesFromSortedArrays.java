class Solution {
    public int removeDuplicates(int[] nums) {
      int fastPointer = 0;
      int slowPointer = 0;
      while(fastPointer < nums.length ){
        if (nums[fastPointer] == nums[slowPointer]) {
          fastPointer ++;
        } else {
          swap(nums, slowPointer + 1, fastPointer);
          slowPointer ++;
          fastPointer ++;
        }
      }
      
      return slowPointer + 1;
   
    }
    void swap(int[] nums, int a, int b){
      int temp = nums[a];
      nums[a] = nums[b];
      nums[b] = temp;
    }
}
