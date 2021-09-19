class Solution {
    public String longestSubsequenceRepeatedK(String s, int k) {
        int N = 26;
        
        
        Deque<String> queue = new ArrayDeque<>();
        String res = "";
        queue.addFirst(res);
        
        while(queue.size() != 0) {
            String cur = queue.removeLast();
            for (int i = 0; i < N; i ++) {
                String next = cur + (char)('a' + i);
                if (isSub(s, next, k)) {
                    res = next;
                    queue.addFirst(next);
                }
            }
        }
        
        return res;
    }
    
    
    boolean isSub(String s, String sub, int k) {
        int repeat = 0;
        int j = 0;
        for (int i = 0; i < s.length(); i ++) {
            if (s.charAt(i) == sub.charAt(j)) {
                j ++;
                if (j == sub.length()) {
                    j = 0;
                    repeat ++;
                    if (repeat == k) return true;
                }
            }
        }
        
        return false;
    }
}
