//4 5 6 7 0 1 2
//2 4 5 6 7 0 1
//0 1 2 4 5 6 7
//7 0 1 2 4 5 6

//3 4 5 1 2
//middle = 2
//left = 2/ right = 4/ middle = 2 + (4 -2)+1/2 = 3
//right = 3, left = 2 middle = 2 + (3-2) +1 /2 = 3 
//right = 3
class Solution {
    public int findMin(int[] nums) {

        int left = 0;
        int right = nums.length - 1;
        while(left < right - 1) {
        	int middle = left + ((right - left + 1))/2;
        	if(nums[left] <= nums[middle] && nums[right] <= nums[middle]) {
        		left = middle;
        	} else if(nums[left] >= nums[middle] && nums[right] >= nums[middle]){
        		right = middle;
        	} else {
        		right = left;
        	}
        }
        return Math.min(nums[right], nums[left]);
    }
}	

["SnapshotArray","snap","snap","set","snap","get","set","get","snap","get"]
[[1],[],[],[0,4],[],[0,1],[0,12],[0,1],[],[0,3]]
1
(0,0)
4
(2, 4)


class SnapshotArray {

	List<Integer> currentList;
	List<List<Integer>> snapshotList = new ArrayList();
	int size = 0;
	int snapSize = 0;
    public SnapshotArray(int length) {
        currentList = new ArrayList<Integer>(length);
        for (int i = 0; i < length; i ++) {
            currentList.add(0);
        }
        size = length;
    }
    
    public void set(int index, int val) {
        currentList.set(index, val);
    }
    
    public int snap() {
    	if (snapshotList.size() == 0) {
    		for (int i = 0; i < size; i ++) { 
    			snapshotList.add(new ArrayList(Arrays.asList(0, currentList.get(i))));
    		}
    	} else {
    		for (int i = 0; i < size; i ++) {
 				List<Integer> currentItemList = snapshotList.get(i);
    			if (currentItemList.get(currentItemList.size() - 1) != currentList.get(i)) {
    				currentItemList.add(snapSize);
                    currentItemList.add(currentList.get(i));
    			} 
    		}
    	}
    	snapSize += 1;
    	return snapSize - 1;
    }
    
    public int get(int index, int snap_id) {
     	List<Integer> currentItemList = snapshotList.get(index);
     	int i = 0;
     	while (2 * i < currentItemList.size() && currentItemList.get(2 * i) <= snap_id) {
     		i += 1;
     	}

    	return currentItemList.get(2 * i - 1);
    }
}
/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length); 


 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */


class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right - 1) {
        	int middle = left + (right - left)/2;
        	//find increse order sub array
        	if (nums[middle] >= nums[left]) {
        		if (nums[middle] >= target && nums[left] <= target){
        			right = middle;
        		} else {
        			left = middle;
        		}
        	} 
        	else {
        		if (nums[middle] <= target && nums[right] >= target){
        			left = middle;
        		} else {
        			right = middle;
        		}
        	}
        }
        if (nums[left] == target) return left;
        else if (nums[right] == target) return right;
        else return -1;
    }
}

[5,1,3]

[0,1,2,4,5,6,7]
[4,5,6,7,0,1,2]
[1,2,4,5,6,7,0]
// A increasing array being rotated
(0,k) (k + 1, n -1)
k -> max

a[0] min in arr(1)
a(n - 1) is max in arr(2)

[2,2,2,2,2,4,7]
 1,0,1,0,1,0,1
 1,1,1,1,1,1,1
class Solution {
    public boolean circularArrayLoop(int[] nums) {
        int[] visitedPos = new int[nums.length];
        boolean isCircular = false;
        for(int i = 0; i < nums.length; i ++) {
        	visitedPos[i] = 0;
        }

        for(int i = 0; i < nums.length; i ++) {
        	if (visitedPos[i] != 1) isCircular = isCircular || move(i, i, nums, visitedPos);
        }
        return isCircular;
    }

    public boolean move(int startPos int pos, int[] nums, int[] visitedPos) {
    	int moveToPos = Math.abs((pos + nums[pos])) % nums.length;
    	if (nums[pos] * nums[moveToPos] < 0) return false;
    	else if (pos == moveToPos) return false;
    	else if (visitedPos[moveToPos]  == 1 && moveToPos == startPos) return true;
    	else {
    		visitedPos[pos] = 1;
    		return move(moveToPos, nums, visitedPos, totalStep);
    	}
    }
}


class Solution {
    public int subarraySum(int[] nums, int k) {
    	int count = 0;
        for (int i = 0; i < nums.length; i ++) {
        	int total = 0;
        	for (int j = i; j < nums.length; j ++) {
        		total = total + nums[j];
        		if (total == k) count += 1;
        	}
        }
        return count;
    }
}


class Solution {
    public int subarraySum(int[] nums, int k) {
    	if (nums.length = 0) return 0;
    	int[] sum = new int[nums.length];
    	for(int i = 0; i < nums.length; i ++) {
    		nums[i] = 0;
    	}
    	sum[0] = nums[0];
    	for(int i = 1; i < nums.length; i ++) {
    		sum[i] = sum[i - 1] + nums[i];
    	}

    	Map<Int, Int> sumMap = new HashMap();

    	for (int i = 0; i < nums.length; i ++) {
    		if (sumMap.containsKey(sum[i])) sumMap.put(sum[i], sumMap.get(sum[i]) + 1);
    		else sumMap.put(sum[i], 1)
    	}

    	int count = 0;
    	for (int i = 0; i < nums.length; i ++) {
    		if (sumMap.containsKey(sum[i])) count += sumMap.get(sum[i]);
    	}

    	return count/2;
    }
}

/*

Input: mat = [[1,3,11],[2,4,6]], k = 5
Output: 7
Explanation: Choosing one element from each row, the first k smallest sum are:
[1,2], [1,4], [3,2], [3,4], [1,6]. Where the 5th sum is 7.  
*/
class Solution {
    public int kthSmallest(int[][] mat, int k) {

    }
}

/*
Input: matrix = 
[
[1,3,5,7],
[10,11,16,20],
[23,30,34,60]
], target = 13
m = 3
n = 4
Output: true
*/

//[1,3,5]

//Left pointer should be pos + 1
//Right pointer should be pos - 1
//Calculate pos 
 class Solution {
            public boolean searchMatrix(int[][] matrix, int target) {
                int m = matrix.length;
                int n = matrix[0].length;
                int startX = 0;
                int startY = 0;

                int endX = m - 1;
                int endY = n - 1;

                int posX = 0;
                int posY = 0;
                while (matrix[posX][posY] != target && (startX * m + startY < endX * m + endY)) {
                    int pos = ((endX - startX) * m + (endY - startY + 1)) / 2;
                    posX = ((startX * n) + startY + pos) / n;
                    posY = ((startX * n) + startY + pos) - posX * n;
                    if (matrix[posX][posY] <= target) {
                        startX = posX;
                        startY = posY + 1;
                    } else {
                        endX = posX;
                        endY = posY - 1;
                    }
                }

                return matrix[posX][posY] == target;
            }
        }


class Solution {
    public int minFlipsMonoIncr(String S) {
    	int[][] dp = new int[S.length()][2];

    	if (S.charAt(S.length() - 1) == '0') {
    		dp[S.length() - 1][0] = 0;
    		dp[S.length() - 1][1] = 1;
    	} else {
    		dp[S.length() - 1][0] = 1;
    	    dp[S.length() - 1][1] = 0;
    	}


    	for(int i = 1; i < S.length(); i ++) {
    		if (S.charAt(S.length() - i - 1) == '0') {
    			dp[S.length() - i - 1][0] = Math.min(dp[S.length() - i][0], dp[S.length() - i][1]) ;
    			dp[S.length() - i - 1][1] = 1 + dp[S.length() - i][1];
    		} else {
    			dp[S.length() - i - 1][0] = 1 + Math.min(dp[S.length() - i][0], dp[S.length() - i][1]);
    			dp[S.length() - i - 1][1] = dp[S.length() - i][1];
    		}
    	}

    	return Math.min(dp[0][1], dp[0][0]);
        
    }
}      


class Solution {
    public int minDominoRotations(int[] A, int[] B) {
    	if (A.length == 0) return 0;
        int value1 = A[0];
        boolean isValue1 = true;
        int value2 = B[0];
        boolean isValue2 = true;

        for (int i = 1; i < A.length; i ++) {
        	if (value1 != A[i] && value1 != B[i]) isValue1 = false;
        	if (value2 != A[i] && value2 != B[i]) isValue2 = false;
        }

        int commonValue = 0;
        if (!isValue1 && !isValue2) return -1;
        else if(isValue1) commonValue =value1;
        else commonValue = value2;

        int nCommonValueUpper = 0;
        int nCommonValueDown = 0;

        for (int i = 0; i < A.length; i++) {
        	if (A[i] == commonValue) nCommonValueUpper += 1;
        	if (B[i] == commonValue) nCommonValueDown += 1;
        }

        return Math.min(A.length() - nCommonValueDown, A.length() - nCommonValueUpper);
    }
}


[ ,4, -1 ,1 ]
class Solution {
    public int firstMissingPositive(int[] nums) {
        int nLessThenOne = 0;
        int nBiggerThenMax = 0;
        int i = 0;
        for (i = 0; i < nums.length; i ++) {
        	if (nums[i] < 1) nLessThenOne += 1;
        }

        for (i = 0; i < nums.length; i ++) {
        	if (nums[i] > nums.length - nLessThenOne) nBiggerThenMax += 1;
        }

        i = 0;
        while(i < nums.length) {
        	if (i == nums[i] - 1|| nums[i] < 1 || nums[i] > nums.length - nLessThenOne) i += 1;
        	else {
        		if (nums[i] != nums[nums[i] - 1]) {
        			swap(i, nums[i] - 1);
        		} else {
        			i+=1;
        		}	
        	}
        }

        for (i = 0; i < nums.length; i ++) {
        	if (i != nums[i] - 1) return i + 1;
        }
        
        return nums.length - nLessThenOne + 1;
    }

    public void swap(int[] nums, int pos1, int pos2) {
    	int temp = nums[pos1];
    	nums[pos1] = nums[pos2];
    	nums[pos2] = temp;
    }
}

class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {

        Map<Int, List<Int>> startPointToIndexMap = buildEdgeMap(edges);

        return findMaxProbilityPath(start, end, startPointToIndexMap, edges, succProb, 1, 0);
    }

    public Map<Int, List<List<Int>> buildEdgeMap(int[][] edges) {
    	Map<Int, List<Int>> startPointToIndexMap = new HashMap<Int, List<Int>>();
    	for(int i = 0; i < edges.length; i++) {
    		if (startPointToIndexMap.contains(edges[0][0])) {
    			startPointToIndexMap.get(edges[0][0]).add(edges[0][1]);
    		} else {
    			List<Int> list = new List<Int>();
    			list.add(edges[0][1]);
    			startPointToIndexMap.put(edges[0][0], list);
    		}
    	
    	}
    	return startPointToIndexMap;

    }

    public double findMaxProbilityPath(int start, int end, Map<Int, List<Int>> edgesMap, int[][] edges, double[] succProb, double currentProb, double maxProb, List<Int> visitedPoint) {
    	if (start == end && currentProb > maxProb) return currentProb;
    	else if (currentProb <= maxProb) return maxProb; 
    	else {
    		List<Int> listIndex = edgesMap.get(start);
    		int newMax = maxProb;
    		for(i : listIndex) {
    			if (visitedPoint.)
    			double prob = succProb[i];
    			newMax = findMaxProbilityPath(edges[i][2], end, edgesMap, edges, succProb, currentProb * prob, newMax);
    		}
    		return newMax;
    	}


    }
}



class Solution {
    public int findUnsortedSubarray(int[] nums) {
    	if (nums.length == 0) return 0;
        int[] maxArray = new int[](nums.length);
        maxArray[0] = nums[0];
        int[] minArray = new int[](nums.length);
        minArray[nums.length - 1] = nums[nums.length - 1];
        for (int i = 1; i < nums.length; i ++) {
        	maxArray[i] = math.max(maxArray[i - 1], nums[i]);
        	minArray[nums.length - i - 1] = math.min(minArray[nums.length - i], nums[nums.length - i - 1]);
        }

        int leftMustSortIndex = nums.length - 1;
        int rightMustSortIndex = 0;
        int iter = 0;
        while (iter < nums.length) {
        	if (nums[iter] <= maxArray[iter] && iter < leftMustSortIndex) leftMustSortIndex = iter;
        	if (nums[iter] <= maxArray[iter] && iter > rightMustSortIndex) rightMustSortIndex = iter;
        	iter += 1;
        }
        iter = nums.length - 1;
        while (iter >= 0) {	
        	if (nums[iter] >= minArray[iter] && iter < leftMustSortIndex) leftMustSortIndex = iter;
        	if (nums[iter] >= minArray[iter] && iter > rightMustSortIndex) rightMustSortIndex = iter;
        	iter -= 1;
        }

        if (leftMustSortIndex >= rightMustSortIndex) return 0;
        else return rightMustSortIndex - leftMustSortIndex + 1; 
    }
}


class Solution {
    public int[] productExceptSelf(int[] nums) {
    	if (nums.length == 1) return nums;
    	int[] res = new int[nums.length];
        int[] startToIndexMul = new int[nums.length];
        startToIndexMul[0] = 1;
        int[] endToIndexMul = new int[nums.length];
        endToIndexMul[nums.length - 1] = 1;
        for(int i = 1; i < nums.length; i ++) {
        	startToIndexMul[i] = startToIndexMul[i - 1] * nums[i - 1];
        	endToIndexMul[nums.length - i - 1] = endToIndexMul[nums.length - i] * nums[nums.length - i];
        }


        for (i = 0; i < nums.length; i ++) {
        	res[i] = startToIndexMul[i] * endToIndexMul[i]

        }
        return res;
    }
}


    class Solution {
        enum Move {
            RIGHT,
            DOWN,
            LEFT,
            UP,
            NONE
        }

        class Position {
            public Position(int x, int y) {
                this.x = x;
                this.y = y;
            }

            public int x;
            public int y;
        }

        public List<Integer> spiralOrder(int[][] matrix) {
            if (matrix.length == 0) return Collections.emptyList();
            List<Integer> res = new ArrayList();
            Move curMove = Move.RIGHT;
            Move nextMove = Move.RIGHT;
            Position pos = new Position(0, 0);
            Position min = new Position(0, 0);
            Position max = new Position(matrix[0].length - 1, matrix.length - 1);

            res.add(matrix[pos.x][pos.y]);
            while (nextMove != Move.NONE) {
                nextMove = findNextMove(pos, min, max, curMove);
                move(pos, nextMove);
                adjustBound(min, max, curMove, nextMove);
                curMove = nextMove;
                if (nextMove != Move.NONE)
                    res.add(matrix[pos.x][pos.y]);
            }


            return res;
        }

        public Move findNextMove(Position pos, Position min, Position max, Move currMove) {
            if (currMove == Move.RIGHT && pos.y < max.y) return Move.RIGHT;
            if (currMove == Move.RIGHT && pos.x < max.x) return Move.DOWN;
            if (currMove == Move.DOWN && pos.x < max.x) return Move.DOWN;
            if (currMove == Move.DOWN && pos.y > min.y) return Move.LEFT;
            if (currMove == Move.LEFT && pos.y > min.y) return Move.LEFT;
            if (currMove == Move.LEFT && pos.x > min.x) return Move.UP;
            if (currMove == Move.UP && pos.x > min.x) return Move.UP;
            if (currMove == Move.UP && pos.y < max.y) return Move.RIGHT;
            return Move.NONE;
        }


        public void move(Position pos, Move move) {
            if (move == Move.RIGHT) pos.y = pos.y + 1;
            else if (move == Move.DOWN) pos.x = pos.x + 1;
            else if (move == Move.LEFT) pos.y = pos.y - 1;
            else if (move == Move.UP) pos.x = pos.x - 1;
        }

        public void adjustBound(Position min, Position max, Move curMove, Move nextMove) {
            if (curMove == Move.RIGHT && nextMove == Move.DOWN) {
                min.x += 1;
            } else if (curMove == Move.DOWN && nextMove == Move.LEFT) {
                max.y -= 1;
            } else if (curMove == Move.LEFT && nextMove == Move.UP) {
                max.x -= 1;
            } else if (curMove == Move.UP && nextMove == Move.RIGHT) {
                min.y += 1;
            }
        }
    }

[0,1,0,2,1,0,1,3,2,1,2,1]
class Solution {
    public int trap(int[] height) {
        	int max = 0;
    	int res = 0;
        for (int i = 0; i < height.length; i ++) {
        	if (max < height[i]) max = height[i];
        }
        
        int startPos = -1;
        int endPos = -1;
        int total = 0;
        for (int i = 1; i <= max; i ++) {
        	for (int j = 0; j < height.length; j ++) {
        		if (height[j] >= i) {
        			if (startPos == -1) startPos = j;
        			endPos = j;
        			total += 1;
        		}
        	}
        	if (endPos - startPos - 1 - (total - 2) > 0)
        			res = res + endPos - startPos - 1 - (total - 2);
        		startPos = -1;
        		endPos = -1;
        		total = 0;
        }
        return res;
    }
}
=> TimeLimitExceeded
    class Solution {
        public int trap(int[] height) {
            int length = height.length;
            int res = 0;
            if (length < 2) return res;
            int[] maxFromLeft = new int[length];
            int[] maxFromRight = new int[length];
            maxFromLeft[0] = height[0];
            maxFromRight[length - 1] = height[length - 1];
            for (int i = 1; i < length; i++) {
                if (height[i] > maxFromLeft[i - 1]) maxFromLeft[i] = height[i];
                else maxFromLeft[i] = maxFromLeft[i - 1];

                if (height[length - 1 - i] > maxFromRight[length - i])
                    maxFromRight[length - i - 1] = height[length - 1 - i];
                else maxFromRight[length - i - 1] = maxFromRight[length - i];
            }

            int[] changedMaxMark = new int[length];
            changedMaxMark[0] = 1;
            changedMaxMark[length - 1] = 1;
            for (int i = 1; i < length - 1; i++) {
                if (maxFromLeft[i] != maxFromLeft[i - 1]) changedMaxMark[i] = 1;
                if (maxFromRight[length - i - 1] != maxFromRight[length - i]) changedMaxMark[length - i - 1] = 1;
            }

            int pStart = 0;
            int pEnd = 1;

            for (int i = 1; i < length; i++) {
                if (changedMaxMark[i] == 1) {
                    pEnd = i;
                    res = res + calculate(pStart, pEnd, height);
                    pStart = i;
                }
            }

            return res;
        }

        private int calculate(int pStart, int pEnd, int[] height) {
            int totalBlock = 0;
            for (int i = pStart + 1; i < pEnd; i++) {
                totalBlock += height[i];
            }

            return Math.min(height[pStart], height[pEnd]) * (pEnd - pStart - 1) - totalBlock;
        }
    }



    class Solution {
        public int longestConsecutive(int[] nums) {
            Map<Integer, Boolean> visitedMap = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                visitedMap.put(nums[i], false);
            }
            int longestConsecutiveArrayLength = 0;
            for (int i = 0; i < nums.length; i++) {
                if (!visitedMap.get(nums[i])) {
                    int cur = nums[i];
                    int totalLeft = 0;
                    while (visitedMap.get(cur - 1) != null) {
                        totalLeft += 1;
                        cur = cur - 1;
                        visitedMap.put(cur, true);
                    }
                    cur = nums[i];
                    int totalRight = 0;
                    while (visitedMap.get(cur + 1) != null) {
                        totalRight += 1;
                        cur = cur + 1;
                        visitedMap.put(cur, true);
                    }
                    visitedMap.put(nums[i], true);
                    if (1 + totalLeft + totalRight > longestConsecutiveArrayLength)
                        longestConsecutiveArrayLength = 1 + totalRight + totalLeft;
                }
            }
            return longestConsecutiveArrayLength;
        }
    }



