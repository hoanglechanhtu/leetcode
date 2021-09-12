class Solution {
    public String reversePrefix(String word, char ch) {
        int index = 0;
        char[] words = word.toCharArray();
        while(index < words.length && words[index] != ch) {
            index ++;
        }
        if (index >= words.length) {
            return word;
        } else {
            for (int i = 0; i < (index + 1)/2; i ++) {
                char temp = words[i];
                words[i] = words[index - i];
                words[index - i] = temp;
            }
            
            return new String(words);
        }
    }
}
