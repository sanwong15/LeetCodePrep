/*
San Wong
hswong1@uci.edu

208. Implement Trie (Prefix Tree)
Implement a trie with insert, search, and startsWith methods.
*/

class TrieNode {
    // Initialize your data structure here.
    TrieNode[] child;
    boolean isWord;
    
    public TrieNode() {
        child = new TrieNode[26];
        isWord = false;
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        char[] wordArray = word.toCharArray();
        TrieNode currentNode = root;
        int len = wordArray.length;
        for (int i=0; i<len; i++){
            int index = wordArray[i]-'a';
            if(currentNode.child[index] == null){
                currentNode.child[index] = new TrieNode();
            }
            currentNode = currentNode.child[index];
        }
        currentNode.isWord = true;
        
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode node = endNode(word);
        
        return (node!=null && node.isWord);
        
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode node = endNode(prefix);
        
        return node!=null;
        
    }
    
    private TrieNode endNode(String word){
        char[] wordArray = word.toCharArray();
        int len = wordArray.length;
        TrieNode currentNode = root;
        for (int i=0; i<len; i++){
            int index = wordArray[i]-'a';
            if(currentNode.child[index] == null){
                return null;
            }
            currentNode = currentNode.child[index];
        }
        return currentNode;
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");