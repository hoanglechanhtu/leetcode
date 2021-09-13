class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i ++) {
            list.add(i);
        }
        
        int i = 0;
        int temp = n;
         while (temp != 0) {
            temp = temp / 10;
            i ++;
        }
        


        while (n != 0) {
            mergeSort(list, 0, list.size() - 1, i);
            i --;
            n = n / 10;
        }
        return list;
    }
    
    void mergeSort(List<Integer> list, int left, int right, int k) {
        if (left >= right) return;
        int middle = (left + right)/2;
        mergeSort(list, left, middle, k);
        mergeSort(list, middle + 1, right, k);
        
        combine(list, left, middle, right, k);
    }
    
    void combine(List<Integer> list, int left, int middle, int right, int k) {
        int[] arr = new int[right - left + 1];
        int iLeft = left;
        int iRight = middle + 1;
        while(iLeft <= middle && iRight <= right) {
            int leftValue = get(list.get(iLeft), k);
            int rightValue = get(list.get(iRight), k);
            
            if (leftValue == -1 || rightValue == -1 || leftValue <= rightValue) {
                arr[iLeft - left + iRight - middle - 1] = list.get(iLeft);
                iLeft ++;
            } else {
                arr[iLeft - left + iRight - middle - 1] = list.get(iRight);
                iRight ++;
            }
        }
        
        while (iLeft <= middle) {
            arr[iLeft - left + iRight - middle - 1] = list.get(iLeft);
            iLeft ++;
        }
        
        while (iRight <= right) {
            arr[iLeft - left + iRight - middle - 1] = list.get(iRight);
            iRight ++;
        }
        
        for (int i = 0; i < arr.length; i ++) {
            list.set(left + i, arr[i]);
        }
    }
    
    //12
    //3
    int get(int value, int k) {
        int temp = value;
        int i = 0;
        while (temp != 0) {
            temp = temp / 10;
            i ++;
        }
        
        while(i > k){
            value = value / 10;
            k ++;
        }
        
        return i == k ? value % 10 : -1;
        
    }
}
