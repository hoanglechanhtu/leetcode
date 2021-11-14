class Solution {
    public int findDuplicate(int[] nums) {
        return find(nums, 0, nums.length - 1);
    }
    
    int find(int[] nums, int left, int right) {
        if (left >= right) return nums[left];
        int p = partial(nums, left, right);
        if (p + 1 <= nums[p]) {
            return find(nums, p + 1, right);
        } else {
            return find(nums, left, p - 1);
        }
    }
    int partial(int[] nums, int left, int right) {
        int pivot = nums[right];
        int j = left;
        for (int i = left; i < right; i ++) {
            if (nums[i] <= pivot) {
                swap(nums, i, j);
                j ++;
            } 
        }
        swap(nums, j, right);
        return j;
    }
    
    void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
