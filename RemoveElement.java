class Solution {
    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) return 0;
        int left = 0, right = nums.length - 1;
        while(left < right){
            while (right > left && nums[right] == val) {
                right --;
            }
            
            while(left < right && nums[left] != val) {
                left ++;
            }
            
            swap (nums, left, right);
            
        }
    
        return nums[left] == val ? 0 : left + 1;
    }
    
    void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
