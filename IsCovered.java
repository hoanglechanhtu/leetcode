class Solution {
    public boolean isCovered(int[][] ranges, int left, int right) {
        for (int i = left; i <= right; i ++) {
            boolean isInclude = false;
            for (int j = 0; j < ranges.length; j ++) {
                if (i <= ranges[j][1] && i >= ranges[j][0]) isInclude = true;
            }
            if (!isInclude) return false;
        }
        return true;
    }
}
