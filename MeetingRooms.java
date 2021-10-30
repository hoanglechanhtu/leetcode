class Solution {
    public boolean canAttendMeeting(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparing(x -> x[0]);
        for (int i = 1; i < intervals.length; i ++) {
          if (intervals[i-1][1] > intervals[i][0]) return false;
        }
        return true;
    }
}
