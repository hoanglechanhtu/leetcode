    class Solution {
        public int rangeSum(int[] nums, int n, int left, int right) {
            int mod = 1000000007;
            List<Integer> subSum = getSubSumList(nums);
            Collections.sort(subSum);
            int res = 0;
            for (int i = left; i <= right; i ++){
                res = (res + (subSum.get(i - 1) % mod)) % mod;
            }
            return res;
        }

        List<Integer> getSubSumList(int[] nums) {
            List<Integer> res = new ArrayList<>();
            for (int i = 0; i < nums.length; i ++) {
                sumSubUtil(i, nums, 0, res);
            }
            return res;
        }

        void sumSubUtil(int pos, int[] nums, int cur, List<Integer> res) {
            if (pos >= nums.length) return;
            res.add(cur + nums[pos]);
            sumSubUtil(pos + 1, nums, cur + nums[pos], res);
        }

    }
