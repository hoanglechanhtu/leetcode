public class Solution {
    /**
     * @param n: An integer
     * @param edges: a list of undirected edges
     * @return: true if it's a valid tree, or false
     */
    public boolean validTree(int n, int[][] edges) {
        // write your code here
        if (n == 1 && edges.length == 0)
            return true;
       
        List<Integer>[] relation = buildRelation(n, edges);
        return checkRelation(n, relation);
        
    }
    boolean checkRelation(int n, List<Integer>[] relation) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < relation.length; i++) {
            if (relation[i].size() == 1) {
                queue.offer(i);
            }
        }

        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Integer node = queue.poll();
                count++;
                for (Integer nb : relation[node]) {
                    relation[nb].remove(node);
                    if (relation[nb].size() == 1) {
                        queue.offer(nb);
                    }
                }
                relation[node] = new ArrayList<>();
            }
        }

        return count == n;
    }
    List<Integer>[] buildRelation(int n, int[][] edges) {
        List<Integer>[] relation = new ArrayList[n];

        for (int i = 0; i < relation.length; i++) {
            relation[i] = new ArrayList<>();
        }

        for (int i = 0; i < edges.length; i++) {
            relation[edges[i][0]].add(edges[i][1]);
            relation[edges[i][1]].add(edges[i][0]);
        }
        return relation;
    }

}

public class Solution {
    /**
     * @param n: An integer
     * @param edges: a list of undirected edges
     * @return: true if it's a valid tree, or false
     */
    public boolean validTree(int n, int[][] edges) {
        // write your code here
        if (fastPass(n, edges)) return true;
        adjustEdges(edges);
        return check(n, edges);
    }


    boolean fastPass(int n, int[][] edges) {
        return n == 1 && edges.length == 0;
    }

    void adjustEdges(int[][] edges){
        Arrays.sort(edges, Comparator.comparing(x -> x[0]));
        for (int i = 0; i < edges.length; i ++) {
            if (edges[i][0] > edges[i][1]) {
                int temp = edges[i][0];
                edges[i][0] = edges[i][1];
                edges[i][1] = temp;
            }
        }
    }
    boolean check(int n, int[][] edges) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i ++) {
            List<Integer> list = new ArrayList<>();
            map.put(i, list);
        }
        for (int i = 0; i < edges.length; i ++) {
            map.get(edges[i][0]).add(edges[i][1]);
        }
        boolean[] isVisited = new boolean[n];
        Arrays.fill(isVisited, false);
        for (int i = 0; i < edges.length; i ++) {
            isVisited[edges[i][1]] = true;
        }
        int root = -1;
        for (int i = 0; i < edges.length; i ++) {
            if (!isVisited[i] && root != -1) return false;
            if (!isVisited[i]) root = i;
        }
        if (root == -1) return false;
        int count = 0;
        Deque<Integer> queue = new ArrayDeque<>();
        queue.addFirst(root);
        while(!queue.isEmpty()) {
            int node = queue.removeLast();
            count ++;
            map.get(node).forEach(val -> {
                queue.addFirst(val);
            });
        }
        return count == n;
    }
}
