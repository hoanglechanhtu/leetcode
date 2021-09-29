class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int[] res = new int[]{-1, -1};
        if (nums.length == 0) return res;
        while(left < right) {
            int middle = (left + right)/2;
            
            if (nums[middle] < target) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }
        if (nums[left] == target) res[0] = left;
        left = 0;
        right = nums.length - 1;
        
         while(left < right) {
            int middle = (left + right + 1)/2;
            
            if (nums[middle] > target) {
                right = middle - 1;
            } else {
                left = middle;
            }
        }
        
        if (nums[left] == target) res[1] = left;
        
        return res;
        
    }
}
