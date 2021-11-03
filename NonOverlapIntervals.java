
    class Solution {
        public int eraseOverlapIntervals(int[][] intervals) {
            sort(intervals);
            int baseIndex = 0;
            int compareIndex = baseIndex + 1;
            int nRemove = 0;
            while (compareIndex < intervals.length) {
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
            Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));
        }
    }
