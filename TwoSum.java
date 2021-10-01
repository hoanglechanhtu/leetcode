class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int leftIndex = 0, rightIndex = numbers.length - 1;
        while(leftIndex < rightIndex && numbers[leftIndex] + numbers[rightIndex] != target){
            int sum = numbers[leftIndex] + numbers[rightIndex];
            if (sum > target) {
                rightIndex--;
            } else {
                leftIndex ++;
            }
        }
        
        return new int[]{leftIndex + 1, rightIndex + 1};
    }
}
