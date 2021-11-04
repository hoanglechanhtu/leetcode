    class Solution {
        public int[] topKFrequent(int[] nums, int k) {
            Map<Integer, Integer> countMap = new HashMap<>();
            for (int i = 0; i < nums.length; i ++) {
                countMap.merge(nums[i], 1, Integer::sum);
            }
            
            //MinHeap
            Queue<Integer> heap = new PriorityQueue<>(Comparator.comparing(x -> countMap.get(x)));
            
            for (int x: countMap.keySet()) {
                heap.add(x);
                if (heap.size() > k) heap.poll();
            }
            
            int[] top = new int[k];
            for (int i = 0; i < k; i ++) {
                top[i] = heap.poll();
            }
            
            return top;
        }
    }
    
    class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0; i < nums.length; i ++) {
            countMap.merge(nums[i], 1, Integer::sum);
        }   
        
        int n = countMap.size();
        int[] unique = new int[n];
        int i = 0;
        for (int x: countMap.keySet()) {
            unique[i] = x;
            i ++;
        }
        
        quickSelect(0, n - 1, n - k, countMap, unique);
        return Arrays.copyOfRange(unique, n - k, n);
    }
    
    void quickSelect(int left, int right, int k, Map<Integer, Integer> map, int[] unique) {
        if (left == right) return;
        int pivotIndex = partition(left, right, map, unique);
        if (k == pivotIndex) {
            return;
        } else if (k < pivotIndex) {
            quickSelect(left, pivotIndex - 1, k, map, unique);
        } else {
            quickSelect(pivotIndex + 1, right, k, map, unique);
        }
    }
    
    //pivotIndex is right
    int partition(int left, int right, Map<Integer, Integer> map, int[] unique) {
        int pivotFreq = map.get(unique[right]);
        int storeIndex = left;
        for (int i = left; i < right; i ++) {
            if (map.get(unique[i]) < pivotFreq) {
                swap(storeIndex, i, unique);
                storeIndex ++;
            }
        }
        
        swap(storeIndex, right, unique);
        
        return storeIndex;
    }
    
    void swap(int a, int b, int[] arr) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
