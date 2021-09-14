class Solution {
    public String restoreString(String s, int[] indices) {
        int[][] indicesMap = new int[indices.length][2];
        for (int i = 0; i < indices.length; i ++) {
            indicesMap[i][0] = indices[i];
            indicesMap[i][1] = i;
        }
        
        Arrays.sort(indicesMap, Comparator.comparing(x -> x[0]));
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < indicesMap.length; i ++) {
            builder.append(s.charAt(indicesMap[i][1]));
        }
        
        return builder.toString();
    }
}
