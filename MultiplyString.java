class Solution {
    public String multiply(String num1, String num2) {
        char[] num = new char[num1.length() * num2.length() + 1];
        Arrays.fill(num, '0');
        int index = 0;
        for (int i = num2.length() - 1; i >= 0; i --) {
            index = num.length - ((num2.length() - 1) - i) - 1 ;
            int remain = 0;
            int mul = Integer.parseInt(String.valueOf(num2.charAt(i)));
            
            for (int j = num1.length() - 1; j >= 0; j --) {
                int res = Integer.parseInt(String.valueOf(num1.charAt(j))) * mul + remain + Integer.parseInt(String.valueOf(num[index]));
                remain = res / 10;
                int value = res % 10;
                num[index] = (char)(value + '0');
                index --;
            }
            
            while(remain != 0) {
                int res = Integer.parseInt(String.valueOf(num[index])) + remain;
                remain = res / 10;
                int value = res % 10;
                num[index] = (char)(value + '0');
                index --;
            }
        }
        int leadingZero = 0;
        while (leadingZero < num.length && num[leadingZero] == '0') {
            leadingZero ++;
        }
        if (leadingZero == num.length) return "0";
        return new String(Arrays.copyOfRange(num, leadingZero, num.length));
    }
}
