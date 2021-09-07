//1 2 3 4 5 6 || k = 3 -> 4 5 6 1 2 3
class Solution {
    public void rotate(int[] nums, int k) {
        reverse(nums, 0, nums.length - k - 1);
        reverse(nums, nums.length - k, nums.length - 1);
        reverse(nums, 0, nums.length - 1);
    }
    
    void reverse(int[] nums, int start, int end) {
        for (int i = 0; i <= (end - start)/2; i ++) {
            int temp = nums[start + i];
            nums[start + i] = nums[end - i];
            nums[end - i] = temp;
        }
    
    }
}
