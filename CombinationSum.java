class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        
        backtrack(candidates, 0, target, new ArrayList<>(), res);
        return res;
    }
    
    void backtrack(int[] candidates, int start, int target, List<Integer> cur, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList(cur));
            return;
        }
        if (target < 0) return;
        
        for (int i = start; i < candidates.length; i ++) {
            cur.add(candidates[i]);
            backtrack(candidates, i, target - candidates[i], cur, res);
            cur.remove(cur.size() - 1);
        }
    }
}
