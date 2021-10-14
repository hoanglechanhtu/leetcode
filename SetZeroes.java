class Solution {
    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        boolean[] cols = new boolean[m];
        boolean[] rows = new boolean[n];
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < m; j ++) {
                if (matrix[i][j] == 0) {
                    cols[j] = true;
                    rows[i] = true;
                }
            }
        }
        
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < m; j ++) {
                if (cols[j] || rows[i]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