class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> elementCountMap = new HashMap<>();

        for (int i = 0; i < nums.length; i ++) {
        	if (elementCountMap.get(nums[i]) != null) {
        		elementCountMap.put(nums[i], elementCountMap.get(i) + 1);
        	} else {
        		elementCountMap.put(nums[i], 1);
        	}
        }
        int res = 0;
        elementCountMap.forEach((key, value) -> {
         if (value > (nums.length / 2)) res = key;
     	});
     	return res;
    }
}


class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        sort(intervals);
        int baseIndex = 0;
        int compareIndex = baseIndex + 1;
        int nRemove = 0;
        while(compareIndex < intervals.length) {
        	if (intervals[baseIndex][1] > intervals[compareIndex][0]) {
        		nRemove += 1;
        		compareIndex += 1;
        	} else {
        		baseIndex = compareIndex;
        		compareIndex = baseIndex + 1;
        	}
        }

        return nRemove;
    }

    void sort(int[][] intervals) {
    	
    }
}

[1,2,3,1,2,3]
2
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        for (int i = 0; i < nums.length; i ++) {
        	for (int j = i + 1; (j <= i + k) && (j < nums.length); j ++) {
        		if (nums[i] == nums[j]) return true;
        	}
        }
        return false;
    }
}


    class Solution {
        public boolean exist(char[][] board, String word) {
            boolean[][] visitedMap = new boolean[board.length][board[0].length];
            int maxX = board.length;
            int maxY = board[0].length;

            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    boolean res = backtrack(i, j, word, 0, visitedMap, board, maxX, maxY);
                    if (res) return res;
                }
            }

            return false;

        }

        boolean backtrack(int posX, int posY, String word, int currentPos, boolean[][] visitedMap, char[][] board, int maxX, int maxY) {
            if (posX < 0 || posX >= maxX) return false;
            if (posY < 0 || posY >= maxY) return false;
            if (visitedMap[posX][posY]) return false;

            if (board[posX][posY] == word.charAt(currentPos)) {
                if (currentPos == word.length() - 1) return true;
                else {
                    visitedMap[posX][posY] = true;

                    boolean res = backtrack(posX, posY + 1, word, currentPos + 1, visitedMap, board, maxX, maxY) ||
                            backtrack(posX + 1, posY, word, currentPos + 1, visitedMap, board, maxX, maxY) ||
                            backtrack(posX - 1, posY, word, currentPos + 1, visitedMap, board, maxX, maxY) ||
                            backtrack(posX, posY - 1, word, currentPos + 1, visitedMap, board, maxX, maxY);
                    visitedMap[posX][posY] = false;

                    return res;
                }
            } else {
                return false;
            }

        }
    }

class Solution {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k - 1];
    }
}


