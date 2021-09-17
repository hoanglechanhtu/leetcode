class Solution {
    public int hammingDistance(int x, int y) {
        int num = x ^ y;
        int total = 0;
        while(num != 0) {
            num = num & num - 1;
            total += 1;
        }
        
        return total;
    }
}
