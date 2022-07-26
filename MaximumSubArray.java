class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length][nums2.length];
        int max = 0;
        for (int i = 0; i < nums1.length; i ++) {
            for (int j = 0; j < nums2.length; j ++) {
                if (nums1[i] == nums2[j]) {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    }
                    max = Math.max(max, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return max;
    }
}

class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i ++) {
           int curSum = 0;
           for (int j = i; j < n; j ++) {
               curSum += nums[j];
               max = Math.max(max, curSum);
           }
        }
        return max;
    }
}

class Solution {
    public int maxSubArray(int[] nums) {
        return findBestSubArray(nums, 0, nums.length - 1);
    }
    
    int findBestSubArray(int[] nums, int left, int right) {
        if (left > right) return Integer.MIN_VALUE;
        
        int middle = (left + right)/2;
        
        int curSum = 0;
        int maxRightSum = 0;
        for (int i = middle + 1; i <= right; i ++) {
            curSum += nums[i];
            maxRightSum = Math.max(maxRightSum, curSum);
        }
        
        curSum = 0;
        int maxLeftSum = 0;
        for (int i = middle - 1; i >= left; i --) {
            curSum += nums[i];
            maxLeftSum = Math.max(maxLeftSum, curSum);
        }
        
        int sum = nums[middle] + maxRightSum + maxLeftSum;
        
        int leftSum = findBestSubArray(nums, left, middle - 1);
        int rightSum = findBestSubArray(nums, middle + 1, right);
        
        return Math.max(Math.max(leftSum, rightSum), sum);
    }
}

class Solution {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int cur = 0;
        for (int i = 0; i < nums.length; i ++) {
            cur += nums[i];
            max = Math.max(max, cur);
            if (cur < 0) {
                cur = 0;
            }
        }
        return max;
    }
}