/**
 * Definition for a binary tree node.
 * public class ListNode {
 *     int val;
 *     ListNode left;
 *     ListNode right;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode left, ListNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public ListNode pruneTree(ListNode root) {
        if (root == null) return null;
        else {
            prune(root);
            if (root.left == null && root.right == null && root.val == 0) return null;
            return root;
        }
    }

    boolean prune(ListNode root) {
    	if (root == null) return false;
    	if (root.left == null && root.right == null && root.val == 0) return true;
    	boolean leftPrune = prune(root.left);
    	boolean rightPrune = prune(root.right);

    	if (leftPrune) root.left = null;
    	if (rightPrune) root.right = null;

    	return leftPrune && rightPrune && root.val == 0;
    }
}	



class Solution {
    enum Direction {
        LEFT,
        RIGHT
    }
    class Solution {
        public List<List<Integer>> zigzagLevelOrder(ListNode root) {
            Deque<ListNode> queue = new ArrayDeque<>();
            Deque<ListNode> queue2 = new ArrayDeque<>();
            List<List<Integer>> res = new ArrayList<>();
            queue.add(root);

            List<Integer> currentLevel = new ArrayList<>();
            while (!queue.isEmpty() || !queue2.isEmpty()){
                if (!queue.isEmpty()){
                    while(!queue.isEmpty()) {
                        ListNode node = queue.poll();
                        currentLevel.add(node.val);
                        if (node.right != null) queue2.addFirst(node.right);
                        if (node.left != null) queue2.addFirst(node.left);
                    }
                }
                else {
                    while(!queue2.isEmpty()) {
                        ListNode node = queue2.poll();
                        currentLevel.add(node.val);
                        if (node.left != null) queue.add(node.left);
                        if (node.right != null) queue.add(node.right);
                    }
                }
                res.add(currentLevel);
                currentLevel = new ArrayList<>();
            }
            return  res;
        }
    }
}



class Solution {
    public ListNode deleteNode(ListNode root, int key) {
        if (root == null) return null;
        ListNode dummyNode = new ListNode(0, root, null);
        searchAndDeleteNode(root, key, dummyNode, true);
        return dummyNode.left;
    }

    void searchAndDeleteNode(ListNode root, int key ,ListNode parent, boolean isLeft) {
    	if (root.val == key) {
    		if (root.left == null) {
    			if (isLeft) {
    				parent.left = root.right;
    			} else {
    				parent.right = root.right;
    			}
    		} else if (root.right == null) {
    			if (isLeft) {
    				parent.left = root.left;
    			} else {
    				parent.right = root.left;
    			}
    		} else {
    			ListNode curNode = root.right;
    			ListNode curParent = root;
    			while (curNode.left != null) {
    				curParent = curNode;
    				curNode = curNode.left;
    			}
    			if (curParent.val == root.val) {
    				if (isLeft) {
    					parent.left = curNode;
    				} else {
    					parent.right = curNode;
    				}
    				curNode.left = root.left;
    			} else {
    				curParent.left = curNode.right;
    				if (isLeft) {
    					parent.left = curNode;
    				} else {
    					parent.right = curNode;
    				}
    				curNode.left = root.left;
    				curNode.right = root.right;
    			}


    		}
    	} else if (root.val > key && root.left != null) {
    		searchAndDeleteNode(root.left, key, root, true);
    	} else if (root.val < key && root.right != null) {
    		searchAndDeleteNode(root.right, key, root, false);
    	}
    }
}

class Solution {
    public int threeSumClosest(int[] nums, int target) {
    	int sum = nums[0] + nums[1] + nums[2];
    	int minDistance = Math.abs(nums[0] + nums[1] + nums[2] - target);
        for (int i = 0; i < nums.length - 2; i ++) {
        	for (int j = i + 1; j < nums.length - 1; j ++) {
        		for (int z = j + 1; z < nums.length; z ++) {
        			int distance = Math.abs(nums[i] + nums[j] + nums[z] - target);
        			if (distance < minDistance) {
        				minDistance = distance;
        				sum = nums[i] + nums[j] + nums[z];
        			}
        		}
        	}
        }
        return sum;

    }
}


class Solution {
    public int threeSumClosest(int[] nums, int target) {
    	Arrays.sort(nums);
    	int sum = ums[0] + nums[1] + nums[2];
    	int min = Math.abs(nums[0] + nums[1] + nums[2] - target);
    	for (int i = 0; i < nums.length - 2) {
    		int j = i + 1;
    		int k = nums.length - 1;
    		while(j < k) {
				if (Math.abs(nums[j] + nums[i] + nums[k] - target) < min) {
					min = Math.abs(nums[j] + nums[i] + nums[k] - target);
					sum = nums[i] + nums[j] + nums[k];
				}
    			if (nums[j] + nums[k] == target - nums[i]) {
    				return nums[j] + nums[i] + nums[k];
    			} else if (nums[j] + nums[k] > target - nums[i]) {
    				k = k - 1;

    			} else {
    				j = j + 1;
    			}
    		}

    	}
    	return sum;
    }
}



class Solution {
    public List<String> generateParenthesis(int n) {
        char[] par= new char[2*n]
        List<String> res= new List<String>();
        backtrack(par, 0, 2*n, 0, res);
        return res;
    }

    private backtrack(char[] par, int pos, int length, int nLeft, List<String> res) {
    	if ((pos == length - 1) && (nLeft == (pos + 1)/ 2)) {
    		res.add(String.valueOf(par));
    	} else if (pos < length) {
    		int nCurrentRight = pos - nLeft;
    		if (nCurrentRight <= nLeft + 1) {
    			par[pos] = '(';
    			backtrack(par, pos + 1, length, nLeft + 1, res);
    		}
    		if (nCurrentRight + 1 <= nLeft) {
    			par[pos] = ')';
    			backtrack(par, pos + 1, length, nLeft, res);
    		}
    	}
    }
}


	class Solution {
		class Node {
			public Node(char value, Node nextNode) {
				this.value = value;
				this.nextNode = nextNode;
			}
			public char value;
			public Node nextNode;
			public List<Node> move(char value){
				List<Node> listNode = new ArrayList<>();
				if (this.nextNode != null && this.nextNode.value == value) listNode.add(this.nextNode);
				if (this.value == '?' && nUseTime == 0) {
					nUseTime += 1;
					listNode.add(this.value);
				}
				if (this.value == '*') {
					nUseTime += 1;
					listNode.add(this.value);
				}

			}
			int nUseTime = 0;
		}
	    public boolean isMatch(String s, String p) {
	        Node node = createNodeChain(s);

	    }

	    boolean backtrack(Node node, String s, int pos) {
	    	if (pos >= s.length) return true;
	    	else {
	    		List<Node> nextNodes = node.move(s.charAt(pos));
	    		if (nextNodes.isEmpty()) return false;
	    		else return nextNodes.stream().reduce(false, (x, y) => (x || backtrack(y, s, pos + 1)));
	    	}
	    }
	    Node createNodeChain(s) {
	    	Node dummyNode = new Node(0, null);
	    	Node curNode = dummyNode;
	    	for (int i = 0; i < s.length; i ++) {
	    		Node node = new Node(s.charAt(i), null);
	    		curNode.nextNode = node;
	    	}
	    	return dummyNode;
	    }
	}





class Solution {
    public int minSwap(Array<int> nums) {
    	int nWrongPosition = 0;
		for (int i = 0; i < nums.size(); i ++) {
			int nLessThan = 0;
			for (int j = 0; j < nums.size(); j ++) {
				if (a[i] > a[j])  nLessThan += 1;
			}
			if (nLessThan != i) nWrongPosition += 1;
		}        
		return nWrongPosition/2;
    }

}



class Solution {
	enum Direction {
		
		North {
			public Direction turnLeft() {
				return West;
			}
			public Direction turnRight(){
				return East;
			}
		},
		West {
			public Direction turnLeft() {
				return South;
			}
			public Direction turnRight(){
				return North;
			}
		},
		South {
			public Direction turnLeft() {
				return East;
			}
			public Direction turnRight(){
				return West;
			}
		},
		East {
			public Direction turnLeft() {
				return North;
			}
			public Direction turnRight(){
				return South;
			}
		};
        abstract public Direction turnLeft();
		abstract public Direction turnRight();

	}
    public boolean isRobotBounded(String instructions) {
        int nW = 0;
        int nS = 0;
        int nE = 0;
        int nN = 0;
        boolean res = false;
        Direction cur = Direction.North;
        for (int time = 0; time < 4; time ++) {
        	for (int i = 0; i < instructions.length(); i ++) {
        		if (instructions.charAt(i) == 'G') {
        			if (cur == Direction.North) nN +=1;
        			if (cur == Direction.West) nW +=1;
        			if (cur == Direction.South) nS += 1;
        			if (cur == Direction.East) nE += 1;
        		}

        		if (instructions.charAt(i) == 'L') {
        			cur = cur.turnLeft();
        		}
        		if (instructions.charAt(i) == 'R'){
        			cur = cur.turnRight();
        		}
        		res = res || (checkCycle(nW, nS, nE, nN) && cur == Direction.North && i == 0);
        	}
        }

        return res;
    }

    private boolean checkCycle(int nW, int nS, int nE, int nN){
    	return nW == nE && nS == nN;
    }
}


class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, x -> x[0]);
        List<int[][]> res = new ArrayList<>();
        for (int i = 0; i < intervals.length - 1; i ++){
        	if (intervals[i][1] > intervals[i + 1][0]){
        		intervals[i + 1] = new int[]{intervals[i][0], math.Max(intervals[i][1], intervals[i + 1][1])};
        	} else {
        		res.add(intervals[i])
        	}
        }
      	res.add(intervals[intervals.length - 1]);
    }
}


class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int nUniquePath = 0;
        int finishX = obstacleGrid.length - 1;
        int finishY = obstacleGrid[0].length - 1;
        int[][] dp = new int[finishX + 1][finishY + 1];
        for (int i = 0; i <= finishX; i ++) {
        	for (int j = 0; j <= finishY; j ++){
        		dp[i][j] = -1;
        	}
        }
        return findUniquePath(0,0, finishX, finishY, obstacleGrid, dp);
    }

    int findUniquePath(int posX, int posY, int finishX, int finishY, int[][] obstacleGrid, int[][] dp) {
    	if (isOut(posX, posY, finishX, finishY)) return 0;
    	else if (obstacleGrid[posX][posY] == 1) return 0;
    	else if (posX == finishX && posY == finishY) return 1;
    	else {
    		if (dp[posX][posY] != -1) return dp[posX][posY];
    		else {
    			int rightPath = findUniquePath(posX, posY + 1, finishX, finishY, obstacleGrid, dp);
    			int leftPath = findUniquePath(posX + 1, posY, finishX, finishY, obstacleGrid, dp);
    			dp[posX][posY] = rightPath + leftPath;
    			return rightPath + leftPath;
    		}
    	}
    }

	boolean isOut(int posX, int posY, int finishX, int finishY) {
		return posX < 0 || posX > finishX || posY < 0 || posY > finishY;
	}
}


class Solution {
    public int findPeakElement(int[] nums) {
    	int i = 0;
        while (!isPeak(nums, i)){
        	if (i == 0 || i == nums.length) i = nums.length / 2;
        	else {
        		if (nums[i] < nums[i + 1]) i = i + (nums.length -i)/2;
        		else i = i / 2;
        	}
        }
        return 0;
    }

    private boolean isPeak(int[] nums, int i) {
    	if (i == 0 && nums[i] > nums[i + 1]) return true;
        else if (i == nums.length - 1 && nums[i] > nums[i - 1]) return true;
        else if (i != 0 && i != nums.length - 1 && nums[i -1] < nums[i] && nums[i] > nums[i + 1]) return true;
        else return false;
    }
}


class Solution {
    public int findTheWinner(int n, int k) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i ++){
        	arr[i] = i;
        }

        int maxLength = n;
        int startIndex = 0;
        while(maxLength != 1){
        	int removeIndex = (startIndex + k % maxLength  + maxLength - 1) % maxLength;
        	moveRight(arr, removeIndex, maxLength);
        	if (removeIndex == maxLength - 1) startIndex = 0;
        	else startIndex = removeIndex;
        	maxLength -= 1;
        }

        return arr[0];
    }

    private void moveRight(int[] arr, int index, int maxLength){
    	int temp = arr[index];
    	for (int i = index; i < maxLength - 1; i ++) {
    		arr[i] = arr[i + 1];
    	}
    	arr[maxLength - 1] = temp;
    }
}


class Solution {
    public int findTheWinner(int n, int k) {
    	if (n == 1) return 1;
      	return findTheWinner(n, k);
    }

    private int findTheWinnerRecursive(int n, int k){
    	int kill = k % n == 0 ? n : k % n;

    	int winner = kill + findTheWinnerRecursive(n - 1, k);
    	return winner % n == 0 ? n : winner % n;
    }
}


class Solution {
    public ListNode lcaDeepestLeaves(ListNode root) {
    	Node deepest;
        find(root, deepest);
        return deepest;
    }

    private int find(ListNode root, TreeNoe deepest) {
    	if (root == null) {
    		return 0;
    	}
    	else if (root.left == null) {
    		return find(root.right, deepest) + 1;
    	} 
    	else if (root.right == null) {
    		return find(root.left, deepest) + 1;
    	} else {
    		Node leftDeepestNode;
    		Node rightDeepestNode;
    		int leftDeep = find(root.left, leftDeepestNode) + 1;
    		int rightDeep = find(root.right, rightDeepestNode) + 1;
    		if (leftDeep == rightDeep) {
    			deepest = root;
    			return leftDeep;
    		} else if (leftDeep < rightDeep) {
    			deepest = rightDeepestNode;
    			return rightDeep;
    		} else {
    			deepest = leftDeepestNode;
    			return leftDeep;
    		}
    	}

    }
}



class Solution {
    public int longestPalindrome(String s) {
    	int maxLength = 0;
        for (int i = 1; i <= s.length; i ++) {
        	for (int j = 0; j < s.length - i; i ++) {
        		if(isPalindrome(j, j + i, s) && maxLength < i) maxLength = i;
        	}
        }
        return maxLength;
    }

    boolean isPalindrome(int start, int end, String s){
    	for (int i = 0; i < (end - start)/2; i ++) {
    		if (s.charAt(start + i) != s.charAt(end - i)) return false;
    	}
    	return true;
    }
}

   class Solution {
        public int longestPalindrome(String s) {
            Map<Character, Integer> charCount = new HashMap<>();

            for (int i = 0; i < s.length(); i++) {
                if (charCount.containsKey(s.charAt(i))) {
                    charCount.put(s.charAt(i), charCount.get(s.charAt(i)) + 1);
                } else {
                    charCount.put(s.charAt(i), 1);
                }
            }

            return charCount.values().stream().reduce(0, (x, y) -> {
                if (x % 2 == 0 && y % 2 == 1) {
                    return x + y;
                } else {
                    return x + (y/2)*2;
                }
            });
        }
    }



class Solution {
    public int threeSumMulti(int[] arr, int target) {

    	int nCount = 0;
    	Map<Integer, Integer> numberCount = new HashMap<>();

    	for (int i = 0; i < arr.length; i ++){
    		if (numberCount.containsKey(arr[i])) numberCount.put(arr[i], numberCount.get(arr[i]) + 1);
    		else numberCount.put(arr[i], 1);
    	}

        return nCount;
    }
}



class Solution {
    public boolean hasAlternatingBits(int n) {
    	int bit = n % 2;
    	n = n / 2;
    	while (n != 0) {
    		if (n % 2 == bit) return false;
    		bit = n % 2;
    		n = n / 2;
    	}   
    	return true;
    }
}


class Solution {
    public int numSplits(String s) {
        Map<Character, Integer> leftMap = new HashMap<>();
        Map<Character, Integer> rightMap = new HashMap<>();
        int nSplit = 0;
       	leftMap.put(s.charAt(0), 1);
       	for (int i = 1; i < s.length(); i ++){
       		if (rightMap.containsKey(s.charAt(i))) rightMap.put(s.charAt(i), rightMap.get(s.charAt(i)) + 1);
       		else rightMap.put(s.charAt(i), 1);
       	}

       	for (int i = 1; i < s.length; i ++) {
       		if (leftMap.keySet().size() == rightMap.keySet().size()) nSplit += 1;
       		else if (leftMap.keySet().size() < rightMap.keySet().size()) {
       		if (leftMap.containsKey(s.charAt(i))) leftMap.put(s.charAt(i), leftMap.get(s.charAt(i)) + 1);
       		else leftMap.put(s.charAt(i), 1);
       		if (rightMap.get(s.charAt(i)) == 1) rightMap.remove(s.charAt(i));
       		else rightMap.put(s.charAt(i), rightMap.get(s.charAt(i)) - 1);
       	}
       	}

    }
}


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class ListNode {
 *     int val;
 *     ListNode left;
 *     ListNode right;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode left, ListNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
	class Res {
		ListNode rootNode;
		ListNode leftSide;
		ListNode rightSide;
		Res(ListNode rootNode, ListNode leftSide, ListNode rightSide) {
			this.rootNode = rootNode;
			this.leftSide = leftSide;
			this.rightSide = rightSide;
		}
	}
    public ListNode sortedListToBST(ListNode head) {
        return createBST(head);
    }
    ListNode createBST(ListNode head){
    	if (head == null) return null;
    	Res res = find(head);
    	ListNode root = new ListNode(res.rootNode.val, null, null);
    	root.left = createBST(res.leftSide);
    	root.right = createBST(res.rightSide);
    	return root;
    }
    Res find(ListNode head) {
    	ListNode preSlowP = null;
    	ListNode slowP = head;
    	ListNode fastP = head;
    	while(fastP.next != null) {
    		preSlowP = slowP;
    		slowP = slowP.next;
    		fastP = fastP.next;
    		if (fastP.next != null) fastP = fastP.next;
    	}
    	if (preSlowP != null) preSlowP.next = null;
    	if (slowP == head) return new Res(slowP, null, null);
    	else return new Res(slowP, head, slowP.next);
    }

}


class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        String start = "JFK";
        List<String> res = new ArrayList<>();

        find(start, new ArrayList<>(), tickets, res);
        return res;

    }

    def void find(String start, List<Integer> used, List<List<String>> tickets, List<String> res) {
    	List<Integer> startWithIndex = new List<Integer>();
    	for (int i = 0; i < tickets.size(); i ++) {
    		if (!used.contains(i) && tickets.get(i).get(0).equals(start))
    			startWith.add(i);
    	}
    
    	Optional<Integer> nextIndex = startWith.stream().sorted(Comparator.comparing(i -> tickets.get(i).get(1))).peek(i -> used.add(i)).findAny();
    	if (!nextIndex.isEmpty) {
    		res.add(tickets.get(nextIndex.get()));
    		find(tickets.get(nextIndex.get()).get(1), used, tickets, res);
    	}
    }
}


class Solution {
    public boolean checkZeroOnes(String s) {
    	int current0Length = 0;
    	int current1Length = 0;
    	int max1Length = 0;
    	int max0Length = 0;
    	int previous = s.charAt(0);
    	if (previous == '0') current0Length = 1;
    	else current1Length = 1;
        for (int i = 1; i < s.size; i ++) {
        	if (previous == s.charAt(i)) {
        		if (s.charAt(i) == '1') current1Length += 1;
        		else current0Length += 1;
        	} 
        	else {
        		if (previous == '1') {
        			if (current1Length > max1Length) max1Length = current1Length;
        			current1Length = 0;
        			current0Length = 1;
        		} else {
        			if (current0Length > max0Length) max0Length = current0Length;
        			current0Length = 0;
        			current1Length = 1;
        		}
        	}

        	previous = s.charAt(i);
        }

        if (current1Length > max1Length) max1Length = current1Length;
        if (current0Length > max0Length) max0Length = current0Length;

        return max1Length > max0Length;
    }
}


class Solution {
    public boolean isUnivalTree(ListNode root) {
        if (root == null) return true;
        return check(root, roo.val);
    }
    
    private boolean check(ListNode root, int value) {
        if (root == null) return true;
        else {
        	return root.val == value && check(root.left, value) && check(root.right, value) ;
        }
    }
}


class Solution {
    public int[] countBits(int n) {
        int[] res = new int[n + 1];
        for (int i = 0; i < res.length; i ++) {
        	res[i] = -1;
        }
        for (int i = 0; i < res.length; i ++) {
        	res[i] = countOneBitIn(i, res);
        }
        return res;

    }

    private int countOneBitIn(int val, int[] dp) {
    	int count = 0;
    	while (val != 0) {
    		if (dp[val] != -1) {
    			count += dp[val];
    			val = 0;
    		} else {
    			if (val % 2 == 1) count ++;
    			val = val/2;
    		}
    	}
    	return count;
    }
}


//Backtrack
class Solution {
    public int countVowelStrings(int n) {
    	int total = 0;
    	int[][] dp = new int[5][n + 1];
    	for (int i = 0; i < 5; i ++) {
    		for (int j = 0; j < n + 1; j ++) {
    			if (j == 0) dp[i][j] = 1;
    			else dp[i][j] = -1;
    		}
    	}
    	total += count(n - 1, 'a', dp);
    	total += count(n - 1, 'e', dp);
    	total += count(n - 1, 'i', dp);
    	total += count(n - 1, 'o', dp);
    	total += count(n - 1, 'u', dp);
    	return total;
    }

    private int count(int n, char lastCharacter, int[][] dp) {
    	if (n == 0) return 1;
    	int total = 0;
    	
    	if (lastCharacter >= 'a'){
    		if (dp[0][n - 1] != -1) total += dp[0][n - 1];
    		else total += count(n - 1, 'a', dp);	
    		dp[0][n] = total;
    	} 
 		if (lastCharacter >= 'e'){
    		if (dp[1][n - 1] != -1) total += dp[1][n - 1];
    		else total += count(n - 1, 'e', dp);	
    		dp[1][n] = total;
    	} 
    	if (lastCharacter >= 'i'){
    		if (dp[2][n - 1] != -1) total += dp[2][n - 1];
    		else total += count(n - 1, 'i', dp);	
    		dp[2][n] = total;
    	} 
    	if (lastCharacter >= 'o'){
    		if (dp[3][n - 1] != -1) total += dp[3][n - 1];
    		else total += count(n - 1, 'o', dp);	
    		dp[3][n] = total;
    	} 
    	if (lastCharacter >= 'u'){
    		if (dp[4][n - 1] != -1) total += dp[4][n - 1];
    		else total += count(n - 1, 'u', dp);	
    		dp[4][n] = total;
    	} 
    	return total;
    
    }


}



class Solution {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length == 1) return 1;
        if (nums.length == 2) return 2;
        int nCurDir = 0;
        int nEqual = 1;
        int nDelete = 0;
        for (int i = 0; i < nums.length - 1; i ++) {
        	if (nums[i] == nums[i + 1]) nEqual += 1;
        	else if (nEqual != 0) {
        		nDelete += (nEqual - 1);
        		nEqual = 1;
        	}
        }
        nDelete += (nEqual - 1);
        for (int i = 0; i < nums.length - 1; i ++) {
        	if (nCurDir == 0) {
        		if (nums[i] < nums[i + 1]) nCurDir = 1;
        		else if (nums[i] > nums[i + 1])nCurDir = -1;
        	}
        	else if (nCurDir > 0) {
        		if (nums[i] < nums[i + 1]) nCurDir += 1;
        		else if (nums[i] > nums[i + 1]) {
        			nDelete += (Math.abs(nCurDir) - 1);
        			nCurDir = -1;
        		}
        	} else {
        		if (nums[i] > nums[i + 1]) nCurDir -= 1;
        		else if (nums[i] < nums[i + 1]){
        			nDelete += (Math.abs(nCurDir)  - 1);
        			nCurDir = 1;
        		}
        	}
        }
        if (nCurDir != 0)
        	nDelete += (Math.abs(nCurDir) - 1);

        return nums.length - nDelete;
    }
}

    class Solution {
        public int minDays(int[][] grid) {
            if (numOfIsland(grid) != 1) return 0;
            for (int i = 0; i < grid.length; i ++) {
                for (int j = 0; j < grid[0].length; j ++){
                    if (grid[i][j] == 1) {
                        grid[i][j] = 0;
                        if (numOfIsland(grid) > 1) return 1;
                        grid[i][j] = 1;
                    }
                }
            }

            return 2;
        }


        int numOfIsland(int[][] grid) {

            int[][] visitedMap = new int[grid.length][grid[0].length];
            for (int i = 0; i < grid.length; i ++) {
                for (int j = 0; j < grid[0].length; j ++) {
                    visitedMap[i][j] = grid[i][j];
                }
            }

            int nIsland = 0;
            for (int i = 0; i < grid.length; i ++) {
                for (int j = 0; j < grid[0].length; j ++) {
                    if (visitedMap[i][j] == 1){
                        nIsland += 1;
                        dfs(i, j, visitedMap);
                    }
                }
            }
            return nIsland;
        }

        void dfs(int posX, int posY, int[][] visitedMap) {
            if (posX <0 || posY < 0 || posX >= visitedMap.length || posY >= visitedMap[0].length || visitedMap[posX][posY] == 0) return;
            visitedMap[posX][posY] = 0;
            dfs(posX + 1, posY, visitedMap);
            dfs(posX - 1, posY, visitedMap);
            dfs(posX, posY + 1, visitedMap);
            dfs(posX, posY - 1, visitedMap);
        }
    }

// 0 1 3


class Solution {
    public boolean canCross(int[] stones) {


        return jump(0, 0, stones);
    }

    public boolean jump(int start, int previousLength, int[] stones) {
    	if (start == stones.length - 1) return true;
    	boolean res = false;
    	int index = start + 1;
    	while (index < stones.length && stones[index] <= stones[start] + previousLength + 1) {
    		if (stones[index] <= stones[start] + previousLength + 1 && stones[index] >= stones[start] + previousLength - 1)  res = res || jump(index, stone[index] - stones[start], stones);
    		index += 1;
    	}

    	return res;
    }
}



class Solution {
    public boolean canCross(int[] stones) {
    	int[] lastJump = new int[stones.length];
    	for (int i = 0; i < lastJump.length; i ++) {
    		lastJump[i] = 0;
    	}

        return jump(0, 0, stones, lastJump);
    }

    public boolean jump(int start, int previousLength, int[] stones, int[] lastJump) {
    	if (start == stones.length - 1) return true;
    	boolean res = false;
    	int index = start + 1;
    	while (index < stones.length && stones[index] <= stones[start] + previousLength + 1) {
    		if (stones[index] <= stones[start] + previousLength + 1 && stones[index] >= stones[start] + previousLength - 1 && lastJump[index] < stones[index] - stones[start]) {
    			lastJump[index] = stones[index] - stones[start];
    			res = res || jump(index, stones[index] - stones[start], stones, lastJump);
    		}
    		index += 1;
    	}

    	return res;
    }
}

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
    	List<Integer> res = new ArrayList<>();
        if (arr[0] > x) {
        	for (int i = 0; i < k; i ++) {
        		res.add(arr[i]);
        	}
        } else if (arr[arr.length - 1] < x ) {
        	for (int i = k; i >= 1; i ++) {
        		res.add(arr[arr.length - i]);
        	}
        } else {
        	int i = 0;
        	int left = 0;
        	int right = 0;
        	while(!(arr[i] == x || (arr[i] <= x && arr[i  + 1] >= x))) {
        		i ++;
        	}
        	left = i;
        	right = i + 1;

        	for (i = 0; i < k; i ++) {
        		if (left >= 0 && right >= arr.length) {
        			left = left - 1;
        		} else if (left < 0 && right < arr.length) {
        			right = right + 1;
        		} 
        		if (left >= 0 && right < arr.length && Math.abs(arr[left] - x) < Math.abs(arr[right] - x)) {
        			left = left - 1;
        		} else if (left >= 0 && right < arr.length && Math.abs(arr[left] - x) > Math.abs(arr[right] - x)) {
        			right = right + 1;
        		} else if (left >= 0 && right < arr.length) {
        			left = left - 1;
        		}
        	}
        

        	for (i = left + 1; i < right; i ++){
        		res.add(arr[i]);
        	}

        }

        return res;
    }
}

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
    	int left = 0;
    	int right = arr.length - k;

    	while (left < right) {
    		int mid = (left + right)/2;
    		if (x - arr[mid] > arr[mid + k] - x){
    			left = mid + 1;
    		} else {
    			right = mid;
    		}
    	}

    	List<Integer> res = new ArrayList<>();
    	for (int i = left; i < left + k; i ++) {
    		res.add(arr[i]);
    	}

    	return res;
    }
}

[0,1,3,5,6,8,12,17]



    class Solution {
        public boolean canCross(int[] stones) {
            int[][] dp = new int[stones.length][stones.length];
            for (int i = 0; i < stones.length; i++) {
                for (int j = i; j < stones.length; j++) {
                    dp[i][j] = stones[j] - stones[i];
                }
            }

            return jump(0, 0, dp);
        }

        private boolean jump(int start, int preStep, int[][] dp) {
            if (start == dp.length - 1) return true;
            int i = start + 1;
            boolean res = false;
            while (i < dp.length && dp[start][i] <= preStep + 1) {
                if (dp[start][i] >= preStep - 1 && dp[start][i] <= preStep + 1) {
                    int step = dp[start][i];
                    dp[start][i] = -1;
                    res = res || jump(i, step, dp);
                }
                i += 1;
            }

            return res;
        }

    }

//remove duplicate, modify algorithm to remove duplicate(below algorithm using set to remoev duplicated item)

    class Solution {
        public List<List<Integer>> palindromePairs(String[] words) {
            Set<List<Integer>> res = new HashSet<>();
            Map<String, List<Integer>> strToIndex = new HashMap<>();
            for (int i = 0; i < words.length; i++) {
                String reveredStr = reverse(words[i]);
                if (strToIndex.containsKey(words[i]))
                    strToIndex.get(words[i]).add(i);
                else {
                    List<Integer> listIndex = new ArrayList<>();
                    listIndex.add(i);
                    strToIndex.put(words[i], listIndex);
                }

                if (strToIndex.containsKey(reveredStr))
                    strToIndex.get(reveredStr).add(i);
                else {
                    List<Integer> listIndex = new ArrayList<>();
                    listIndex.add(i);
                    strToIndex.put(reveredStr, listIndex);
                }
            }

            int empIndex = -1;
            for (int i = 0; i < words.length; i ++){
                if (words[i].equals("")) empIndex = i;
            }
            if (empIndex != -1) {
                for (int i = 0; i < words.length; i ++) {
                    if (checkPalindrome(words[i], "") && i != empIndex) {
                        List<Integer> listRes = new ArrayList<>();
                        listRes.add(i);
                        listRes.add(empIndex);
                        res.add(new ArrayList<>(listRes));
                        Collections.reverse(listRes);
                        res.add(listRes);
                    }
                }
            }
            for (int i = 0; i < words.length; i++) {
                String reveredStr = reverse(words[i]);
                Integer strIndex = i;
                for (int j = 0; j < words[i].length(); j++) {
                    String rightSubString = words[i].substring(0, j + 1);
                    if (strToIndex.containsKey(rightSubString)) {

                        strToIndex.get(rightSubString).stream()
                                .filter(index -> !index.equals(strIndex))
                                .filter(index -> checkPalindrome(words[strIndex], words[index]))
                                .forEach(index -> {
                                    List<Integer> listRes = new ArrayList<>();
                                    listRes.add(strIndex);
                                    listRes.add(index);
                                    res.add(listRes);
                                });
                    }

                    String leftSubString = reveredStr.substring(0, j + 1);
                    if (strToIndex.containsKey(leftSubString)) {
                        strToIndex.get(leftSubString).stream()
                                .filter(index -> !index.equals(strIndex))
                                .filter(index -> checkPalindrome(words[index], words[strIndex]))
                                .forEach(index -> {
                                    List<Integer> listRes = new ArrayList<>();
                                    listRes.add(index);
                                    listRes.add(strIndex);
                                    res.add(listRes);
                                });
                    }
                }
            }

            return new ArrayList<>(res);
        }

        private boolean checkPalindrome(String a, String b) {
            String res = a + b;
            for (int i = 0; i < res.length(); i++) {
                if (res.charAt(i) != res.charAt(res.length() - i - 1)) return false;
            }
            return true;
        }

        private String reverse(String s) {
            StringBuilder strBuilder = new StringBuilder();
            strBuilder.append(s);
            strBuilder.reverse();
            return strBuilder.toString();
        }
    }



    /**
 * Definition for a binary tree node.
 * public class ListNode {
 *     int val;
 *     ListNode left;
 *     ListNode right;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(ListNode root) {
        StringBuilder encodeBuilder = new StringBuilder();
        build(root, encodeBuilder);
        return encodeBuilder.toString();
    }

    private void build(ListNode root, StringBuilder encodeBuilder) {
    	if (root == null) return;
    	String value = fromIntToBinary(root.val);
    	encodeBuilder.append(value);
    	String pattern = nodeToPattern(root);
    	encodeBuilder.append(pattern);
    	build(root.left, encodeBuilder);
    	build(root.right, encodeBuilder);
    }

    //11 bit integer value 
    //first bit -> negative(1) or not(0)
    private String fromIntToBinary(Integer value) {
    	StringBuilder binaryBuilder = new BinaryBuilder();
    	while(value != 0) {
    		int remain = value % 2;
    		value = value / 2;
    		binaryBuilder.append(remain);
    	}
    	for (int i = 0; i < 11 - binaryBuilder.length(); i ++) {
    		binaryBuilder.append('0');
    	}
    	return binaryBuilder.toString();
    }

    private Integer fromBinaryToInt(String str, int start) {
    	Integer res = 0;
    	for (int i = 0; i < 11; i ++) {
    		res += Integer.valueOf(binary.charAt(start + i)) * Math.pow(2, i)
    	}	
    }

    private String nodeToPattern(ListNode root) {
    	if (root.left != null && root.right != null) "11";
    	else if (root.left == null && root.right == null) "00";
    	else if (root.left != null & root.right == null) "10";
    	else "01";
    }



    // Decodes your encoded data to tree.
    public ListNode deserialize(String data) {
        if (data == null || data.equals("")) return null;
        else return decode(new DecodeData(data, 0));
    }

	private ListNode decode(DecodeData data) {
		ListNode ListNode = new ListNode();
		Integer val = fromBinaryToInt(data.data, data.index);
		root.val = val;
		data.index += 11;
		String nodePattern = data.substring(data.index , data.index + 3);
		data.index += 2;
		if (nodePattern.equals("11")) {
			ListNode left = decode(data);
			ListNode right = decode(data);
			root.left = left;
			root.right = right;
		} else if (nodePattern.equals("10")){
			ListNode left = decode(data);
			root.left = left;	
		} else if (nodePattern.equals("01")) {
			ListNode right = decode(data);
			root.right = right;
		}

		return ListNode;
	}

	class DecodeData{
		public String data;
		public Integer index;

		public DecodeDate(String data, Integer index) {
			this.data = data;
			this.index = index;
		}
	}

}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// ListNode ans = deser.deserialize(ser.serialize(root));



class Solution {
    public int findShortestSubArray(int[] nums) {
   		//find the max max frequencey value
    	Map<Integer, Integer> valueFrequency = new HashMap<>();
    	int maxFrequency = 1;
    	for (int i = 0; i < nums.length; i ++) {
    		if (valueFrequency.containsKey(nums[i])){
    			valueFrequency.put(nums[i], valueFrequency.get(nums[i]) + 1);
    			if (valueFrequency.get(nums[i]) > maxFrequency) maxFrequency = valueFrequency.get(nums[i]);
    		} else {
    			valueFrequency.put(nums[i], 1);
    		}
    	}
    	List<Integer> maxFrequencyValueList = new ArraysList<>();
   		//find all the element with max frequency
    	for(Integer key: valueFrequency.keySet()) {
    		if (valueFrequency.get(key) == maxFrequency) maxFrequencyValueList.add(key);
    	}
    	int firstIndex = nums.length;

    	for (int i = 0; i < maxFrequencyValueList.size(); i ++) {
    		int lastIndex = -1;
    		int minimunLength = nums.length;
    		for (int j = 0; j < nums.length; j ++){
    			if (nums[j] == maxFrequencyValueList.get(i)) {
    				if (j < firstIndex) firstIndex = j;
    				if (j > lastIndex) lastIndex = j;
    			}
    		}
    		if (minimunLength > lastIndex - firstIndex + 1) minimunLength = lastIndex - firstIndex + 1;
    	}

   		//get first-last indef of each element
   		//get diffient between first -last of each element -> get minimun value     

   		return minimunLength;
    }
}

    class Solution {
        public int[][] matrixBlockSum(int[][] mat, int k) {
            int width = mat[0].length;
            int height = mat.length;
            int [][] verticalSumMap = new int[height][width];
            int [][] horizontalSumMap = new int[height][width];

            for (int i = 0; i < height; i ++){
                for (int j = 0; j < width; j ++) {
                    verticalSumMap[i][j] = sumVertical(mat, i, j, k);
                    horizontalSumMap[i][j] = sumHorizontal(mat, i, j, k);
                }
            }

            int[][] res = new int[height][width];
            for (int j = 0; j < Math.min(k + 1, width); j ++) {
                res[0][0] += verticalSumMap[0][j];
            }

            for (int i = 1; i < height; i ++) {
                if (i <= k && i + k < height) {
                    res[i][0] = res[i - 1][0] + horizontalSumMap[i + k][0];
                } else if (i >= height - k && i - k - 1 >= 0) {
                    res[i][0] = res[i - 1][0] - horizontalSumMap[i - k - 1][0];
                } else if (i + k < height){
                    res[i][0] = res[i - 1][0] + horizontalSumMap[i + k][0] - horizontalSumMap[i - k - 1][0];
                } else {
                    res[i][0] = res[i - 1][0];
                }
            }
            for (int i = 0; i < height; i ++) {
                for (int j = 1; j < width; j ++) {
                    if (j <= k && j + k < width) {
                        res[i][j] = res[i][j - 1] + verticalSumMap[i][j + k];
                    } else if (j >= width - k && j - k - 1 >= 0) {
                        res[i][j] = res[i][j - 1] - verticalSumMap[i][j - k - 1];
                    } else if (j + k < width){
                        res[i][j] = res[i][j - 1] + verticalSumMap[i][j + k] - verticalSumMap[i][j - k - 1];
                    } else {
                        res[i][j] = res[i][j - 1];
                    }
                }
            }

        }


        int sumHorizontal(int[][] mat, int posX, int posY, int k) {
            int sum = 0;
            for (int i = posY - k; i <= posY + k ; i ++) {
                if (i >= 0 && i < mat[0].length) {
                    sum += mat[posX][i];
                }            return res;

            }
            return sum;
        }

        int sumVertical(int[][] mat, int posX, int posY, int k) {
            int sum = 0;
            for (int i = posX - k; i <= posX + k ; i ++) {
                if (i >= 0 && i < mat.length) {
                    sum += mat[i][posY];
                }
            }
            return sum;
        }
    }


//DFS from root node to get a array of element, one swap make 2 element in wrong order. 
class Solution {
    public void recoverTree(ListNode root) {
        List<Integer> dfsTraverse = new ArrayList<>();
        traverse(root, dfsTraverse);
        int left = -1;
        int right = -1;
       	
       	for (int i = 0; i < (dfsTraverse.size() + 1)/2; i ++) {
       		if (left == -1 && dfsTraverse.get(i) > dfsTraverse.get(i + 1)) left = i;
       		if (right == -1 && dfsTraverse.get(dfsTraverse.size() - i - 1) < dfsTraverse.get(dfsTraverse.size() -i - 2)) right = i;
       	}

        recoverTree(root, dfsTraverse.get(leftP), dfsTraverse.get(rightP));



    }

    void traverse(ListNode root, List<Integer> dfsTraverse) {
    	if (root.left != null) traverse(root.left, dfsTraverse);
    	if (root != null) dfsTraverse.add(root.val);
    	if (root.right != null) traverse(root.right, dfsTraverse);
    }

    void recoverTree(ListNode root, int ele1, int ele2) {
    	if (root.left != null) recoverTree(root.left, ele1, ele2);
    	if (root != null) {
    		if (root.val == ele1) root.val = ele2;
    		else if (root.val == ele2) root.val = ele1;
    	}
    	if (root.right != null) recoverTree(root.right, ele1, ele2);
    }
}

class Solution {
    public void recoverTree(ListNode root) {
    
    	List<Integer> swaped = new ArrayList<>();

    	dfs(root, Integer.MIN_VALUE, Integer.MAX_VALUE, swaped);

    	recoverTree(root, swaped.get(0), swaped.get(1));


    }


    void recoverTree(ListNode root, int ele1, int ele2) {
    	if (root.left != null) recoverTree(root.left, ele1, ele2);
    	if (root != null) {
    		if (root.val == ele1) root.val = ele2;
    		else if (root.val == ele2) root.val = ele1;
    	}
    	if (root.right != null) recoverTree(root.right, ele1, ele2);
    }

    int dfs(ListNode root, int lowerBound, int upperBound, List<Integer> swaped, boolean isLeft) {
    	int childLowerBound = Int.MIN_VALUE;
    	int childUpperBound = Int.MAX_VALUE;
    	if (root.left != null) childLowerBound = Math.max(dfs(root.left, lowerBound, root.val, swaped, true), lowerBound);
       	if (root.right != null) childUpperBound= Math.min(dfs(root.right, root.val, upperBound, swaped, false), upperBound);

       	if (swap.size() == 0 && (root.val >  Math.max(upperBound, childUpperBound) && root.val > Math.max(lowerBound, childUpperBound))) swaped.add(root.val);
    	else if (swap.size() == 1 && (root.val < Math.max(lowerBound, childUpperBound) && root.val < Math.max(upperBound, childUpperBound)) ) swaped.add(root.val);
    	if (isLeft) return Math.max(childUpperBound, root.val);
    	else return Math.min(root.val, childLowerBound);
    }
}


public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
    	int total1s = 0;
        if (n >= 0) {
        	char[] binary = decToBinary(n);
        	for (int i = 0; i < binary.length; i ++) {
        		if (binary[i] == '1') total1s += 1;
        	}
        } else {
        	int twoComplementN = -1 * n;
        	char[] binary = decToBinary(n);
        	reverse(binary);
        	plusOne(binary);
        	for (int i = 0; i < binary.length; i ++) {
        		if (binary[i] == '1') total1s += 1;
        	}
        }

        return total1s;
    }

	char[] decToBinary(int n) {
		char[] binary = new char[32];
		for (int i = 0; i < 32; i ++) {
			int mod = n % 2;
			if (mod == 0) binary[i] = '0';
			else binary[i] = '1';
			n = n / 2;
		}
		return binary;
	}

	void reverse(char[] binary) {
		for (int i = 0; i < binary.length; i ++) {
			if (binary[i] == '0') binary[i] = '1';
			else binary[i] = '0';
		}
	}

	void plusOne(char[] binary) {
		int plus = 1;
		for (int i = 0; i < 32; i ++){
			if (plus == 1) {
				if (binary[i] == '1') {
					binary[i] = '0';
					plus = 1;
				} else {
					binary[i] = '1';
					plus = 0;
				}
			}
		}
	}
}


   class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            return merge(lists, 0, lists.length);
        }

        ListNode merge(ListNode[] lists, int start, int end) {
            int middle = (start + end) / 2;

            if (end - start == 1) return lists[start];
            else if (end - start == 0) return null;

            ListNode leftNode = merge(lists, start, middle);
            ListNode rightNode = merge(lists, middle, end);

            return combine(leftNode, rightNode);
        }

        ListNode combine(ListNode left, ListNode right) {
            ListNode lPointer = left, rPointer = right;
            ListNode cur = null;
            while (lPointer != null && rPointer != null) {
                if (lPointer.val <= rPointer.val) {
                   if (cur == null) {
                       cur = lPointer;
                   } else {
                       cur.next = lPointer;
                       cur = cur.next;
                   }
                   lPointer = lPointer.next;
                } else {
                  if (cur == null) {
                      cur = rPointer;
                  } else {
                      cur.next = rPointer;
                      cur = cur.next;
                  }
                  rPointer = rPointer.next;
                }
            }

            while (lPointer != null) {
                if (cur == null) {
                    cur = lPointer;
                } else {
                    cur.next = lPointer;
                    cur = cur.next;
                }
                lPointer = lPointer.next;
            }

            while (rPointer != null) {
                if (cur == null) {
                    cur = rPointer;
                } else {
                    cur.next = rPointer;
                    cur = cur.next;
                }
                rPointer = rPointer.next;
            }

            if (left != null && right != null) return left.val <= right.val ? left : right;
            else if (left != null) return left;
            else return right; 
        }


    }


class Solution {
    public int[] findPeakGrid(int[][] mat) {
        return find(mat, 0, 0, mat.length, mat[0].length);
    }

    private int[] find(int[][] mat, int x, int y, int maxX, int maxY) {
    	int middleX = (x + maxX)/2;
    	int middleY = (y + maxY)/2;
    	if (middleX == x && middleY == y) return new int[]{x, y};
    	int[] leftTop = find(mat, x, y, middleX, middleY);
    	int[] rightTop = find(mat, x, middleY, middleX, maxY);
    	int[] leftBot = find(mat, middleX, y, maxX, middleY);
    	int[] rightBot = find(mat, middleX, middleY, maxX, maxY);

    	return max(mat, leftTop, rightTop, leftBot, rightBot);
    }

    int[] max(int[][] mat, int[] leftTop, int[] rightTop, int[] leftBot, int[] rightBot) {
    	int leftTopValue = mat[leftTop[0]][leftTop[1]];
    	int rightTopValue = mat[rightTop[0]][rightTop[1]];
    	int leftBotValue = mat[leftBot[0]][leftBot[1]];
    	int rightBotValue = mat[rightBot[0]][rightBot[1]];

    	int max = Math.max(Math.max(leftTopValue, leftBotValue), Math.max(rightTopValue, rightBotValue));

    	if (max == leftTopValue) return leftTop;
    	else if (max == leftBotValue) return leftBot;
    	else if (max == rightTopValue) return rightTop;
    	else return rightBot;
    }
}


class Solution {
    public int[] beautifulArray(int n) {

    }

    int[] build(int pos, int[], int[] arr) {

    }
}


    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            return search(0, 0, matrix.length, matrix[0].length, matrix, target);
        }

        boolean search(int startX, int startY, int endX, int endY, int[][] matrix, int target) {
            int middleX = (startX + endX)/2;
            int middleY = (startY + endY)/2;
            if (startX > endX || startY > endY ) return false;
            if (startX == middleX && startY == middleY) return matrix[middleX][middleY] == target;
            if (checkCross(middleX, middleY, matrix, target)) return true;
            else {
            	boolean res = false;
            	if (matrix[middleX][startY] < target) 
            		res = res || search(middleX, startY, endX, middleY , matrix, target);
           		if (matrix[startX][middleY] < target)
            		res = res || search(startX, middleY, middleX, endY, matrix, target);
                if (matrix[middleX][middleY] < target) 
                    res = res || search(startX, startY, middleX, middleY, matrix, target);
                if (matrix[middleX][middleY] > target)
            		res = res || search(startX, startY, middleX, middleY, matrix, target);
            	return res;
            }
        }

        boolean checkCross(int posX, int posY, int[][] matrix, int target) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[posX][j] == target) return true;
            }

            for (int i = 0; i < matrix.length; i++) {
                if (matrix[i][posY] == target) return true;
            }

            return false;
        }
    }


class Solution {
    public int longestSubstring(String s, int k) {
        Map<Character, Integer> charNumMap = new HashMap<Character, Integer>();

        for (int i = 0; i < s.length(); i ++) {
        	charNumMap.merge(s.charAt(i), 1, Integer::sum);
        }

        int left = 0, right = s.length() - 1, curLeft = 0, curRight = s.length() - 1;

        while(checkMap(charNumMap, k) && left < right) {
        	curLeft = left;
        	curRight = right;
        	while(charNumMap.get(s.charAt(curLeft)) < minCount) {
        		curLeft += 1;
        	}

        	while(charNumMap.get(s.charAt(curRight)) < minCount) {
        		curRight -= 1;
        	}

        	
        	if (curLeft - left <= right - curRight) {
        		while(left <= curLeft) {
        			charNumMap.merge(s.charAt(left), -1, Integer::sum);
        			left += 1;
        		}
        	} else {
        		while(right >= curRight) {
        			charNumMap.merge(s.charAt(right), -1, Integer::sum);
        			right -= 1;
        		}
        	}
        	
        }

        return right - left + 1;
    }

	boolean checkMap(Map<Character, Integer> charNumMap, int minCount) {
		return charNumMap.values.stream.nonMatch(val -> val < minCount && val > 0);
	}
}

-2 , 5, 1


    class Solution {
        public int countRangeSum(int[] nums, int lower, int upper) {
            int total = 0;
            long[] dp = new long[nums.length];
            for (int i = 0; i < nums.length; i ++) {
                if (isBetween(nums[i], lower, upper)) total += 1;
            }

            for (int start = 0; start < nums.length; start ++) {
                dp[start] = nums[start];
                for (int size = 1; size < nums.length - start; size ++) {
                    long sum = dp[start + size - 1] + nums[start + size];
                    if (isBetween(sum, lower, upper)) total += 1;
                    dp[start + size] = sum;
                }

            }

            return total;
        }

        boolean isBetween(long val, int lower, int upper){
            return val <= upper && val >= lower;
        }
    }

  class Solution {
        public int countRangeSum(int[] nums, int lower, int upper) {

            int[] preSum = new int[nums.length + 1];
            preSum[0] = 0;
            for (int i = 1; i < nums.length + 1; i ++) {
                preSum[i] = preSum[i - 1] + nums[i - 1];
            }

            return mergeSort(preSum, 0, nums.length, lower, upper);

        }


        private int mergeSort(int[] preSum, int low, int high, int lower, int upper) {
            int middle = (low + high) / 2;
            if (low == high) return 0;
            int leftCount = mergeSort(preSum, low, middle, lower, upper);
            int rightCount = mergeSort(preSum, middle + 1, high, lower, upper);


            int leftEnd = middle + 1, rightEnd = middle + 1;
            int currentCount = 0;
            for (int start = low; start <= middle; start ++) {
                while(leftEnd <= high && preSum[leftEnd] - preSum[start] < lower) leftEnd ++;
                while(rightEnd <= high && preSum[rightEnd] - preSum[start] <= upper) rightEnd ++;

                currentCount += rightEnd - leftEnd;
            }

            merge(preSum, low, middle, high);

            return currentCount + leftCount + rightCount;
        }

        private void merge(int[] preSum, int low, int middle, int high) {
            int[] tempArray = new int[high - low + 1];
            int leftIndex = low;
            int rightIndex = middle + 1;
            while (leftIndex <= middle && rightIndex <= high) {
                if (preSum[leftIndex] <= preSum[rightIndex]){
                    tempArray[leftIndex + rightIndex - low - middle - 1] = preSum[leftIndex];
                    leftIndex += 1;
                } else {
                    tempArray[leftIndex + rightIndex - low - middle - 1] = preSum[rightIndex];
                    rightIndex += 1;
                }
            }

            while (leftIndex <= middle) {
                tempArray[leftIndex + rightIndex - low - middle - 1] = preSum[leftIndex];
                leftIndex += 1;
            }

            while (rightIndex <= high) {
                tempArray[leftIndex + rightIndex - low - middle - 1] = preSum[rightIndex];
                rightIndex += 1;
            }

            for (int i = low; i <= high; i ++) {
                preSum[i] = tempArray[i - low];
            }

        }

    }

class Solution {
    public List<Integer> countSmaller(int[] nums) {
        int[] result = new int[nums.length];
        int[] index = new int[nums.length];
        for (int i = 0; i < nums.length; i ++) {
            result[i] = 0;
            index[i] = i;
        }

        mergeSort(nums, index, result, 0, nums.length - 1);
        return Arrays.asList(result);
    }

    void mergeSort(int[] nums, int[] index, int[] result, int low, int high) {
        int middle = (low + high)/2;
        if (low >= high) return;
        mergeSort(nums, index, result, low, middle);
        mergeSort(nums, index, result, middle + 1, high);
        int end = middle + 1;
        for (int start = low; start <= middle; start ++) {
            while (nums[index[end]] < nums[index[start]]) end += 1;
            result[index[start]] += end - middle - 1;
        }

        merge(int[] nums. int[] index, int low, int middle, int high) {
            int iLeft = low, iRight = middle + 1;
            int[] tempArray = new int[high - low + 1];
            while (iLeft <= middle && iRight <= high) {
                if (nums[index[iLeft]] <= nums[index[iRight]]) {
                    tempArray[iLeft + iRight - low - middle - 1] = index[iLeft];
                    iLeft ++;
                } else {
                    tempArray[iLeft + iRight - low - middle - 1] = index[iRight];
                    iRight ++;   
                }
            }

            while (iLeft <= middle) {
                tempArray[iLeft + iRight - low - middle - 1] = index[iLeft];
                iLeft ++;
            }

            while (iRight <= high) {
                tempArray[iLeft + iRight - low - middle - 1] = index[iRight];
                iRight ++; 
            }

            for (int i = low; i <= high; i++){
                index[i] = tempArray[i];
            }
        }
    }
}


class Solution {
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);

    }


    int mergeSort(int[] nums, int low, int high) {
        int middle = (low + high)/2;
        if (low >= high) return 0;

        int leftRevPair = mergeSort(nums, low, middle);
        int rightRevPair = mergeSort(nums, middle + 1, high);

        int curRevPair = 0;
        int iEnd = middle + 1;
        for (int i = low; i <= middle; i ++) {
            while (iEnd <= high && nums[i] > 2 * nums[iEnd]) iEnd += 1;
            curRevPair += iEnd - middle - 1;
        }

        merge(nums, low, middle, high);
        return leftRevPair + rightRevPair + curRevPair;
    }
    void merge(int[] nums, int low, int middle, int high) {
        int[] tempArray = new int[high - low + 1];
        int iLeft = low, iRight = middle + 1;
        while(iLeft <= middle && iRight <= high) {
            if (nums[iLeft] <= nums[iRight]) {
                tempArray[iLeft + iRight - low - middle - 1] = nums[iLeft];
                iLeft += 1;
            } else {
                tempArray[iLeft + iRight - low - middle - 1] = nums[iRight];
                iRight += 1;
            }
        }

        while (iLeft <= middle){
            tempArray[iLeft + iRight - low - middle - 1] = nums[iLeft];
            iLeft += 1;
        }

        while (iRight <= high) {
            tempArray[iLeft + iRight - low - middle - 1] = nums[iRight];
            iRight += 1;
        }

        for (int i = low; i <= high; i ++){
            nums[i] = tempArray[i - low];
        }

    }
}

//7 9 15 -2
//goal = 6
  class Solution {
        public int minAbsDifference(int[] nums, int goal) {
            //Add 0 element
            int minDis = Math.abs(goal);
            Result result = mergeSort(nums, 0, nums.length - 1, goal);
            if (result.minDis < minDis) return result.minDis;
            else return minDis;

        }

        class Result{
            private List<Integer> sumSub;
            private int minDis;
            Result(List<Integer> sumSub, int minDis) {
                this.sumSub = sumSub;
                this.minDis = minDis;
            }
        }
        Result mergeSort(int[] nums, int low, int high, int goal) {
            List<Integer> res = new ArrayList();
            int middle = (low + high)/2;
            if (low >= high) {
                res.add(nums[low]);
                return new Result(res, Math.abs(nums[low] - goal));
            }

            int minDis = goal;
            Result resLeft = mergeSort(nums, low, middle, goal);
            Result resRight = mergeSort(nums, middle + 1, high, goal);
            minDis = Math.min(resLeft.minDis, resRight.minDis);

            for (int iLeft = 0; iLeft < resLeft.sumSub.size(); iLeft ++) {
                int nearestRightSum = binarySearch(resRight.sumSub, goal - resLeft.sumSub.get(iLeft));
                if (Math.abs(resLeft.sumSub.get(iLeft) + nearestRightSum - goal) < minDis) minDis = Math.abs(resLeft.sumSub.get(iLeft) + nearestRightSum - goal);
            }

            res = allSubsequence(nums, low, high).stream().sorted().collect(Collectors.toList());

            return new Result(res, minDis);
        }

        void merge(List<Integer> left, List<Integer> right, List<Integer> res) {
            int iLeft = 0, iRight = 0;
            while(iLeft < left.size() && iRight < right.size()) {
                if (left.get(iLeft) < right.get(iRight)) {
                    res.add(left.get(iLeft));
                    iLeft ++;
                } else {
                    res.add(right.get(iRight));
                    iRight ++;
                }
            }

            while(iLeft < left.size()) {
                res.add(left.get(iLeft));
                iLeft ++;
            }

            while(iRight < right.size()) {
                res.add(right.get(iRight));
                iRight++;
            }
        }

        int binarySearch(List<Integer> res, int key) {
            if (res.size() == 1) return res.get(0);
            int start = 0, end = res.size() - 1;
            while(start < end) {
                int middle = (start + end)/2;
                if (res.get(middle) < key) {
                    start = middle + 1;
                } else {
                    end = middle;
                }
            }
            if (start == 0) return res.get(0);
            if (Math.abs(res.get(start) - key) < Math.abs(res.get(start - 1) - key)) {
                return res.get(start);
            } else {
                return res.get(start - 1);
            }
        }

        List<Integer> allSubsequence(int[] nums, int low, int high) {
            List<Integer> res = new ArrayList();
            for (int i = low; i <= high; i ++) {
                backtrack(i - 1, high, i - low + 1, nums, 0, res);
            }
            return res;
        }

        void backtrack(int pos, int high, int nAdd, int[] nums, int sum, List<Integer> res) {
            if (nAdd == 0) return;
            for (int i = pos + 1; i <= high; i ++) {
                res.add(sum + nums[i]);
                backtrack(i, high, - 1, nums, sum + nums[i], res);
            }
        }
    }

class LFUCache {

    class Value{
        public int value;
        public long timestamp;
        public int useCount;
        public Value(int value, long timestamp) {
            this.value = value;
            this.timestamp = timestamp;
            this.useCount = 1;
        }
    }
    int capacity;
    int size;
    Map<Integer, Value> cache;
    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        cache = new HashMap();
    }
    
    public int get(int key) {
        if (cache.containsKey(key)) {
            Value value = cache.get(key);
            value.timestamp = System.currentTimeMillis();
            value.useCount ++;
            return value.value;
        } else {
            return - 1;
        }
        
    }
    
    public void put(int key, int value) {
        if (size >= capacity) {
            //remove least frequency use
            int minUseCount = cache.entrySet().stream().map(entry -> entry.getValue().useCount).min(Comparator.comparing(i -> i)).get();
            Integer lfuKey = cache.entrySet().stream().filter(entry -> entry.getValue().useCount == minUseCount).min(Comparator.comparing(entry -> entry.getValue().timestamp)).get().getKey();
            cache.remove(lfuKey);
            size --;
        }

        size ++;
        cache.put(key, new Value(value, System.currentTimeMillis()));
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */



