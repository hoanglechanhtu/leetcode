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

class Solution {
    
    public boolean canJump(int[] nums) {
        boolean dp[] = new boolean[nums.length];
        Arrays.fill(dp, false);
        dp[0] = true;
        for (int i = 0; i < nums.length; i ++) {
            if (!dp[i]) break;
            for (int k = nums[i]; k > 0; k--) {
                if (i + k < nums.length) {
                    if (dp[i + k]) continue;
                    else dp[i + k] = true;
                }
            }
        }
        
        return dp[nums.length - 1];
    }
}
