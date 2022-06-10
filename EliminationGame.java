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


Idea is simple:

Note that 1 2 3 4 5 6 7 8 9 10, eliminate every second will leave us with 2 4 6 8 10
In other words:

lastRemaining(10) = 2 * lastRemaining(5)

When we go in the opposite direction there are two cases:

n is even, thus 1 2 3 4 will leave us with 3 1. In other words when n is even lastRemaining(4) = 2 * lastRemaining(2) - 1
When n is odd, lastRemaining(5) = 2* lastRemaining(2) (1 2 3 4 5 will be eliminated to 2 4)

class Solution {
    public int lastRemaining(int n) {
        return helper(n, 0);
    }
    
    public int helper(int n, int direction) {
        if (n == 1)
            return 1;

        if (direction == 0)
            return 2 * helper(n / 2, 1);
        
        return 2 * helper(n / 2, 0) + n%2 - 1;
    }
}
