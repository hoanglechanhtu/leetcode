    class Solution {
        public int[][] merge(int[][] intervals) {
            Arrays.sort(intervals, Comparator.comparing(arr -> arr[0]));
            List<int[]> res = new ArrayList<>();
            int i = 0;
            
            while(i < intervals.length) {
                if (i < intervals.length - 1 && intervals[i][1] >= intervals[i + 1][1]) {
                    intervals[i + 1][0] = intervals[i][0];
                    intervals[i + 1][1] = intervals[i][1];
                } else if (i < intervals.length - 1 && intervals[i][1] >= intervals[i + 1][0]) {
                    intervals[i + 1][0] = intervals[i][0];
                } else {
                    res.add(intervals[i]);
                }
                
                i ++;
            }
            
            int[][] resArray = new int[res.size()][2];
            for (int j = 0; j < res.size(); j ++) {
                resArray[j] = res.get(j);
            }
            
            return resArray;
        }
    }

    class Solution {
        public int[][] merge(int[][] intervals) {
            Arrays.sort(intervals, Comparator.comparing(arr -> arr[0]));
            LinkedList<int[]> merged = new LinkedList<>();
            for (int[] interval : intervals) {
                if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
                    merged.add(interval);
                } else {
                    merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
                }
            }
            
            return merged.toArray(new int[merged.size()][]);
        }
    }
