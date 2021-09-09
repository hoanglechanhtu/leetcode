class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int iNum1 = 0;
        int iNum2 = 0;
        int[] intersect = new int[nums1.length + nums2.length];
        int i = 0;
        while (iNum1 < nums1.length && iNum2 < nums2.length) {
            if (nums1[iNum1] == nums2[iNum2]) {
                intersect[i] = nums1[iNum1];
                i ++;
                iNum1 ++;
                iNum2 ++;
            } else if (nums1[iNum1] > nums2[iNum2]) {
                iNum2 ++;
            } else {
                iNum1 ++;
            }
        }
        
        return Arrays.copyOf(intersect, i);
    }
}
