
class Solution {
    public long interchangeableRectangles(int[][] rectangles) {
        
        for (int i = 0; i < rectangles.length; i ++) {
            int gcd = gcd(rectangles[i][0], rectangles[i][1]);
            rectangles[i][0] = rectangles[i][0] / gcd;
            rectangles[i][1] = rectangles[i][1] / gcd;
        }
        
        Arrays.sort(rectangles, (x, y) -> x[0] != y[0] ? x[0] - y[0] : x[1] - y[1]);
        
        long total = 0;
        int left = 0, right = 0;
        while (right < rectangles.length) {
            while(right < rectangles.length && rectangles[left][0] == rectangles[right][0] && rectangles[left][1] == rectangles[right][1]){
                right ++;
            }
            total += total(right - left);
            left = right;
        }
        
        return total;
    }
    
    int gcd(int x, int y){
        if (x == 0) return y;
        return gcd(y % x, x);
    }
    
    long total(int n){
        return n * (n - 1)/2L;
    }
}
