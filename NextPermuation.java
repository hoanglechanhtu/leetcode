//Find the first descending order sub array from right to left.(pivot is the number that break descending order)
//Reverse it to make it become smallest permutation of this sub array
//Then swap the last number that greater than pivot and pivot from right to left.

class Solution {
    //1 2 3
    public void nextPermutation(int[] nums) {
        int index = nums.length - 1;
        while(index > 0 && nums[index - 1] >= nums[index]) {
            index --;
        }

        reverse(nums, index);
        if (index == 0) return;
        
        int cur = index - 1;
        
        while(nums[cur] >= nums[index]) {
            index ++;
        }
        
        swap(nums, cur, index);
        
    }
    
    void reverse(int[] nums, int from) {
        for (int i = 0; i < (nums.length - from) / 2; i ++) {
            swap(nums, from + i, nums.length - i - 1);
        }
    }
    
    void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
