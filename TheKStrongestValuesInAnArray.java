class Solution {
  public int[] getStrongest(int[] arr, int k) {
    Arrays.sort(arr);
    int median = arr[(arr.length - 1)/2];    
    mergeSort(arr, median);
    return Arrays.copyOfRange(arr, 0, k);
  }
  
  void mergeSort(int[] arr, int median) {
    divide(arr, 0, arr.length - 1, median);
  }
  
  void divide(int[] arr, int left, int right, int median) {
    if (left >= right) return;
    int middle = (left + right)/2;
    divide(arr, left, middle, median);
    divide(arr, middle + 1, right, median);
    merge(arr, left, middle, middle + 1, right, median);
  }
  
  void merge(int[] arr, int left1, int right1, int left2, int right2, int median) {
    int[] tempArray = new int[right2 - left1  + 1];
    int leftIndex = left1;
    int rightIndex = left2;
    
      while(leftIndex <= right1 && rightIndex <= right2) {
      if (Math.abs(arr[leftIndex] - median) > Math.abs(arr[rightIndex] - median)) {
        tempArray[leftIndex - left1 + rightIndex - left2] = arr[leftIndex];
        leftIndex ++;
      } else {
        tempArray[leftIndex - left1 + rightIndex - left2] = arr[rightIndex];
        rightIndex ++;
      }
    }
          
    while (leftIndex <= right1) {
        tempArray[leftIndex - left1 + rightIndex - left2] = arr[leftIndex];
        leftIndex ++;     
    }
       
    while (rightIndex <= right2) {
        tempArray[leftIndex - left1 + rightIndex - left2] = arr[rightIndex];
        rightIndex ++;     
    }
          
    for (int i = left1; i <= right2; i ++) {
      arr[i] = tempArray[i - left1];
    }
          
  }
    
  
    
}
