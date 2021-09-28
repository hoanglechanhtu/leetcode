//There is 2 ways to backtracking
//First one is by choose or not choose an index 
//                                  start
//                  0-choose                  0-not choose
//            1-choose   1-not choose     1-choose       1-not choose
//The second one is choosing a number for an index.
//              index- 0    0               1        2       3
//        index - 1     1      2   3      2   3      3       null
//        index - 2    2  3    3   null   3   null   null 
//             
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        combinationUtil(0, target, candidates, new ArrayList<>(), res);
        
        return res;
    }
    
    void combinationUtil(int index, int target, int[] candidates, List<Integer> cur, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList(cur));
            return;
        }
        if (target < 0) return;
        for (int i = index; i < candidates.length; i ++) {
            if (i == index || candidates[i] != candidates[i - 1]) {
                cur.add(candidates[i]);
                combinationUtil(i + 1, target - candidates[i], candidates, cur, res);
                cur.remove(cur.size() - 1);
            }
        }
    }
}
