//Split the array into sqrt(len) array of sum
class NumArray {
    private int[] b;
    private int[] nums;
    private int len;
    public NumArray(int[] nums) {
        this.nums = nums;
        double l = Math.sqrt(nums.length);
        len = (int) Math.ceil(nums.length/l);
        b = new int[len];
        for (int i = 0; i < nums.length; i ++) {
            b[i/len] += nums[i];
        }
    }
    
    public void update(int index, int val) {
        int blockIndex = index/len;
        b[blockIndex] += (val - nums[index]);
        nums[index] = val;
        
    }
    
    public int sumRange(int left, int right) {
        int sum = 0;
        int startBlock = left/len;
        int endBlock = right/len;
        if (startBlock == endBlock) {
            for (int i = left; i <= right; i ++) {
                sum += nums[i];
            }
        } else {
            for (int i = left; i <= (startBlock + 1) * len - 1; i ++) {
                sum += nums[i];
            }
            for (int i = startBlock + 1; i <= endBlock - 1; i ++) {
                sum += b[i];
            }
            for (int i = endBlock * len; i <= right; i ++) {
                sum += nums[i];
            }
        }
        return sum;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */
 
 
 
 Segment Tree
 class NumArray {
    int[] seg;
    int[] nums;
    int n;
    public NumArray(int[] nums) {
        n = nums.length;
        this.nums = nums;
        buildSegmentTree(nums);
    }
    
    void buildSegmentTree(int[] nums) {
        seg = new int[2*n];
        for (int i = n, j = 0; i < 2*n; i ++, j ++) {
            seg[i] = nums[j];
        }
        
        for (int i = n - 1; i >= 0; i --) {
            seg[i] = seg[i * 2] + seg[i * 2 + 1];
        }
    }
    
    public void update(int index, int val) {
        nums[index] = val;
        int segIndex = index + n;
        seg[segIndex] = val;
        while(segIndex > 0) {
            int left = segIndex;
            int right = segIndex;
            if (segIndex % 2 == 0) {
                right += 1;
            } else {
                left -= 1;
            }
            
            seg[segIndex/2] = seg[left] + seg[right];
            segIndex /= 2;
        }
    }
    
    public int sumRange(int left, int right) {
        left += n;
        right += n;
        int sum = 0;
        while(left <= right) {
            if (left % 2 == 1) {
                sum += seg[left];
                left ++;
            }
            
            if (right % 2 == 0) {
                sum += seg[right];
                right --;
            }
            
            left /= 2;
            right /= 2;
        }
        
        return sum;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */
