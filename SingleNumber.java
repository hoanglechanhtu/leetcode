class Solution {
    public int singleNumber(int[] nums) {
        int value = nums[0];
        for (int i = 1; i < nums.length; i ++) {
            value = value ^ nums[i];
        }
        return value;

    }
}
