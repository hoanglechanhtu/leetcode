class Solution {
    public int nextBeautifulNumber(int n) {
        for (int i = n + 1; i < Integer.MAX_VALUE; i ++) {
            if (isBalanced(i)) return i;
        }
        return n;
    }
    
    boolean isBalanced(int n) {
        int[] count = new int[10];
        
        while(n != 0){
            count[n % 10] ++;
            n = n / 10;
        }
        for (int i = 0; i < 10; i ++) {
            if (i == 0 && count[i] != 0) return false;
            if (i != 0 && count[i] != i && count[i] != 0) return false;
        }
        return true;
    }
}
