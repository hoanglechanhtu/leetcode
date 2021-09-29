class Solution {
    public int searchInsert(int[] nums, int target) {
        if (nums[0] > target) return 0;
        if (nums[nums.length - 1] < target) return nums.length;
        int left = 0, right = nums.length - 1;
        while(left < right) {
            int middle = (left + right)/2;
            if (nums[middle] < target) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }
        
        return left;
    }
}
