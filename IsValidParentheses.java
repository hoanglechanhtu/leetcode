class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i ++) {
            char cur = s.charAt(i);
            if (stack.size() == 0) {
                stack.addFirst(cur);
            } else {
                Character last = stack.getFirst();
                if ((cur == ')' && last.equals('('))
                   || (cur == ']' && last.equals('['))
                    || (cur == '}' && last.equals('{'))
                   ) {
                    stack.removeFirst();
                } else {
                    stack.addFirst(cur);
                }
            }
        } 
        return stack.size() == 0;
    }
}
