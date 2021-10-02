class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int N = answerKey.length();
        if (N == 1) return 1;
        int[] preSum = new int[N];
        //Maximize the T answer
        preSum[0] = answerKey.charAt(0) == 'F' ? 0 : 1;
        for (int i = 1; i < N; i ++) {
            preSum[i] = preSum[i - 1] + (answerKey.charAt(i) == 'F' ? 0 : 1);
        }
        int total = calculate(preSum, k);
        
        //Maximize the F answer
        preSum[0] = answerKey.charAt(0) == 'T' ? 0 : 1;
        for (int i = 1; i < N; i ++) {
            preSum[i] = preSum[i - 1] + (answerKey.charAt(i) == 'T' ? 0 : 1);
        }
        
        total = Math.max(total, calculate(preSum, k));
        
        return total;
        
    }
    //TTF
    //preSum 1 2 2
    //index  0 1 2
    //nOper  0
    //right 2
    //left 0
    //total 2
    int calculate(int[] preSum, int k) {
        int left = 0, right = 0;
        int total = 1;
        int nOper = right + 1 - preSum[right];
        
        while (right < preSum.length) {
            if (nOper <= k) {
                total = Math.max(total, right - left + 1);
                right ++;
                if (right < preSum.length && preSum[right] - right != preSum[right - 1] - (right - 1)) nOper ++;
            } else {
                //nOper > k
                if ((left == 0 && preSum[left] == 0) || (left != 0 && preSum[left] - left != preSum[left - 1] - (left - 1))) nOper --;
                left ++;
         }
        }
        return total;       
    }
}
