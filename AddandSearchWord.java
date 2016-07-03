/*
San Wong
hswong1@uci.edu

211. Add and Search Word - Data structure design

Design a data structure that supports the following two 
operations:

void addWord(word)
bool search(word)

search(word) can search a literal word or a regular expression 
string containing only letters a-z or .. A . means it can 
represent any one letter.

Example: 
addWord("bad")
addWord("dad")
addWord("mad")
search("pad") -> false
search("bad") -> true
search(".ad") -> true
search("b..") -> true
*/

public class WordDictionary {
    private TrieNode root = new TrieNode();
    
    private class TrieNode{
        public TrieNode[] next;
        public boolean isWord;
        
        public TrieNode(){
            next = new TrieNode[26];
        }
    }

    // Adds a word into the data structure.
    public void addWord(String word) {
        //Corner Case
        if(word == null || word.length() == 0){
            return;
        }
        TrieNode node = root;
        int d = 0;
        
        while(d<word.length()){
            char c = word.charAt(d);
            if(node.next[c-'a']==null){
                node.next[c-'a'] = new TrieNode();
            }
            node = node.next[c-'a'];
            d++;
        }
        
        node.isWord = true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        if(word == null || word.length() == 0){
            return false;
        }
        
        TrieNode node = root;
        int d = 0;
        return search(node, word, 0);
    }
    
    private boolean search(TrieNode node, String word, int d){
        if(node == null){
            return false;
        }
        
        if(d == word.length()){
            return node.isWord;
        }
        
        char c = word.charAt(d);
        if (c =='.'){
            for (TrieNode child:node.next){
                if(child != null && search(child,word,d+1)){
                    return true;
                }
            }
            return false;
        }else{
            return search(node.next[c-'a'],word,d+1);
        }
    }
}



// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");