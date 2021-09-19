class Solution {
    enum Operation{
        PlusLeft(1, "++X"),
        PlusRight(1, "X++"),
        MinusLeft(-1, "--X"),
        MinusRight(-1, "X--");
        
        Operation(int d, String value) {
            this.d = d;
            this.value = value;
        }
        int d;
        String value;
    }
    public int finalValueAfterOperations(String[] operations) {
        int value = 0;
        for (int i = 0; i < operations.length; i ++) {
            for (Operation oper : Operation.values()) {
                if (oper.value.equals(operations[i])) value += oper.d;
            }
        }
        
        return value;
    }
}
