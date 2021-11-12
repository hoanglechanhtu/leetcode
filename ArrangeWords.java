class Solution {
    public String arrangeWords(String text) {
        int n = text.length();
        Map<Integer, List<String>> map = new HashMap<>();
        text = text.toLowerCase();
        int max = 0;
        String[] words = text.split(" ");
        for (int i = 0; i < words.length; i ++) {
            int length = words[i].length();
            max = Math.max(max, length);
            if (!map.containsKey(length)) {
                List<String> list = new ArrayList<>();
                map.put(length, list);
            }
            map.get(length).add(words[i]);
        }
        
        StringBuilder strBuilder = new StringBuilder();
        for (int i = 1; i <= max; i ++) {
            if (map.containsKey(i)) {
                map.get(i).forEach(s -> strBuilder.append(s + " "));
            }
        }
        String str = strBuilder.toString();
        
        return str.substring(0,1).toUpperCase() + str.substring(1, n);
    }
    
    
}
