class WordDictionary {
    Trie trie;
    public WordDictionary() {
        trie = new Trie();
    }
    
    public void addWord(String word) {
        trie.insert(word);   
    }
    
    public boolean search(String word) {
        return trie.searchPattern(word);
    }
    
    
    
    static class Trie {
    
    private TrieNode root;
    
    static class TrieNode {
        Map<Character, TrieNode> map;
        boolean endOfWord;
        TrieNode() {
            map = new HashMap<>();
            endOfWord = false;
        }
    }
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i ++) {
            if (node.map.containsKey(word.charAt(i))) {
                node = node.map.get(word.charAt(i));
            } else {
                TrieNode newNode = new TrieNode();
                node.map.put(word.charAt(i), newNode);
                node = newNode;
            }
        }
        
        node.endOfWord = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i ++) {
            if (node.map.containsKey(word.charAt(i))) {
                node = node.map.get(word.charAt(i));
            } else {
                return false;
            }
        }
        
        return node.endOfWord;
    }
        
    public boolean searchPattern(String word) {
        return searchPattern(word, 0, root);
    }
        
    private boolean searchPattern(String word, int index, TrieNode node) {
        if (index == word.length()) {
            return node.endOfWord;   
        }
        
        if (word.charAt(index) == '.') {
                
            for(TrieNode newNode : node.map.values()) {
                if (searchPattern(word, index + 1, newNode)) return true;
            }
            
        } else {
            
            if (node.map.containsKey(word.charAt(index))) {
                return searchPattern(word, index + 1, node.map.get(word.charAt(index)));
            } else {
                return false;
            }
            
        }
        
        return false;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (int i = 0; i < prefix.length(); i ++) {
            if (node.map.containsKey(prefix.charAt(i))) {
                node = node.map.get(prefix.charAt(i));
            } else {
                return false;
            }
        }
        
        return true;
    }
    
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
}


/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */


class WordDictionary {
    Set<String> dictionary;
    public WordDictionary() {
        dictionary = new HashSet<>();
    }
    
    public void addWord(String word) {
        dictionary.add(word);
    }
    
    public boolean search(String word) {
        char[] chars = new char[word.length()];
        return check(word, 0, chars);
    }
    
    private boolean check(String word, int index, char[] chars) {
        if (index == word.length()) {
            return dictionary.contains(new String(chars));
        }
        boolean res = false;
        if (word.charAt(index) == '.') {
            for (int i = 0; i < 26; i ++) {
                char c = (char)('a' + i);
                chars[index] = c;
                res = res || check(word, index + 1, chars);
            }
        } else {
            chars[index] = word.charAt(index);
            res = res || check(word, index + 1, chars);
        }
        return res;
        
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