class Solution {
    public int[] beautifulArray(int n) {
        Map<Integer, int[]> dp = new HashMap();
        generate(n, dp);
    }

    int[] generate(int n, Map<Integer, int[]> dp) {
        if (dp.containsKey(n)) return dp.get(n);

        int[] lSize = generate((n + 1)/2, dp);
        int[] rSize = generate(n/2, dp);
        int[] res = new int[n];
        int t = 0;
        for (int i = 0; i < lSize.length; i++) {
            res[t ++] = lSize[i];
        }

        for (int i = 0; i < rSize.length; i ++) {
            res[t ++] = rSize[i];
        }
        dp.put(n, res);
        return res;
    }

   
}


class Solution {
    public int createSortedArray(int[] instructions) {
        int[] cLess = new int[instructions.length], cGreater = new int[instructions.length];
        int totalCost = 0;
        for (int i = 0; i < instructions.length; i ++) {
            totalCost += Math.min(cLess[i], cGreater[i]);
        }
        return totalCost;
    }

    void mergeSortAndReturnCost(int[] nums, int left, int right, int[] cLess, int[] cGreater) {

        int middle = (left + right)/2;
        if (left >= right) return;
      
        mergeSortAndReturnCost(nums, left, middle, cLess, cGreater);
        mergeSortAndReturnCost(nums, middle + 1, right, cLess, cGreater);

        //calculate right to left cost
        int iLess = left;
        int iGreater = left;
        for (int iRight = middle + 1; iRight <= right; iRight ++) {
            while (iLess <= middle && nums[iLess] < nums[iRight]) iLess ++;
            iGreater = iLess;
            while (iGreater <= middle && nums[iGreater] <= nums[iRight]) iGreater ++;
            cLess[iRight] += iLess - left;
            cGreater[iRight] += middle + 1 - iGreater;
        }

        merge(nums, left, middle, right, cLess, cGreater);
    }

