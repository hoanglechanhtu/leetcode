class Solution {
    String base = "abc";
    public boolean isValid(String s) {
        Deque<String> stack = new ArrayDeque<>();
        
        int start = 0;
        while(start < s.length()) {
            String cur = getNext(s, start);
            if (!cur.equals(base)) {
                if (stack.size() == 0 || base.startsWith(cur)) {
                    stack.addFirst(cur);
                } else {
                    //b //c //
                    String previous = stack.getFirst();
                    if (cur.equals("b")) {
                        if (previous.equals("a")) {
                            stack.removeFirst();
                            stack.addFirst("ab");
                        } else {
                            stack.addFirst(cur);
                        }
                    } else if (cur.equals("c")) {
                        if (previous.equals("ab")) {
                            stack.removeFirst();
                        } else if (previous.equals("b")) {
                            stack.removeFirst();
                            stack.addFirst("bc");
                        } else {
                            stack.addFirst(cur);
                        }
                    }
                }
            }
            
            start += cur.length();
        }
        
        return stack.size() == 0;
    }
    
    String getNext(String s, int start) {
        //ab
        //b
        int index = 0;
        while (start + index < s.length() && index < base.length() && s.charAt(start + index) == base.charAt(index)) {
            index ++;
        }
        
        if (index == 0) return s.substring(start, start + 1);
        else return base.substring(0, index);
    }
}
