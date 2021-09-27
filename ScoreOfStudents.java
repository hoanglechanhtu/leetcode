class Solution {
    public int scoreOfStudents(String s, int[] answers) {
        int n = s.length();
        Set<Integer>[][] dp = new Set[(n + 1)/2][(n + 1)/2];
        for (int i = 0; i < dp.length; i ++) {
            for (int j = 0; j < dp.length; j ++) {
                dp[i][j] = new HashSet<>();
            }
        }
        for (int i = 0; i < dp.length; i ++) {
            dp[i][i].add(s.charAt(2 * i) - '0');
        }
        
        for (int r = 1; r < dp.length; r ++) {
            for (int i = 0; i < dp.length - r; i ++) {
                int end = i + r;
                //dp[i][i + r] 
                for (int k = i; k < end; k ++) {
                    for (Integer left : dp[i][k]) {
                        for (Integer right : dp[k + 1][end]) {
                            if (s.charAt(2 * k + 1) == '+') {
                                if (left + right <= 1000) {
                                    dp[i][end].add(left + right);
                                }
                            } else if (s.charAt(2 * k + 1) == '*') {
                                if (left * right <= 1000) {
                                    dp[i][end].add(left * right);
                                }
                            } 
                        }
                    }
                }
            }
        }
        
        Set<Integer> incorrectOrder = dp[0][(n + 1)/2 - 1];
        int total = 0;
        int correctAnswer = calculate(s);
        
        for (int i = 0; i < answers.length; i ++) {
            if (answers[i] == correctAnswer) total += 5;
            else if (incorrectOrder.contains(answers[i])) total += 2;
        }
        
        return total;
    }
    
    
      public int calculate(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        int num = 0;
        int i = 0;
        char operator = '+';
        // 1 + 2
        while(i < s.length()) {
            StringBuilder builder = new StringBuilder();
            while(i < s.length() && ((s.charAt(i) <= '9' && s.charAt(i) >= '0') || s.charAt(i) == ' ')) {
                if (s.charAt(i) != ' ') builder.append(s.charAt(i));
                i ++;
            }
            if (builder.length() != 0) {
                num = Integer.valueOf(builder.toString());
            }
            while (i < s.length() && s.charAt(i) == ' ') {
                i ++;
            }
            
            if (operator == '+') {
                stack.addLast(num);
            } else if (operator == '-') {
                stack.addLast(-num);
            } else if (operator == '*') {
                stack.addLast(stack.removeLast() * num);
            } else if (operator == '/'){
                stack.addLast(stack.removeLast() / num);
            }
            
            if (i < s.length()) {
                operator = s.charAt(i);
            }
            i ++;
        }
                  
        return stack.stream().mapToInt(Integer::intValue).sum();
    }
}
