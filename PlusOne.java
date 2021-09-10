class Solution {
    public int[] plusOne(int[] digits) {
        int[] newDigits = new int[digits.length + 1];
        newDigits[0] = 0;
        int remain = 1;
        
        for (int i = digits.length - 1; i >= 0 ; i --) {
            int res = digits[i] + remain;
            remain = res / 10;
            newDigits[i + 1] = res % 10;
        }
        
        if (remain == 0) {
            return Arrays.copyOfRange(newDigits, 1, newDigits.length);
        } else {
            newDigits[0] = remain;
            return newDigits;
        }
    }
}
