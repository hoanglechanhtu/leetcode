class Solution {
    public int sumOfBeauties(int[] nums) {
        int[] minArr = new int[nums.length];
        int[] maxArr = new int[nums.length];
        
        maxArr[0] = 0;
        minArr[nums.length - 1] = 100001;
        for (int i = 1; i < nums.length; i ++) {
            maxArr[i] = Math.max(maxArr[i - 1], nums[i - 1]);
        }
        
        for (int i = nums.length - 2; i >= 0; i --) {
            minArr[i] = Math.min(minArr[i + 1], nums[i + 1]);
        }
        
        int total = 0;
        for (int i = 1; i < nums.length - 1; i ++) {
            if (nums[i] > maxArr[i] && nums[i] < minArr[i]) total += 2;
            else if (nums[i] > nums[i - 1] && nums[i] < nums[i + 1]) total += 1;
        }
        
        return total;
    }
}
