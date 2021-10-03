class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int m = rolls.length;
        int total = mean * (m + n);
        int remain = total;
        for (int i = 0; i < rolls.length; i ++) {
            remain -= rolls[i];
        }
        
        if (remain > n * 6 || remain < n) return new int[0];
        
        int mMean = (remain / n);
        int[] res = new int[n];
        for (int i = 0; i < n - 1; i ++) {
            if (remain >= mMean) {
                res[i] = remain / (n - i);
                remain = remain - res[i];
            }
        }
        
        res[n - 1] = remain;
        
        return res;
    }
}
