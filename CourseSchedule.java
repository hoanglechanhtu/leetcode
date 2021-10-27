class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        boolean[] isVisited = new boolean[numCourses];
        Set<Integer> current = new HashSet<>();
        
        for (int i = 0; i < numCourses; i ++) {
            if (!isVisited[i] && haveCyclic(i, isVisited, current, prerequisites)) return false;
        }
        
        return true;
    }
    
    boolean haveCyclic(int pos, boolean[] isVisited, Set<Integer> current, int[][] prerequisites) {
        if (current.contains(pos)) return true;
        if (isVisited[pos]) return false;
        isVisited[pos] = true;
        current.add(pos);
        for (int i = 0; i < prerequisites.length; i ++) {
            if (prerequisites[i][1] == pos && haveCyclic(prerequisites[i][0], isVisited, current, prerequisites)) return true; 
        }
        current.remove(pos);
        return false;
    }
}
