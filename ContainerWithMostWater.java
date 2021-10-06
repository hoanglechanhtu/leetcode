class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int total = (right - left) * Math.min(height[left], height[right]);
        while (left < right) {
            if (height[left] < height[right]) {
                int min = height[left];
                while(left < right && height[left] <= min) {
                    left ++;
                }
                total = Math.max(total, (right - left) * Math.min(height[left], height[right]));
            } else {
                int min = height[right];
                while(right > left && height[right] <= min) {
                    right --;
                }
                total = Math.max(total, (right - left) * Math.min(height[left], height[right]));
            }
            
        }
        
        return total;
    }
}
