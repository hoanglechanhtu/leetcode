class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        // 1 2 2 3 3 4 6 7 8
        // index = 6 < hand.length = 9
        // curValue = 6
        // map 1 -> 0, 2-> 0, 3 -> 0, 4 -> 0, 6 -> 0, 7 -> 1, 8 -> 1
        // groupIndex =1 < 3
        if (hand.length % groupSize != 0) return false;
        Arrays.sort(hand);
        Map<Integer, Integer> cardCount = new HashMap<>();
        for (int i = 0; i < hand.length; i ++) {
            cardCount.merge(hand[i], 1, Integer::sum);
        }
        
        int index = 0;
        while(index < hand.length) {
            while(index < hand.length && cardCount.get(hand[index])  == 0) {
                index ++;
            }
            if (index == hand.length) return true;
            int groupIndex = 1;
            int curValue = hand[index];
            cardCount.merge(curValue, -1, Integer::sum);
            while (groupIndex < groupSize){
                if (cardCount.containsKey(curValue + 1) && cardCount.get(curValue + 1) > 0){
                    cardCount.merge(curValue + 1, -1, Integer::sum);
                } else return false;
                curValue ++;
                groupIndex ++;
            }
        }
        
        
        return true;
        
    }
}
