class Solution {
    public int lastRemaining(int n) {
        int head = 1;
        int step = 1;
        boolean fromLeft = true;
        while(n != 1) {
            if (fromLeft || n % 2 == 1) {
                head += step;
            } 
            fromLeft = !fromLeft;
            n = n / 2;
            step = step * 2;
        }
        
        return head;
    }
}
