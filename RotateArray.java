//1 2 3 4 5 6 || k = 3 -> 4 5 6 1 2 3
class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        for (int i = 0; i < k; i ++) {
            int tempCur = nums[0];
            int last = nums[nums.length - 1];
            for (int j = 1; j < nums.length; j ++) {
                int temp = nums[j];
                nums[j] = tempCur;
                tempCur = temp;
            }
            nums[0] = last;
        }
    }
}
