
object Solution {
    def findMedianSortedArrays(nums1: Array[Int], nums2: Array[Int]): Double = {
        val newArray: Array[Int] = new Array(nums1.size + nums2.size)
        var i = 0
        var j = 0
        while (i < nums1.size || j < nums2.size) {
            if (i == nums1.size) {
                newArray(i + j) = nums2(j)
                j = j + 1
            } else if (j == nums2.size) {
                newArray(i + j) = nums1(i)
                i = i + 1
            } else {
                if (nums1(i) < nums2(j)) {
                    newArray(i + j) = nums1(i)
                    i = i + 1
                } else {
                    newArray(i + j) = nums2(j)
                    j = j + 1
                }
            }

        }
        if ( newArray.size % 2 == 0){
            return (newArray((newArray.size -1)/2) + newArray(newArray.size/2))/2.0
        } else return newArray((newArray.size -1)/2)
    }
}