    void merge(int[] nums, int left, int middle, int right, int[] cLess, int[] cGreater) {
        int[] temp = new int[right - left + 1], tempLess = new int[right - left + 1], tempGreater = new int[right - left + 1];
        int iLeft = left, iRight = middle + 1;
        while (iLeft <= middle && iRight <= right) {
            if (nums[iLeft] < nums[iRight]) {
                temp[iLeft + iRight - left - middle - 1] = nums[iLeft];
                tempLess[iLeft + iRight - left - middle - 1] = cLess[iLeft];
                tempGreater[iLeft + iRight - left - middle - 1] = cGreater[iLeft];
                iLeft ++;
            } else {
                temp[iLeft + iRight - left - middle - 1] = nums[iRight];
                tempLess[iLeft + iRight - left - middle - 1] = cLess[iRight];
                tempGreater[iLeft + iRight - left - middle - 1] = cGreater[iRight];
                iRight ++;
            }
        }

        while (iLeft <= middle) {
            temp[iLeft + iRight - left - middle - 1] = nums[iLeft];
            tempLess[iLeft + iRight - left - middle - 1] = cLess[iLeft];
            tempGreater[iLeft + iRight - left - middle - 1] = cGreater[iLeft];
            iLeft ++;
        }

        while (iRight <= right) {
                temp[iLeft + iRight - left - middle - 1] = nums[iRight];
                tempLess[iLeft + iRight - left - middle - 1] = cLess[iRight];
                tempGreater[iLeft + iRight - left - middle - 1] = cGreater[iRight];
                iRight ++;

        }

        for (int i = left; i <= right; i ++) {
            nums[i] = temp[i - left];
            cLess[i] = tempLess[i - left];
            cGreater = tempGreater[i - left];
        }
    }
}




class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        if (firstList.length == 0) return firstList;
        if (secondList.length == 0) return secondList;
        List<int[]> res = new ArrayList<>();
        int iFirst = 0, iSecond = 0;
        int turn = 1;
      
        while(iFirst < firstList.length && iSecond < secondList.length) {
            if (firstList[iFirst][0] < secondList[iSecond][0]) {
                turn = 1;
            } else {
                turn = 2;
            }
            if (turn == 1) {
                if (secondList[iSecond][0] > firstList[iFirst][1]) {
                    iFirst ++;
                } else if (secondList[iSecond][1] > firstList[iFirst][1]) {
                    res.add(new int[]{secondList[iSecond][0], firstList[iFirst][1]});
                    iFirst ++;
                } else {
                    res.add(secondList[iSecond]);
                    iSecond ++;
                }
            } else {
                if (firstList[iFirst][0] > secondList[iSecond][1]) {
                    iSecond ++;
                } else if (firstList[iFirst][1] > secondList[iSecond][1]) {
                    res.add(new int[]{firstList[iFirst][0], secondList[iSecond][1]});
                    iSecond ++;
                } else {
                    res.add(firstList[iFirst]);
                    iFirst ++;
                }
            }
        }

        int[][] resArray = new int[res.size()][2];
        for (int i = 0; i < resArray.length; i ++) {
            resArray[i] = res.get(i);
        }
        
        return resArray;
    }
}


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
    class Solution {
        public int[] findOrder(int numCourses, int[][] prerequisites) {
            
            //check cyclic
            //find topological order
            if (isCyclic(prerequisites, numCourses)) return new int[0];
            return topologicalSort(prerequisites, numCourses);
            
        }
        boolean isCyclic(int[][] prerequisites, int numCourses) {
            boolean[] isVisited = new boolean[numCourses];
            for (int i = 0; i < prerequisites.length; i ++) {
                
                if (!isVisited[prerequisites[i][1]] && isCyclicUtil(prerequisites, prerequisites[i][1], isVisited, new HashSet<Integer>())) return true;
            }   
            return false;
        }
        
        boolean isCyclicUtil(int[][] prerequisites, int pos, boolean[] isVisited, Set<Integer> cur) {
            if (cur.contains(pos)) return true;
            isVisited[pos] = true;
            boolean res = false;
            cur.add(pos);
            for (int i = 0; i < prerequisites.length; i ++) {
                if (prerequisites[i][1] == pos) res = res || isCyclicUtil(prerequisites, prerequisites[i][0], isVisited);
            }
            cur.remove(pos);
            return res;
        }
        int[] topologicalSort(int[][] prerequisites, int numCourses) {
            boolean[] isVisited = new boolean[numCourses];
            Arrays.fill(isVisited, false);
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < numCourses; i ++) {
                if (!isVisited[i]) {
                    sortUtil(i, prerequisites, stack, isVisited);
                }
            }
            
            int[] res = new int[numCourses];
            int i = 0;
            while(!stack.isEmpty()) {
                res[i] = stack.pop();
                i ++;
            }
            
            return res;
        }
        
        void sortUtil(int pos, int[][] prerequisites, Stack<Integer> stack, boolean[] isVisited) {
            isVisited[pos] = true;
            for (int i = 0; i < prerequisites.length; i ++) {
                if (prerequisites[i][1] == pos && !isVisited[prerequisites[i][0]]) {
                    sortUtil(prerequisites[i][0], prerequisites, stack, isVisited);
                }
            }
            stack.push(pos);
        }
    }

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        return mergeSort(head);
    }

    ListNode mergeSort(ListNode head) {
        ListNode middle = getMiddle(head);
        if (middle == null || head == middle) return head;

        ListNode left = mergeSort(head);
        ListNode right = mergeSort(middle);

        return merge(left, right);
    }


    ListNode getMiddle(ListNode head) {

        ListNode pre = head;

        while(head != null) {
            head = head.next;
            if (head != null) head = head.next;
            if (head != null) pre = pre.next;
        }

        ListNode middle = pre.next;
        pre.next = null;
        return middle;
    }

    ListNode merge(ListNode left, ListNode right) {
        ListNode dummyHead = new ListNode();
        ListNode cur = dummyHead;

        while (left != null && right != null) {
            if (left.val < right.val) {
                cur.next = left;
                left = left.next;
                cur = cur.next;
            } else {
                cur.next = right;
                right = right.next;
                cur = cur.next;
            }
        }

        cur.next = (left != null) ? left : right;
        return dummyHead.next;
    }
}


class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, Comparator.comparing(i -> i.length()));
        int[] dp = new int[words.length];
        dp[words.length - 1] = 0;
        for (int i = words.length - 1; i >= 0; i --) {
            int max = 0;
            for (int j = i + 1; j < words.length; j ++) {
                if (isPredecessor(words[i], words[j]) && max < dp[j] + 1) max = dp[j] + 1; 
            }
            dp[i] = max;
        }
        int max = 0;
        for (int i = 0; i < dp.length; i ++) {
            if (max < dp[i]) max = dp[i];
        }
        return max + 1;
    }
    
   
    boolean isPredecessor(String o1, String o2) {
        int nDifferent = 0;
        if (o2.length() - o1.length() != 1) return false;
        for (int i = 0; i < o2.length(); i ++) {
            if (i - nDifferent >= o1.length()) nDifferent ++;
            else if (o1.charAt(i - nDifferent) != o2.charAt(i)) nDifferent ++;
        }
        
        return nDifferent == 1;
    }
}

"ebcbb ececab bacec bbcbe"

class Solution {
    public boolean validPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                boolean isPalindromeWithoutI = isPalindrome(s, i + 1, j);
                boolean isPalindromeWithoutJ = isPalindrome(s, i, j - 1);
                if (isPalindromeWithoutI || isPalindromeWithoutJ) return true;
                else return false;
            }
            i ++;
            j --;
        }
        
        return true;
    }
    
    boolean isPalindrome(String s, int left, int right) {
        for (int i = left; i <= right; i ++) {
            if (s.charAt(i) != s.charAt(right - (i - left))) return false;
        }
        return true;
    }
}

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length()) return false;
        int[] s1CharCount = new int[26];
        Arrays.fill(s1CharCount, 0);
        for (int i = 0; i < s1.length(); i ++) {
            s1CharCount[s1.charAt(i) - 'a'] += 1;
        }
        
        int[] s2CharCount = new int[26];
        Arrays.fill(s2CharCount, 0);
        for (int i = 0; i < s1.length(); i ++) {
            s2CharCount[s2.charAt(i) - 'a'] += 1;
        }
        if (checkPermutation(s1CharCount, s2CharCount)) return true;
        
        for (int i = 1; i <= s2.length() - s1.length(); i ++) {
            s2CharCount[s2.charAt(i - 1) - 'a'] --;
            s2CharCount[s2.charAt(i + s1.length() - 1) - 'a'] ++;
            if (checkPermutation(s1CharCount, s2CharCount)) return true;
        }
        
        
        return false;
        
    }
    
    boolean checkPermutation(int[] c1, int[] c2) {
        for (int i = 0; i < c1.length; i ++) {
            if (c1[i] != c2[i]) return false;
        }
        return true;
    }
}







class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        backtrack(-1, nums, new ArrayList<>(), res);

        Collections.sort(res);
        return res.get(k - 1);
    }

    void backtrack(int nPos, int[] nums,List<Integer> cur, List<Integer> res) {
        if (cur.size() == 2) {
            res.add(Math.abs(cur.get(0) - cur.get(1)));
            return;
        }
        for (int i = nPos + 1; i < nums.length; i++) {
            cur.add(nums[i]);
            backtrack(i, nums, cur, res);
            cur.remove(nums[i]);
        }
    }
}




class Solution {
    class Result{
        int dis;
        int nPair;
        public Result(int dis, int nPair) {
            this.dis = dis;
            this.nPair = nPair;
        }
    }
    public int smallestDistancePair(int[] nums, int k) {
        int[] distance = new int[nums.length - 1];
        Arrays.sort(nums);
        int maxDistance = nums[nums.length - 1] - nums[0];
        int minDistance = Math.abs(nums[0] - nums[1]);
        for (int i = 0; i < nums.length - 1; i ++) {
            distance[i] = nums[i + 1] - nums[i];
            if (distance[i] < minDistance) minDistance = distance[i];
        }
        while (minDistance < maxDistance) {
            int middleDistance = (minDistance + maxDistance) / 2;
            Result result = nPairWithDistanceLessOrEqual(distance, middleDistance);
            if (result.nPair == k ) return result.dis;
            if (result.nPair > k) {
                maxDistance = result.dis;
            } else {
                minDistance = result.dis;
            }
        }

        return minDistance;
    }

    Result nPairWithDistanceLessOrEqual(int[] distance, int value) {
        int slowP = 0, fastP = 1;
        int curSum = distance[slowP];
        int distance = 0;
        int nPair = 0;
        while (fastP <= distance.length) {
            if (curSum <= value) {
                nPair += (fastP - slowP);
                if (curSum > distance) distance = curSum;
                fastP ++;
                if (fastP - 1 < distance.length) curSum += distance[fastP - 1];
            } else {
                slowP ++;
                curSum -= distance[slowP - 1];
            }
        }

        return new Result(distance, nPair);
    }
}

class Solution {
    public int findDuplicate(int[] nums) {
        return find(nums, 0, nums.length - 1);
    }
    
    int find(int[] nums, int left, int right) {
        if (left >= right) return nums[left];
        int p = partial(nums, left, right);
        if (p + 1 <= nums[p]) {
            return find(nums, p + 1, right);
        } else {
            return find(nums, left, p - 1);
        }
    }
    int partial(int[] nums, int left, int right) {
        int pivot = nums[right];
        int j = left;
        for (int i = left; i < right; i ++) {
            if (nums[i] <= pivot) {
                swap(nums, i, j);
                j ++;
            } 
        }
        swap(nums, j, right);
        return j;
    }
    
    void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

class MedianFinder {
    class Node{
        Node next;
        int value;
        Node(int value, Node next){
            this.value = value;
            this.next = next;
        }
    }
    
    int size;
    Node head;
    /** initialize your data structure here. */
    public MedianFinder() {
        head = new Node(0, null);
        size = 0;
    }
    
    public void addNum(int num) {
        Node cur = head.next;
        Node pre = head;
        while (cur != null && cur.value < num) {
            pre = cur;
            cur = cur.next;
        }
     
        Node newNode = new Node(num, cur);
        pre.next = newNode;
        size++;

    }
    
    public double findMedian() {
        Node middle = head;
        int iMiddle = (size + 1) / 2;
        for (int i = 0; i < iMiddle; i ++) {
            middle = middle.next;
        }
        
        if (size % 2 == 0) {
            return (middle.value + middle.next.value)/2.0;
        } else {
            return middle.value;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */

class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        for (int i = 0; i < image.length; i ++) {
            for (int j = 0; j < (image[0].length + 1)/2; j ++) {
                int temp = image[i][j];
                image[i][j] = image[i][image[0].length -j - 1] == 0 ? 1 : 0;
                image[i][image[0].length -j - 1] = temp == 0 ? 1 : 0;
            }

        }
        
        return image;
    }
}


    class Solution {
        public int rangeSum(int[] nums, int n, int left, int right) {
            int mod = 1000000007;
            List<Integer> subSum = getSubSumList(nums);
            Collections.sort(subSum);
            int res = 0;
            for (int i = left; i <= right; i ++){
                res = (res + (subSum.get(i - 1) % mod)) % mod;
            }
            return res;
        }

        List<Integer> getSubSumList(int[] nums) {
            List<Integer> res = new ArrayList<>();
            for (int i = 0; i < nums.length; i ++) {
                sumSubUtil(i, nums, 0, res);
            }
            return res;
        }

        void sumSubUtil(int pos, int[] nums, int cur, List<Integer> res) {
            if (pos >= nums.length) return;
            res.add(cur + nums[pos]);
            sumSubUtil(pos + 1, nums, cur + nums[pos], res);
        }

    }

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> res = new HashSet<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                res.add(nums1[i]);
                i ++;
                j ++;
            } else if (nums1[i] > nums2[j]) {
                j ++;
            } else {
                i ++;
            }
        }
    
        return res.stream().mapToInt(k -> k).toArray();
    }
}

class Solution {
    public int missingNumber(int[] nums) {
        int total = getSum(nums.length);
        for (int i = 0; i < nums.length; i ++) {
            total -= nums[i];
        }
        
        return total;
    }
    
    int getSum(int n) {
        int total = 0;
        for (int i = 0; i <= n; i ++) {
            total += i;
        }
        return total;
    }
}


