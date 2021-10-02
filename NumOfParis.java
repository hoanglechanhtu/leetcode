class Solution {
    public int numOfPairs(String[] nums, String target) {
        int total = 0;
        for (int i = 0; i < nums.length; i ++) {
            for (int j = i + 1; j < nums.length; j ++) {
                String s = nums[i] + nums[j];
                String revS = nums[j] + nums[i];
                if (s.equals(target)) total ++;
                if (revS.equals(target)) total ++;
            }
        }
        
        return total;
    }
}
