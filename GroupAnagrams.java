class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i ++) {
            char[] cArray = strs[i].toCharArray();
            Arrays.sort(cArray);
            String sortStr = new String(cArray);
            
            if (map.containsKey(sortStr)) {
                map.get(sortStr).add(strs[i]);
            } else {
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                map.put(sortStr, list);
            }
        }
        
        return new ArrayList(map.values());
        
    }
}
