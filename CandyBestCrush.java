static class Solution {
        public String candyCrush(String s) {
            Map<String, String> map = new HashMap<>();
            return recursive(s, 0, map);
        }

        String recursive(String s, int i, Map<String, String> map) {
            if (map.containsKey(s)) return map.get(s);
            for (; i < s.length(); i ++) {
                if (i + 2 < s.length() && s.charAt(i) == s.charAt(i + 1) && s.charAt(i + 1) == s.charAt(i + 2)) {
                    int start = i;
                    i += 2;
                    char repeatedChar = s.charAt(i);
                    while(i < s.length() && s.charAt(i) == repeatedChar) {
                        i ++;
                    }

                    String left = s.substring(0, start);
                    String right = s.substring(i);

                    String unCrush = recursive(s, i, map);
                    String crush = recursive(left + right, 0, map);
                    if (unCrush.length() < crush.length()) {
                        map.put(s, unCrush);
                        return unCrush;
                    } else {
                        map.put(s, crush);
                        return crush;
                    }
                }
            }
            return s;
        }
    }
