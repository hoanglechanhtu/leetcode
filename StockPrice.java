class StockPrice {
    TreeMap<Integer, Integer> map;
    TreeMap<Integer, Set<Integer>> valueToTimestamp;
    
    public StockPrice() {
        map = new TreeMap<>();
        valueToTimestamp = new TreeMap<>();
    }
    
    public void update(int timestamp, int price) {
        if (map.containsKey(timestamp)) {
            int oldValue = map.get(timestamp);
            valueToTimestamp.get(oldValue).remove(timestamp);
            if (valueToTimestamp.get(oldValue).size() == 0) valueToTimestamp.remove(oldValue);
        }
        map.put(timestamp, price);
        valueToTimestamp.putIfAbsent(price, new HashSet<>());
        valueToTimestamp.get(price).add(timestamp);
        
    }
    
    public int current() {
        return map.get(map.lastKey());
    }
    
    public int maximum() {
        return valueToTimestamp.lastKey();
    }
    
    public int minimum() {
        return valueToTimestamp.firstKey();
    }
}

/**
 * Your StockPrice object will be instantiated and called as such:
 * StockPrice obj = new StockPrice();
 * obj.update(timestamp,price);
 * int param_2 = obj.current();
 * int param_3 = obj.maximum();
 * int param_4 = obj.minimum();
 */
