class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int N = intervals.length;
        int[][] newIntervals = new int[N + 1][2];
        for (int i = 0; i < N; i ++) {
            newIntervals[i] = intervals[i];
        }
        newIntervals[N] = newInterval;
        Arrays.sort(newIntervals, Comparator.comparing(x -> x[0]));
        LinkedList<int[]> list = new LinkedList<>();
        for (int i = 0; i < N + 1; i ++) {
            if (list.isEmpty() || list.getLast()[1] < newIntervals[i][0]) {
                list.add(newIntervals[i]);
            } else {
                list.getLast()[1] = Math.max(list.getLast()[1], newIntervals[i][1]);
            }
        }
        return list.toArray(new int[list.size()][2]);
    }
}
