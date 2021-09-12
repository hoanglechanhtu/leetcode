class Solution {
    public int maxProduct(String s) {
        if (isSingleChar(s)) return s.length() * s.length()/4;
        List<List<Integer>> list = new ArrayList<>();
        build(0, s.toCharArray(), new ArrayList<>(), list);
        int max = 0;
        for (int i = 0; i < list.size(); i ++) {
            for (int j = i + 1; j < list.size(); j ++) {
                if (isDisjoint(list.get(i), list.get(j))) max = Math.max(max, list.get(i).size() * list.get(j).size());
            }
        }
        
        return max;
        
    }
    //ab
    void build(int index, char[] s, List<Integer> cur, List<List<Integer>> list) {
        if (index == s.length) return;
        
        build(index + 1, s, cur, list);
        cur.add(index);
        if (isPalindrome(s, cur)) list.add(new ArrayList(cur));
        build(index + 1, s, cur, list);
        cur.remove(cur.size() - 1);
    }
    
    boolean isPalindrome(char[] s, List<Integer> cur) {
        for (int i = 0; i <= cur.size()/2; i ++) {
            if (s[cur.get(i)] != s[cur.get(cur.size() - i - 1)]) return false;
        }
        return true;
    }
    
    boolean isDisjoint(List<Integer> list1, List<Integer> list2) {
        return list1.stream()
            .filter(x -> list2.contains(x))
            .count() == 0;
    }
    
    boolean isSingleChar(String s) {
        for (int i = 0; i < s.length(); i ++) {
            if (s.charAt(i) != s.charAt(0)) return false;
        }
        return true;
    }
}



class Solution {
    int max = 0;
    public int maxProduct(String s) {
        build(s.toCharArray(), 0, "", "");
        return max;
    }
    
    
    void build(char[] c, int index, String s1, String s2) {
        if (index == c.length) {
            if (isPalindrome(s1) && isPalindrome(s2)) {
                max = Math.max(max, s1.length() * s2.length());
            }
            return;
        }
        
        build(c, index + 1, s1 + c[index], s2);
        build(c, index + 1, s1, s2 + c[index]);
        build(c, index + 1, s1, s2);
    }
    boolean isPalindrome(String s) {
        for (int i = 0; i < s.length()/2; i ++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) return false;
        }
        return true;
    }
}