class Solution {
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        
        int[] res = new int[k];
        Arrays.fill(res, 0);
        Arrays.sort(logs, Comparator.comparing(arr -> arr[0]));
        Set<Integer> currentTime = new HashSet<>();
        int currentUser = -1;
        for (int i = 0; i < logs.length; i ++) {
            if (logs[i][0] == currentUser) {
                currentTime.add(logs[i][1]);
            } else {
                if (currentTime.size() >= 1) res[currentTime.size() - 1] += 1;
                currentTime.clear();
                currentUser = logs[i][0];
                currentTime.add(logs[i][1]);
            }
        }
        if (currentTime.size() >= 1) res[currentTime.size() - 1] += 1;
        
        return res;
    }
}

class Solution {
    public int longestDecomposition(String text) {
        int sLeft = 0, sRight = text.length() - 1;
        int range = 0;
        int counter = 0;
        while (sLeft + range < sRight - range) {
            if (compare(text, sLeft, sRight, range)) {
                counter += 2;
                sLeft = sLeft + range + 1;
                sRight = sRight - range - 1;
                range = 0;
            } else {
                range ++;
            }
        }
        if (range != 0 || sLeft == sRight) counter ++;
        
        return counter;
    }
    
    boolean compare(String text, int sLeft, int sRight, int range) {
        for (int i = 0; i < range + 1; i ++) {
            if (text.charAt(sLeft + i) != text.charAt(sRight - range + i)) return false;
        }
        return true;
    }
}


class Solution {
    public int maximumScore(int[] nums, int k) {
        int left = k, right = k;
        int maxScore = nums[k];
        int minValue = nums[k];
        int range = 1;
        while (left != 0 || right != nums.length - 1) {
            range ++;
            if (right == nums.length - 1 || (left - 1 >= 0 && nums[left - 1] >= nums[right + 1])) {
                left = left - 1;
                minValue = Math.min(nums[left], minValue);
            } else if (left == 0 || ( right + 1 <= nums.length - 1 && nums[left - 1] < nums[right + 1] )) {
                right = right + 1;
                minValue = Math.min(nums[right], minValue);
            }
            
            maxScore = Math.max(maxScore, minValue * range);
        }
        
        return maxScore;
    }
}


class Solution {
    int module = 1000000007;
    public int maxSum(int[] nums1, int[] nums2) {
        List<Integer> res = new ArrayList<>();
        moveOne(0, 0, nums1, nums2, new HashSet<Integer>(), res);
        moveTwo(0, 0, nums1, nums2, new HashSet<Integer>(), res);
        return res.stream().max(Comparator.comparing(i -> i)).get();
    }
    
    void moveOne(int pos1, int pos2, int[] nums1, int[] nums2, Set<Integer> current, List<Integer> res) {
        if (pos1 == nums1.length) {
            Integer[] arr = current.toArray(new Integer[0]);
            int score = 0;
            for (int i = 0; i < arr.length; i ++) {
                score = (score + arr[i]) % module;
            }
            res.add(score);
            return;
        }
        
        boolean alreadyContain = !current.add(nums1[pos1]);
        if (pos2 < nums2.length && nums1[pos1] == nums2[pos2])
            moveTwo(pos1 + 1, pos2, nums1, nums2, current, res);    
        while (pos2 < nums2.length && pos1 + 1 < nums1.length && nums2[pos2] < nums1[pos1 + 1]) pos2++;
        
        moveOne(pos1 + 1, pos2, nums1, nums2, current, res);
        if (!alreadyContain) current.remove(Integer.valueOf(nums1[pos1]));
        
    }
    
    void moveTwo(int pos1, int pos2, int[] nums1, int[] nums2, Set<Integer> current, List<Integer> res) {
         if (pos2 == nums2.length) {
            Integer[] arr = current.toArray(new Integer[0]);
            int score = 0;
            for (int i = 0; i < arr.length; i ++) {
                score = (score + arr[i]) % module;
            }
            res.add(score);
            return;
        }
        
        boolean alreadyContain = !current.add(nums2[pos2]);
        if (pos1 < nums1.length && nums1[pos1] == nums2[pos2])
            moveOne(pos1, pos2 + 1, nums1, nums2, current, res);    
        while (pos1 < nums1.length && pos2 + 1 < nums2.length && nums1[pos1] < nums2[pos2 + 1]) pos1++;
        
        moveTwo(pos1, pos2 + 1, nums1, nums2, current, res);
        if (!alreadyContain) current.remove(Integer.valueOf(nums2[pos2]));
    }
}


class Solution {
    public String lastSubstring(String s) {
        char[] arr = s.toCharArray();
        int iMax = arr.length - 1;
        int i = arr.length - 1;
        while (i >= 0) {
            
            while (i > 0 && arr[i] == arr[i - 1]) i --;
            if (compare(arr, i, iMax) > 0) iMax = i;
            
            i --;
        }

        
        return s.substring(iMax);
    }
    
    int compare(char[] arr, int i, int j) {
        int iSize = j;
        while (i < iSize && j < arr.length) {
            if (arr[i] < arr[j]) return -1;
            else if (arr[i] > arr[j]) return 1;
            else {
                i ++;
                j ++;
            }
        }
        
        return 1;
    }
}

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        char[] ransomNoteArr = ransomNote.toCharArray();
        Arrays.sort(ransomNoteArr);
        char[] magazineArr = magazine.toCharArray();
        Arrays.sort(magazineArr);
        int j = 0;
        for (int i = 0; i < ransomNoteArr.length; i ++) {
            while (j < magazineArr.length && magazineArr[j] != ransomNoteArr[i]) j ++;
            if (j >= magazineArr.length) return false;
            j ++;
        }
        
        return true;
    }
}

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int[] dp = new int[s.length()];
        Arrays.fill(dp, 0);
        
        return backtrack(s, 0, wordDict, dp);
    }
    
    boolean backtrack(String s, int position, List<String> wordDict, int[] dp) {
        boolean result = false;
        if (dp[position] == -1) return false;
        else if (dp[position] == 1) return true;
        
        for (int i = 0; i < wordDict.size(); i ++) {
            if (wordDict.get(i).length() <= s.length() - position && s.substring(position, position + wordDict.get(i).length()).equals(wordDict.get(i))) {
                if (position + wordDict.get(i).length() == s.length()) return true;
                result = result || backtrack(s, position + wordDict.get(i).length(), wordDict, dp);
            }
        }
        dp[position] = result ? 1 : -1;
        return result;
    }
}


class Solution {
    public int scoreOfParentheses(String s) {
        return calculate(s, 0, s.length() - 1);
    }
    
    int calculate(String s, int from, int to) {
        int ans = 0, bal = 0;
        for (int k = from; k <= to; k ++) {
            bal += s.charAt(k) == ')' ? -1 : 1;
            if (bal == 0) {
                if (k - from == 1) ans ++;
                else ans += 2 * calculate(s, from + 1, k - 1);
                from = k + 1;
            }
        }
        
        return ans;
    }
    
}


class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> stack = new Stack();
        stack.push(0);
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i ++) {
            if (arr[i] == '(') stack.push(0);
            else {
                int currentValue = stack.pop();
                int preValue = stack.pop();
                stack.push(preValue + (Math.max(2 * currentValue, 1)));
            }
        }
        
        return stack.pop();
    }
       
}


class Solution {

    public int scoreOfParentheses(String S) {
        int ans = 0, bal = 0;
        for (int i = 0; i < S.length(); ++i) {
            if (S.charAt(i) == '(') {
                bal++;
            } else {
                bal--;
                if (S.charAt(i-1) == '(')
                    ans += 1 << bal;
            }
        }

        return ans;
    }
}


class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> stringToList = new HashMap<>();
        for (int i = 0; i < strs.length; i ++) {
            char[] arr = strs[i].toCharArray();
            Arrays.sort(arr);
            String sortString = new String(arr);
            if (stringToList.containsKey(sortString)) {
                stringToList.get(sortString).add(strs[i]);
            } else {
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                stringToList.put(sortString, list);
            }
        }
        
        List<List<String>> res = new ArrayList<>();
        stringToList.forEach((key, value) -> res.add(value));
        
        return res;
    }
}

class Solution {
    class CharFrequency{
        char c;
        int freq;
        public CharFrequency(char c, int freq) {
            this.c = c;
            this.freq = freq;
        }
    }
    public String frequencySort(String s) {
        List<CharFrequency> charFreq = new ArrayList<>();
        Map<Character, Integer> cToFreq = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i ++) {
            cToFreq.merge(s.charAt(i), 1 , Integer::sum);
        } 
        cToFreq.forEach((key, value) -> {
           charFreq.add(new CharFrequency(key, value)); 
        });
        
        Collections.sort(charFreq, Comparator.comparing(res -> -res.freq));
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < charFreq.size(); i ++) {
            for (int j = 0; j < charFreq.get(i).freq; j ++) {
                builder.append(charFreq.get(i).c);
            }
        }
        return builder.toString();
    }
}

class Solution {
    public List<String> letterCasePermutation(String S) {
        List<String> res = new ArrayList<>();
        backtrack(S.toCharArray(), 0, new char[S.length()], res);
        return res;
    }
    
    void backtrack(char[] arr, int position, char[] current, List<String> res) {
        if (position == arr.length) {
            res.add(new String(current));
            return;
        }
        if (arr[position] >= '0' && arr[position] <= '9') {
            current[position] = arr[position];
            backtrack(arr, position + 1, current, res);

        } else {
            current[position] = Character.toUpperCase(arr[position]);
            backtrack(arr, position + 1, current, res);
            current[position] = Character.toLowerCase(arr[position]);
            backtrack(arr, position + 1, current, res);
        }
    }
}


class Solution {
    public int minSteps(String s, String t) {
        int[] sCharCount = new int[26];
        int[] tCharCount = new int[26];
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        for (int i = 0; i < sArr.length; i ++) {
            sCharCount[sArr[i] - 'a'] ++;
            tCharCount[tArr[i] - 'a'] ++;
        }
        
        int total = 0;
        
        for (int i = 0; i < sCharCount.length; i ++) {
            if (tCharCount[i] < sCharCount[i]) total += sCharCount[i] - tCharCount[i];
        }
        
        return total;
    }
}

class Solution {
    public String defangIPaddr(String address) {
        return address.replace(".", "[.]");
    }
}

class MagicDictionary {
    String[] dictionary;
    /** Initialize your data structure here. */
    public MagicDictionary() {
        
    }
    
    public void buildDict(String[] dictionary) {
        this.dictionary = dictionary;
    }
    
    public boolean search(String searchWord) {
        for (int i = 0; i < dictionary.length; i ++) {
            if (isMatch(searchWord, dictionary[i])) return true;
        }
        
        return false;
    }
    
    boolean isMatch(String x, String y) {
        if (x.length() != y.length()) return false;
        int nDiff = 0;
        for (int i = 0; i < x.length(); i ++) {
            if (x.charAt(i) != y.charAt(i)) {
                nDiff++;
            }
        }
        
        return nDiff == 1;
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dictionary);
 * boolean param_2 = obj.search(searchWord);
 */



class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        int[] preSum = new int[s.length() + 1];
        preSum[0] = 0;
        preSum[1] = 1;
        for (int i = 2; i <= s.length(); i ++) {
            if (s.charAt(i - 1) == '1') preSum[i] = preSum[i - 1];
            else {
                int max = Math.max(0, i - minJump);
                int min = Math.max(0, i - maxJump - 1);
                if (preSum[max] > preSum[min]) preSum[i] = preSum[i - 1] + 1;
                else preSum[i] = preSum[i - 1];
            }
        }
        
        return preSum[s.length()] > preSum[s.length() - 1];
    }
}

class Solution {
    public int minOperations(String[] logs) {
        int height = 0;
        for (int i = 0; i < logs.length; i ++ ){
            if (logs[i].equals("../") ) {
                if (height != 0) height --;
            }
            else if (!logs[i].equals("./")) height ++;
        }
        
        return height;
    }
}

class Solution {
    public int numTilePossibilities(String tiles) {
        
        boolean[] isVisited = new boolean[tiles.length()];
        Arrays.fill(isVisited, false);
        return backtrack(isVisited, tiles);
    }
    
    int backtrack(boolean[] isVisited, String tiles) {
        int res = 0;
        Set<Character> current = new HashSet<>();
        for (int i = 0; i < tiles.length(); i ++) {
            if (!isVisited[i] && (!current.contains(tiles.charAt(i)))) {
                current.add(tiles.charAt(i));
                isVisited[i] = true;
                res += (backtrack(isVisited, tiles) + 1);
                isVisited[i] = false;
            }
        }
        return res;
    }
}

class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i ++) {
            if (stack.size() == 0) stack.push(s.charAt(i));
            else if (s.charAt(i) == ')' && stack.peek() == '(') stack.pop();
            else stack.push(s.charAt(i));
        }
        return stack.size();
    }
}


//Wrong
class Solution {
    public String removeOccurrences(String s, String part) {
        Stack<Character> charStack = new Stack<Character>();
        Stack<Integer> indexStack = new Stack<Integer>();
        int curIndex = -1;
        for (int i = 0; i < s.length(); i ++) {
            if (indexStack.size() != 0) curIndex = indexStack.peek();
                else curIndex = -1;
            
            charStack.push(s.charAt(i));
            //Here
            //First 2 conditions
            //Character at i maybe the start of part, maybe curIndex
            //If we only save one of them, we are missing the other option here.
            if (s.charAt(i) == part.charAt(curIndex + 1)) {
                curIndex += 1;
            } else if(s.charAt(i) == part.charAt(0)){
                curIndex = 0;  
            } else {
                curIndex = -1;
            }
            indexStack.push(curIndex);
            
            if (indexStack.peek() == part.length() - 1) {
                pop(charStack, indexStack, part.length());
                
            }
        }
        
        char[] newS = new char[charStack.size()];
        for (int i = 0; i < charStack.size(); i ++) {
            newS[i] = charStack.get(i);
        }
        return new String(newS);
    }
    
    void pop(Stack<Character> charStack, Stack<Integer> indexStack, int n) {
        for (int i = 0; i < n; i ++) {
            charStack.pop();
            indexStack.pop();
        }
    }
}


class Solution {
    public String removeOccurrences(String s, String part) {
        Character lastInPart = part.charAt(part.length() - 1);
        Stack<Character> charStack = new Stack<Character>();
        for (int i = 0; i < s.length(); i ++) {
            charStack.push(s.charAt(i));
            if (charStack.peek() == lastInPart) {
                checkThenRemove(charStack, part);
            }
        }
        
        char[] newS = new char[charStack.size()];
        for (int i = 0; i < charStack.size(); i ++) {
            newS[i] = charStack.get(i);
        }
        return new String(newS);
    }
    
    void checkThenRemove(Stack<Character> charStack, String part) {
        Stack<Character> peekChar = new Stack<>();
        boolean res = true;
        int i = part.length() - 1;
        while (res && i >= 0 && charStack.size() != 0) {
            char c = charStack.pop();
            peekChar.push(c);
            if (c != part.charAt(i)) res = false;
            i--;
        }
        if (!res || i != -1) {
            while(peekChar.size() != 0){
                charStack.push(peekChar.pop());
            }
        }
    }
}

//Iterative DFS with stack

class Solution {
    public TreeNode recoverFromPreorder(String traversal) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode dummyHead = new TreeNode(0);
        //add dummy head
        stack.push(dummyHead);
        int currentHeight = -1;
        
        int index = 0;
        int start = 0;
        while (index < traversal.length()) {
            start = index;
            while (index < traversal.length() && traversal.charAt(index) == '-') index ++;
            int nDash = index - start;
            start = index;
            while (index < traversal.length() && traversal.charAt(index) != '-') index ++;
            int value = Integer.valueOf(traversal.substring(start, index));
            TreeNode cur = new TreeNode(value);
            while (nDash != currentHeight + 1) {
                stack.pop();
                currentHeight --;
            }
            TreeNode head = stack.peek();
            if (head.left == null) head.left = cur;
            else head.right = cur;
            stack.push(cur);
            currentHeight ++;
        }
        return dummyHead.left;
    }
    

}

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> wordToCount = new HashMap<>();
        PriorityQueue<String> priorityQueue = new PriorityQueue(Comparator.comparing(s -> -wordToCount.getOrDefault(s, 0)).thenComparing(Object::toString));
        for (int i = 0; i < words.length; i ++) {
            wordToCount.merge(words[i], 1, Integer::sum);
            priorityQueue.remove(words[i]);
            priorityQueue.add(words[i]);
        }
    
        List<String> result = new ArrayList<>();
        for (int i = 0; i < k; i ++) {
            result.add(priorityQueue.poll());
        }
        
        return result;
        
    }
}

class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        current.add(0);
        traverse(0, graph, current, res);
        return res;
    }
    
    void traverse(int position, int[][] graph, List<Integer> current, List<List<Integer>> res) {
        if (position == graph.length - 1) {
            res.add(new ArrayList(current));
            return;
        }

        for (int i = 0; i < graph[position].length; i ++) {
           
                current.add(graph[position][i]);
                traverse(graph[position][i], graph, current, res, dp);
                current.remove(Integer.valueOf(graph[position][i]));
            
        }
    }
}


class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        int[] nIncoming = new int[n];
        Arrays.fill(nIncoming, 0);
        
        for (int i = 0; i < edges.size(); i ++) {
            nIncoming[edges.get(i).get(1)] ++;
        }
        
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i ++) {
            if (nIncoming[i] == 0) res.add(i);
        }
        
        return res;
    }
}

class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] isVisited = new boolean[rooms.size()];
        backtrack(0, rooms, isVisited);
        for (int i = 1; i < isVisited.length; i ++) {
            if (!isVisited[i]) return false;
        }
        
        return true;
    }
    
    void backtrack(int position, List<List<Integer>> rooms, boolean[] isVisited) {
        if (position >= rooms.size()) return;
        List<Integer> keys = rooms.get(position);
        keys.forEach(key -> {
           if (!isVisited[key]) {
               isVisited[key] = true;
               backtrack(key, rooms, isVisited);
           }
        });
    }
}

class Solution {
    public int minReorder(int n, int[][] connections) {
        boolean[] isVisited = new boolean[n];
        Map<Integer, List<Integer>> fromNode = new HashMap<>();
        Map<Integer, List<Integer>> toNode = new HashMap<>();
        for (int i = 0; i < n; i ++) {
            fromNode.put(i, new ArrayList<>());
            toNode.put(i, new ArrayList<>());
        }
        for (int i = 0; i < connections.length; i ++) {
            fromNode.get(connections[i][0]).add(connections[i][1]);
            toNode.get(connections[i][1]).add(connections[i][0]);
        }
        Arrays.fill(isVisited, false);
        return backtrack(0, connections, n, isVisited, fromNode, toNode);
    }
    
    int backtrack(int position, int[][] connections, int n, boolean[] isVisited, Map<Integer, List<Integer>> from, Map<Integer, List<Integer>> to) {
        
        if (position >= n) return 0;
        isVisited[position] = true;
        int res = 0;
        List<Integer> toNode = from.get(position);
        for (int i = 0; i < toNode.size(); i ++) {
            if (!isVisited[toNode.get(i)]) {
                res += 1 + backtrack(toNode.get(i), connections, n, isVisited, from, to);
            }
        }
        
        List<Integer> fromNode = to.get(position);
        
        for(int i = 0; i < fromNode.size(); i ++) {
            if (!isVisited[fromNode.get(i)]) {
                res += backtrack(fromNode.get(i), connections, n, isVisited, from, to);
            }
        }
       
        return res;
    }
}




