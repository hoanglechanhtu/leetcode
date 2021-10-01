class Solution {
    public int[] sortedSquares(int[] nums) {
        if (nums.length == 0) return nums;
      
        int[] res = new int[nums.length];
        
        int index = 0;
        while (index < nums.length && nums[index] < 0) {
            index ++;
        }
        
        int leftStart = index - 1, leftIndex = index - 1;
        int rightRight = index, rightIndex = index;
        
        while(leftIndex >= 0 && rightIndex < nums.length) {
            if (square(nums[leftIndex]) < square(nums[rightIndex])) {
                res[rightIndex - rightRight + leftStart - leftIndex] = square(nums[leftIndex]);
                leftIndex--;
            } else {
                res[rightIndex - rightRight + leftStart - leftIndex] = square(nums[rightIndex]);
                rightIndex++;
            }
        }
        
        while(leftIndex >= 0) {
            res[rightIndex - rightRight + leftStart - leftIndex] = square(nums[leftIndex]);
            leftIndex--;
        }
        
        while(rightIndex < nums.length) {
            res[rightIndex - rightRight + leftStart - leftIndex] = square(nums[rightIndex]);
            rightIndex++;   
        }
        
        return res;
        
    }
    
    int square(int num) {
        return num * num;
    }
}
