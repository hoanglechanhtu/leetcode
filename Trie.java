class Trie {
    
    private TrieNode root;
    
    class TrieNode {
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
    
    public boolean remove(String word) {
        removeUtil(word, 0, root);
    }
    
    private void removeUtil(String word, int index, TrieNode node) {
        if (index == word.length()) {
            node.endOfWord = false;
            return;
        }
        if (node.map.containsKey(word.charAt(index))) {
            removeUtil(word, index + 1, node.map.get(word.charAt(index)));
            if (node.map.get(word.charAt(index)).size() == 0) {
                node.map.remove(word.charAt(i));
            }
        }
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