class Solution {
    public int shortestBridge(int[][] grid) {
        //change 2nd island to 2s
        int px = 0, py = 0;
        for (int i = 0; i < grid.length; i ++) {
            for (int j = 0; j < grid.length; j ++) {
                if (grid[i][j] == 1) {
                    px = i;
                    py = j;
                }
            }
        }
        
        change(px, py, grid);
        boolean[][] isVisited = new boolean[grid.length][grid[0].length];
        int[][] distance = new int[grid.length][grid[0].length];
        for (int i = 0; i < distance.length; i ++){
            for (int j = 0; j < distance[0].length; j ++) {
                distance[i][j] = Integer.MAX_VALUE;
            }
        }
    
        return findMinDistance(px, py, grid, isVisited, distance);
        
    }
    void change(int px, int py, int[][] grid) {
        grid[px][py] = 2;
        if (px -1 >= 0 && grid[px - 1][py] == 1) change(px - 1, py, grid);
        if (px + 1 < grid.length && grid[px + 1][py] == 1) change(px + 1, py, grid);
        if (py - 1 >= 0 && grid[px][py - 1] == 1) change(px, py - 1, grid);
        if (py + 1 < grid[0].length && grid[px][py + 1] == 1) change(px, py + 1, grid);
    }
    
    int findMinDistance(int px, int py, int[][] grid, boolean[][] isVisited, int[][] distance) {
        isVisited[px][py] = true;
        int minDistance = findMinUtil(px, py, grid, distance);
        if (px - 1 >= 0 && !isVisited[px -1][py] && grid[px - 1][py] == 2) minDistance = Math.min(minDistance, findMinDistance(px - 1, py, grid, isVisited, distance));
        if (px + 1 < grid.length && !isVisited[px +1][py] && grid[px + 1][py] == 2) minDistance = Math.min(minDistance, findMinDistance(px + 1, py, grid, isVisited, distance));
        if (py - 1 >= 0 && !isVisited[px][py - 1] && grid[px][py - 1] == 2) minDistance = Math.min(minDistance, findMinDistance(px, py - 1, grid, isVisited, distance));
        if (py + 1 < grid[0].length && !isVisited[px][py + 1] && grid[px][py + 1] == 2) minDistance = Math.min(minDistance, findMinDistance(px, py + 1, grid, isVisited, distance));
        
        return minDistance;
        
    }
    class Node{
        int px;
        int py;
        Node(int px, int py) {
            this.px = px;
            this.py = py;
        }
    }
    int findMinUtil(int px, int py, int[][] grid, int[][] distance) {
        //Start at 2, find the first 1
        if (grid[px][py] == 1) return 0;
        boolean[][] isVisited = new boolean[grid.length][grid[0].length];

        Deque<Node> deque = new ArrayDeque<>();
        deque.addLast(new Node(px, py));
        int level = 0;
        while (deque.size() != 0) {
            int levelSize = deque.size();
            while (levelSize != 0) {
                Node node = deque.removeFirst();
                levelSize--;
                if (distance[node.px][node.py] > level){
                    distance[node.px][node.py] = level;
                    isVisited[node.px][node.py] = true;
                    if (grid[node.px][node.py] == 1) return level - 1;
                    if (node.px -1 >= 0 && !isVisited[node.px - 1][node.py] && grid[node.px - 1][node.py] != 2) deque.addLast(new Node(node.px - 1, node.py));
                    if (node.px + 1 < grid.length && !isVisited[node.px + 1][node.py] && grid[node.px + 1][node.py] != 2) deque.addLast(new Node(node.px + 1, node.py));
                    if (node.py - 1 >= 0 && !isVisited[node.px][node.py - 1] && grid[node.px][node.py - 1] != 2) deque.addLast(new Node(node.px, node.py - 1));
                    if (node.py + 1 < grid[0].length && !isVisited[node.px][node.py + 1] && grid[node.px][node.py + 1] != 2) deque.addLast(new Node(node.px, node.py + 1));
                }   
            }
            level ++;
        }
        
        return Integer.MAX_VALUE;
    }
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        Deque<TreeNode> left = new ArrayDeque<>();
        Deque<TreeNode> right = new ArrayDeque<>();
        left.addFirst(root1);
        right.addFirst(root2);
        
        while(left.size() != 0 || right.size() != 0) {
            TreeNode lNode = left.removeLast();
            TreeNode rNode = right.removeLast();
            lNode.val = lNode.val + (rNode != null ? rNode.val : 0);
            if (lNode != null && rNode != null) {
                if (lNode.left != null && rNode.left != null) {
                    left.addFirst(lNode.left);
                    right.addFirst(rNode.left);
                } else if (lNode.left == null && rNode.left != null) {
                    lNode.left = rNode.left;
                    left.addFirst(rNode.left);
                    right.addFirst(new TreeNode(0));
                } else if (lNode.left != null && rNode.left == null){
                    left.addFirst(lNode.left);
                    right.addFirst(new TreeNode(0));
                }
                
                if (lNode.right != null && rNode.right != null) {
                    left.addFirst(lNode.right);
                    right.addFirst(rNode.right);
                } else if (lNode.right == null && rNode.right != null) {
                    lNode.right = rNode.right;
                    left.addFirst(rNode.right);
                    right.addFirst(new TreeNode(0));
                } else if (lNode.right != null && rNode.right == null) {
                    left.addFirst(lNode.right);
                    right.addFirst(new TreeNode(0));
                }
                
            } else if (lNode != null) {
                left.addFirst(lNode.left);
                right.addFirst(new TreeNode(0));
            }
            
        }
        return root1;
    }
}


class Solution {
    public int deepestLeavesSum(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        
        int level = 0;
        queue.addFirst(root);
        int sum = 0;
        int preSum = root != null ? root.val : 0;
        while(queue.size() != 0) {
            int levelSize = queue.size();
            preSum = sum;
            sum = 0;
            while(levelSize > 0){
                TreeNode node = queue.removeLast();
                sum += node.left != null ? node.left.val : 0;
                sum += node.right != null ? node.right.val : 0;
                if (node.left != null) queue.addFirst(node.left);
                if (node.right != null) queue.addFirst(node.right);
                levelSize--;
            }
        }
        return preSum;
        
    }
}

class Solution {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        Deque<TreeNode> oriQ = new ArrayDeque<>();
        Deque<TreeNode> cloQ = new ArrayDeque<>();
        oriQ.addFirst(original);
        cloQ.addFirst(cloned);
        while (oriQ.size() != 0) {
            TreeNode ori = oriQ.removeLast();
            TreeNode clo = cloQ.removeLast();
            
            if (ori == target) return clo;
            if (ori.left != null) {
                oriQ.addFirst(ori.left);
                cloQ.addFirst(clo.left);
            }
            if (ori.right != null) {
                oriQ.addFirst(ori.right);
                cloQ.addFirst(clo.right);
            }
            
        }
        return null;
    }
}

class Solution {
    public int sumEvenGrandparent(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.addFirst(new TreeNode(1));
        queue.addFirst(new TreeNode(1));
        queue.addFirst(root);
        int sum = 0;
        while(queue.size() != 0) {
            int levelSize = queue.size();
            while(levelSize > 0) {
                TreeNode grand = queue.removeLast();
                TreeNode parent = queue.removeLast();
                TreeNode node = queue.removeLast();
                if (grand.val % 2 == 0) sum += node.val;
                if (node.left != null)  {
                    queue.addFirst(parent);
                    queue.addFirst(node);
                    queue.addFirst(node.left);
                }
                if (node.right != null) {
                    queue.addFirst(parent);
                    queue.addFirst(node);
                    queue.addFirst(node.right);
                }
                levelSize-= 3;
            }
            
        }
        return sum;
    }
}

   class Solution {
        public int minFlips(int[][] mat) {
            int res = backtrack(0, 0, mat, new boolean[mat.length][mat[0].length]);
            if (res == Integer.MAX_VALUE) return -1;
            else return res;
        }

        int backtrack(int px, int py, int[][] mat, boolean[][] isVisited) {
            int res = Integer.MAX_VALUE;
            isVisited[px][py] = true;
            flip(px, py, mat);
            if (isZeroMatrix(mat)) res =  1;

            if (px - 1 >= 0 && !isVisited[px - 1][py]) {
                int temp = backtrack(px - 1, py, mat, isVisited);
                if (temp != Integer.MAX_VALUE) res = Math.min(res, 1 + temp);
            } else if (px + 1 < mat.length && !isVisited[px + 1][py]) {
                int temp = backtrack(px + 1, py, mat, isVisited);
                if (temp != Integer.MAX_VALUE) res = Math.min(res, 1 + temp);
            } else if (py - 1 >= 0 && !isVisited[px][py - 1]) {
                int temp = backtrack(px, py - 1, mat, isVisited);
                if (temp != Integer.MAX_VALUE) res = Math.min(res, 1 + temp);
            } else if (py + 1 < mat[0].length && !isVisited[px][py + 1]) {
                int temp = backtrack(px, py + 1, mat, isVisited);
                if (temp != Integer.MAX_VALUE) res = Math.min(res, 1 + temp);
            }
            flip(px, py, mat);
            
            if (isZeroMatrix(mat)) res = 0;

            if (px - 1 >= 0 && !isVisited[px - 1][py]){
                int temp = backtrack(px - 1, py, mat, isVisited);
                if (temp != Integer.MAX_VALUE) res = Math.min(res, temp);
            } else if (px + 1 < mat.length && !isVisited[px + 1][py]) {
                int temp = backtrack(px + 1, py, mat, isVisited);
                if (temp != Integer.MAX_VALUE) res = Math.min(res, temp);
            } else if (py - 1 >= 0 && !isVisited[px][py - 1]) {
                int temp = backtrack(px, py - 1, mat, isVisited);
                if (temp != Integer.MAX_VALUE) res = Math.min(res, temp);
            } else if (py + 1 < mat[0].length && !isVisited[px][py + 1]) {
                int temp = backtrack(px, py + 1, mat, isVisited);
                if (temp != Integer.MAX_VALUE) res = Math.min(res, temp);
            }
            isVisited[px][py] = false;

            return res;
        }

        void flip(int px, int py, int[][] mat) {
            flipUtil(px, py, mat);
            flipUtil(px - 1, py, mat);
            flipUtil(px + 1, py, mat);
            flipUtil(px, py - 1, mat);
            flipUtil(px, py + 1, mat);
        }

        void flipUtil(int px, int py, int[][] mat) {
            if (px >= 0 && px < mat.length && py >= 0 && py < mat[0].length) mat[px][py] = mat[px][py] == 0 ? 1 : 0;
        }

        boolean isZeroMatrix(int[][] mat) {
            for (int i = 0; i < mat.length; i ++) {
                for (int j = 0; j < mat[0].length; j ++) {
                    if (mat[i][j] == 1) return false;
                }
            }
            return true;
        }
    }


    class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String, List<String>> adjMap = new HashMap<String, List<String>>();
        adjMap.put(beginWord, new ArrayList<>());
        for (int i = 0; i < wordList.size(); i ++) {
            adjMap.put(wordList.get(i), new ArrayList<>());
        }
        Map<String, Boolean> isUse = new HashMap<>();
        for (int i = 0; i < wordList.size(); i ++) {
            isUse.put(wordList.get(i), false);
        }
        for (int i = 0; i < wordList.size(); i++) {
            if (isAdjacent(beginWord, wordList.get(i))) {
                adjMap.get(beginWord).add(wordList.get(i));
            }
        }
        
        for (int i = 0; i < wordList.size(); i ++) {
            for (int j = i + 1; j < wordList.size(); j ++) {
                if (isAdjacent(wordList.get(i), wordList.get(j))) {
                    adjMap.get(wordList.get(i)).add(wordList.get(j));
                    adjMap.get(wordList.get(j)).add(wordList.get(i));   
                }
            }
        }
        
        
        Deque<String> queue = new ArrayDeque<>();
        
        queue.add(beginWord);
        
        int level = 0;
        while (queue.size() != 0) {
            int levelSize = queue.size();
            
            while (levelSize > 0) {
                String node = queue.removeLast();
                isUse.put(node, true);
                if (node.equals(endWord)) return level + 1;
                
                adjMap.get(node).forEach(s -> {
                    if (!isUse.get(s)) queue.addFirst(s);
                });
                
                levelSize--;
            }
            level ++;
        }
    
        return 0;
        
    }
    
    public boolean isAdjacent(String word, String next) {
        int diff = 0;
        for (int i = 0; i < word.length(); i ++) {
            if (word.charAt(i) != next.charAt(i)) diff ++;
        }
        return diff == 1;
    }
}


class Solution {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        return dfs(root, low, high);
    }
    
    TreeNode dfs(TreeNode root, int low, int high) {
        if (root == null) return null;
        if (root.val >= low && root.val <= high) {
            TreeNode left = dfs(root.left, low, high);
            root.left = left;
            TreeNode right = dfs(root.right, low, high);
            root.right = right;
            return root;
        }
        if (root.val < low) return dfs(root.right, low, high);
        if (root.val > high) return dfs(root.left, low, high);
        return null;
    }
}


/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int maxIndex = findHighestPointIndex(mountainArr);
        if (mountainArr.get(maxIndex) == target) return maxIndex;
        int iTargetLeft = leftBinarySearch(target, 0, maxIndex, mountainArr);
        if (iTargetLeft != -1) return iTargetLeft;
        else return rightBinarySearch(target, maxIndex + 1, mountainArr.length(), mountainArr);
    }
    
    int findHighestPointIndex(MountainArray arr) {
        int left = 0;
        int right = arr.length() - 1;
        
        while (left < right) {
            int middle = (left + right)/2;
            if (arr.get(middle) < arr.get(middle + 1)) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }
        
        return left;
    }
    
    int leftBinarySearch(int target, int left, int right, MountainArray arr) {
        while (left < right) {
            int middle = (left + right)/2;
            if (arr.get(middle) == target) return middle;
            if (arr.get(middle) < target) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }
        return -1;
    }
    
    int rightBinarySearch(int target, int left, int right, MountainArray arr) {
        while (left < right) {
            int middle = (left + right)/2;
            if (arr.get(middle) == target) return middle;
            if (arr.get(middle) < target) {
                right = middle;
            } else {
                left = middle + 1;
            }
        }
        return -1;
    }
}

class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        for (int i = 0; i < grid.length; i ++) {
            for (int j = 0; j < grid[0].length; j ++) {
                if (grid[i][j] == 1) {
                    int curArea = area(i, j, grid);
                    if (curArea > maxArea) maxArea = curArea;
                }
            }
        }
        
        return maxArea;
    }
    
    class Position {
        int posX;
        int posY;
        Position(int pX, int pY) {
            this.posX = pX;
            this.posY = pY;
        }
    }
    int area(int pX, int pY, int[][] grid) {
        int area = 0;
        
        Deque<Position> queue = new ArrayDeque<>();
        
        queue.add(new Position(pX, pY));
        grid[pX][pY] = 0;
        while(queue.size() != 0) {
            Position node = queue.removeLast();
            area ++;
            
            if (node.posX - 1 >= 0 && grid[node.posX - 1][node.posY] == 1) {
                grid[node.posX - 1][node.posY] = 0;
                queue.addFirst(new Position(node.posX - 1, node.posY));
            }
            if (node.posX + 1 < grid.length && grid[node.posX + 1][node.posY] == 1) {
                grid[node.posX + 1][node.posY] = 0;
                queue.addFirst(new Position(node.posX + 1, node.posY));
            }
            if (node.posY - 1 >= 0 && grid[node.posX][node.posY -1] == 1) {
                grid[node.posX][node.posY - 1] = 0;
                queue.addFirst(new Position(node.posX, node.posY - 1));
            }
            if (node.posY + 1 < grid[0].length && grid[node.posX][node.posY + 1] == 1) {
                grid[node.posX][node.posY + 1] = 0;
                queue.addFirst(new Position(node.posX, node.posY + 1));
            }
            
        }
        
        return area;
    }
}


class Solution {
    public int findBottomLeftValue(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        int leftMostValue = root.val;
        
        queue.addFirst(root);
        while (queue.size() != 0) {
            int size = queue.size();
            leftMostValue = queue.getLast().val;
            while(size != 0) {
                TreeNode node = queue.removeLast();
                if (node.left != null) queue.addFirst(node.left);
                if (node.right != null) queue.addFirst(node.right);
                size--;
            }
        }
        
        return leftMostValue;
    }
}

class Solution {
    public List<Integer> largestValues(TreeNode root) {
        if (root == null) return new ArrayList<Integer>();
        Deque<TreeNode> queue = new ArrayDeque<>();
        List<Integer> res = new ArrayList<>();
        queue.addFirst(root);
        
        while (queue.size() != 0) {
            int size = queue.size();
            int max = Integer.MIN_VALUE;
            
            while(size != 0) {
                TreeNode node = queue.removeLast();
                if (node.val > max) max = node.val;
                if (node.left != null) queue.addFirst(node.left);
                if (node.right != null) queue.addFirst(node.right);
                size --;
            }
            
            res.add(max);
            
        }
        
        return res;
        
    }
}
class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> isVisited = new HashSet<>();
        Deque<String> queue = new ArrayDeque<String>();
        String current = "0000";
        checkAndAdd(current, queue, isVisited, deadends);
        
        int level = 0;
        while(queue.size() != 0) {
            int size = queue.size();
            while(size != 0) {
                current = queue.removeLast();
                if (current.equals(target)) return level;
                
                move(current, queue, isVisited, deadends);
                size--;
            }
            
            level ++;
        }
        return -1;
    }
    
    void move(String current, Deque queue, Set<String> isVisited, String[] deadends) {
        char[] charArr = current.toCharArray();
        for (int i = 0; i < charArr.length; i ++) {
            if (charArr[i] != '0' && charArr[i] != '9') {
                charArr[i] = (char) (charArr[i] + 1);
                String newStr = new String(charArr);
                checkAndAdd(newStr, queue, isVisited, deadends);
                charArr[i] = (char)(charArr[i] - 2);
                newStr = new String(charArr);
                checkAndAdd(newStr, queue, isVisited, deadends);
                charArr[i] = (char)(charArr[i] + 1);
            }  else if (charArr[i] == '0') {
                charArr[i] = '9';
                String newStr = new String(charArr);
                checkAndAdd(newStr, queue, isVisited, deadends);
                charArr[i] = '1';
                newStr = new String(charArr);
                checkAndAdd(newStr, queue, isVisited, deadends);
                charArr[i] = '0';
            } else if (charArr[i] == '9') {
                charArr[i] = '0';
                String newStr = new String(charArr);
                checkAndAdd(newStr, queue, isVisited, deadends);
                charArr[i] = '8';
                newStr = new String(charArr);
                checkAndAdd(newStr, queue, isVisited, deadends);
                charArr[i] = '9';
            }
        }
    }
    
    void checkAndAdd(String string, Deque queue, Set<String> isVisited, String[] deadends) {
        if (!isVisited.contains(string)) {
            for (int i = 0; i < deadends.length; i ++) {
                if (deadends[i].equals(string)) return;
            }
            isVisited.add(string);
            queue.addFirst(string);
        }
    }
   
}



class Solution {
    
    class Position{
        int px;
        int py;
        Position(int px, int py) {
            this.px = px;
            this.py = py;
        }
    }
    public int maxDistance(int[][] grid) {
        Deque<Position> queue = new ArrayDeque<>();
        
        for (int i = 0; i < grid.length; i ++) {
            for (int j = 0; j < grid[0].length; j ++) {
                if (grid[i][j] == 1) queue.addFirst(new Position(i, j));
            }
        }
        if (queue.size() == grid.length * grid[0].length) return -1;
        int level = 0;
        while(queue.size() != 0) {
            int size = queue.size();
            List<Position> list = new ArrayList<>();
            while (size != 0) {
                list.add(queue.removeLast());
                size --;
            }
            list.forEach(node -> {
                getNeighborWater(node.px, node.py, grid).forEach(neighbor -> {
                    grid[neighbor.px][neighbor.py] = 1;
                    queue.addFirst(new Position(neighbor.px, neighbor.py));
                });
            });
            
            level ++;
        }
        
        return level - 1;
    }
    
