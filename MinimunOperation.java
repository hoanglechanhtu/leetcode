class Solution {
    public int minimumOperations(int[] nums, int start, int goal) {
         Deque<Integer> queue = new ArrayDeque<>();
        
        Set<Integer> set = new HashSet<>();
        queue.addFirst(start);
        set.add(start);
        int nOper = 0;
        while(queue.size() != 0) {
            int size = queue.size();
            nOper ++;
            while(size > 0) {
                Integer value = queue.removeLast();
                if (value == goal) return nOper;
                    for (int i = 0; i < nums.length; i ++) {
                        int[] arrs = new int[]{value + nums[i], value - nums[i], value ^ nums[i]};
                        for (Integer x: arrs) {
                            if (x == goal) return nOper ++;
                            if (x >= 0 && x <= 1000 && !set.contains(x)) {
                                queue.addFirst(x);
                                set.add(x);
                            }
                        }
                    }
                size--;
            }
        }
        return -1;
    }
}
