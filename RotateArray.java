//1 2 3 4 5 6 || k = 3 -> 4 5 6 1 2 3
class Solution {
    public void rotate(int[] nums, int k) {
        k = k % n;
        int[] copyArray = new int[nums.length];
        Arrays.copy(nums, copyArray);
        for (int i = 0; i < nums.length; i ++){
            nums[i] = copyArray[i - k >= 0 ? i - k : nums.length + (i - k) - 1];
        }
    }
}
