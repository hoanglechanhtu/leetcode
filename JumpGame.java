class Solution {
    public boolean canJump(int[] nums) {
        int N = nums.length;
        int lastIndex = N - 1;
        for (int i = N - 2; i >= 0; i --) {
            if (lastIndex - i <= nums[lastIndex]) lastIndex = i;
        }
        
        return lastIndex == 0;
    }
}
