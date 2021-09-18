class Solution {
    public int[] findOriginalArray(int[] changed) {
        int[] emp = new int[0];
        if (changed.length % 2 != 0) return emp;
        int[] result = new int[changed.length/2];
        int index = 0;
        Arrays.sort(changed);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < changed.length; i ++) {
            map.merge(changed[i], 1, Integer::sum);
        }
        for (int i = 0; i < changed.length; i ++) {
            if (map.get(changed[i]) != 0) {
                map.merge(changed[i], -1, Integer::sum);
                if (map.containsKey(2  * changed[i]) && map.get(2 * changed[i]) != 0) {
                    map.merge(2 * changed[i], -1, Integer::sum);
                    result[index] = changed[i];
                    index ++;
                } else {
                    return emp;
                }
            }
        }
        
        return result;
    }
}
