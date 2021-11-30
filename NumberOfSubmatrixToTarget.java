/*
Given a matrix and a target, return the number of non-empty submatrices that sum to target.

A submatrix x1, y1, x2, y2 is the set of all cells matrix[x][y] with x1 <= x <= x2 and y1 <= y <= y2.

Two submatrices (x1, y1, x2, y2) and (x1', y1', x2', y2') are different if they have some coordinate that is different: for example, if x1 != x1'.

 

Example 1:


Input: matrix = [[0,1,0],[1,1,1],[0,1,0]], target = 0
Output: 4
Explanation: The four 1x1 submatrices that only contain 0.
Example 2:

Input: matrix = [[1,-1],[-1,1]], target = 0
Output: 5
Explanation: The two 1x2 submatrices, plus the two 2x1 submatrices, plus the 2x2 submatrix.
Example 3:

Input: matrix = [[904]], target = 0
Output: 0
*/
class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int columns = matrix[0].length, rows = matrix.length;
        //Calculate prefixSum for each row
        for (int i = 0; i < rows; i ++) {
            for (int j = 1; j < columns; j ++) {
                matrix[i][j] = matrix[i][j] + matrix[i][j - 1];
            }
        }
        
        int res = 0;
        //Submatrix with columns from start to end
        for (int start = 0; start < columns; start ++) {
            for (int end = start; end < columns; end ++) {
                Map<Integer, Integer> map = new HashMap<>();
                map.put(0, 1);
                //This problem now become calculate sub sum of array with equal target - currentSum
                int sum = 0;
                for (int line = 0; line < rows; line ++) {
                    sum += (start == 0 ? matrix[line][end] : matrix[line][end] - matrix[line][start - 1]);
                    res += map.getOrDefault(sum - target, 0);
                    map.merge(sum, 1, Integer:: sum);
                }
            }
        }
        return res;
    }
}
