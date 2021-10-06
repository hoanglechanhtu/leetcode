class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i ++) {
            if (map.containsKey(nums[i])) {
                map.get(nums[i]).add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(nums[i], list);
            }
        }
        
        for (int i = 0; i < nums.length; i ++) {
            if (!map.containsKey(nums[i])) continue ;
            map.get(nums[i]).remove(Integer.valueOf(i));
            for (int j = i + 1; j < nums.length; j ++) {
                map.get(nums[j]).remove(Integer.valueOf(j));
                if ((j == i + 1 || nums[j - 1] != nums[j]) && map.containsKey(- nums[i] - nums[j])) {
                 
                    if (map.get(- nums[i] - nums[j]).size() != 0) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[map.get(- nums[i] - nums[j]).get(0)]);
                        res.add(list);
                    }
                }
            }
            for (int j = i + 1; j < nums.length; j ++) {
                map.get(nums[j]).add(j);
            }           
            
            map.remove(Integer.valueOf(nums[i]));
        }
        
        return res;
    }
}
