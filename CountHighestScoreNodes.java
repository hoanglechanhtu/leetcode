class Solution {
    public int countHighestScoreNodes(int[] parents) {
        int n = parents.length;
        int[] left = new int[n], right = new int[n];
        int[] score = new int[n];
        
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i ++) {
            if (parents[i] != -1) {
                if (map.containsKey(parents[i])) {
                    map.get(parents[i]).add(i);
                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    map.put(parents[i], list);
                }
            }
        }
        
        boolean[] isVisited = new boolean[n];
        Arrays.fill(isVisited, false);
        
        buildTree(0, left, right, map, isVisited);
        
        int max = 0, total = 0;
        for (int i = 0; i < n; i ++) {
            if (left[i] != 0 && right[i] != 0) {
                if (n - left[i] - right[i] - 1 == 0) {
                    score[i] = left[i] * right[i];
                } else {
                    score[i] = left[i] * right[i] * (n - left[i] - right[i] - 1);
                }
            } else if (left[i] == 0 && right[i] == 0) {
                score[i] = n - 1;
            } else if (left[i] != 0) {
                if (n - left[i] - 1 == 0) {
                    score[i] = left[i];
                } else {
                    score[i] = left[i] * (n - left[i] - 1);
                }
            } else {
                if (n - right[i] - 1 == 0) {
                    score[i] = right[i];
                } else {
                    score[i] = right[i] * (n - right[i] - 1);
                }
            }
            max = Math.max(max, score[i]);
        }
        for (int i = 0; i < n; i ++) {
            if (score[i] == max) total ++;
        }
        return total;
    }
    
    int buildTree(int index, int[] left, int[] right, Map<Integer, List<Integer>> map, boolean[] isVisited) {
        if (!map.containsKey(index)) {
            isVisited[index] = true;
            return 1;
        }
        map.get(index).forEach(value -> {
            if (left[index] == 0 && !isVisited[index]) left[index] = buildTree(value, left, right, map, isVisited);
            else if (right[index] == 0 && !isVisited[index]) right[index] = buildTree(value, left, right, map, isVisited);  
        });
        
        isVisited[index] = true;
        return 1 + left[index] + right[index];
        
    }
}
