class Solution {
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
