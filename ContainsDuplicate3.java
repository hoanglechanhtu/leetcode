class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        Map<Long, Long> bucketMap = new HashMap<>();
        int n = nums.length;
        
        for (int i = 0; i < nums.length; i ++) {
            long num = nums[i];
            long bucketId = getBucket(nums[i], t);
            
            if (bucketMap.containsKey(bucketId) 
               || (bucketMap.containsKey(bucketId - 1) && num - bucketMap.get(bucketId - 1) <= t)
                || (bucketMap.containsKey(bucketId + 1) && bucketMap.get(bucketId + 1) - num <= t)
               ) {
                return true;
            }
            
            if (bucketMap.size() >= k) {
                long removeBucketId = getBucket(nums[i - k], t);
                bucketMap.remove(removeBucketId);
            }
            bucketMap.put(bucketId, num);
            
        }
        
        return false;
        
    }
    
    
    long getBucket(long value, long div) {
        long bucketId = value / (div + 1);
        if (value < 0) bucketId = bucketId - 1;
        return bucketId;
    }
    
    /// 1 2 3 1
}