    List<Position> getNeighborWater(int px, int py, int[][] grid) {
        List<Position> listPos = new ArrayList<>();
        if (px - 1 >= 0 && grid[px - 1][py] == 0) listPos.add(new Position(px - 1, py));
        if (px + 1 < grid.length && grid[px + 1][py] == 0) listPos.add(new Position(px + 1, py));
        if (py - 1 >= 0 && grid[px][py - 1] == 0) listPos.add(new Position(px, py - 1));
        if (py + 1 < grid[0].length && grid[px][py + 1] == 0) listPos.add(new Position(px, py + 1));
        
        return listPos;
    }
    
}

class Solution {
    class Position{ 
        int px;
        int py;
        Position(int px, int py) {
            this.px = px;
            this.py = py;
        }
    }
    public int largestIsland(int[][] grid) {
        boolean isAllOne = true;
        for (int i = 0; i < grid.length; i ++) {
            for (int j = 0; j < grid[0].length; j ++) {
                if (grid[i][j] == 0) isAllOne = false;
            }
        }
        
        if (isAllOne) return grid.length * grid[0].length;
        
        
        int[][] cover = new int[grid.length][grid[0].length];
        for (int[] row: cover) {
            Arrays.fill(row, 0);
        }
        
        for (int i = 0; i < grid.length; i ++) {
            for (int j = 0; j < grid[0].length; j ++) {
                if (grid[i][j] == 1) updateLevel(i, j, grid, cover);
            }
        }
        
        int max = 0;
        for (int i = 0; i < grid.length; i ++) {
            for (int j = 0; j < grid[0].length; j ++) {
                if (cover[i][j] > max) max = cover[i][j];
            }
        }
        return max + 1;
        
    }
    
   
    void updateLevel(int px, int py, int[][] grid, int[][] cover) {
        Deque<Position> queue = new ArrayDeque<>();
        grid[px][py] = -1;
        queue.addFirst(new Position(px, py));
        List<Position> island = new ArrayList<>();
        while(queue.size() != 0) {
            Position pos = queue.removeLast();
            island.add(pos);
            List<Position> list = getNeighbor(pos.px, pos.py, grid);
            list.forEach(node -> {
                grid[node.px][node.py] = -1;
                queue.addFirst(node);
            });
            
        }
        int size = island.size();
        boolean[][] isUpdated = new boolean[grid.length][grid[0].length];
        for (boolean[] row: isUpdated) {
            Arrays.fill(row, false);
        }
        island.forEach(node -> {
            update(node.px, node.py, grid, cover, size, isUpdated);
        });
    }
    
    List<Position> getNeighbor(int px, int py, int[][] grid) {
        List<Position> res = new ArrayList<>();
        if (px - 1 >= 0  && grid[px - 1][py] == 1)  res.add(new Position(px - 1, py));
        if (px + 1 < grid.length && grid[px + 1][py] == 1) res.add(new Position(px + 1, py));
        if (py - 1 >= 0 && grid[px][py - 1] == 1) res.add(new Position(px, py - 1));
        if (py + 1 < grid[0].length && grid[px][py + 1] == 1) res.add(new Position(px, py + 1));
        
        return res;
    }
    
     void update(int px, int py,int[][] grid, int[][] cover, int value, boolean[][] isUpdated) {
        if (px - 1 >= 0 && grid[px - 1][py] == 0 && !isUpdated[px - 1][py]){
            cover[px - 1][py] += value;
            isUpdated[px - 1][py] = true;
        }
        if (px + 1 < grid.length && grid[px + 1][py] == 0 && !isUpdated[px + 1][py]) {
            cover[px + 1][py] += value;
            isUpdated[px + 1][py] = true;
        }
        if (py - 1 >= 0 && grid[px][py - 1] == 0 && !isUpdated[px][py - 1]) {
            cover[px][py - 1] += value;
            isUpdated[px][py - 1] = true;
        }
        if (py + 1 < grid[0].length && grid[px][py + 1] == 0 && !isUpdated[px][py + 1]) {
            cover[px][py + 1] += value;
            isUpdated[px][py + 1] = true;
        }
     }
}


class Solution {
    class Position{ 
        int px;
        int py;
        Position(int px, int py) {
            this.px = px;
            this.py = py;
        }
    }
    public int largestIsland(int[][] grid) {
        boolean isAllOne = true;
        for (int i = 0; i < grid.length; i ++) {
            for (int j = 0; j < grid[0].length; j ++) {
                if (grid[i][j] == 0) isAllOne = false;
            }
        }
        
        if (isAllOne) return grid.length * grid[0].length;
        
        
        int[][] cover = new int[grid.length][grid[0].length];
        for (int[] row: cover) {
            Arrays.fill(row, 0);
        }
        
        for (int i = 0; i < grid.length; i ++) {
            for (int j = 0; j < grid[0].length; j ++) {
                if (grid[i][j] == 1) updateLevel(i, j, grid, cover);
            }
        }
        
        int max = 0;
        for (int i = 0; i < grid.length; i ++) {
            for (int j = 0; j < grid[0].length; j ++) {
                if (cover[i][j] > max) max = cover[i][j];
            }
        }
        return max + 1;
        
    }
    
   
    void updateLevel(int px, int py, int[][] grid, int[][] cover) {
        Deque<Position> queue = new ArrayDeque<>();
        grid[px][py] = -1;
        queue.addFirst(new Position(px, py));
        List<Position> island = new ArrayList<>();
        while(queue.size() != 0) {
            Position pos = queue.removeLast();
            island.add(pos);
            List<Position> list = getNeighbor(pos.px, pos.py, grid);
            list.forEach(node -> {
                grid[node.px][node.py] = -1;
                queue.addFirst(node);
            });
            
        }
        int size = island.size();
        boolean[][] isUpdated = new boolean[grid.length][grid[0].length];

        island.forEach(node -> {
            update(node.px, node.py, grid, cover, size, isUpdated);
        });
    }
    
    List<Position> getNeighbor(int px, int py, int[][] grid) {
        List<Position> res = new ArrayList<>();
        if (px - 1 >= 0  && grid[px - 1][py] == 1)  res.add(new Position(px - 1, py));
        if (px + 1 < grid.length && grid[px + 1][py] == 1) res.add(new Position(px + 1, py));
        if (py - 1 >= 0 && grid[px][py - 1] == 1) res.add(new Position(px, py - 1));
        if (py + 1 < grid[0].length && grid[px][py + 1] == 1) res.add(new Position(px, py + 1));
        
        return res;
    }
    
     void update(int px, int py,int[][] grid, int[][] cover, int value, boolean[][] isUpdated) {
        if (px - 1 >= 0 && grid[px - 1][py] == 0 && !isUpdated[px - 1][py]){
            cover[px - 1][py] += value;
            isUpdated[px - 1][py] = true;
        }
        if (px + 1 < grid.length && grid[px + 1][py] == 0 && !isUpdated[px + 1][py]) {
            cover[px + 1][py] += value;
            isUpdated[px + 1][py] = true;
        }
        if (py - 1 >= 0 && grid[px][py - 1] == 0 && !isUpdated[px][py - 1]) {
            cover[px][py - 1] += value;
            isUpdated[px][py - 1] = true;
        }
        if (py + 1 < grid[0].length && grid[px][py + 1] == 0 && !isUpdated[px][py + 1]) {
            cover[px][py + 1] += value;
            isUpdated[px][py + 1] = true;
        }
     }
}

class FindElements {
    Set<Integer> vals = new HashSet<>();
    TreeNode root;
    public FindElements(TreeNode root) {
        this.root = root;
        recover(root, 0);
    }
    
    private void recover(TreeNode root, int val) {
        vals.add(val);
        root.val = val;
        if (root.left != null) recover(root.left, 2 * val + 1);
        if (root.right != null) recover(root.right, 2 * val + 2);
    }
    
    public boolean find(int target) {
        return vals.contains(target);
    }
}

class Solution {
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        
        boolean isRemoveRoot = updateTree(root, target);
        if (isRemoveRoot) return null;
        else return root;
    }
    
    boolean updateTree(TreeNode root, int target) {
        if (root.val == target && root.left == null && root.right == null) return true;
        boolean isEmptyLeft = false;
        boolean isEmptyRight = false;
        if (root.left != null) {
            boolean isRemoveLeft = updateTree(root.left, target);
            if (isRemoveLeft) {
                root.left = null;
                isEmptyLeft = true;
            }
        } else isEmptyLeft = true;
        if (root.right != null) {
            boolean isRemoveRight = updateTree(root.right, target);
            if (isRemoveRight) {
                root.right = null;
                isEmptyRight = true;
            }
        } else isEmptyRight = true;
        
        
        if (isEmptyRight && isEmptyLeft) return root.val == target;
        else return false;
    }
    
}


class Solution {
    public int goodNodes(TreeNode root) {
        return countGoodNodes(root, -10000);
    }
    
    int countGoodNodes(TreeNode root, int max) {
        if (root == null) return 0;
        return (root.val >= max ? 1 : 0) + countGoodNodes(root.left, Math.max(max, root.val)) + countGoodNodes(root.right, Math.max(max, root.val));
    }
}

class Solution {
    public int pseudoPalindromicPaths (TreeNode root) {
        int[] eleFre = new int[10];
        Arrays.fill(eleFre, 0);
        return countPseudoPalindromicPaths(root, eleFre);
    }
    
    private int countPseudoPalindromicPaths(TreeNode root, int[] eleFre) {
        eleFre[root.val] ++;
        if (root.left == null && root.right == null) {
            boolean isPalindromic = isPossiblePalindromic(eleFre);
            eleFre[root.val] --;
            return isPalindromic ? 1: 0;

        }
        int total = 0;
        if (root.right != null) {
            total += countPseudoPalindromicPaths(root.right, eleFre);
        } 
        if (root.left != null){
            total += countPseudoPalindromicPaths(root.left, eleFre);
        }
        
        eleFre[root.val] --;
        return total;
    }
    
    private boolean isPossiblePalindromic(int[] eleFre) {
        int nEven = 0;
        int nOdd = 0;
        
        for (int i = 0; i < eleFre.length; i ++) {
            if (eleFre[i] % 2 == 0) nEven ++;
            else nOdd ++;
        }
        
        return nOdd == 1 || nOdd == 0;
    }
}

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        Deque<Node> queue = new ArrayDeque<>();
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        queue.addFirst(root);
        
        while(queue.size() != 0) {
            int size = queue.size();
            List<Integer> curLevelNodes = new ArrayList<>();
            while(size != 0) {
                Node node = queue.removeLast();
                curLevelNodes.add(node.val);
                node.children.forEach(child -> {
                   queue.addFirst(child); 
                });
                size --;
            }
            res.add(curLevelNodes);
        }
        return res;
    }
}


class Solution {
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return getResult(root, 1, getHeight(root));
    }
    
    private TreeNode getResult(TreeNode root, int curHeight, int height) {
        if (root == null) return null;
        if (root.left == null && root.right == null && curHeight == height) return root;
        TreeNode leftRes = getResult(root.left, curHeight + 1, height);
        TreeNode rightRes = getResult(root.right, curHeight + 1, height);
        if (leftRes != null && rightRes != null) return root;
        else if (leftRes != null) return leftRes;
        else return rightRes;
    }
    private int getHeight(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int height = 0;
        while(queue.size() != 0) {
            int size = queue.size();
            while(size != 0) {
                TreeNode cur = queue.removeLast();
                if (cur.left != null) queue.addFirst(cur.left);
                if (cur.right != null) queue.addFirst(cur.right);
                size --;
            }
                       
            height ++;
        }
        return height;
    }
}

//Folder name maybe have more than one char like /aa
// /a/b/ca is start with /a/b/c but /a/b/c is not parent of /a/b/ca

class Solution {
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);
        List<String> res = new ArrayList<>();
        int curIndex = 0;
        int nextIndex = 1;
        res.add(folder[curIndex]);
        while(nextIndex < folder.length){
            while (nextIndex < folder.length && getParentFolder(folder[nextIndex]).startsWith(folder[curIndex])) {
                nextIndex ++;
            }
            if (nextIndex < folder.length) {
                curIndex = nextIndex;
                nextIndex ++;
                res.add(folder[curIndex]);
            }
        }
        
        return res;
    
        
    }
    
    String getParentFolder(String folder) {
        int lastIndex = folder.lastIndexOf("/");
        return folder.substring(0, lastIndex);
    }
    

}

class Solution {
    
    class Position{
        int px;
        int py;
        Position(int px, int py) {
            this.px = px;
            this.py = py;
        }
    }
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int total = 0;
        for (int i = 0; i < grid2.length; i ++) {
            for (int j = 0; j < grid2[0].length; j ++) {
                if (grid2[i][j] == 1 && checkAndUpdate(i, j, grid1, grid2)) total ++;
            }
        }
        return total;
    }
    
    boolean checkAndUpdate(int px, int py, int[][] grid1, int[][] grid2) {
        boolean isSub = true;
        Deque<Position> queue = new ArrayDeque<>();
        add(px, py, grid2, queue);
        while(queue.size() != 0) {
            Position tile = queue.removeLast();
            if (grid1[tile.px][tile.py] == 0) isSub = false;
            add(tile.px - 1, tile.py, grid2, queue);
            add(tile.px + 1, tile.py, grid2, queue);
            add(tile.px, tile.py - 1, grid2, queue);
            add(tile.px, tile.py + 1, grid2, queue);
        }
        return isSub;
    }
    
    void add(int px, int py, int[][] grid2, Deque<Position> queue) {
        if (px >= 0 && px < grid2.length && py >= 0 && py < grid2[0].length && grid2[px][py] == 1)  {
            grid2[px][py] = 0;
            queue.addFirst(new Position(px, py));
        }
    }
}


class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        for (int i = edges.length - 1; i >= 0; i --) {
            if (canConnect(i, edges)) return edges[i];
        }
        return null;
    }
    
    boolean canConnect(int excludeIndex, int[][] edges) {
        int from = edges[excludeIndex][0];
        int to = edges[excludeIndex][1];
        Deque<Integer> queue = new ArrayDeque<>();
        Set<Integer> isVisited = new HashSet();
        queue.addFirst(from);
        isVisited.add(from);
        while(queue.size() != 0) {
            int val = queue.removeLast();
            if (val == to) return true;
            for (int i = 0; i < edges.length; i ++) {
                if (i != excludeIndex && edges[i][0] == val && !isVisited.contains(edges[i][1])) {
                    queue.addFirst(edges[i][1]);
                    isVisited.add(edges[i][1]);
                }
                if (i != excludeIndex && edges[i][1] == val && !isVisited.contains(edges[i][0])) {
                    queue.addFirst(edges[i][0]);
                    isVisited.add(edges[i][0]);
                }
            }
        }
        return false;   
    }
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        int sum = 0;
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while(queue.size() != 0) {
            TreeNode node = queue.removeLast();
            if (node.left != null && node.left.left == null && node.left.right == null) sum += node.left.val;
            if (node.left != null) queue.addFirst(node.left);
            if (node.right != null) queue.addFirst(node.right);
        }
        
        return sum;
    }
}

class Solution {
    public int numEnclaves(int[][] grid) {
        int total = 0;
        for (int i = 0; i < grid.length; i ++) {
            for (int j = 0; j < grid[0].length; j ++) {
                if (grid[i][j] == 1) total += isEnclave(i, j, grid);
            }
        }
        return total;
    }
    
    class Position {
        int px;
        int py;
        Position(int px, int py) {
            this.px = px;
            this.py = py;
        }
    }
    int isEnclave(int px, int py, int[][] grid) {
        boolean isEnclave = true;
        Deque<Position> queue = new ArrayDeque<>();
        isEnclave = !addAndUpdateThenCheckBoundary(px, py, grid, queue) && isEnclave;
        int size = 0;
        while(queue.size() != 0) {
            Position cell = queue.removeLast();
            size ++;
            isEnclave = !addAndUpdateThenCheckBoundary(cell.px - 1, cell.py, grid, queue) && isEnclave;
            isEnclave = !addAndUpdateThenCheckBoundary(cell.px + 1, cell.py, grid, queue) && isEnclave;
            isEnclave = !addAndUpdateThenCheckBoundary(cell.px, cell.py - 1, grid, queue) && isEnclave;
            isEnclave = !addAndUpdateThenCheckBoundary(cell.px, cell.py + 1, grid, queue) && isEnclave;
            
        }
        if (isEnclave) return size;
        else return 0;
    }
    
    boolean addAndUpdateThenCheckBoundary(int px, int py, int[][] grid, Deque<Position> queue) {
        if (px >= 0 && px < grid.length && py >= 0 && py < grid[0].length && grid[px][py] == 1) {
            queue.addFirst(new Position(px, py));
            grid[px][py] = 0;
            return (px == 0 || px == grid.length - 1 || py == 0 || py == grid[0].length - 1);
        }
        return false;
    }
}


class Solution {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        for (int i = edges.length - 1; i >= 0; i --) {
            if (canConnect(i, edges)) return edges[i];
        }
        return null;
    }
    
      boolean canConnect(int excludeIndex, int[][] edges) {
        int from = edges[excludeIndex][0];
        boolean isContainFrom = false;
        int to = edges[excludeIndex][1];
        boolean isContainTo = false;
        Deque<Integer> queue = new ArrayDeque<>();
        Set<Integer> isVisited = new HashSet();
        int rootNode = getRootNode(excludeIndex, edges);
        if (rootNode == -1) return false;
        queue.addFirst(rootNode);
        while(queue.size() != 0) {
            int val = queue.removeLast();
            if (val == from) isContainFrom = true;
            if (val == to) isContainTo = true;
            if (isContainFrom && isContainTo) return true;
            for (int i = 0; i < edges.length; i ++) {
                if (i != excludeIndex && edges[i][0] == val && !isVisited.contains(edges[i][1])) {
                    queue.addFirst(edges[i][1]);
                }
            }
        }
        return false;   
    }
    
    int getRootNode(int excludeIndex, int[][] edges) {
        int[] inNode = new int[edges.length + 1];
        for (int i = 0; i < edges.length; i ++) {
            if (i != excludeIndex) inNode[edges[i][1]] ++;
        }
        int evenNode = 0;
        int nEven = 0;
        for (int i = 1; i <= edges.length; i ++) {
            if (inNode[i] == 0) {
                nEven ++;
                evenNode = i;
            }
        }
        if (nEven == 1) return evenNode;
        else return -1;
    }

}

class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        return maxSatisfaction(0, 0, 0, satisfaction);
    }
    
    int maxSatisfaction(int index, int nDish, int curSatisfaction, int[] satisfaction) {
        if (index == satisfaction.length) return curSatisfaction;
        int choose = maxSatisfaction(index + 1, nDish + 1, curSatisfaction + (nDish + 1) * satisfaction[index], satisfaction);
        int notChoose = maxSatisfaction(index + 1, nDish, curSatisfaction, satisfaction);
        return Math.max(choose, notChoose);
    }
}


class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int[] coSum = new int[satisfaction.length + 1];
        int[] eleSum = new int[satisfaction.length + 1];
        
        for (int i = satisfaction.length - 1; i >= 0; i--) {
            if (coSum[i + 1] > coSum[i + 1] + eleSum[i + 1] + satisfaction[i]) {
                coSum[i] = coSum[i + 1];
                eleSum[i] = eleSum[i + 1];
            } else {
                coSum[i] = coSum[i + 1] + eleSum[i + 1] + satisfaction[i];
                eleSum[i] = eleSum[i + 1] + satisfaction[i];
            }
        }
        
        return coSum[0];
    }
    
 
}
