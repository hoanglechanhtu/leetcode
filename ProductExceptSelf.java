class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] pre = new int[n];
        int[] post = new int[n];
        pre[0] = nums[0];
        post[n - 1] = nums[n - 1];
        for (int i = 0; i < n - 1; i ++) {
            pre[i + 1] = pre[i] * nums[i + 1];
            post[n - i - 2] = post[n - i - 1] * nums[n - i - 2]; 
        }
        
        nums[0] = post[1];
        nums[n - 1] = pre[n - 2];
        for (int i = 1; i < n - 1; i ++) {
            nums[i] = pre[i - 1] * post[i + 1];
        }
        
        return nums;
    }
}
