class Solution {
    public int sumBase(int n, int k) {
        //34 6
        //i 6
        //mod 1
        //n 34
        //temp 
        int total = 0;
        int i = k;
        int mod = 1;
        while(n != 0) {
            int temp = n % i;
            int base = temp / mod;
            total += base;
            n -= base * mod;
            i = i * k;
            mod = mod * k;
        }
        return total;
    }
}
