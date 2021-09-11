//This exercise is similar to https://github.com/hoanglechanhtu/leetcode/blob/main/LongestRepeatingCharacter.java
//The main difference is, in this excercise, the map only contains 2 values, one and zero, and the left pointer maybe go pass the right pointer, so we have to handle this case
//HashMap and sliding window
//Key words: max, consecutives

//We can use prefix sum and binary search to solve this problem.
//Let p(x) is the sum from 0 to x. Then with x, y, x >= y, x - y - (P(x) - P(y)) will be the number of zero from x to y.Our objective is maximizing the window(x - y)
//For each x, the candidate y is from 0: x, and if x - y - (P(x) - P(y)) <= k, we can safely ignore any k that y < k < x, because the number of zero from k to y always
//less then in from y to x.
//Because of that, we can use binary search, 
class Solution {
    public int longestOnes(int[] nums, int k) {
        int nZero = 0;
        int nOne = 0;
        
        int left = 0;
        int right = 0;
        if (nums[left] == 0) nZero ++;
        else nOne ++;
        
        int max = nOne;
        while (left <= right && right < nums.length) {
            if (nZero <= k) {
                max = Math.max(max, right - left + 1);
                right ++;
                if (right < nums.length) {
                    if (nums[right] == 0) nZero ++;
                    else nOne ++;
                }
            } else {
                if (nums[left] == 0) nZero --;
                else nOne --;
                
                left ++;
                if (left > right) {
                    right ++;
                    if (right < nums.length) {
                        if (nums[right] == 0) nZero ++;
                        else nOne ++;
                    }
                }
            }
        }
        
        return max;
    }
}
